package tracker.models;

public class Meal {

    private int id;
    private String name;
    private double calories;
    private double fats;
    private double proteins;
    private double carbohydrates;

    public Meal(){}

    public Meal(String name, double calories, double fats, double proteins, double carbohydrates) {
        this.name = name;
        this.calories = calories;
        this.fats = fats;
        this.proteins = proteins;
        this.carbohydrates = carbohydrates;
    }

    public double getCalories() {
        return calories;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public double getFats() {
        return fats;
    }

    public double getProteins() {
        return proteins;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public void setFats(double fats) {
        this.fats = fats;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProteins(double proteins) {
        this.proteins = proteins;
    }

}
