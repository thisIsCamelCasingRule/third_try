package tracker.database;

public class Queries {
    public UserQueries userQueries;
    public MealQueries mealQueries;
    public MealLogQueries mealLogQueries;

    public Queries(){
        this.userQueries = new UserQueries();
        this.mealLogQueries = new MealLogQueries();
        this.mealQueries = new MealQueries();
    }
}
