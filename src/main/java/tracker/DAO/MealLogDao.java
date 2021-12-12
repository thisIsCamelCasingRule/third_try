package tracker.DAO;

import java.util.List;

public interface MealLogDao {
    public int insertMealLog(int userId, int mealId);
    public List<Integer> getAllUserMeal(int userId);
}
