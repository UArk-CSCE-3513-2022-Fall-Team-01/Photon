package com.team01.photon.PlayView;

import java.awt.Color;
import java.awt.Font;

public final class Constants {
    private Constants() {
        // Hide constructor, class only contains static constants
    }
    private static final float EMPHASIZE = (float)1.2;
    private static final float DE_EMPHASIZE = (float)0.8;

    public static final int BASE_FONT_SIZE = 28;
    public static final float BIG_FONT_SIZE = BASE_FONT_SIZE * EMPHASIZE;
    public static final float SMALL_FONT_SIZE = BASE_FONT_SIZE * DE_EMPHASIZE;

    public static final Color BG_COLOR = Color.BLACK;
    public static final Color FG_COLOR = Color.WHITE;

    public static final Font BASE_FONT = new Font(Font.SANS_SERIF, Font.PLAIN, BASE_FONT_SIZE);
    public static final Font BIG_FONT = BASE_FONT.deriveFont(BIG_FONT_SIZE);
    public static final Font SMALL_FONT = BASE_FONT.deriveFont(SMALL_FONT_SIZE);

    public static final Font MONO_FONT = new Font(Font.MONOSPACED, Font.PLAIN, BASE_FONT_SIZE);
    public static final Font BIG_MONO_FONT = MONO_FONT.deriveFont(BIG_FONT_SIZE);
    public static final Font SMALL_MONO_FONT = MONO_FONT.deriveFont(SMALL_FONT_SIZE);
}
