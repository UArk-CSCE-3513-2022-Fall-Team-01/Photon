package team01.photon.playview;

import java.awt.Color;
import java.awt.Dimension;
import java.time.Duration;

public class TimerLabel extends BaseLabel {
    private static final String FORMAT = "%02d:%02d";

    public TimerLabel(Duration time, Color color, int alignment) {
        super(formatTime(time), color, alignment);

        setFont(Constants.BIG_MONO_FONT);
        setHorizontalAlignment(CENTER);
    }

    private static String formatTime(Duration time) {
        return String.format(FORMAT, time.toMinutes(), time.toSecondsPart());
    }

    public void setTime(Duration time) {
        setText(formatTime(time));
    }

    @Override
    public Dimension getMaximumSize() {
        return getPreferredSize();
    }
}
