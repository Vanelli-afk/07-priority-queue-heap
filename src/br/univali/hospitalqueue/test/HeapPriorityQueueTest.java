package br.univali.hospitalqueue.test;

import br.univali.hospitalqueue.datastructure.HeapPriorityQueue;
import br.univali.hospitalqueue.model.Patient;

/**
 * Automated script mock testing package routing validation parameters.
 * Validates heap transformations using the 6 scenario data matrix configurations from instructions.
 * * @author Miguel Vanelli
 * @version 1.0
 */
public class HeapPriorityQueueTest {

    /**
     * Executes assertions printing internal heap changes over data ingestion metrics.
     *
     * @param args system console execution attributes maps
     */
    public static void main(String[] args) {

        HeapPriorityQueue<Patient> queue =
                new HeapPriorityQueue<>(10);

        queue.enqueue(new Patient("Carlos", 2, 45, false));
        System.out.println(queue);

        queue.enqueue(new Patient("Maria", 5, 5, false));
        System.out.println(queue);

        queue.enqueue(new Patient("João", 3, 20, false));
        System.out.println(queue);

        queue.enqueue(new Patient("Beatriz", 3, 35, true));
        System.out.println(queue);

        queue.enqueue(new Patient("Pedro", 5, 2, false));
        System.out.println(queue);

        queue.enqueue(new Patient("Helena", 2, 45, true));
        System.out.println(queue);

        System.out.println(
            "\n=========== SERVICE ORDER ==========="
        );

        int order = 1;

        while (!queue.isEmpty()) {
            System.out.println(
                order + " -> " + queue.dequeue()
            );
            order++;
        }

        System.out.println(
            "====================================="
        );
    }
}