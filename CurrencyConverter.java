import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URISyntaxException;  
import java.util.Scanner;
import org.json.JSONObject;

public class CurrencyConverter {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/07c4baea72e14120bb46bd7a/latest/";

    // List of supported currencies
    private static final String[] SUPPORTED_CURRENCIES = {
        "USD", "EUR", "GBP", "INR", "AUD", "JPY", "CNY", "CAD", "MXN", "BRL", "CHF", "SEK", "NZD"
    };

    // Display supported currencies
    public static void displaySupportedCurrencies() {
        System.out.println("\nSupported Currencies:");
        for (String currency : SUPPORTED_CURRENCIES) {
            System.out.println(currency);
        }
    }

    // Fetch exchange rate from the API
    public static double getExchangeRate(String baseCurrency, String targetCurrency) throws IOException {
        String urlString = API_URL + baseCurrency;  // Dynamically append base currency to the API URL
        try {
            URL url = new URI(urlString).toURL();
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("HTTP Response Code: " + responseCode);
            }

            Scanner scanner = new Scanner(url.openStream());
            StringBuilder jsonStr = new StringBuilder();
            while (scanner.hasNext()) {
                jsonStr.append(scanner.nextLine());
            }
            scanner.close();

            JSONObject jsonObj = new JSONObject(jsonStr.toString());
            return jsonObj.getJSONObject("conversion_rates").getDouble(targetCurrency);

        } catch (URISyntaxException e) {
            System.out.println("Error: Invalid URL syntax");
            return 0;  // Return a default value in case of error
        }
    }

    // Main method to interact with the user
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nCurrency Converter");
            System.out.println("1. Convert Currency");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            if (choice == 2) {
                System.out.println("Exiting the application...");
                break;
            }

            // Display supported currencies
            displaySupportedCurrencies();

            System.out.print("Enter base currency: ");
            String baseCurrency = scanner.next().toUpperCase();
            if (!isValidCurrency(baseCurrency)) {
                System.out.println("Invalid base currency. Please enter a valid currency code.");
                continue;
            }

            System.out.print("Enter target currency: ");
            String targetCurrency = scanner.next().toUpperCase();
            if (!isValidCurrency(targetCurrency)) {
                System.out.println("Invalid target currency. Please enter a valid currency code.");
                continue;
            }

            System.out.print("Enter amount: ");
            double amount = scanner.nextDouble();

            try {
                double exchangeRate = getExchangeRate(baseCurrency, targetCurrency);
                if (exchangeRate != 0) {
                    double convertedAmount = amount * exchangeRate;
                    System.out.printf("%f %s = %f %s\n", amount, baseCurrency, convertedAmount, targetCurrency);
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }

    // Method to validate currency codes
    public static boolean isValidCurrency(String currency) {
        for (String supportedCurrency : SUPPORTED_CURRENCIES) {
            if (supportedCurrency.equals(currency)) {
                return true;
            }
        }
        return false;
    }
}
