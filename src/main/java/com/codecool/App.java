package com.codecool;

public class App {
    public static void main(String[] args) {
        Thread thread = new Thread(new TimerContainer());
        thread.start();
    }
}
