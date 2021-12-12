package tracker.database;


import tracker.models.User;

public class UserQueries {
    public UserQueries(){};

    public String getGetAllUsers() {
        return "SELECT * FROM User";
    }

    public String getIbByName(String name){
        return "select id from User where username = '"+name+"'";
    }

    public String insertUser(User u){
        return "INSERT INTO User(username, password, age, weight, height, lifestyle) VALUES('"+u.getUsername()+ "','"+u.getPassword()+"',"+u.getAge()+","+u.getWeight()+","+u.getHeight()+","+u.getLifestyle()+")";
    }

    public String deleteUser(User user){
        return "DELETE FROM User WHERE id = " + user.getId();
    }

    public String updateUser(User u){
        return "UPDATE User SET username = '"+u.getUsername()+"', weight = "+u.getWeight()+", height = "+u.getHeight()+", lifestyle = "+u.getLifestyle();
    }

    public String getUserByUsername(String uname){
        return "SELECT * FROM User WHERE username = '"+uname+"' LIMIT 1";
    }
}
