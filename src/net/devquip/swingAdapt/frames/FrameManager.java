package net.devquip.swingAdapt.frames;

import javax.swing.*;
import java.awt.*;

public class FrameManager extends JFrame {

    public static void createJFrame(String nameJFrame, String title, int width, int height, Component classPane, boolean resizable) {
        JFrame frame = new JFrame();
        frame.setTitle(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane((Container) classPane);
        frame.setResizable(resizable);
        frame.setVisible(true);
    }

    public static void createJFrame(String nameJFrame, String title, int width, int height, Component classPane) {
        JFrame frame = new JFrame();
        frame.setTitle(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane((Container) classPane);
        frame.setResizable(true);
        frame.setVisible(true);
    }

    public static void createJFrame(String nameJFrame, String title, int width, int height, boolean resizable) {
        JFrame frame = new JFrame();
        frame.setTitle(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(resizable);
        frame.setVisible(true);
    }

    public static void createJFrame(String nameJFrame, String title, int width, int height) {
        JFrame frame = new JFrame();
        frame.setTitle(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setVisible(true);
    }
}