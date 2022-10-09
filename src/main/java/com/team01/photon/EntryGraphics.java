package com.team01.photon;
import java.awt.*;
import javax.swing.*;

public class EntryGraphics extends JPanel
{
    private final int frameW;
    private final int frameH;

    public EntryGraphics(int width, int height)
    {
        frameW = width;
        frameH = height;
    }

    @Override
    public void paintComponent(final Graphics g)
    {
        //Default background
        g.setColor(Color.BLACK);
        g.fillRect(0,0,frameW,frameH);

        //Image background
        ImageIcon entryImage = new ImageIcon(this.getClass().getResource("/images/entryscreen.png"));
        g.drawImage(entryImage.getImage(),0,0,null);

    }
}
