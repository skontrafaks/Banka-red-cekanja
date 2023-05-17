package predavanja.queueimplementation;

public interface ADTQUEUE<E> {

    /**
     * Gives size of the queue
     *
     * @return size
     */
    int size();

    /**
     * Provides first element but does not
     * remove it from the queue
     *
     * @return forst element
     */
    E first();

    /**
     * puts new element at the end of the queue
     *
     * @param element
     */
    void enqueue(E element);

    /**
     * Gives and removes the first elment
     * from the queue
     *
     * @return element
     */
    E dequeue();

    /**
     * Check if empty or not
     *
     * @return true or false
     */
    boolean isEmpty();

}
