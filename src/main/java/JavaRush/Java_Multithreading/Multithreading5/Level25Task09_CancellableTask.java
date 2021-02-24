package JavaRush.Java_Multithreading.Multithreading5;

import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;

public interface Level25Task09_CancellableTask<T> extends Callable<T> {
    void cancel();
    RunnableFuture<T> newTask();
}
