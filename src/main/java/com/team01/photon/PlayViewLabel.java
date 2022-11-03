package com.team01.photon;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class PlayViewLabel extends JLabel {
    private static final Color DEFAULT_FG_COLOR = Color.WHITE;
    private static final Font DEFAULT_FONT = new Font(Font.SANS_SERIF, Font.PLAIN, 28);

    public PlayViewLabel(String text, Color color, int alignment) {
        super(text, alignment);

        setForeground(color);
        setFont(DEFAULT_FONT);
        setVerticalAlignment(SwingConstants.CENTER);
    }
}
