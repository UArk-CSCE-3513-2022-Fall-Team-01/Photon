package com.team01.photon;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public abstract class PlayViewLabel extends JLabel {

    protected PlayViewLabel(String text, Color color, int alignment) {
        super(text, alignment);

        setForeground(color);
        setFont(PlayViewConstants.BASE_FONT);
        setVerticalAlignment(SwingConstants.CENTER);
    }
}
