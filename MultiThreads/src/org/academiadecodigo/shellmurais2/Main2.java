package org.academiadecodigo.shellmurais2;

public class Main2 {

    public static void main(String[] args) {
        MyTask task = new MyTask();
        task.run();

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new MyTask());
            thread.setName("T" + i);
            thread.start();

        }

    }

}
