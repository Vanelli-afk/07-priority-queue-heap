package br.univali.hospitalqueue.app;

import java.util.Scanner;
import br.univali.hospitalqueue.datastructure.HeapPriorityQueue;
import br.univali.hospitalqueue.model.Patient;

/**
 * Console entry-point interface orchestration pipeline for managing patient triage flows.
 * * @author Your Name
 * @version 1.0
 */
public class Main {

    /** Terminal Scanner listener instance accessing cross-method console loops. */
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Main runtime engine driving triage application lifecycle structures.
     *
     * @param args console startup args configuration parameters arrays
     */
    public static void main(String[] args) {

        HeapPriorityQueue<Patient> queue =
                new HeapPriorityQueue<>(100);

        int option;

        do {
            printMenu();
            option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    insertPatient(queue);
                    break;
                case 2:
                    removePatient(queue);
                    break;
                case 3:
                    searchPatient(queue);
                    break;
                case 4:
                    listPatients(queue);
                    break;
                case 0:
                    System.out.println("\nClosing system...");
                    break;
                default:
                    System.out.println("\nInvalid option.");
            }

        } while (option != 0);

        scanner.close();
    }

    /**
     * Renders user option layout choices inside the primary interface view loop.
     */
    private static void printMenu() {
        System.out.println("\n=================================");
        System.out.println(" HOSPITAL PRIORITY QUEUE SYSTEM ");
        System.out.println("=================================");
        System.out.println("1 - Insert patient");
        System.out.println("2 - Remove highest priority patient");
        System.out.println("3 - Search patient");
        System.out.println("4 - List patients");
        System.out.println("0 - Exit");
        System.out.print("Choose an option: ");
    }

    /**
     * Prompts terminal configurations inputs to register a new Patient entity into the heap.
     *
     * @param queue references targeted priority heap instance
     */
    private static void insertPatient(HeapPriorityQueue<Patient> queue) {
        System.out.println("\n=== INSERT PATIENT ===");

        System.out.print("Name: ");
        String rawName = scanner.nextLine();
        String capitalizedName = capitalizeName(rawName);

        System.out.print("Urgency level (1-5): ");
        int urgency = Integer.parseInt(scanner.nextLine());

        System.out.print("Wait time (minutes): ");
        int waitTime = Integer.parseInt(scanner.nextLine());

        System.out.print("Vulnerable group? (true/false): ");
        boolean vulnerable = Boolean.parseBoolean(scanner.nextLine());

        Patient patient = new Patient(
                capitalizedName,
                urgency,
                waitTime,
                vulnerable
        );

        queue.enqueue(patient);
        System.out.println("\nPatient inserted successfully.");
    }

    /**
     * Extracts and prints the highest clinical priority element from the heap.
     *
     * @param queue references targeted priority heap instance
     */
    private static void removePatient(HeapPriorityQueue<Patient> queue) {
        System.out.println("\n=== REMOVE PATIENT ===");

        if (queue.isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        Patient removed = queue.dequeue();
        System.out.println("\nRemoved patient:");
        System.out.println(removed);
    }

    /**
     * Sequentially scans active tracking arrays for matching name properties.
     *
     * @param queue references targeted priority heap instance
     */
    private static void searchPatient(HeapPriorityQueue<Patient> queue) {
        System.out.println("\n=== SEARCH PATIENT ===");

        if (queue.isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("Enter patient name: ");
        String name = scanner.nextLine();

        boolean found = false;

        for (int i = 0; i < queue.size(); i++) {
            Patient patient = queue.get(i);

            if (patient.getName().equalsIgnoreCase(name)) {
                System.out.println("\nPatient found:");
                System.out.println(patient);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("\nPatient not found.");
        }
    }

    /**
     * Loops through tracking indexes to format output visibility.
     *
     * @param queue references targeted priority heap instance
     */
    private static void listPatients(HeapPriorityQueue<Patient> queue) {
        System.out.println("\n=== PATIENT LIST ===");

        if (queue.isEmpty()) {
            System.out.println("[EMPTY HEAP]");
            return;
        }

        System.out.println("\n=========== HEAP ===========");
        for (int i = 0; i < queue.size(); i++) {
            System.out.printf("Position %d: %s\n", (i + 1), queue.get(i));
        }
        System.out.println("============================");
    }

    /**
     * Utility parser method ensuring text strings maintain standardized name capitalization structures.
     *
     * @param str raw input string text values target
     * @return transformed text matching Title Case guidelines
     */
    private static String capitalizeName(String str) {
        if (str == null || str.trim().isEmpty()) {
            return str;
        }
        
        String[] words = str.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        
        for (String word : words) {
            if (!word.isEmpty()) {
                sb.append(Character.toUpperCase(word.charAt(0)))
                .append(word.substring(1).toLowerCase())
                .append(" ");
            }
        }
        
        return sb.toString().trim();
    }
}