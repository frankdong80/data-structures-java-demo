package org.dongtech.javacore.multithreads;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 * @author Fuqiang
 * Created on 24/02/2018.
 */
public class Ball {
  private static final int XSIZE = 15;
  private static final int YSIZE = 15;
  private double x = 0;
  private double y = 0;
  private double dx = 1;
  private double dy = 1;
  private Color color;

  public Ball() {
    this.color = new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
  }

  public Ball(Color color) {
    this.color = color;
  }

  public Color getColor() {
    return color;
  }

  public void move(Rectangle2D bounds) {
//    if (Math.random() > 0.5) {
//      x += dx;
//    } else {
//      x -= dx;
//    }
//    if (Math.random() > 0.5) {
//      y += dy;
//
//    } else {
//      y -= dy;
//    }
    if (x < bounds.getMinX()) {
      x = bounds.getMinX();
      dx = -dx;
    }
    if (x + XSIZE >= bounds.getMaxX()) {
      x = bounds.getMaxX() - XSIZE;
      dx = -dx;
    }
    if (y < bounds.getMinY()) {
      y = bounds.getMinY();
      dy = -dy;
    }
    if (y + YSIZE >= bounds.getMaxY()) {
      y = bounds.getMaxY() - YSIZE;
      dy = -dy;
    }
  }

  public Ellipse2D getShape() {
    return new Ellipse2D.Double(x, y, XSIZE, YSIZE);
  }
}
