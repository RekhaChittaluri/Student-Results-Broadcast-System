import java.util.HashMap;
import java.util.Scanner;

public class ResultSystem {

    // HashMap to store student ID and their result
    private static HashMap<String, String> studentResults = new HashMap<>();

    // Method to add student result
    public static void addResult(String studentId, String result) {
        studentResults.put(studentId, result);
        System.out.println("Result added successfully!\n");
    }

    // Method to retrieve result
    public static void getResult(String studentId) {
        if (studentResults.containsKey(studentId)) {
            System.out.println("Student ID: " + studentId);
            System.out.println("Result: " + studentResults.get(studentId));
        } else {
            System.out.println("No result found for Student ID: " + studentId);
        }
    }

    // Method to display all results
    public static void displayAllResults() {
        if (studentResults.isEmpty()) {
            System.out.println("No results available.");
        } else {
            System.out.println("\nAll Student Results:");
            for (String studentId : studentResults.keySet()) {
                System.out.println("ID: " + studentId + " | Result: " + studentResults.get(studentId));
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n==== Student Results Broadcast System ====");
            System.out.println("1. Add Student Result");
            System.out.println("2. Get Student Result");
            System.out.println("3. Display All Results");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Result (e.g., Pass / Fail / Marks): ");
                    String res = sc.nextLine();
                    addResult(id, res);
                    break;

                case 2:
                    System.out.print("Enter Student ID to retrieve result: ");
                    String searchId = sc.nextLine();
                    getResult(searchId);
                    break;

                case 3:
                    displayAllResults();
                    break;

                case 4:
                    System.out.println("Exiting system. Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);

        sc.close();
    }
}
