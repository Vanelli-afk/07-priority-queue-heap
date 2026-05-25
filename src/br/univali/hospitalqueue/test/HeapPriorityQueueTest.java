package br.univali.hospitalqueue.test;

public class HeapPriorityQueueTest {

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