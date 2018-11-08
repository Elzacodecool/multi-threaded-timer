package com.codecool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class TimerContainer implements Runnable {
    private Map<String, Timer> timers = new HashMap<>();


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
            timers.get(name).start();
        } else {
            timers.put(name, new Timer(name));
        }
    }
}
