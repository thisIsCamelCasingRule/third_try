package tracker.database;

public class MealLogQueries {

    public MealLogQueries(){}

    public String GetUserFromMealId(int mealId){
        return "select user_id from Meal_log where meal_id = " + mealId;
    }

    public String GetMealIdsFromUserId(int userId){
        return "select meal_id from Meal_log where user_id = " + userId;
    }

    public String InsertNewMeal(int userId, int mealId){
        return "insert into Meal_log(user_id, meal_id) values(" +userId+ ", " +mealId+ ")" ;
    }
}
