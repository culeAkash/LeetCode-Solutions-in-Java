class Food implements Comparable<Food> {
    String name;
    int rating;

    Food(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }

    @Override
    public int compareTo(Food other) {
        if (this.rating == other.rating) {
            return this.name.compareTo(other.name);
        }
        return other.rating - this.rating; // higher rating first
    }
}

class FoodRatings {
    Map<String,TreeSet<Food>> cuisineFoodMap;
    Map<String,Food> foodMap;
    Map<String,String> foodCuisineMap;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        cuisineFoodMap = new HashMap<>();
        foodMap = new HashMap<>();
        foodCuisineMap = new HashMap<>();

        int N = foods.length;

        for(int index = 0;index < N;index++){
            String cuisine = cuisines[index];
            String food = foods[index];
            Integer rating = ratings[index];

            Food f = new Food(food, rating);
            foodMap.put(food, f);
            foodCuisineMap.put(food,cuisine);

            cuisineFoodMap.computeIfAbsent(cuisine, k -> new TreeSet<>()).add(f);
        }
    }
    
    public void changeRating(String food, int newRating) {
        Food f = foodMap.get(food);
        String cuisine = foodCuisineMap.get(food);

        cuisineFoodMap.get(cuisine).remove(f);  // remove old
        Food updated = new Food(food, newRating);
        foodMap.put(food, updated);
        cuisineFoodMap.get(cuisine).add(updated); // add new
    }
    
    public String highestRated(String cuisine) {
        return cuisineFoodMap.get(cuisine).first().name;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */