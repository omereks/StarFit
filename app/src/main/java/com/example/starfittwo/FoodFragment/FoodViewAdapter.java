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
    ArrayList<FoodModle> foodModleArrayList;

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
                foodModleArrayList.get(position).setNumberOfFood(foodModleArrayList.get(position).getNumberOfFood()+1);
                int num = foodModleArrayList.get(position).getNumberOfFood();
                holder.getNumber_of_food().setText(num + "");
            }
        });
        //remove button -1 when push
        holder.getRemove_button().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (foodModleArrayList.get(position).getNumberOfFood()!=0) {
                    foodModleArrayList.get(position).setNumberOfFood(foodModleArrayList.get(position).getNumberOfFood() - 1);
                    int num = foodModleArrayList.get(position).getNumberOfFood();
                    holder.getNumber_of_food().setText(num + "");
                }
            }
        });



            //////here i stoped

        //yellow star

        holder.getRatingBar().setNumStars(4);

        if (foodModleArrayList.get(position).getYellowStar()>0){
            //Button b = new Button(this.mainActivity);
           // holder.getLinearLayoutYellow().addView(b);
        }



    }

    public void addView(LinearLayout layout,ImageView img, int width, int high) {
        Button b = new Button(this.mainActivity);
        layout.addView(b);
    }

    @Override
    public int getItemCount() {
        return foodModleArrayList.size();
    }
}
