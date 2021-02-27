package com.example.starfittwo.FoodFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.starfittwo.MainActivity;
import com.example.starfittwo.R;

import java.util.ArrayList;

public class FoodViewAdapter extends RecyclerView.Adapter<FoodViewHolder> {
    MainActivity mainActivity;
    ArrayList<ArrayList<FoodModle>> array;
    ArrayList<FoodModle> foodModleArrayList;
    ArrayList<FoodModle> foodModleArrayListChoose = new ArrayList<FoodModle>();

    public FoodViewAdapter(MainActivity mainActivity, ArrayList<FoodModle> foodModleArrayList, ArrayList<FoodModle> foodModleArrayListChoose) {
        this.mainActivity = mainActivity;
        this.foodModleArrayList = foodModleArrayList;
        this.foodModleArrayListChoose = foodModleArrayListChoose;
        //this.array.add(this.foodModleArrayList);
        //this.array.add(this.foodModleArrayListChoose);
    }

    public FoodViewAdapter(MainActivity mainActivity, ArrayList<FoodModle> foodModleArrayList) {
        this.mainActivity = mainActivity;
        this.foodModleArrayList = foodModleArrayList;
    }


    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mainActivity.getBaseContext());
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_row, parent, false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        holder.getList_food_name().setText(foodModleArrayList.get(position).getName());
        holder.getList_food_amount().setText(foodModleArrayList.get(position).getAmount());
        //add button +1 when push
        holder.getAdd_button().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (foodModleArrayList.get(position).getNumberOfFood() == 0){
                    foodModleArrayList.add(foodModleArrayList.get(position));
                }
                foodModleArrayList.get(position).setNumberOfFood(foodModleArrayList.get(position).getNumberOfFood()+1);
                int num = foodModleArrayList.get(position).getNumberOfFood();
                holder.getNumber_of_food().setText(num + "");
            }
        });
        //remove button -1 when push
        holder.getRemove_button().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (foodModleArrayList.get(position).getNumberOfFood() == 1) {
                    foodModleArrayListChoose.remove(foodModleArrayList.get(position));
                }
                if (foodModleArrayList.get(position).getNumberOfFood() != 0) {
                    foodModleArrayList.get(position).setNumberOfFood(foodModleArrayList.get(position).getNumberOfFood() - 1);
                    int num = foodModleArrayList.get(position).getNumberOfFood();
                    holder.getNumber_of_food().setText(num + "");
                }
            }
        });

        //yellow star
        holder.getYellow_ratingBar().setRating((float)foodModleArrayList.get(position).getYellowStar());
        holder.getRed_ratingBar().setRating((float)foodModleArrayList.get(position).getRedStar());

    }


    @Override
    public int getItemCount() {
        return foodModleArrayList.size();
    }

    public void filterList(ArrayList<FoodModle> filterList){
        foodModleArrayList = filterList;
        notifyDataSetChanged();
    }
}
