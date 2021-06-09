package GOFO.UI;

import java.util.Scanner;

public class AdministratorUI {
    public AdministratorUI() {
        System.out.println("Welcome Administrator.");
        mainMenu();
    }

    /**
     * Let an admin choose an option from the menu.
     */
    private void mainMenu() {
        System.out.println("\n1.Manage playgrounds.\n" +
                "2. Manage complaints.\n" +
                "3. Log Out.");
        int choice = getChoice(3);
        switch (choice) {
            case 1 -> managePlaygrounds();
            case 2 -> manageComplaints();
            case 3 -> new UI();
        }
    }

    /**
     * Manage a complaint by suspending a playground or not.
     */
    private void manageComplaints() {
        System.out.println("\n1. View complaints.\n" +
                "2. Resolve a complaint.\n" +
                "3. Go to Main Menu.");
        int choice = getChoice(3);

        switch (choice) {
            case 1 -> viewComplaints();
            case 2 -> resolveComplaint();
            case 3 -> mainMenu();
        }
    }

    /**
     * Resolve a complaint.
     */
    private void resolveComplaint() {

    }

    /**
     * See a list of unresolved complaints.
     */
    private void viewComplaints() {

    }

    /**
     * Gives control to the administrator to approve, suspend, or remove
     * a playground.
     */
    private void managePlaygrounds() {
        System.out.println("\n1. Approve a playground.\n" +
                "2. Suspend a playground.\n" +
                "3. Remove a playground.\n" +
                "4. Go to Main Menu.");
        int choice = getChoice(4);

        switch (choice) {
            case 1 -> approvePlayground();
            case 2 -> suspendPlayground();
            case 3 -> removePlayground();
            case 4 -> mainMenu();
        }
    }

    /**
     * Remove a playground.
     */
    private void removePlayground() {

    }

    /**
     * Suspend a playground.
     */
    private void suspendPlayground() {

    }

    /**
     * Approve a playground
     */
    private void approvePlayground() {

    }

    private int getChoice(int max) {
        Scanner input = new Scanner(System.in);
        System.out.print("\nChoice (1 - " + max + "): ");
        int choice = input.nextInt();
        while (choice < 1 || choice > max) {
            System.out.println("Invalid input");
            System.out.print("\nChoice (1 - " + max + "): ");
            choice = input.nextInt();
        }

        return choice;
    }
}
