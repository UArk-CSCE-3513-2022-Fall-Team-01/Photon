package team01.photon.playview;

import java.awt.Color;
import java.awt.Dimension;

public class PlayerScoreLabel extends BaseScoreLabel {
    public PlayerScoreLabel(int score, Color color, int alignment) {
        super(score, color, alignment);

        setFont(Constants.SMALL_MONO_FONT);
    }

    @Override
    public Dimension getMaximumSize() {
        return getPreferredSize();
    }
}
