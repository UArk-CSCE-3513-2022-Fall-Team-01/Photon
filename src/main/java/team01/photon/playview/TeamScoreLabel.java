package team01.photon.playview;

import java.awt.Color;

public class TeamScoreLabel extends BaseScoreLabel {

    public TeamScoreLabel(int score, Color color, int alignment) {
        super(score, color, alignment);

        setFont(Constants.MONO_FONT);
    }
    
}
