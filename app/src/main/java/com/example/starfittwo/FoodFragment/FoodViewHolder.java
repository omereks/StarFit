package com.example.starfittwo.FoodFragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.starfittwo.R;

public class FoodViewHolder extends RecyclerView.ViewHolder{
    private TextView list_food_name;
    private TextView list_food_amount;
    private ImageView add_button;
    private ImageView remove_button;
    private TextView number_of_food;
    private ImageView yellow_star_img;

    public RatingBar getRed_ratingBar() {
        return red_ratingBar;
    }

    public void setRed_ratingBar(RatingBar red_ratingBar) {
        this.red_ratingBar = red_ratingBar;
    }

    private LinearLayout linearLayoutYellow;
    private RatingBar yellow_ratingBar;
    private RatingBar red_ratingBar;

    public RatingBar getYellow_ratingBar() {
        return yellow_ratingBar;
    }

    public void setYellow_ratingBar(RatingBar yellow_ratingBar) {
        this.yellow_ratingBar = yellow_ratingBar;
    }

    public LinearLayout getLinearLayoutYellow() {
        return linearLayoutYellow;
    }

    public void setLinearLayoutYellow(LinearLayout linearLayoutYellow) {
        this.linearLayoutYellow = linearLayoutYellow;
    }

    public ImageView getYellow_star_img() {
        return yellow_star_img;
    }

    public void setYellow_star_img(ImageView yellow_star_img) {
        this.yellow_star_img = yellow_star_img;
    }

    public ImageView getAdd_button() {
        return add_button;
    }

    public void setAdd_button(ImageView add_button) {
        this.add_button = add_button;
    }

    public TextView getNumber_of_food() {
        return number_of_food;
    }

    public void setNumber_of_food(TextView number_of_food) {
        this.number_of_food = number_of_food;
    }

    public ImageView getRemove_button() {
        return remove_button;
    }

    public void setRemove_button(ImageView remove_button) {
        this.remove_button = remove_button;
    }

    public FoodViewHolder(@NonNull View itemView) {
        super(itemView);
        list_food_name = itemView.findViewById(R.id.foodName);
        list_food_amount = itemView.findViewById(R.id.foodAmount);
        add_button =  itemView.findViewById(R.id.addButton);
        remove_button =  itemView.findViewById(R.id.removeButton);
        number_of_food = itemView.findViewById(R.id.numberOfFood);
        linearLayoutYellow = itemView.findViewById(R.id.layoutYellowStar);
        yellow_ratingBar = itemView.findViewById(R.id.YellowStarRating);
        red_ratingBar = itemView.findViewById(R.id.redStarRating);
    }

    public TextView getList_food_name() {
        return list_food_name;
    }

    public void setList_food_name(TextView list_food_name) {
        this.list_food_name = list_food_name;
    }

    public TextView getList_food_amount() {
        return list_food_amount;
    }

    public void setList_food_amount(TextView list_food_amount) {
        this.list_food_amount = list_food_amount;
    }
}