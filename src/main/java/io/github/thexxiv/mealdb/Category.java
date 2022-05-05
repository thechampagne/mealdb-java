package io.github.thexxiv.mealdb;

import java.util.ArrayList;

public class Category{
    public String idCategory;
    public String strCategory;
    public String strCategoryThumb;
    public String strCategoryDescription;

    @Override
    public String toString() {
        return "Category{" +
                "idCategory='" + idCategory + '\'' +
                ", strCategory='" + strCategory + '\'' +
                ", strCategoryThumb='" + strCategoryThumb + '\'' +
                ", strCategoryDescription='" + strCategoryDescription + '\'' +
                '}';
    }
}

class Categories{
    ArrayList<Category> categories;
}