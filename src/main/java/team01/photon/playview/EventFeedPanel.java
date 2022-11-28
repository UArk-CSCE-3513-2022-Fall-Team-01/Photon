package team01.photon.playview;

import java.awt.Color;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import team01.photon.EventFeedQueue;
import team01.photon.PlayerHitEvent;

public class EventFeedPanel extends BasePanel implements ChangeListener {
    private transient EventFeedQueue linkedQueue;

    public EventFeedPanel(EventFeedQueue queue) {
        super();

        setAlignmentX(CENTER_ALIGNMENT);
        setAlignmentY(CENTER_ALIGNMENT);

        linkedQueue = queue;
        linkedQueue.addChangeListener(this);

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(Box.createVerticalGlue());

        // setBackground(new Color(32, 0, 32));
        // setOpaque(true);
    }

    public void pushEvent(PlayerHitEvent e) {
        if (getComponentCount() > 18)
            remove(1);

        // Insert at the end / bottom of list
        add(new EventLabel(e), -1);
    }

    @Override
    public void stateChanged(ChangeEvent arg0) {
        pushEvent(linkedQueue.getLatest());
    }
}
