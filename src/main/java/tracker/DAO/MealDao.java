package tracker.DAO;

import tracker.models.Meal;
import tracker.models.User;

import java.util.List;

public interface MealDao {
    public List<Meal> getAllUserMeal(int userId);
    public int getMeal(String name);
    public Meal getMealById(int mealId);
    public void updateUser(User u);
    public void deleteUser(User u);
    public void insertUser(User u);
}
