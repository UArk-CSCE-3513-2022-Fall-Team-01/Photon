package team01.photon.playview;

import java.awt.Color;

public class EventFeedPanel extends BasePanel {
    // TODO: Will eventually be populated with event feed records / panels in Sprint
    // 4
    // Will need to manage a stack / queue of them to display somehow, so that when
    // they start reaching the top they will remove the oldest events shown to make
    // room for the new one
    public EventFeedPanel() {
        super();
        // setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBackground(new Color(32, 0, 32));
        setOpaque(true);
    }
}
