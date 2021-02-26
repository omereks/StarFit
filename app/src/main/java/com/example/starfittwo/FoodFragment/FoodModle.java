package com.example.starfittwo.FoodFragment;

public class FoodModle {
    private String Name;
    private String Amount;
    private double YellowStar;
    private double RedStar;

    public int getNumberOfFood() {
        return numberOfFood;
    }

    public void setNumberOfFood(int numberOfFood) {
        this.numberOfFood = numberOfFood;
    }

    private int numberOfFood;


    public FoodModle(String name, String amount) {
        Name = name;
        Amount = amount;
    }

    public FoodModle(){
    }

    public FoodModle(String name, String amount, String yellowStar, String redStar) {
        Name = name;
        Amount = amount;
        try {
            YellowStar = Double.parseDouble(yellowStar);
        }
        catch (Exception e){

        }
        try{
        RedStar = Double.parseDouble(redStar);
        }
        catch (Exception e){

        }
    }

    public FoodModle(String name, String amount, double yellowStar, double redStar) {
        Name = name;
        Amount = amount;
        YellowStar = yellowStar;
        RedStar = redStar;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public void setYellowStar(double yellowStar) {
        YellowStar = yellowStar;
    }

    public void setRedStar(double redStar) {
        RedStar = redStar;
    }

    public String getName() {
        return Name;
    }

    public String getAmount() {
        return Amount;
    }

    public double getYellowStar() {
        return YellowStar;
    }

    public double getRedStar() {
        return RedStar;
    }
}
