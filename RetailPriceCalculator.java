import java.util.Scanner;

public class RetailPriceCalculator {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.class);
        System.out.println("Retail Price Calculator started. (type 'stop' at the cost to exit)");

        while (true){
            System.out.print("\nEnter the item's wholesale cost (or 'stop' to quit): ");
            String costInput = keyboard.nextLine().trim();

            if (costInput.equalsIgnoreCase("stop")){
                System.out.println("bye bye!!!");
                break;
            }

            double wholesaleCost = validateAndParseInput(costInput);
            if (wholesaleCost < 0){
                continue;
            }

            System.out.print("Enter the markup percent: ");
            String markupInput = keyboard.nextLine().trim();

            double markupPercentage = validateAndParseInput(markupInput);
            if (markupPercentage < 0) {
                continue;
            }
            
            double retailPrice = calculateRetail(wholesaleCost, markupPercentage);
            System.out.printf("Expected Retail Price: %.1f\n", retailPrice);

        }
        keyboard.close();
    }
    public static double calculateRetail(double wholesaleCost, double markupPercentage){
        return wholesaleCost + (wholesaleCost * (markupPercentage / 100.0));
    }
    private static double validateAndParseInput(String input){
        if (input.isEmpty()){
            System.out.println("Error: Input cannot be blank");
            return -1;
        }
        try{
            double value = Double.parseDouble(input);
            if (value < 0){
                System.out.println("Error: Negative numbers are not allowed");
                return -1;
            }
            return value;
        } catch (NumberFormatException e){
            System.out.println("Error: Invalid input. Please enter a valid number");
            return -1;
        }
    }
}