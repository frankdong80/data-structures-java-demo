package org.dongtech.javacore.multithreads;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author Fuqiang
 * Created on 2018/5/12.
 */
public class FutureTest {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.print("Enter base directory (e.g. /usr/local/jdk1.6.0/src): ");
    String directory = in.nextLine();
    System.out.print("Enter keyword( e.g. volatile): ");
    String keyword = in.nextLine();

    MatchCounter counter = new MatchCounter(new File(directory), keyword);
    FutureTask<Integer> task = new FutureTask<>(counter);
    new Thread(task).start();

    try {
      System.out.printf("%d matching files", task.get());
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (ExecutionException e) {
      e.printStackTrace();
    }

  }
}

class MatchCounter implements Callable<Integer> {
  private File directory;
  private String keyword;

  MatchCounter(File directory, String keyword) {
    this.directory = directory;
    this.keyword = keyword;
  }

  @Override
  public Integer call() throws Exception {
    int count = 0;
    try {
      File[] files = directory.listFiles();
      ArrayList<Future<Integer>> results = new ArrayList<>();
      assert files != null;
      for (File file : files) {
        if (file.isDirectory()) {
          MatchCounter counter = new MatchCounter(file, this.keyword);
          FutureTask<Integer> task = new FutureTask<>(counter);
          results.add(task);
          new Thread(task).start();
        } else {
          if (this.search(file)) {
            count++;
          }
        }
      }
      for (Future<Integer> result : results) {
        count += result.get();
      }
    } catch (InterruptedException e) {

    }
    return count;
  }

  private boolean search(File file) {
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
