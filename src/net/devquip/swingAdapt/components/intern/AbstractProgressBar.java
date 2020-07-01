package net.devquip.swingAdapt.components.intern;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractProgressBar extends JComponent {
    private int value;

    private int maximum;

    private String string;

    private boolean stringPainted;

    private Color stringColor;

    private boolean vertical = false;

    public void setValue(int value) {
        this.value = value;
        repaint();
    }

    public int getValue() {
        return this.value;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
        repaint();
    }

    public int getMaximum() {
        return this.maximum;
    }

    public void setString(String string) {
        if (string == null)
            throw new IllegalArgumentException("string == null");
        this.string = string;
        repaint();
    }

    public String getString() {
        return this.string;
    }

    public void setStringPainted(boolean stringPainted) {
        this.stringPainted = stringPainted;
        repaint();
    }

    public boolean isStringPainted() {
        return this.stringPainted;
    }

    public void setStringColor(Color stringColor) {
        if (stringColor == null)
            throw new IllegalArgumentException("stringColor == null");
        this.stringColor = stringColor;
        repaint();
    }

    public Color getStringColor() {
        return this.stringColor;
    }

    public void setVertical(boolean vertical) {
        this.vertical = vertical;
        repaint();
    }

    public boolean isVertical() {
        return this.vertical;
    }
}