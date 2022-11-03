package com.team01.photon;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class PlayViewPlayerRecord extends PlayViewPanel {
    private final PlayerNameLabel nameLabel;
    private PlayViewScoreLabel scoreLabel;

    public PlayViewPlayerRecord() {
        super(new GridBagLayout());

        nameLabel = new PlayerNameLabel(TOOL_TIP_TEXT_KEY, getBackground(), ABORT)

        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.LINE_END;
        c.gridx = 1;
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 1;
        add(new())
    }
    // TODO: This will contain a PlayerNameLabel and a PlayViewScoreLabel together
    // Optionally make it switchable from LTR and RTL for different side of board


}
