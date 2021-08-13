package org.academiadecodigo.shellmurais;


import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

    Timer timer;
    Timer timer1;

    public static void main(String[] args) {
        System.out.println("Thread: " + Thread.currentThread().getName());
        Scanner scan = new Scanner(System.in);

        System.out.print("Number of times to ring? ");
        int numRings = scan.nextInt();

        System.out.print("Ring interval in seconds? ");
        int ringinterval = scan.nextInt();

        Main alarm = new Main();
        alarm.start(ringinterval,numRings);

    }

    private void start(int ringInterval, int numRings) {
        timer = new Timer();
        timer.scheduleAtFixedRate(new Ring(numRings),ringInterval*1000,ringInterval*1000);

        timer1 = new Timer();
        timer1.scheduleAtFixedRate(new Ring(numRings),ringInterval*1000,ringInterval*1000);

    }

    public class Ring extends TimerTask {

        private int numRings;

        public Ring(int numRings) {
            this.numRings = numRings;

        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ": Alarm is ringing!!");

            numRings--;
            if (numRings == 0) {
                System.out.println(Thread.currentThread().getName() + ": Alarm is off.");
                stop();

            }

        }

        private void stop() {
            timer.cancel();
            timer1.cancel();

        }

    }

}
