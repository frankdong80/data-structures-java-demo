package org.dongtech.javacore;

import org.dongtech.javacore.multithreads.BounceFrame;

import javax.swing.*;
import java.awt.*;

/**
 * @author Fuqiang
 * Created on 24/02/2018.
 */
public class BounceTest {
  public static void main(String[] args) {
    EventQueue.invokeLater(() -> {
      JFrame frame = new BounceFrame();
      frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      frame.setVisible(true);
    });
  }
}
