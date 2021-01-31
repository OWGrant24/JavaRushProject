package Multithreading.Multithreading8.PhaserExp;

import java.util.concurrent.atomic.AtomicInteger;

public class Level28Task09_Plant extends Level28Task09_Character {
    private final static AtomicInteger idSequence = new AtomicInteger();
    private final int id = idSequence.incrementAndGet();

    protected int getId() {
        return id;
    }
}
