package team01.photon.playview;

import javax.swing.BoxLayout;

import team01.photon.GameTimer;

public class MatchPane extends BasePanel {

    public MatchPane(GameTimer timer) {
        super();
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        add(new MatchStatusPanel(timer));
        add(new EventFeedPanel());
    }
    // TODO: This will be the central panel showing the match timer, team scores,
    // and event feed
}
