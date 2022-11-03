package com.team01.photon;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.SwingConstants;

public class PlayViewPlayerRecord extends PlayViewPanel {
    private final PlayViewNameLabel name;
    private PlayViewScoreLabel score;
    private static final String lorem = "Placeholder";

    public PlayViewPlayerRecord() {
        super(new GridBagLayout());

        name = new PlayViewNameLabel(lorem, PlayViewConstants.FG_COLOR, SwingConstants.LEADING);
        score = new PlayViewScoreLabel(PlayViewConstants.FG_COLOR, SwingConstants.LEADING);

        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.LINE_START;
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 1;
        c.ipady = 1;
        c.weightx = 1.0;

        add(name, c);

        c.anchor = GridBagConstraints.LINE_END;
        c.gridx = 1;
        c.fill = GridBagConstraints.NONE;
        c.weightx = 0.0;

        add(score, c);
    }

    // TODO: Test out flipping the orientation. It should work if using setComponentOrientation
}
