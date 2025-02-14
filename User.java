public class User {
    private String name;
    private Calculator calculator;

    public User(String name) {
        this.name = name;
        this.calculator = new Calculator();
    }

    public void addNutrition(Nutrition nutrition) {
        calculator.addNutrition(nutrition);
    }

    public void showTotalNutrition() {
        calculator.showTotalNutrition();
    }

    public void calculateTDEE(double weight, double height, int age, char gender, String activityLevel) {
        double tdee = calculator.calculateTDEE(weight, height, age, gender, activityLevel);
        System.out.println("Your TDEE: " + tdee + " kcal/day");
    }

    public double calculateBMI(double weight, double height) {
        return calculator.calculateBMI(weight, height);
    }

    public void showBMICategory(double bmi) {
        calculator.showBMICategory(bmi);
    }
}
