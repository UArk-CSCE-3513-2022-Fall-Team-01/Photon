package com.team01.photon;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.SwingConstants;

public class PlayViewPlayerRecord extends PlayViewPanel {
    private final PlayViewNameLabel nameLabel;
    private PlayViewScoreLabel scoreLabel;
    private static final String lorem = "Placeholder";

    public PlayViewPlayerRecord() {
        super(new GridBagLayout());

        nameLabel = new PlayViewNameLabel(lorem, PlayViewConstants.FG_COLOR, SwingConstants.LEADING);
        scoreLabel = new PlayViewScoreLabel(PlayViewConstants.FG_COLOR, SwingConstants.LEADING);

        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.LINE_END;
        c.gridx = 1;
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 1;


    }
    // TODO: This will contain a PlayerNameLabel and a PlayViewScoreLabel together
    // Optionally make it switchable from LTR and RTL for different side of board
    // Should be doable, I think I saw a method just for doing that. Otherwise, change
    // up the constraints used


}
