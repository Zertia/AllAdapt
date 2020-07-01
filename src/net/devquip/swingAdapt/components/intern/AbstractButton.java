package net.devquip.swingAdapt.components.intern;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JComponent;

public abstract class AbstractButton extends JComponent implements MouseListener {
    private String text;

    private Color textColor;

    private ArrayList<EventListener> eventListeners = new ArrayList<EventListener>();

    private boolean hover = false;

    public AbstractButton() {
        addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e) {}

    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {
        if (isEnabled())
            for (EventListener eventListener : this.eventListeners) {
                eventListener.onEvent(new Event(this, 0));
            }
    }

    public void mouseEntered(MouseEvent e) {
        this.hover = true;
        repaint();
    }

    public void mouseExited(MouseEvent e) {
        this.hover = false;
        repaint();
    }

    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        repaint();
    }

    public void setText(String text) {
        if (text == null)
            throw new IllegalArgumentException("text == null");
        this.text = text;
        repaint();
    }

    public String getText() {
        return this.text;
    }

    public void setTextColor(Color textColor) {
        if (textColor == null)
            throw new IllegalArgumentException("textColor == null");
        this.textColor = textColor;
        repaint();
    }

    public Color getTextColor() {
        return this.textColor;
    }

    public void addEventListener(EventListener eventListener) {
        if (eventListener == null)
            throw new IllegalArgumentException("eventListener == null");
        this.eventListeners.add(eventListener);
    }

    public ArrayList<EventListener> getEventListeners() {
        return this.eventListeners;
    }

    public boolean isHover() {
        return this.hover;
    }
}