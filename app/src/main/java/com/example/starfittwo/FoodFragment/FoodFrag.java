package com.example.starfittwo.FoodFragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.starfittwo.R;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class FoodFrag extends AppCompatActivity {

    private FirebaseFirestore db;
    private RecyclerView mRecyclerView;
    private RecyclerView mRecyclerViewChoosen;
    private FirestoreRecyclerAdapter foodAdapter;
    private ArrayList<FoodModle> foodArrayList;
    private ArrayList<FoodModle> foodArrayListChoosen;
    private FoodViewAdapter adapter;
    private EditText search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fregmant_food);

        foodArrayList = new ArrayList<>();
        foodArrayListChoosen = new ArrayList<>();

        setUpRecyclerView();
        setUpFireBase();
        //setUpSearch();
        addTestDataToFireBase();
        loadDataFromFireBase();

        search = findViewById(R.id.searchFood);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                ArrayList<FoodModle> filteredList = new ArrayList<FoodModle>();

                for (FoodModle foodItem: foodArrayList){
                    if (foodItem.getName().contains(s.toString())){
                        filteredList.add(foodItem);
                    }
                }
                adapter.filterList(filteredList);
            }
        });


    }

    private void setUpSearch() {
        search = findViewById(R.id.searchFood);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
            ArrayList<FoodModle> filteredList = new ArrayList<FoodModle>();

            for (FoodModle foodItem: foodArrayList){
                if (((foodItem.getAmount().contains(s.toString())))||(foodItem.getName().contains(s.toString()))){
                    filteredList.add(foodItem);
                }
            }
            adapter.filterList(filteredList);
            }
        });
    }

    private void loadDataFromFireBase() {
        if (foodArrayList.size()>0)
            foodArrayList.clear();

        db.collection("food").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (DocumentSnapshot querySnapshot : task.getResult()) {
                        FoodModle foodModle = new FoodModle(querySnapshot.getString("Name"),
                                querySnapshot.getString("Amount"),
                                querySnapshot.getString("YellowStar"),
                                querySnapshot.getString("RedStar"));
                        foodArrayList.add(foodModle);
                    }

                    adapter = new FoodViewAdapter(FoodFrag.this, foodArrayList, foodArrayListChoosen);
                    mRecyclerView.setAdapter(adapter);
                }
            }
        })
        .addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                //log for failuar
            }
        });

    }

    private void addTestDataToFireBase() {
        /*Random random = new Random();

        for (int i=0;i<2;i++) {
            Map<String, String> datMap = new HashMap<>();
            datMap.put("name", "try name" + random.nextInt(50));
            datMap.put("status", "try status" + random.nextInt(50));

            db.collection("food")
                    .add(datMap)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Toast.makeText(com.example.starfittwo.MainActivity.this, "Add", Toast.LENGTH_SHORT).show();
                        }
                    });
        }*/
    }

    private void setUpFireBase() {
        db = FirebaseFirestore.getInstance();
    }

    private void setUpRecyclerView() {
        mRecyclerView =findViewById(R.id.recyclerViewFood);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        //mRecyclerViewChoosen =findViewById(R.id.recyclerViewFoodFilter);
        //mRecyclerViewChoosen.setHasFixedSize(true);
        //mRecyclerViewChoosen.setLayoutManager(new LinearLayoutManager(this));
    }
}
