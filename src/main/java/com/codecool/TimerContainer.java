package com.codecool;

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


}
