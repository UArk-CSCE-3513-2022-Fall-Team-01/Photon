package team01.photon.playview;

import java.awt.Color;
import java.awt.Dimension;

public abstract class BaseScoreLabel extends BaseLabel {
    private static final String SCORE_FORMAT = "%5s";

    protected BaseScoreLabel(int score, Color color, int alignment) {
        super(formatScore(score), color, alignment);

        setFont(Constants.MONO_FONT);
    }

    // Constrain label's minimum to match it's preference
    @Override
    public Dimension getMinimumSize() {
        return getPreferredSize();
    }

    // Use this instead of setText
    public void setScore(int score) {
        super.setText(formatScore(score));
    }

    private static String formatScore(int score) {
        return String.format(SCORE_FORMAT, score);
    }
}
