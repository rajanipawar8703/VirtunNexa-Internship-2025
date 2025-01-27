import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nTemperature Converter");
            System.out.println("1. Celsius to Fahrenheit");
            System.out.println("2. Fahrenheit to Celsius");
            System.out.println("3. Celsius to Kelvin");
            System.out.println("4. Kelvin to Celsius");
            System.out.println("5. Fahrenheit to Kelvin");
            System.out.println("6. Kelvin to Fahrenheit");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            if (choice == 7) {
                System.out.println("Goodbye!");
                break;
            }

            System.out.print("Enter temperature: ");
            double temp = scanner.nextDouble();
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
        }
        scanner.close();
    }
}
