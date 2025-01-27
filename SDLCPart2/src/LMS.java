/*
 * Name: Dereck Velez Matias
 * Course: CEN 3024C-24204
 * Date: 01/26/2025
 * This class contains the main application for the library management software.
 * The LMS lets librarians easily manage their patrons from within the app. With it,
 * they can: insert patrons using text files, display a list of all current patrons,
 * manually add new patrons, manually remove patrons, and close the app when they are done.
 */


import java.util.*;
import java.io.*;

public class LMS {

    private static List<String> patrons = new ArrayList<>();

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        //Prints all the options the user has
        //The menu loops until the user decides to exit
        while (true) {
            System.out.println("\nLibrary Management System:");
            System.out.println("1. Load patrons from a file");
            System.out.println("2. Display all patrons");
            System.out.println("3. Add a new patron");
            System.out.println("4. Remove a patron");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> loadPatrons(scanner);
                case "2" -> displayPatrons();
                case "3" -> addPatron(scanner);
                case "4" -> removePatron(scanner);
                case "5" -> {
                    System.out.println("Exiting the program.");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    //The loadPatrons method uses BufferedReader to load patron information from text files
    //supplied by the user. It inputs a file path and outputs a message letting the user
    //know whether it could successfully read the information or not
    private static void loadPatrons(Scanner scanner) {
        System.out.print("Enter file path: ");
        String filePath = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                patrons.add(line.trim());
            }
            System.out.println("Patrons loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    //The displayPatrons method displays a list of all current patrons in the system.
    private static void displayPatrons() {
        if (patrons.isEmpty()) {
            System.out.println("No patrons in the system.");
        } else {
            System.out.println("\nCurrent Patrons:");
            for (String patron : patrons) {
                System.out.println(patron);
            }
        }
    }

    //The addPatron method lets users manually type in patron information. After using
    //the displayPatrons method, any patrons added with addPatron will also be included
    //in the list
    private static void addPatron(Scanner scanner) {
        System.out.print("Enter patron details (ID, Name, Address, Fine): ");
        String patronDetails = scanner.nextLine();
        patrons.add(patronDetails.trim());
        System.out.println("Patron added successfully.");
    }

    //The removePatron method lets the user input an ID for a patron they'd like to remove.
    //It outputs its success on removing a patron
    private static void removePatron(Scanner scanner) {
        System.out.print("Enter patron ID to remove: ");
        String id = scanner.nextLine();
        boolean removed = patrons.removeIf(patron -> patron.startsWith(id + ","));
        if (removed) {
            System.out.println("Patron removed successfully.");
        } else {
            System.out.println("No patron found with ID: " + id);
        }
    }
}