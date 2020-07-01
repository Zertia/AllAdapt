package net.devquip.swingAdapt.components;


import net.devquip.swingAdapt.components.intern.AbstractProgressBar;
import net.devquip.swingAdapt.main.SwingAdapt;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class JProgressBarTextured extends AbstractProgressBar {
    private BufferedImage backgroundTexture;

    private BufferedImage foregroundTexture;

    public JProgressBarTextured(BufferedImage backgroundTexture, BufferedImage foregroundTexture) {
        if (backgroundTexture == null)
            throw new IllegalArgumentException("Background Texture == null");
        this.backgroundTexture = backgroundTexture;
        if (foregroundTexture == null)
            throw new IllegalArgumentException("Foreground Texture == null");
        this.foregroundTexture = foregroundTexture;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        SwingAdapt.drawFullsizedImage(g, (JComponent)this, this.backgroundTexture);
        int fgSize = SwingAdapt.crossMult(getValue(), getMaximum(), isVertical() ? getHeight() : getWidth());
        if (fgSize > 0) {
            BufferedImage subForeground = this.foregroundTexture.getSubimage(0, 0, isVertical() ? getWidth() : fgSize, isVertical() ? fgSize : getHeight());
            g.drawImage(subForeground, 0, 0, subForeground.getWidth(), subForeground.getHeight(), (ImageObserver)this);
        }
        if (isStringPainted() && getString() != null) {
            SwingAdapt.activateAntialias(g);
            if (getStringColor() != null)
                g.setColor(getStringColor());
            SwingAdapt.drawCenteredString(g, getString(), getBounds());
        }
    }

    public void setBackgroundTexture(BufferedImage backgroundTexture) {
        if (backgroundTexture == null)
            throw new IllegalArgumentException("backgroundTexture == null");
        this.backgroundTexture = backgroundTexture;
        repaint();
    }

    public BufferedImage getBackgroundTexture() {
        return this.backgroundTexture;
    }

    public void setForegroundTexture(BufferedImage foregroundTexture) {
        if (foregroundTexture == null)
            throw new IllegalArgumentException("foregroundTexture == null");
        this.foregroundTexture = foregroundTexture;
        repaint();
    }

    public BufferedImage getForegroundTexture() {
        return this.foregroundTexture;
    }
}