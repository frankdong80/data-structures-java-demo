package org.dongtech.javacore.multithreads;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.*;

/**
 * @author Fuqiang
 * Created on 2018/5/14.
 */
public class ThreadPoolTest {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.print("Enter base directory (e.g. /usr/local/jdk1.6.0/src): ");
    String directory = in.nextLine();
    System.out.print("Enter keyword( e.g. volatile): ");
    String keyword = in.nextLine();

    ExecutorService pool = Executors.newCachedThreadPool();
    ThreadPoolMatchCounter counter = new ThreadPoolMatchCounter(new File(directory), keyword, pool);
    Future<Integer> result = pool.submit(counter);

    try {
      System.out.printf("%d matching files%n", result.get());
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (ExecutionException e) {
      e.printStackTrace();
    }
    pool.shutdown();
    int largestPoolSize = ((ThreadPoolExecutor) pool).getLargestPoolSize();
    System.out.printf("largest pool size=%d%n", largestPoolSize);

  }

}

class ThreadPoolMatchCounter implements Callable<Integer> {

  private File directory;
  private String keyword;
  private ExecutorService pool;
  private int count;

  public ThreadPoolMatchCounter(File directory, String keyword, ExecutorService pool) {
    this.directory = directory;
    this.keyword = keyword;
    this.pool = pool;
  }

  @Override
  public Integer call() throws Exception {
    this.count = 0;
    try {
      File[] files = this.directory.listFiles();
      ArrayList<Future<Integer>> results = new ArrayList<>();
      for (File file : files) {
        if (file.isDirectory()) {
          ThreadPoolMatchCounter counter = new ThreadPoolMatchCounter(file, this.keyword, this.pool);
          Future<Integer> result = pool.submit(counter);
          results.add(result);
        } else {
          if (searchFile(file)) {
            this.count++;
          }
        }
      }
      for (Future<Integer> result : results) {
        try {
          this.count += result.get();
        } catch (ExecutionException e) {
          e.printStackTrace();
        }
      }
    } catch (InterruptedException e) {
      e.getStackTrace();
    }
    return this.count;
  }

  private boolean searchFile(File file) {
    try {
      Scanner in = new Scanner(new FileInputStream(file));
      boolean found = false;
      while (!found && in.hasNextLine()) {
        String line = in.nextLine();
        if (line.contains(this.keyword)) {
          found = true;
        }
      }
      in.close();
      return found;
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      return false;
    }
  }
}

