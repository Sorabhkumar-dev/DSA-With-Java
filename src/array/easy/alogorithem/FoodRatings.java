package array.easy.alogorithem;

import java.util.*;

public class FoodRatings {
//    String[] foods,cuisines;
//    int[] ratings;
//    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
//        this.foods = foods;
//        this.cuisines = cuisines;
//        this.ratings = ratings;
//    }
//
//    public void changeRating(String food, int newRating) {
//        int foodIndex = 0;
//        for (int i = 0;i < foods.length;i++){
//            if (foods[i].contentEquals(food)){
//                foodIndex = i;
//                break;
//            }
//        }
//        ratings[foodIndex] = newRating;
//    }
//
//    public String highestRated(String cuisine) {
//        int maxIndex = -1;
//        for (int i = 0;i<cuisines.length;i++){
//            if (cuisines[i].contentEquals(cuisine)){
//                if (maxIndex == -1)
//                    maxIndex = i;
//                else{
//                    if (ratings[maxIndex] <= ratings[i])
//                        maxIndex = i;
//                }
//            }
//        }
//        if (maxIndex == -1)return "";
//        return foods[maxIndex];
//    }


    HashMap<String,String> foodCuisinesMap = new HashMap<>();
    HashMap<String,PriorityQueue<Food>> cuisinesMap = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for(int i = 0;i< foods.length;i++){

            foodCuisinesMap.put(foods[i],cuisines[i]);
            PriorityQueue<Food> temp;
            if(!cuisinesMap.containsKey(cuisines[i])){
                temp = new PriorityQueue<>();
                temp.add(new Food(foods[i],ratings[i],cuisines[i]));
                cuisinesMap.put(cuisines[i],temp);
            }else{
                cuisinesMap.get(cuisines[i]).add(new Food(foods[i],ratings[i],cuisines[i]));
            }
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine =  foodCuisinesMap.get(food);
        PriorityQueue<Food> tempQ = cuisinesMap.get(cuisine);

        tempQ.removeIf(r -> r.foodName.contentEquals(food));

        tempQ.add(new Food(food,newRating,cuisine));

        cuisinesMap.put(cuisine,tempQ);
    }

    public String highestRated(String cuisine) {
        return cuisinesMap.get(cuisine).peek().foodName;
    }
}

class Food implements Comparable<Food> {
    String foodName;
    String cuisine;
    int rating;

    public Food(String foodName,int rating,String cuisine){
        this.foodName = foodName;
        this.rating = rating;
        this.cuisine = cuisine;
    }

    @Override
    public int compareTo(Food food) {
        if (Objects.equals(food.foodName, foodName))
            return food.foodName.compareTo(foodName);
        else
            return -1 * Integer.compare(food.rating,rating);

    }

}
