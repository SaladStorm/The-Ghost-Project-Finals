import java.util.Scanner;

public class CurrencyConvertionStringActivity {
    // 1. Fixed the array initialization
    private final String[] currencies = {"USD", "EUR", "AUD", "SGD", "MYR", "INR", "CAD", "CHF", "JPY", "PHP"};
    
    // Constructor 
    public CurrencyConvertionStringActivity() {
        try (Scanner input = new Scanner(System.in)) {
            // 2. Loop through the existing array to display options
            for(int i = 0; i < currencies.length; i++)
            {
                System.out.println((i + 1) + ". " + currencies[i]);
            }
            
            System.out.print("\nSelect a currency number: ");
            int choice1 = input.nextInt();
            
            // Validation logic
            if(choice1 > 0 && choice1 <= currencies.length)
            {
                System.out.println("You selected: " + currencies[choice1 - 1]);
                for(int i = 0; i < currencies.length; i++)
                {
                    System.out.println((i + 1) + ". " + currencies[i]);
                }
                
                System.out.print("\nSelect a currency number that you want to convert to: ");
                int choice2 = input.nextInt();
                if(choice2 > 0 && choice2 <= currencies.length)
                {
                    System.out.println(currencies[choice1 - 1] + " has been converted to " + currencies[choice2 - 1]);
                } else {
                    System.out.println("Invalid selection.");
                }
            }
            else
            {
                System.out.println("Invalid selection.");
            }
        }
    }

    public static void main(String[] args) {
        CurrencyConvertionStringActivity app = new CurrencyConvertionStringActivity();
    }
}