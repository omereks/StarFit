package com.example.starfittwo.FoodFragment;

import androidx.appcompat.app.AppCompatActivity;


public class FoodFragment extends AppCompatActivity {
/**
    private FirebaseFirestore firebaseFirestore;
    private RecyclerView mFireStorList;
    private FirestoreRecyclerAdapter foodAdapter;

    private static final String TAG = "FoodFragment";

    public FoodFragment() {
    }

    public FoodFragment(FirebaseFirestore firebaseFirestore, RecyclerView mFireStorList, FirestoreRecyclerAdapter foodAdapter) {
        this.firebaseFirestore = firebaseFirestore;
        this.mFireStorList = mFireStorList;
        this.foodAdapter = foodAdapter;
    }

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        firebaseFirestore = FirebaseFirestore.getInstance();
        mFireStorList = findViewById(R.id.recyclerViewFood);


        //Query
        Query query = firebaseFirestore.collection("food");
        //RecyclerOption
        FirestoreRecyclerOptions<FoodModle> option = new FirestoreRecyclerOptions.Builder<FoodModle>()
                .setQuery(query, FoodModle.class)
                .build();
        foodAdapter = new FirestoreRecyclerAdapter<FoodModle, FoodFragment>(option) {
            @Override
            protected void onBindViewHolder(@NonNull FoodFragment holder, int position, @NonNull FoodModle model) {

            }

            @androidx.annotation.NonNull
            @Override
            public FoodViewerHolder onCreateViewHolder(@androidx.annotation.NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_row, parent, false);
                return new FoodViewerHolder(view);
            }

            @Override
            protected void onBindViewHolder(@androidx.annotation.NonNull FoodViewerHolder holder, int position, @androidx.annotation.NonNull FoodModle model) {
                holder.list_food_name.setText(model.getName());
                holder.list_food_amount.setText(model.getAmount());
            }
        };

        mFireStorList.setHasFixedSize(true);
        mFireStorList.setLayoutManager(new LinearLayoutManager(this));
        mFireStorList.setAdapter(foodAdapter);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
/**
    private class FoodViewerHolder extends RecyclerView.ViewHolder{

        private TextView list_food_name;
        private TextView list_food_amount;

        public FoodViewerHolder(@NonNull View itemView) {
            super(itemView);
            list_food_name = itemView.findViewById(R.id.foodName);
            list_food_amount = itemView.findViewById(R.id.foodAmount);
        }
    }


    @Override
    public void onStop() {
        super.onStop();
        foodAdapter.stopListening();
    }

    @Override
    public void onStart() {
        super.onStart();
        foodAdapter.startListening();
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fregment_food,container, false);



    }*/
}
//public class CountryImageAdapter extends RecyclerView.Adapter<CFoodModle, FoodFragment.FoodViewerHolder> {
//}
























