package com.example.starfittwo;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.starfittwo.FoodFragment.FoodModle;
import com.example.starfittwo.FoodFragment.FoodViewAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private FirebaseFirestore db;
    private RecyclerView mRecyclerView;
    private FirestoreRecyclerAdapter foodAdapter;
    private ArrayList<FoodModle> foodArrayList;
    private FoodViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fregmant_food);

        foodArrayList = new ArrayList<>();

        setUpRecyclerView();
        setUpFireBase();
        addTestDataToFireBase();
        loadDataFromFireBase();





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

                    adapter = new FoodViewAdapter(MainActivity.this, foodArrayList);
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
        Random random = new Random();

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
        }
    }

    private void setUpFireBase() {
        db = FirebaseFirestore.getInstance();
    }

    private void setUpRecyclerView() {
        mRecyclerView =findViewById(R.id.recyclerViewFood);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
