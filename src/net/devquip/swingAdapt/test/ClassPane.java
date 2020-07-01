package net.devquip.swingAdapt.test;

import net.devquip.swingAdapt.components.JButtonTextured;
import net.devquip.swingAdapt.components.JColoredBar;
import net.devquip.swingAdapt.components.JProgressBarTextured;
import net.devquip.swingAdapt.components.intern.Event;
import net.devquip.swingAdapt.components.intern.EventListener;
import net.devquip.swingAdapt.main.SwingAdapt;

import javax.swing.*;
import java.awt.*;

public class ClassPane extends JPanel implements EventListener {

    public static JLabel label = new JLabel("Test");
    public static JButtonTextured test = new JButtonTextured(SwingAdapt.getResource("disconnect.png"));
    public static JColoredBar progressBarTextured = new JColoredBar(SwingAdapt.getTransparentWhite(100), SwingAdapt.getTransparentInstance(Color.GREEN, 50));
    private static Thread updateThread;

    public ClassPane() {
        updateThread = new Thread() {
            private int val;

            private int max;

            public void run() {
                while (!isInterrupted()) {
                    this.max++;
                    this.val++;
                    progressBarTextured.setMaximum(this.max);
                    progressBarTextured.setValue(this.val);
                    progressBarTextured.setBackground(new Color(1.0F, 1.0F, 1.0F, 0.5F));
                }
            }
        };
        updateThread.start();
        this.setLayout(null);

        label.setBounds(1, 1, 100, 100);
        this.add(label);

        test.setBounds(1, 1, 100, 100);
        test.addEventListener(this);
        this.add(test);

        progressBarTextured.setBounds(0, 500, 1000, 10);
        this.add(progressBarTextured);
    }

    @Override
    public void onEvent(Event e) {
        if(e.getSource() == test) {
            System.out.println("Event");
        }
    }
}