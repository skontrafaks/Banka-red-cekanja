package predavanja.queueimplementation;

public class TestQueue {

    public static void main(String[] args) {
        QueueArr<String> qs = new QueueArr<>(5);
        qs.enqueue("A");
        qs.enqueue("B");
        qs.enqueue("C");
        qs.enqueue("D");
        qs.enqueue("E");
        qs.enqueue("F");
        System.out.println(qs);
        String inProcess;
        inProcess = qs.dequeue();
        System.out.println("processing..." + inProcess);
        System.out.println(qs);
        qs.enqueue("F");
        System.out.println(qs);
        qs.dequeue();
        qs.dequeue();
        qs.dequeue();
        qs.dequeue();
        System.out.println(qs);
        qs.dequeue();
        System.out.println(qs);

    }
}
