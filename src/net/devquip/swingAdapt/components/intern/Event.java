package net.devquip.swingAdapt.components.intern;

public class Event {
    public static final int BUTTON_CLICKED_EVENT = 0;

    private Object source;

    private int type;

    public Event(Object source, int type) {
        this.source = source;
    }

    public Object getSource() {
        return this.source;
    }

    public int getType() {
        return this.type;
    }
}