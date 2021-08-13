package org.academiadecodigo.bootcamp.concurrency;

import org.academiadecodigo.bootcamp.concurrency.bqueue.BQueue;

/**
 * Consumer of integers from a blocking queue
 */
public class Consumer implements Runnable {

    private final BQueue<Integer> queue;
    private int elementNum;
    private int elementCur;

    /**
     * @param queue the blocking queue to consume elements from
     * @param elementNum the number of elements to consume
     */
    public Consumer(BQueue queue, int elementNum) {
        this.queue = queue;
        this.elementNum = elementNum;
        this.elementCur = 0;

    }

    @Override
    public void run() {
        while (elementCur < elementNum) {
            synchronized (queue) {
                queue.poll();
                if (queue.getSize() == 0) {
                    System.out.println(Thread.currentThread().getName()
                            + ": consumed one element from the queue(" + queue.getSize() + "), the queue is now empty");

                } else {
                    System.out.println(Thread.currentThread().getName()
                            + ": consumed one element from the queue(" + queue.getSize() + ")");

                }

            }
            ++elementCur;

        }

    }

}
