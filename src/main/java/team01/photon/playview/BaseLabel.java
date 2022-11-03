package team01.photon.playview;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public abstract class BaseLabel extends JLabel {

    protected BaseLabel(String text, Color color, int alignment) {
        super(text, alignment);

        setForeground(color);
        setFont(Constants.BASE_FONT);
        setVerticalAlignment(SwingConstants.CENTER);
    }
}
