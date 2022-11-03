package team01.photon.playview;

import java.awt.Color;
import java.awt.Dimension;

public class PlayerScoreLabel extends BaseLabel {
    private static final String SCORE_FORMAT = "%5s";

    public PlayerScoreLabel(Color color, int alignment) {
        super(formatScore(0), color, alignment);

        setFont(Constants.SMALL_MONO_FONT);
    }

    // Constrain this label to only ever be its preferred size via these two
    // overrides
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
