package org.dongtech.javacore.multithreads;

import java.awt.*;

/**
 * @author Fuqiang
 * Created on 24/02/2018.
 */
public class BallRunnable implements Runnable {
  public static final int STEPS = 1000;
  public static final int DELAY = 5;
  private boolean flag = true;
  private Ball ball;
  private Component component;

  public BallRunnable(Ball aBall, Component aComponent) {
    ball = aBall;
    component = aComponent;
  }

  public void stop() {
    flag = false;
  }

  @Override
  public void run() {
    try {
      while (flag) {
        ball.move(component.getBounds());
        component.repaint();
        Thread.sleep(DELAY);
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
