package team01.photon.playview;

import java.awt.Color;
import java.time.Duration;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;

public class MatchStatusPanel extends BasePanel {

    public MatchStatusPanel() {
        super();
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

        add(Box.createHorizontalGlue());
        add(new TeamScoreLabel(99999, Color.RED, SwingConstants.CENTER));
        add(Box.createHorizontalGlue());
        add(new TimerLabel(Duration.ofHours(1), Constants.FG_COLOR, SwingConstants.CENTER));
        add(Box.createHorizontalGlue());
        add(new TeamScoreLabel(99999, Color.GREEN, SwingConstants.CENTER));
        add(Box.createHorizontalGlue());
    }
}
