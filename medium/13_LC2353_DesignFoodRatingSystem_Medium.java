// LeetCode 2353 - Design a Food Rating System
// Topic: Classes, objects, methods and encapsulation
import java.util.*;

class FoodRatings {
    private static class Food {
        String name;
        int rating;

        Food(String name, int rating) {
            this.name = name;
            this.rating = rating;
        }
    }

    private final Map<String, String> foodCuisine = new HashMap<>();
    private final Map<String, Food> foods = new HashMap<>();
    private final Map<String, TreeSet<Food>> cuisineFoods = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        Comparator<Food> order = (a, b) -> {
            if (a.rating != b.rating) return Integer.compare(b.rating, a.rating);
            return a.name.compareTo(b.name);
        };

        for (int i = 0; i < foods.length; i++) {
            String name = foods[i];
            String cuisine = cuisines[i];
            Food food = new Food(name, ratings[i]);

            foodCuisine.put(name, cuisine);
            this.foods.put(name, food);
            cuisineFoods.computeIfAbsent(cuisine, key -> new TreeSet<>(order))
                        .add(food);
        }
    }

    public void changeRating(String food, int newRating) {
        Food item = foods.get(food);
        String cuisine = foodCuisine.get(food);
        TreeSet<Food> set = cuisineFoods.get(cuisine);

        set.remove(item);
        item.rating = newRating;
        set.add(item);
    }

    public String highestRated(String cuisine) {
        return cuisineFoods.get(cuisine).first().name;
    }
}
