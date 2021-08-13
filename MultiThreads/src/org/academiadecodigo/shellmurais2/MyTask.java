package org.academiadecodigo.shellmurais2;

public class MyTask implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());

    }

}
