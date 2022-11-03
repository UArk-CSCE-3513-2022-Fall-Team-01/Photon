package team01.photon.playview;

import java.awt.Color;

public class PlayerScoreLabel extends BaseScoreLabel {
    public PlayerScoreLabel(int score, Color color, int alignment) {
        super(score, color, alignment);

        setFont(Constants.SMALL_MONO_FONT);
    }
}
