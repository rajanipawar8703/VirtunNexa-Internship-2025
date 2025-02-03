import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("\nTemperature Converter");
                System.out.println("1. Celsius to Fahrenheit");
                System.out.println("2. Fahrenheit to Celsius");
                System.out.println("3. Celsius to Kelvin");
                System.out.println("4. Kelvin to Celsius");
                System.out.println("5. Fahrenheit to Kelvin");
                System.out.println("6. Kelvin to Fahrenheit");
                System.out.println("7. Exit");
                System.out.print("Choose an option: ");
                
                // Ensure valid choice input
                int choice = getValidChoice(scanner);

                if (choice == 7) {
                    System.out.println("Goodbye!");
                    break;
                }

                System.out.print("Enter temperature: ");
                
                // Ensure valid temperature input
                double temp = getValidTemperature(scanner);

                double converted;
                switch (choice) {
                    case 1:
                        converted = (temp * 9 / 5) + 32; // Celsius to Fahrenheit
                        System.out.println("Result: " + converted + " °F");
                        break;
                    case 2:
                        converted = (temp - 32) * 5 / 9; // Fahrenheit to Celsius
                        System.out.println("Result: " + converted + " °C");
                        break;
                    case 3:
                        converted = temp + 273.15; // Celsius to Kelvin
                        System.out.println("Result: " + converted + " K");
                        break;
                    case 4:
                        converted = temp - 273.15; // Kelvin to Celsius
                        System.out.println("Result: " + converted + " °C");
                        break;
                    case 5:
                        converted = (temp - 32) * 5 / 9 + 273.15; // Fahrenheit to Kelvin
                        System.out.println("Result: " + converted + " K");
                        break;
                    case 6:
                        converted = (temp - 273.15) * 9 / 5 + 32; // Kelvin to Fahrenheit
                        System.out.println("Result: " + converted + " °F");
                        break;
                    default:
                        System.out.println("Invalid option. Please choose a valid option.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine();  // Consume the invalid input to avoid infinite loop
            }
        }
        scanner.close();
    }

    // Method to validate the user's menu choice
    private static int getValidChoice(Scanner scanner) {
        int choice;
        while (true) {
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= 7) {
                    return choice;
                } else {
                    System.out.println("Invalid choice! Please choose a valid option (1-7):");
                }
            } else {
                System.out.println("Invalid input! Please enter an integer between 1 and 7:");
                scanner.next();  // Consume the invalid input
            }
        }
    }

    // Method to validate the temperature input
    private static double getValidTemperature(Scanner scanner) {
        double temp;
        while (true) {
            if (scanner.hasNextDouble()) {
                temp = scanner.nextDouble();
                return temp;
            } else {
                System.out.println("Invalid temperature input! Please enter a valid number:");
                scanner.next();  // Consume the invalid input
            }
        }
    }
}
