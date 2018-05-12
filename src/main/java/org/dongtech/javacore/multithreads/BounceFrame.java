package org.dongtech.javacore.multithreads;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Fuqiang
 * Created on 24/02/2018.
 */


public class BounceFrame extends JFrame {
  public static final int DEFAULT_WIDTH = 450;
  public static final int DEFAULT_HEIGHT = 350;
  public static final int STEPS = 1000;
  public static final int DELAY = 3;
  private BallComponent comp;
  private List<BallRunnable> threads = new LinkedList<>();

  public BounceFrame() {
    setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    setTitle("Bounce");
    comp = new BallComponent();
    add(comp, BorderLayout.CENTER);
    JPanel buttonPanel = new JPanel();
    addButton(buttonPanel, "Start", e -> addBall());
    addButton(buttonPanel, "Clear", e -> clear());
    addButton(buttonPanel, "Close", e -> System.exit(0));
    add(buttonPanel, BorderLayout.SOUTH);

  }

  private void addButton(Container c, String title, ActionListener listener) {
    JButton button = new JButton(title);
    c.add(button);
    button.addActionListener(listener);
  }

  private void addBall() {
    Ball b = new Ball();
    comp.add(b);
    BallRunnable runnable = new BallRunnable(b, comp);
    Thread t = new Thread(runnable);
    t.start();
    threads.add(runnable);
  }

  private void clear() {
    while (threads.size() > 0) {
      threads.remove(0).stop();
    }
    comp.clear();
  }
}
