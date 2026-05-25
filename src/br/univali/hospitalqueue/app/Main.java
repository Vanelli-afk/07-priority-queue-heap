package br.univali.hospitalqueue.app;

import java.util.Scanner;

import br.univali.hospitalqueue.datastructure.HeapPriorityQueue;
import br.univali.hospitalqueue.model.Patient;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

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

    private static void insertPatient(
            HeapPriorityQueue<Patient> queue) {

        System.out.println("\n=== INSERT PATIENT ===");

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Urgency level (1-5): ");
        int urgency = Integer.parseInt(scanner.nextLine());

        System.out.print("Wait time (minutes): ");
        int waitTime = Integer.parseInt(scanner.nextLine());

        System.out.print("Vulnerable group? (true/false): ");
        boolean vulnerable =
                Boolean.parseBoolean(scanner.nextLine());

        Patient patient = new Patient(
                name,
                urgency,
                waitTime,
                vulnerable
        );

        queue.enqueue(patient);

        System.out.println("\nPatient inserted successfully.");
    }

    private static void removePatient(
            HeapPriorityQueue<Patient> queue) {

        System.out.println("\n=== REMOVE PATIENT ===");

        if (queue.isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        Patient removed = queue.dequeue();

        System.out.println("\nRemoved patient:");
        System.out.println(removed);
    }

    private static void searchPatient(
            HeapPriorityQueue<Patient> queue) {

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

            if (patient.getName()
                    .equalsIgnoreCase(name)) {

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

    private static void listPatients(
            HeapPriorityQueue<Patient> queue) {

        System.out.println("\n=== PATIENT LIST ===");

        if (queue.isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.println(queue);
    }
}