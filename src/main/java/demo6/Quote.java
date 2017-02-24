package demo6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Quote
 *
 * @author liuruichao
 * @date 15/7/28 下午2:11
 */
public class Quote {
    private static final ExecutorService exec = Executors.newCachedThreadPool();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        getRankedTravelQuotes();
        exec.shutdown();
    }

    public static List<TravelQuote> getRankedTravelQuotes() throws InterruptedException, ExecutionException {
        List<QuoteTask> tasks = new ArrayList<>();
        tasks.add(new QuoteTask());
        tasks.add(new QuoteTask());
        tasks.add(new QuoteTask());
        tasks.add(new QuoteTask());
        List<Future<TravelQuote>> futures = exec.invokeAll(tasks, 2, TimeUnit.SECONDS);
        for (Future<TravelQuote> future : futures) {
            if (future.isDone() && !future.isCancelled()) {
                System.out.println(future.get());
            }
        }
        return null;
    }
}

class QuoteTask implements Callable<TravelQuote> {

    @Override
    public TravelQuote call() throws Exception {
        Random random = new Random();
        Thread.sleep(random.nextInt(5000));
        return new TravelQuote();
    }
}

class TravelQuote {

}