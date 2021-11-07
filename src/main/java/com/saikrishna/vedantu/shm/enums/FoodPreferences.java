package com.saikrishna.vedantu.shm.enums;

public enum FoodPreferences {
    V("V"),
    NV("NV");
    private String foodType;
    FoodPreferences(String f) {
        this.foodType = f;
    }
    public static FoodPreferences getFoodPreferences(String s) {
        return s==null|| s.length()==0? null: FoodPreferences.valueOf(s);
    }
}
