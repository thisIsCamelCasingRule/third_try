package tracker.DAO;


import tracker.database.Database;
import tracker.database.UserQueries;
import tracker.models.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class UserDaoImpl implements UserDao<tracker.models.User> {

    public UserDaoImpl(){}


    @Override
    public void deleteUser(User user) {
        try {
            Connection conn = Database.getConnection();
            Statement st = conn.createStatement();
            UserQueries q = new UserQueries();
            int res = st.executeUpdate(q.deleteUser(user));
            System.out.println("Student deleted from database status: " + res);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertUser(User u) {
        try {
            Connection conn = Database.getConnection();
            Statement st = conn.createStatement();
            UserQueries q = new UserQueries();

            boolean res = st.execute(q.insertUser(u));

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    //retrive list of users from the database
    @Override
    public List<User> getAllUsers() {
        try {
            List<User> userlist = new ArrayList<User>();
            Connection conn = Database.getConnection();
            Statement st = conn.createStatement();
            UserQueries q = new UserQueries();

            ResultSet res = st.executeQuery(q.getGetAllUsers());
            while(res.next()){
                User temp = new User();
                temp.setId(res.getInt("id"));
                temp.setUsername(res.getString("username"));
                temp.setPassword(res.getString("password"));
                temp.setAge(res.getInt("age"));
                temp.setHeight(res.getDouble("height"));
                temp.setWeight(res.getDouble("weight"));
                //temp.setMeal_log(res.getInt("meal_log"));
                temp.setLifestyle(res.getInt("lifestyle"));
                userlist.add(temp);
            }
            System.out.println("User list was created !");

            return userlist;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public User getUser(String username) {
        try {
            Connection conn = Database.getConnection();
            Statement st = conn.createStatement();
            UserQueries q = new UserQueries();

            ResultSet res = st.executeQuery(q.getUserByUsername(username));
            User temp = new User();
            while (res.next()){
                temp.setId(res.getInt("id"));
                temp.setUsername(res.getString("username"));
                temp.setPassword(res.getString("password"));
                temp.setAge(res.getInt("age"));
                temp.setHeight(res.getDouble("height"));
                temp.setWeight(res.getDouble("weight"));
                temp.setLifestyle(res.getInt("lifestyle"));

                System.out.println("Info about user with name "+username);
            }


            return temp;

        } catch (SQLException e) {
            return null;
            //e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateUser(User user){
        try {
            Connection conn = Database.getConnection();
            Statement st = conn.createStatement();
            UserQueries q = new UserQueries();

            int res = st.executeUpdate(q.updateUser(user));

            if (res == 1){
                System.out.println("User was updated!");
            }
            else if (res == 2){
                System.out.println("Somthing went wrong!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
