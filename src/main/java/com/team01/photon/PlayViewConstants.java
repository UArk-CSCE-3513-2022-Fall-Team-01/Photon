package com.team01.photon;

import java.awt.Color;
import java.awt.Font;

public final class PlayViewConstants {
    private PlayViewConstants() {
        // Hide constructor, class only contains static constants
    }

    private static final float EM = (float)1.2;
    private static final float DE_EM = (float)0.8;

    public static final Color BG_COLOR = Color.BLACK;
    public static final Color FG_COLOR = Color.WHITE;
    public static final Font BASE_FONT = new Font(Font.SANS_SERIF, Font.PLAIN, 28);
    public static final Font BIG_FONT = BASE_FONT.deriveFont(BASE_FONT.getSize() * EM);
    public static final Font SMALL_FONT = BASE_FONT.deriveFont(BASE_FONT.getSize() * DE_EM);

}
