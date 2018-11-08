package com.codecool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Time;
import java.util.HashMap;
import java.util.Map;

public class TimerContainer implements Runnable {
    private Map<String, Timer> timers = new ConcurrentHashMap<>();


    @Override
    public void run() {
        boolean isRun = true;

        while (isRun) {
            String[] command = getCommand();

            switch (command[0]) {
                case "start":
                    startTimer(command[1]);
                    break;
                case "stop":
                    stopTimer(command[1]);
                    break;
                case "check":
                    check();
                    break;
                case "exit":
                    isRun = false;
                    exit();
                    break;
            }
        }
    }


    private String[] getCommand() {
        System.out.println("Command?");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return reader.readLine().split(" ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return getCommand();
    }

    private void startTimer(String name) {
        if (timers.containsKey(name)) {
            timers.get(name).startAgain();
        } else {
            Timer timer = new Timer((name));
            timer.start();
            timers.put(name, timer);
        }
    }

    private void stopTimer(String name) {
        timers.get(name).pause();
    }

    private void check() {
        timers.forEach((key, value) -> value.display());
    }

    private void exit() {
        timers.forEach((key, value) -> value.interrupt());
    }
}
