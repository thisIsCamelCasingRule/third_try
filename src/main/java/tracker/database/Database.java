package tracker.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Database {
    // Driver and db_path
    //static final String JDBC_DRIVER = ;
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/fattracker";

    // User and Password
    static final String USER = "tracker";
    static final String PASSWORD = "1234";

    public Database(){};

    // Get connection to DB
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", USER);
        connectionProps.put("password", PASSWORD);
        try {
            conn = DriverManager.getConnection(DATABASE_URL, connectionProps);
        } catch (SQLException e){
            e.printStackTrace();
        }
        System.out.println("Connected to database");
        return conn;
    }

    // Executes given statement
    public boolean executeStatement(String query) throws SQLException, ClassNotFoundException{
       try{
           Connection conn = getConnection();
           Statement stmt = conn.createStatement();
           boolean re = stmt.execute(query);
           //ResultSet res = stmt.executeUpdate(query);
           stmt.close();
           conn.close();
           return re;
       } catch (SQLException e){
           e.printStackTrace();
       }
      return false;
    }
}
