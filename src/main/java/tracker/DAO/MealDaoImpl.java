package tracker.DAO;

import tracker.models.User;
import tracker.database.Database;
import tracker.database.Queries;
import tracker.models.Meal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MealDaoImpl implements MealDao{

    // Rewrite it to user service
    @Override
    public List<Meal> getAllUserMeal(int userId) {
        try {
            List<Meal> meallist = new ArrayList<Meal>();
            List<Integer> mealIdList = new ArrayList<Integer>();
            Connection conn = Database.getConnection();
            Statement st = conn.createStatement();
            Queries q = new Queries();

            // Get all meal ids from log for user with inserted id
            ResultSet r = st.executeQuery(q.mealLogQueries.GetMealIdsFromUserId(userId));

            // For each meal id find meal in db and add it to list
            while(r.next()){
                ResultSet res = st.executeQuery(q.mealQueries.getMealById(r.getInt("meal_id")));
                while(res.next()){
                    Meal temp = new Meal();
                    temp.setId(res.getInt("id"));
                    temp.setName(res.getString("name"));
                    temp.setCalories(res.getDouble("calories"));
                    temp.setFats(res.getDouble("fats"));
                    temp.setProteins(res.getDouble("proteins"));
                    temp.setCarbohydrates(res.getDouble("carbohydrates"));
                    meallist.add(temp);
                }
            }

            System.out.println("Meal list was created !");

            return meallist;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public int getMeal(String name) {
        try {
            Connection conn = Database.getConnection();
            Statement st = conn.createStatement();
            Queries q = new Queries();

            ResultSet r = st.executeQuery(q.mealQueries.getMealByName(name));
            //System.out.println(r);
            int mealId = 0;
            while (r.next()){
                mealId = r.getInt("id");
            }
            return mealId;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Meal getMealById(int mealId) {
        try {
            Connection conn = Database.getConnection();
            Statement st = conn.createStatement();
            Queries q = new Queries();

            ResultSet r = st.executeQuery(q.mealQueries.getMealById(mealId));

            Meal tmp = new Meal();
            while (r.next()){
                tmp.setId(r.getInt("id"));
                tmp.setName(r.getString("name"));
                tmp.setCalories(r.getDouble("calories"));
                tmp.setFats(r.getDouble("fats"));
                tmp.setProteins(r.getDouble("proteins"));
                tmp.setCarbohydrates(r.getDouble("carbohydrates"));
            }
            return tmp;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateUser(User u) {

    }

    @Override
    public void deleteUser(User u) {

    }

    @Override
    public void insertUser(User u) {

    }
}
