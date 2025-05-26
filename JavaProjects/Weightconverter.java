import java.util.Scanner;

public class Weightconverter {

    public static void main(String[] args) {
        // weight conversion program
        Scanner scanner = new Scanner(System.in);

        // declare variables
        double weight;
        double newWeight;
        int choice;

        // Print welcome message
        System.out.println("Weight conversion Program");
        // options to choose from
        System.out.println("1: Convert lbs to kgs");
        System.out.println("2: Convert kgs to lbs");

        System.out.print("Choose an option: ");
        choice = scanner.nextInt();

        if (choice == 1) {
            System.out.print("Enter weight in lbs: ");
            weight = scanner.nextDouble();
            newWeight = weight * 0.453592;
            System.out.printf("The new weight in kgs is: %.2f \n", newWeight);

        } else if (choice == 2) {
            System.out.print("Enter weight in kgs: ");
            weight = scanner.nextDouble();
            newWeight = weight * 2.20462;
            System.out.printf("The new weight in lbs is: %.2f \n", newWeight);

        } else {
            System.out.println("That is not a valid choice. Please use the given choices");
        }

        scanner.close();
    }
}