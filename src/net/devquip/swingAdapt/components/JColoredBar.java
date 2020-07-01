package net.devquip.swingAdapt.components;

import net.devquip.swingAdapt.components.intern.AbstractProgressBar;
import net.devquip.swingAdapt.main.SwingAdapt;

import javax.swing.*;
import java.awt.*;

public class JColoredBar extends AbstractProgressBar {
    private Color background;

    private Color foreground;

    public JColoredBar(Color background) {
        this(background, (Color)null);
    }

    public JColoredBar(Color background, Color foreground) {
        if (background == null)
            throw new IllegalArgumentException("background == null");
        this.background = background;
        if (foreground == null) {
            this.foreground = background.brighter();
        } else {
            this.foreground = foreground;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        SwingAdapt.fillFullsizedRect(g, (JComponent)this, this.background);
        int fgSize = SwingAdapt.crossMult(getValue(), getMaximum(), isVertical() ? getHeight() : getWidth());
        if (fgSize > 0) {
            g.setColor(this.foreground);
            g.fillRect(0, 0, isVertical() ? getWidth() : fgSize, isVertical() ? fgSize : getHeight());
        }
        if (isStringPainted() && getString() != null) {
            SwingAdapt.activateAntialias(g);
            if (getStringColor() != null)
                g.setColor(getStringColor());
            SwingAdapt.drawCenteredString(g, getString(), getBounds());
        }
    }

    public void setBackground(Color background) {
        if (background == null)
            throw new IllegalArgumentException("background == null");
        this.background = background;
        repaint();
    }

    public Color getBackground() {
        return this.background;
    }

    public void setForeground(Color foreground) {
        if (foreground == null)
            throw new IllegalArgumentException("foreground == null");
        this.foreground = foreground;
        repaint();
    }

    public Color getForeground() {
        return this.foreground;
    }
}