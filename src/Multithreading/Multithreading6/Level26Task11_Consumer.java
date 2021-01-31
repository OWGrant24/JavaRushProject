package Multithreading.Multithreading6;

import java.util.concurrent.ConcurrentHashMap;

public class Level26Task11_Consumer implements Runnable {
    private ConcurrentHashMap<String, String> map;

    public Level26Task11_Consumer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    public void run() {
        Thread currentThread = Thread.currentThread();
        while (!currentThread.isInterrupted()) {
            if (!map.isEmpty()) {
                for (String key : map.keySet()) {
                    System.out.println(map.remove(key));
                }
            }
        }
    }
}

