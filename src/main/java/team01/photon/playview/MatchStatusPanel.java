package team01.photon.playview;

import java.time.Duration;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import team01.photon.GameTimer;

public class MatchStatusPanel extends BasePanel implements ChangeListener {
    private transient TimerLabel timerLabel;
    private transient GameTimer timer;

    public MatchStatusPanel() {
        this(null);
    }

    public MatchStatusPanel(GameTimer timer) {
        super();
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

        timerLabel = new TimerLabel(timer.getTime(), Constants.FG_COLOR, SwingConstants.CENTER);

        add(Box.createHorizontalGlue());
        add(timerLabel);
        add(Box.createHorizontalGlue());

        this.timer = timer;
        timer.addChangeListener(this);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        timerLabel.setTime(timer.getTime());
        if (timer.getTime().toSeconds() <= 0)
            timerLabel.setVisible(false);
    }
}
