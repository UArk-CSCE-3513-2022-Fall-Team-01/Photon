package team01.photon.playview;

import java.awt.Color;
import java.awt.Dimension;

public class PlayerNameLabel extends BaseLabel {

    public PlayerNameLabel(String name, Color color, int alignment) {
        super(name, color, alignment);
    }

    // Constrain max size to preferred size
    @Override
    public Dimension getMaximumSize() {
        return getPreferredSize();
    }
}
