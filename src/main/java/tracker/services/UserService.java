package tracker.services;

import tracker.DAO.MealDaoImpl;
import tracker.DAO.MealLogDaoImpl;
import tracker.models.Meal;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    public UserService(){}

    public void addNewMealToLog(String mealName, int userId){
        // Get id of meal from name
        MealDaoImpl mealDao = new MealDaoImpl();
        int mealId = mealDao.getMeal(mealName);

        // if no such meal then return error, else continue
        if (mealId == 0){
            return;
        }

        // add new write in meal_log
        MealLogDaoImpl mealLogDao = new MealLogDaoImpl();
        int flag = mealLogDao.insertMealLog(userId, mealId);

        if (flag==1){
            System.out.println("New meal added to meal log");
        } else {
            System.out.println("Error while adding meal to log");
        }

        return;
    }

    public List<Meal> getUserMeal(int userID){
        MealLogDaoImpl mealLogDao = new MealLogDaoImpl();
        List<Meal> mealList = new ArrayList<>();

        // Get list of meal ids that user has in meal_log
        List<Integer> mealIdList = mealLogDao.getAllUserMeal(userID);

        // find the meal in db and parse it to meal list
        MealDaoImpl mealDao = new MealDaoImpl();
        for(int i = 0; i < mealIdList.size(); i++){
            Meal tmpm = mealDao.getMealById(mealIdList.get(i));
            mealList.add(tmpm);
        }
        // return meal list
        return mealList;
    }
}
