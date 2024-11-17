import java.util.ArrayList;
import java.util.Scanner;

public class Main { // Online compilers often require the main class to be named "Main"
    static double currentBill = 150.75; // Example amount for demo
    static ArrayList<String> paymentHistory = new ArrayList<>();
   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Phone Bill Payment System ---");
            System.out.println("1. View Current Bill");
            System.out.println("2. Make a Payment");
            System.out.println("3. View Payment History");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
           
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewCurrentBill();
                    break;
                case 2:
                    makePayment(scanner);
                    break;
                case 3:
                    viewPaymentHistory();
                    break;
                case 4:
                    System.out.println("Exiting the system. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    public static void viewCurrentBill() {
        System.out.printf("Your current bill amount is: $%.2f\n", currentBill);
    }

    public static void makePayment(Scanner scanner) {
        System.out.print("Enter the amount to pay: $");
        double payment = scanner.nextDouble();
       
        if (payment <= 0) {
            System.out.println("Invalid payment amount! Please enter a positive value.");
        } else if (payment > currentBill) {
            System.out.printf("You paid $%.2f. Your account is now overpaid.\n", payment);
            paymentHistory.add(String.format("Paid $%.2f (Overpayment)", payment));
            currentBill = 0;
        } else {
            currentBill -= payment;
            System.out.printf("Payment of $%.2f successful. Remaining bill: $%.2f\n", payment, currentBill);
            paymentHistory.add(String.format("Paid $%.2f", payment));
        }
    }

    public static void viewPaymentHistory() {
        if (paymentHistory.isEmpty()) {
            System.out.println("No payments made yet.");
        } else {
            System.out.println("Payment History:");
            for (String record : paymentHistory) {
                System.out.println("- " + record);
            }
        }
    }
}
