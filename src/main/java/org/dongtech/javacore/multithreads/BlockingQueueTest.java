package org.dongtech.javacore.multithreads;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author Fuqiang
 * Created on 2018/5/12.
 */
public class BlockingQueueTest {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.print("Enter base directory (e.g. /usr/local/jdk1.6.0/src): ");
    String directory = in.nextLine();
    System.out.print("Enter keyword( e.g. volatile): ");
    String keyword = in.nextLine();

    final int FILE_QUEUE_SIZE = 10;
    final int SEARCH_THREADS = 100;

    BlockingQueue<File> queue = new ArrayBlockingQueue<>(FILE_QUEUE_SIZE);
    FileEnumerationTask enumerator = new FileEnumerationTask(queue, new File(directory));
    new Thread(enumerator).start();
    for (int i = 0; i < SEARCH_THREADS; i++) {
      new Thread(new SearchTask(queue, keyword)).start();
    }
  }
}

class SearchTask implements Runnable {
  private BlockingQueue<File> queue;
  private String keyword;

  SearchTask(BlockingQueue<File> queue, String keyword) {
    this.queue = queue;
    this.keyword = keyword;
  }

  @Override
  public void run() {
    try {
      boolean done = false;
      while (!done) {
        File file = this.queue.take();
        if (file == FileEnumerationTask.DUMMY) {
          this.queue.put(file);
          done = true;
        } else {
          this.search(file);
        }
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

  }

  void search(File file) throws FileNotFoundException {
    Scanner in = new Scanner(new FileInputStream(file));
    int lineNumber = 0;
    while (in.hasNextLine()) {
      lineNumber++;
      String line = in.nextLine();
      if (line.contains(keyword)) {
        System.out.printf("%s:%d:%s%n", file.getPath(), lineNumber, line);
      }
    }
    in.close();
  }
}

class FileEnumerationTask implements Runnable {
  static File DUMMY = new File("");
  private BlockingQueue<File> queue;
  private File startingDirectory;

  FileEnumerationTask(BlockingQueue<File> queue, File startingDirectory) {
    this.queue = queue;
    this.startingDirectory = startingDirectory;
  }

  void enumerate(File directory) {
    File[] files = directory.listFiles();
    try {
      assert files != null;
      for (File file : files) {
        if (file.isDirectory()) {
          enumerate(file);
        } else {
          queue.put(file);
        }
      }
    } catch (InterruptedException e) {
    }
  }

  @Override
  public void run() {
    try {
      this.enumerate(this.startingDirectory);
      this.queue.put(DUMMY);
    } catch (InterruptedException e) {
    }
  }
}
