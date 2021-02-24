package JavaRush.Java_Multithreading.Multithreading9;

import java.util.concurrent.*;

public class Level29Task08_CacheComputeManager<Argument,Value> implements Level29Task08_Computable<Argument,Value> {
    private final ConcurrentHashMap<Argument, Future<Value>> cache = new ConcurrentHashMap<>();
    private final Level29Task08_Computable<Argument, Value> computable;

    public Level29Task08_CacheComputeManager(Level29Task08_Computable<Argument, Value> computable) {
        this.computable = computable;
    }

    @Override
    public Value compute(final Argument arg) throws InterruptedException {
        Future<Value> f = cache.get(arg);
        if (f == null) {
            FutureTask<Value> ft = createFutureTaskForNewArgumentThatHasToComputeValue(arg);
            cache.putIfAbsent(arg, ft);
            f = ft;
            ft.run();
            System.out.print(arg + " will be cached  ");
        } else {
            System.out.print(arg + " taken from cache  ");
        }
        try {
            return f.get();
        } catch (CancellationException e) {
            cache.remove(arg, f);
        } catch (ExecutionException e) {
            throw new RuntimeException(e.getCause());
        }
        return null;
    }

    public FutureTask<Value> createFutureTaskForNewArgumentThatHasToComputeValue(final Argument arg) {
        FutureTask<Value> futureTask = new FutureTask<>(new Callable<Value>() {
            @Override
            public Value call() throws Exception {
                return computable.compute(arg);
            }
        });
        return futureTask;
    }
}