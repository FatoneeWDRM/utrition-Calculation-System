import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        User user = new User(name);

        boolean run = true;

        while (run) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Nutrition");
            System.out.println("2. Show Total Nutrition");
            System.out.println("3. Calculate TDEE"); //คำนวณพลังงานที่ใช้ทั้งหมดต่อวัน
            System.out.println("4. Calculate BMI");//ดัชนีมวลกาย
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine();// ล้างบัฟเฟอร์ที่ค้างจากการอ่านตัวเลข
                    System.out.print("Enter food name: ");
                    String foodName = scanner.nextLine();
                    System.out.print("Enter calories: ");
                    double calories = scanner.nextDouble();
                    System.out.print("Enter protein (g): ");
                    double protein = scanner.nextDouble();
                    System.out.print("Enter fat (g): ");
                    double fat = scanner.nextDouble();

                    Nutrition nutrition = new Nutrition(foodName, calories, protein, fat);// สร้างอ็อบเจกต์ Nutrition เพื่อเก็บข้อมูลโภชนาการที่ป้อน
                    user.addNutrition(nutrition);// เรียกเมธอด addNutrition เพื่อเพิ่มโภชนาการใน User
                    break;
                case 2:
                    user.showTotalNutrition();
                    break;
                case 3:
                    System.out.print("Enter your weight (kg): ");
                    double weight = scanner.nextDouble();
                    System.out.print("Enter your height (cm): ");
                    double height = scanner.nextDouble();
                    System.out.print("Enter your age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter your gender (M/F): ");
                    String gender = scanner.nextLine();
                    System.out.print("Enter your activity level (sedentary/light/moderate/active/very active): ");
                    String activityLevel = scanner.nextLine();

                    user.calculateTDEE(weight, height, age, gender.charAt(0), activityLevel);
                    break;
                case 4:
                    System.out.print("Enter your weight (kg): ");
                    weight = scanner.nextDouble();
                    System.out.print("Enter your height (cm): ");
                    height = scanner.nextDouble();

                    double bmi = user.calculateBMI(weight, height);
                    user.showBMICategory(bmi);
                    break;
                case 5:
                    run = false;
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
        scanner.close();
    }
}
