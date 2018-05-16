package org.dongtech.javacore.multithreads;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.Semaphore;

/**
 * @author Fuqiang
 * Created on 2018/5/15.
 */
public class AlgorithmAnimation {
  public static void main(String[] args) {
    EventQueue.invokeLater(() -> {
      JFrame frame = new AnimationFrame();
      frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      frame.setVisible(true);
    });
  }
}

class AnimationFrame extends JFrame {
  private static final int DEFAULT_WIDTH = 300;
  private static final int DEFAULT_HEIGHT = 300;

  AnimationFrame() {
    ArrayComponent comp = new ArrayComponent();
    this.add(comp, BorderLayout.CENTER);

    final Sorter sorter = new Sorter(comp);

    JButton runButton = new JButton("Run");
    runButton.addActionListener(e -> sorter.setRun());

    JButton stepButton = new JButton("Step");
    stepButton.addActionListener(e -> sorter.setStep());

    JPanel buttons = new JPanel();
    buttons.add(runButton);
    buttons.add(stepButton);
    this.add(buttons, BorderLayout.NORTH);
    this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

    Thread t = new Thread(sorter);
    t.start();
  }
}

class ArrayComponent extends JComponent {
  private Double marked1;
  private Double marked2;
  private Double[] values;

  synchronized void setValues(Double[] values, Double marked1, Double marked2) {
    this.marked1 = marked1;
    this.marked2 = marked2;
    this.values = values;
  }

  @Override
  protected synchronized void paintComponent(Graphics g) {
    if (this.values == null) {
      return;
    }
    Graphics2D g2 = (Graphics2D) g;
    int width = this.getWidth() / values.length;
    for (int i = 0; i < values.length; i++) {
      double height = values[i] * this.getHeight();
      Rectangle2D bar = new Rectangle2D.Double(width * i, 0, width, height);
      if (values[i].equals(this.marked1)) {
        g2.setColor(Color.YELLOW);
        g2.fill(bar);
      } else if (values[i].equals(this.marked2)) {
        g2.setColor(Color.BLUE);
        g2.fill(bar);
      } else {
        g2.setColor(Color.BLACK);
        g2.draw(bar);
      }
    }
  }
}

class Sorter implements Runnable {
  private static final int DELAY = 1000;
  private static final int VALUES_LENGTH = 30;
  private Double[] values;
  private ArrayComponent component;
  private Semaphore gate;
  private volatile boolean run;

  Sorter(ArrayComponent component) {
    this.values = new Double[VALUES_LENGTH];
    for (int i = 0; i < values.length; i++) {
      values[i] = Math.random();
    }
    this.component = component;
    this.gate = new Semaphore(1);
    this.run = false;
  }

  void setRun() {
    this.run = true;
    this.gate.release();
  }

  void setStep() {
    this.run = false;
    this.gate.release();
  }

  @Override
  public void run() {
    Comparator<Double> comp = (o1, o2) -> {
      try {
        component.setValues(values, o1, o2);
        component.repaint();
        if (run) {
          Thread.sleep(DELAY);
        } else {
          gate.acquire();
        }
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
      return o1.compareTo(o2);
    };
    Arrays.sort(this.values, comp);
    this.component.setValues(this.values, null, null);

  }
}