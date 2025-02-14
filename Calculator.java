import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private double totalCalories = 0;
    private double totalProtein = 0;
    private double totalFat = 0;
    private List<Nutrition> nutritionList = new ArrayList<>();

    public void addNutrition(Nutrition nutrition) {
        totalCalories += nutrition.getCalories();
        totalProtein += nutrition.getProtein();
        totalFat += nutrition.getFat();
        nutritionList.add(nutrition); 
    }

    public void showTotalNutrition() {
        System.out.println("List of all added Nutrition:");
        for (Nutrition nutrition : nutritionList) {
            System.out.println("- " + nutrition.getName() + ": " +
                               nutrition.getCalories() + " kcal, " +
                               nutrition.getProtein() + " g protein, " +
                               nutrition.getFat() + " g fat");
        }
        System.out.println("\nTotal Calories: " + totalCalories + " kcal");
        System.out.println("Total Protein: " + totalProtein + " g");
        System.out.println("Total Fat: " + totalFat + " g");
    }

    public double calculateBMR(double weight, double height, int age, char gender) {
        if (gender == 'M' || gender == 'm') {
            return 10 * weight + 6.25 * height - 5 * age + 5;
        } else if (gender == 'F' || gender == 'f') {
            return 10 * weight + 6.25 * height - 5 * age - 161;
        }
        return 0;
    }

    public double calculateTDEE(double weight, double height, int age, char gender, String activityLevel) {
        double bmr = calculateBMR(weight, height, age, gender);
        switch (activityLevel.toLowerCase()) {
            case "sedentary":
             return bmr * 1.2;
            case "light":
             return bmr * 1.375;
            case "moderate":
             return bmr * 1.55;
            case "active":
             return bmr * 1.725;
            case "very active":
             return bmr * 1.9;
            default:
             return bmr;
        }
    }

    public double calculateBMI(double weight, double height) {
        height = height / 100;
        return weight / (height * height);
    }

    public void showBMICategory(double bmi) {
        System.out.println("Your BMI: " + bmi);
        if (bmi < 18.5) System.out.println("BMI Category: Underweight");
        else if (bmi < 24.9) System.out.println("BMI Category: Normal weight");
        else if (bmi < 29.9) System.out.println("BMI Category: Overweight");
        else System.out.println("BMI Category: Obesity");
    }
}
