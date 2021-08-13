package org.academiadecodigo.shellmurais.casadebanho1;

public class Bathroom {

    private Toilet toilet;

    public Bathroom() {
        toilet = new Toilet();
    }

    public void enter() {
        synchronized (toilet) {
            System.out.println(Thread.currentThread().getName() + " entering toilet...");
            toilet.use();
            try {
                Thread.sleep(500);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " leaving toilet...");
            System.out.println("===========================");

        }

    }

    public synchronized void washHands() {
        System.out.println(Thread.currentThread().getName() + ": *washy washy*");

    }

}
