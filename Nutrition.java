public class Nutrition {
    private String name;
    private double calories;
    private double protein;
    private double fat;

    public Nutrition(String name, double calories, double protein, double fat) {
        this.name = name;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
    }

    public String getName() {
         return name; 
        }
    public double getCalories() {
         return calories; 
        }
    public double getProtein() {
         return protein; 
        }
    public double getFat() { 
        return fat; 
    }
}
