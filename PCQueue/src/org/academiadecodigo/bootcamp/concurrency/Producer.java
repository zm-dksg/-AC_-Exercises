package org.academiadecodigo.bootcamp.concurrency;

import org.academiadecodigo.bootcamp.concurrency.bqueue.BQueue;

/**
 * Produces and stores integers into a blocking queue
 */
public class Producer implements Runnable {

    private final BQueue<Integer> queue;
    private int elementNum;
    private int elementCur;

    /**
     * @param queue the blocking queue to add elements to
     * @param elementNum the number of elements to produce
     */
    public Producer(BQueue queue, int elementNum) {
        this.queue = queue;
        this.elementNum = elementNum;
        this.elementCur = 0;

    }

    @Override
    public void run() {
        while (elementCur < elementNum) {
            synchronized (queue) {
                queue.offer(++elementCur);
                if (queue.getSize() == queue.getLimit()) {
                    System.out.println(Thread.currentThread().getName()
                            + ": added one element to the queue(" + queue.getSize() + "), the queue is now full");

                } else {
                    System.out.println(Thread.currentThread().getName()
                            + ": added one element to the queue(" + queue.getSize() + ")");

                }
            }

        }

    }

}
