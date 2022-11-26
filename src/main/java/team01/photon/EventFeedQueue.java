package team01.photon;

import java.util.LinkedList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.EventListenerList;

public class EventFeedQueue implements ChangeNotifier {
    private LinkedList<PlayerHitEvent> queue;

    private EventListenerList listeners;

    public EventFeedQueue() {
        queue = new LinkedList<>();
        listeners = new EventListenerList();
    }

    public boolean add(PlayerHitEvent e) {
        boolean result = queue.add(e);

        if (result)
            fireChangeEvent();
        
        return result;
    }

    public PlayerHitEvent getLatest() {
        return queue.getLast();
    }

    public void clear() {
        queue.clear();
        fireChangeEvent();
    }

    public int size() {
        return queue.size();
    }

    @Override
    public void addChangeListener(ChangeListener listener) {
        listeners.add(ChangeListener.class, listener);
    }

    @Override
    public void clearChangeListeners() {
        listeners = new EventListenerList();
    }

    protected void fireChangeEvent() {
        for (ChangeListener tmp : listeners.getListeners(ChangeListener.class)) {
            tmp.stateChanged(new ChangeEvent(this));
        }
    }

    @Override
    public void removeChangeListener(ChangeListener listener) {
        listeners.remove(ChangeListener.class, listener);
    }
}
