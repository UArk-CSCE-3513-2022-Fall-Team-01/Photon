package team01.photon.playview;

import java.awt.Color;

public abstract class BaseScoreLabel extends BaseLabel {
    private static final String SCORE_FORMAT = "%5s";

    protected BaseScoreLabel(int score, Color color, int alignment) {
        super(formatScore(score), color, alignment);

        setFont(Constants.MONO_FONT);
        setAlignmentX(CENTER_ALIGNMENT);
    }

    // Use this instead of setText
    public void setScore(int score) {
        super.setText(formatScore(score));
    }

    public static String formatScore(int score) {
        return String.format(SCORE_FORMAT, score);
    }
}
