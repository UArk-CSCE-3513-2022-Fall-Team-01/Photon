package com.team01.photon;

import java.awt.Color;
import java.awt.Dimension;

public class PlayViewScoreLabel extends PlayViewLabel {
    private static final String SCORE_FORMAT = "%5s";

    public PlayViewScoreLabel(Color color, int alignment) {
        super(formatScore(0), color, alignment);

        setFont(PlayViewConstants.SMALL_MONO_FONT);
    }

    // Constrain this label to only ever be its preferred size via these two overrides
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
