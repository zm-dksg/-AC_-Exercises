package org.academiadecodigo.bootcamp.concurrency.bqueue;

import java.util.LinkedList;

/**
 * Blocking Queue
 * @param <Integer> the type of elements stored by this queue
 */
public class BQueue<Integer> {

    private LinkedList<Integer> queue;
    private int limit;
    private int size;

    /**
     * Constructs a new queue with a maximum size
     * @param limit the queue size
     */
    public BQueue(int limit) {
        queue = new LinkedList<>();
        this.limit = limit;
        this.size  = 0;

        //throw new UnsupportedOperationException();

    }

    /**
     * Inserts the specified element into the queue
     * Blocking operation if the queue is full
     * @param data the data to add to the queue
     */
    public synchronized void offer(Integer data) {
        while (size >= limit) {
            System.out.println(Thread.currentThread().getName() + " > queue is full");
            try {
                wait();

            } catch (InterruptedException e) { e.printStackTrace(); }

        }

        size++;
        queue.add(data);
        notifyAll();

        //throw new UnsupportedOperationException();

    }

    /**
     * Retrieves and removes data from the head of the queue
     * Blocking operation if the queue is empty
     * @return the data from the head of the queue
     */
    public synchronized Integer poll() {
        while (size <= 0) {
            System.out.println(Thread.currentThread().getName() + " > queue is empty");
            try {
                wait();

            } catch (InterruptedException e) { e.printStackTrace(); }

        }

        size--;
        notifyAll();
        return queue.poll();

        //throw new UnsupportedOperationException();

    }

    /**
     * Gets the number of elements in the queue
     * @return the number of elements
     */
    public int getSize() {
        return size;

        //throw new UnsupportedOperationException();

    }

    /**
     * Gets the maximum number of elements that can be present in the queue
     * @return the maximum number of elements
     */
    public int getLimit() {
        return limit;

        //throw new UnsupportedOperationException();

    }

}
