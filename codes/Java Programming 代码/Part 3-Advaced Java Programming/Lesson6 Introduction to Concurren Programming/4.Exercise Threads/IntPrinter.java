import jdk.jshell.ImportSnippet;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public final class IntPrinter {
  public static void main(String[] args) throws Exception {
//    if (args.length != 1) {
//      System.out.println("Usage: Main <number of threads>");
//      return;
//    }
//
//    int n = Integer.parseInt(args[0]);
//
//    // TODO: Create a list of n Threads and run them all in parallel with the System.out.println
//    //       statement.
//    List<Thread> threads = new ArrayList<>();
//    for (int i = 0; i < n; i++){
//      threads.add(new Thread(new IntRunner(i+1)));
//    }
//    for (Thread thread:threads) {
//      thread.start();
//      thread.join();
//    }
//    for (Thread thread:threads)
    CountDownLatch latch = new CountDownLatch(4);
    ExecutorService pool = Executors.newFixedThreadPool(4,new IntRunner());
    Future<?> print = pool.submit(() -> System.out.println("foo"));
  }

  private static final class IntRunner extends Thread{
    private final CountDownLatch latch;
    public IntRunner(CountDownLatch latch, String name) {
      super(name);
      this.latch = latch;
    }

    @Override
    public void run() {
      latch.countDown();
      System.out.println(Thread.currentThread().getName()+ " finished");
    }
  }
}
