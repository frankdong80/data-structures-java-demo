package org.dongtech.javacore.multithreads;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * @author Fuqiang
 * Created on 2018/5/15.
 */
public class SwingThreadTest {
  public static void main(String[] args) {
    EventQueue.invokeLater(() -> {
      SwingThreadFrame frame = new SwingThreadFrame();
      frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      frame.setVisible(true);
    });
  }
}

class SwingThreadFrame extends JFrame {
  public SwingThreadFrame() {
    this.setTitle("SwingThreadTest");

    final JComboBox<Integer> combo = new JComboBox<>();
    combo.insertItemAt(Integer.MAX_VALUE, 0);
    combo.setPrototypeDisplayValue(combo.getItemAt(0));
    combo.setSelectedIndex(0);

    JPanel panel = new JPanel();

    JButton goodButton = new JButton("Good");
    goodButton.addActionListener(e -> new Thread(new GoodWorkerRunnable(combo)).start());
    panel.add(goodButton);

    JButton badButton = new JButton("Bad");
    badButton.addActionListener(e -> new Thread(new BadWorkerRunnable(combo)).start());
    panel.add(badButton);

    panel.add(combo);
    this.add(panel);
    this.pack();
  }
}

class BadWorkerRunnable implements Runnable {
  private JComboBox<Integer> combo;
  private Random generator;

  public BadWorkerRunnable(JComboBox<Integer> combo) {
    this.combo = combo;
    this.generator = new Random();
  }

  @Override
  public void run() {
    try {
      while (true) {
        int i = Math.abs(this.generator.nextInt());
        if (i % 2 == 0) {
          this.combo.insertItemAt(i, 0);
        } else if (combo.getItemCount() > 0) {
          this.combo.removeItemAt(i % this.combo.getItemCount());
        }
        Thread.sleep(1);
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

class GoodWorkerRunnable implements Runnable {
  private JComboBox<Integer> combo;
  private Random generator;

  public GoodWorkerRunnable(JComboBox<Integer> combo) {
    this.combo = combo;
    this.generator = new Random();
  }

  @Override
  public void run() {
    try {
      while (true) {
        EventQueue.invokeLater(() -> {
          int i = Math.abs(generator.nextInt());
          if (i % 2 == 0) {
            combo.insertItemAt(i, 0);
          } else if (combo.getItemCount() > 0) {
            combo.removeItemAt(i % combo.getItemCount());
          }
        });
        Thread.sleep(1);
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

