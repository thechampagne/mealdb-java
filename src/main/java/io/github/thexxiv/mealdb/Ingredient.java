package io.github.thexxiv.mealdb;

import java.util.ArrayList;

public class Ingredient{
    public String idIngredient;
    public String strIngredient;
    public String strDescription;
    public String strType;

    @Override
    public String toString() {
        return "Ingredient{" +
                "idIngredient='" + idIngredient + '\'' +
                ", strIngredient='" + strIngredient + '\'' +
                ", strDescription='" + strDescription + '\'' +
                ", strType='" + strType + '\'' +
                '}';
    }
}

class Ingredients {
    ArrayList<Ingredient> meals;
}