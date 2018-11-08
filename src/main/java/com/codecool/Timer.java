package com.codecool;

public class Timer extends Thread {
    private boolean isPaused;
    private String name;
    private int time = 0;

    public Timer(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (!interrupted()) {
            incrementTime();
       }
    }

    private synchronized void incrementTime() {
        try {
            if (isPaused) {
                wait();
            }

            Thread.sleep(1000);
            time++;

        } catch (InterruptedException e) {
            interrupt();
        }
    }

    public synchronized void startAgain() {
        isPaused = false;
        notify();
    }

    public void pause() {
        isPaused = true;
    }


    public void display() {
        System.out.printf("Name: %s, ThreadId: %d, Seconds: %d\n", name, getId(), time);
    }
}
