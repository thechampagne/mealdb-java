package io.github.thexxiv.mealdb;

import java.util.ArrayList;

public class Filter {
    public String strMeal;
    public String strMealThumb;
    public String idMeal;

    @Override
    public String toString() {
        return "Filter{" +
                "strMeal='" + strMeal + '\'' +
                ", strMealThumb='" + strMealThumb + '\'' +
                ", idMeal='" + idMeal + '\'' +
                '}';
    }
}

class FilterMeals {
    ArrayList<Filter> meals;
}