package predavanja.queueimplementation;

public class QueueArr<E> implements ADTQUEUE<E>, Cloneable {

    private static final int CAPACITY = 10;
    private int front;
    private final int capacity;
    private int size;
    private E[] queue;

    public QueueArr() {
        this.capacity = CAPACITY;
        this.size = 0;
        this.front = 0;
        this.queue = (E[]) new Object[capacity];
    }

    public QueueArr(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.front = 0;
        this.queue = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public E first() {
        E element = null;
        if (isEmpty()) {
            System.out.println("Queue is empty!");
        } else {
            element = queue[front];
        }
        return element;
    }

    @Override
    public void enqueue(E element) {
        if (this.size < this.capacity) {
            System.out.println("Placing new element in the queue..." + element);
            int index = (front + size) % capacity;
            System.out.println("Added to index -> " + index);
            queue[index] = element;
            size++;
        } else {
            System.out.println("IT'S FULL, CAN'T ADD");
        }
    }

    @Override
    public E dequeue() {
        E element = null;
        if (isEmpty()) {
            System.out.println("NOTHING TO PROCESS - EMPTY");
        } else {
            element = queue[front];
            queue[front] = null;
            front = (front + 1) % capacity;
            size--;
        }
        return element;
    }

    @Override
    public String toString() {
        String frontRep = "Front: ";
        String sizeRep = "Size: ";
        String rep = "";

        if (isEmpty()) {
            sizeRep += size;
        } else {
            frontRep += front;
            sizeRep += size;
            for (int k = 0; k < capacity; k++) {
                if (k == front) {
                    rep += ">>[" + queue[front] + "]<<";
                } else {
                    rep += "[" + queue[k] + "]";
                }
            }
        }
        return sizeRep + "\n" + frontRep + "\n" + rep + "\n";
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        QueueArr<E> clonedQueue = (QueueArr<E>) super.clone();
        clonedQueue.queue = queue.clone();
        return clonedQueue;
    }
}
