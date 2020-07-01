package net.devquip.swingAdapt.components;

import net.devquip.swingAdapt.components.intern.AbstractButton;
import net.devquip.swingAdapt.main.SwingAdapt;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class JButtonTextured extends AbstractButton {

    private Image texture;

    private Image textureHover;

    private Image textureDisabled;

    public JButtonTextured(BufferedImage texture) {
        this(texture, (BufferedImage)null, (BufferedImage)null);
    }

    public JButtonTextured(BufferedImage texture, BufferedImage textureHover) {
        this(texture, textureHover, (BufferedImage)null);
    }

    public JButtonTextured(BufferedImage texture, BufferedImage textureHover, BufferedImage textureDisabled) {
        if (texture == null)
            throw new IllegalArgumentException("texture == null");
        this.texture = texture;
        if (textureHover == null) {
            this.textureHover = SwingAdapt.fillImage(SwingAdapt.copyImage(texture), SwingAdapt.HOVER_COLOR, getParent());
        } else {
            this.textureHover = textureHover;
        }
        if (textureDisabled == null) {
            this.textureDisabled = SwingAdapt.fillImage(SwingAdapt.copyImage(texture), SwingAdapt.DISABLED_COLOR, getParent());
        } else {
            this.textureDisabled = textureDisabled;
        }
    }

    public void paintComponent(Graphics g) {
        Image texture;
        super.paintComponent(g);
        if (!isEnabled()) {
            texture = this.textureDisabled;
        } else if (isHover()) {
            texture = this.textureHover;
        } else {
            texture = this.texture;
        }
        SwingAdapt.drawFullsizedImage(g, (JComponent)this, texture);
        if (getText() != null) {
            SwingAdapt.activateAntialias(g);
            if (getTextColor() != null)
                g.setColor(getTextColor());
            SwingAdapt.drawCenteredString(g, getText(), getBounds());
        }
    }
}