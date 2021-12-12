package tracker.models;

public class User {
    private int id;
    private String username;
    private String password;
    private int meal_log;
    private int age;
    private double weight;
    private double height;
    private int lifestyle;

    private String[] lifestyleList = {"normal", "good", "bad"};

    //default constructor
    public User(){};

    // constructor
    public User(String username, String password, int age, double weight, double height, int lifestyle){
        this.username = username;
        this.password = password;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.lifestyle = lifestyle;
    }


    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMeal_log() {
        return meal_log;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getLifestyle() {
        return lifestyle;
    }

    public void setLifestyle(int lifestyle) {
        this.lifestyle = lifestyle;
    }

    public void setMeal_log(int meal_log) {
        this.meal_log = meal_log;
    }

    public void setId(int id) {
        this.id = id;
    }
}
