package com.codecool;

public class Timer implements Runnable {
    private String name;

    public Timer(String name) {
        this.name = name;
    }

    @Override
    public void run() {

    }

    public void display() {
        System.out.printf("Name: %s, ThreadId: %d, Seconds: %d\n", name, getId(), time);
    }
}
