package team01.photon.playview;

import javax.swing.BoxLayout;

public class MatchPane extends BasePanel {

    public MatchPane() {
        super();
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        add(new MatchStatusPanel());
        add(new EventFeedPanel());
    }
    // TODO: This will be the central panel showing the match timer, team scores,
    // and event feed
}
