package io.github.thexxiv.mealdb;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * TheMealDB API client.
 * <p>
 * An open, crowd-sourced database of
 * Recipes from around the world
 *
 * @author XXIV
 */
public class MealDB {

    private static String http(String endpoint) {
        try {
            URL url = new URL(String.format("https://themealdb.com/api/json/v1/1/%s", endpoint));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader reader;
            if (100 <= connection.getResponseCode() && connection.getResponseCode() <= 399) {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            }
            StringBuilder string = new StringBuilder();
            String output;
            while ((output = reader.readLine()) != null) {
                string.append(output);
            }
            return string.toString();
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * Search meal by name.
     *
     * @param s Meal name.
     * @return List of {@link Meal}.
     */
    public static List<Meal> search(String s) {
        try {
            String response = http(String.format("search.php?s=%s", URLEncoder.encode(s, StandardCharsets.UTF_8.toString())));
            if (response != null && response.length() != 0) {
                Gson gson = new Gson();
                Meals meal = gson.fromJson(response, Meals.class);
                if (meal.meals != null && !meal.meals.isEmpty()) {
                    List<Meal> list = new ArrayList<>(meal.meals);
                    if (list.isEmpty()) {
                        return null;
                    } else {
                        return list;
                    }
                } else {
                    return null;
                }
            } else {
                return null;
            }
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * Search meals by first letter.
     *
     * @param c Meal letter.
     * @return List of {@link Meal}.
     */
    public static List<Meal> searchByLetter(char c) {
        try {
            String response = http(String.format("search.php?f=%s", c));
            if (response != null && response.length() != 0) {
                Gson gson = new Gson();
                Meals meal = gson.fromJson(response, Meals.class);
                if (meal.meals != null && !meal.meals.isEmpty()) {
                    List<Meal> list = new ArrayList<>(meal.meals);
                    if (list.isEmpty()) {
                        return null;
                    } else {
                        return list;
                    }
                } else {
                    return null;
                }
            } else {
                return null;
            }
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * Search Meal details by id.
     *
     * @param l Meal id.
     * @return {@link Meal}.
     */
    public static Meal searchByID(Long l) {
        try {
            String response = http(String.format("lookup.php?i=%d", l));
            if (response != null && response.length() != 0) {
                Gson gson = new Gson();
                Meals meal = gson.fromJson(response, Meals.class);
                if (meal.meals != null && !meal.meals.isEmpty()) {
                    return meal.meals.get(0);
                } else {
                    return null;
                }
            } else {
                return null;
            }
        } catch (Exception ex) {
            return null;
        }
    }


    /**
     * Search a random meal.
     *
     * @return Random meal.
     */
    public static Meal random() {
        try {
            String response = http("random.php");
            if (response != null && response.length() != 0) {
                Gson gson = new Gson();
                Meals meal = gson.fromJson(response, Meals.class);
                if (meal.meals != null && !meal.meals.isEmpty()) {
                    return meal.meals.get(0);
                } else {
                    return null;
                }
            } else {
                return null;
            }
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * List the meals categories.
     *
     * @return List of  {@link Category}.
     */
    public static List<Category> mealCategories() {
        try {
            String response = http("categories.php");
            if (response != null && response.length() != 0) {
                Gson gson = new Gson();
                Categories meal = gson.fromJson(response, Categories.class);
                if (meal.categories != null && !meal.categories.isEmpty()) {
                    List<Category> list = new ArrayList<>(meal.categories);
                    if (list.isEmpty()) {
                        return null;
                    } else {
                        return list;
                    }
                } else {
                    return null;
                }
            } else {
                return null;
            }
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * Filter by ingredient.
     *
     * @param s Ingredient name.
     * @return List of {@link Filter}.
     */
    public static List<Filter> filterByIngredient(String s) {
        try {
            String response = http(String.format("filter.php?i=%s", URLEncoder.encode(s, StandardCharsets.UTF_8.toString())));
            if (response != null && response.length() != 0) {
                Gson gson = new Gson();
                FilterMeals meal = gson.fromJson(response, FilterMeals.class);
                if (meal.meals != null && !meal.meals.isEmpty()) {
                    List<Filter> list = new ArrayList<>(meal.meals);
                    if (list.isEmpty()) {
                        return null;
                    } else {
                        return list;
                    }
                } else {
                    return null;
                }
            } else {
                return null;
            }
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * Filter by area.
     *
     * @param s Area name.
     * @return List of {@link Filter}.
     */
    public static List<Filter> filterByArea(String s) {
        try {
            String response = http(String.format("filter.php?a=%s", URLEncoder.encode(s, StandardCharsets.UTF_8.toString())));
            if (response != null && response.length() != 0) {
                Gson gson = new Gson();
                FilterMeals meal = gson.fromJson(response, FilterMeals.class);
                if (meal.meals != null && !meal.meals.isEmpty()) {
                    List<Filter> list = new ArrayList<>(meal.meals);
                    if (list.isEmpty()) {
                        return null;
                    } else {
                        return list;
                    }
                } else {
                    return null;
                }
            } else {
                return null;
            }
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * Filter by Category.
     *
     * @param s Category name.
     * @return List of {@link Filter}.
     */
    public static List<Filter> filterByCategory(String s) {
        try {
            String response = http(String.format("filter.php?c=%s", URLEncoder.encode(s, StandardCharsets.UTF_8.toString())));
            if (response != null && response.length() != 0) {
                Gson gson = new Gson();
                FilterMeals meal = gson.fromJson(response, FilterMeals.class);
                if (meal.meals != null && !meal.meals.isEmpty()) {
                    List<Filter> list = new ArrayList<>(meal.meals);
                    if (list.isEmpty()) {
                        return null;
                    } else {
                        return list;
                    }
                } else {
                    return null;
                }
            } else {
                return null;
            }
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * List the categories filter.
     *
     * @return List of {@link String}.
     */
    public static List<String> categoriesFilter() {
        try {
            String response = http("list.php?c=list");
            if (response != null && response.length() != 0) {
                Gson gson = new Gson();
                CategoriesFilter meal = gson.fromJson(response, CategoriesFilter.class);
                if (meal.meals != null && !meal.meals.isEmpty()) {
                    List<String> list = new ArrayList<>();
                    for (CategoryFilter c : meal.meals) {
                        list.add(c.strCategory);
                    }
                    return list;
                } else {
                    return null;
                }
            } else {
                return null;
            }
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * List the ingredients filter.
     *
     * @return List of {@link Ingredient}.
     */
    public static List<Ingredient> ingredientsFilter() {
        try {
            String response = http("list.php?i=list");
            if (response != null && response.length() != 0) {
                Gson gson = new Gson();
                Ingredients meal = gson.fromJson(response, Ingredients.class);
                if (meal.meals != null && !meal.meals.isEmpty()) {
                    List<Ingredient> list = new ArrayList<>(meal.meals);
                    if (list.isEmpty()) {
                        return null;
                    } else {
                        return list;
                    }
                } else {
                    return null;
                }
            } else {
                return null;
            }
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * List the area filter.
     *
     * @return List of {@link String}.
     */
    public static List<String> areaFilter() {
        try {
            String response = http("list.php?a=list");
            if (response != null && response.length() != 0) {
                Gson gson = new Gson();
                AreaFilter meal = gson.fromJson(response, AreaFilter.class);
                if (meal.meals != null && !meal.meals.isEmpty()) {
                    List<String> list = new ArrayList<>();
                    for (Area c : meal.meals) {
                        list.add(c.strArea);
                    }
                    return list;
                } else {
                    return null;
                }
            } else {
                return null;
            }
        } catch (Exception ex) {
            return null;
        }
    }
}