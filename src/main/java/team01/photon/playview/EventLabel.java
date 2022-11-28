package team01.photon.playview;

import java.awt.Color;
import java.awt.LayoutManager;

import javax.swing.SwingConstants;

import team01.photon.PlayerHitEvent;

public class EventLabel extends BaseLabel {

    protected EventLabel(String text, Color color, int alignment) {
        super(text, color, alignment);
        setFont(Constants.MONO_FONT);
        setHorizontalAlignment(CENTER);
        setAlignmentX(CENTER_ALIGNMENT);
        setAlignmentY(CENTER_ALIGNMENT);
    }

    public EventLabel(PlayerHitEvent e) {
        this(e.toString(), Constants.FG_COLOR, SwingConstants.CENTER);
    }
}
