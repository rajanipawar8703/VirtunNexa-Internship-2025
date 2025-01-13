import java.util.Scanner;

public class BinaryToDecimalConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
       
        System.out.print("Enter a binary number as a String: ");
        String binaryString = scanner.nextLine();
        
       
        if (isBinary(binaryString)) {
            // Convert the binary string to a decimal number
            int decimal = convertBinaryToDecimal(binaryString);
            System.out.println("Decimal equivalent: " + decimal);
        } else {
            System.out.println("Invalid binary number. Please enter only 0s and 1s.");
        }

        scanner.close();
    }

    // Method to check if the input string is a valid binary number
    private static boolean isBinary(String binaryString) {
        return binaryString.matches("[01]+"); // Match only strings containing 0s and 1s
    }

    // Method to convert a binary string to a decimal number
    private static int convertBinaryToDecimal(String binaryString) {
        return Integer.parseInt(binaryString, 2); // Convert using base 2
    }
}
