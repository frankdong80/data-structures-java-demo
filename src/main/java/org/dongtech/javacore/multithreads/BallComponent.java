package org.dongtech.javacore.multithreads;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * @author Fuqiang
 * Created on 24/02/2018.
 */
public class BallComponent extends JPanel {
  private ArrayList<Ball> balls = new ArrayList<>();


  public void add(Ball b) {
    balls.add(b);
  }

  public void clear() {
    balls.clear();
    repaint();
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    for (Ball b : balls) {
      g2.fill(b.getShape());
    }

  }
}
