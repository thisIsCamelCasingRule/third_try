package tracker.DAO;

import tracker.database.Database;
import tracker.database.Queries;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MealLogDaoImpl implements MealLogDao{

    public MealLogDaoImpl(){}

    @Override
    public int insertMealLog(int userId, int mealId) {
        try {
            Connection conn = Database.getConnection();
            Statement st = conn.createStatement();
            Queries q = new Queries();

            int res = st.executeUpdate(q.mealLogQueries.InsertNewMeal(userId, mealId));
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public List<Integer> getAllUserMeal(int userId) {
        try {
            Connection conn = Database.getConnection();
            Statement st = conn.createStatement();
            List<Integer> resList = new ArrayList<>();
            Queries q = new Queries();

            ResultSet res = st.executeQuery(q.mealLogQueries.GetMealIdsFromUserId(userId));
            while (res.next()){
                resList.add(res.getInt("meal_id"));
            }
            return resList;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
