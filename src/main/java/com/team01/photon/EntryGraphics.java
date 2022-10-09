package com.team01.photon;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EntryGraphics extends JPanel implements KeyListener
{
    private final int frameW;
    private final int frameH;
    private int playerSelected;
    private boolean teamSelected; //False for red, true for green
    private boolean editingCodename; //False means entering ID, true means entering/editing codename

    //Spacing variables
    private final int pixelsBetweenBoxes;
    private final int boxHeight;
    private final int idWidth;
    private final int playerWidth;
    private final int redTeamX; //X value to start drawing the selection box for red team
    private final int blueTeamX; //X value to start drawing the selection box for blue team
    private final int startingY; //Y value to start drawing the selection box

    //Keys
    boolean tabKeyDown;


    public EntryGraphics(int width, int height)
    {
        frameW = width;
        frameH = height;
        playerSelected = 0;
        teamSelected = false;
        editingCodename = false;

        //Spacing variables
        pixelsBetweenBoxes = 5;
        boxHeight = 40;
        idWidth = 90;
        playerWidth = 250;
        redTeamX = 45;
        blueTeamX = 445;
        startingY = 120;

        //Keys
        tabKeyDown = false;

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

        //Selection box outline
        g.setColor(System.currentTimeMillis() % 700 > 350 ? Color.BLUE : Color.WHITE);
        for(int outlineLayer = 0; outlineLayer < 5; outlineLayer++)
        {
            int x = (teamSelected ? blueTeamX : redTeamX) + (editingCodename ? idWidth : 0) + outlineLayer;
            int y = startingY + playerSelected*(pixelsBetweenBoxes+boxHeight) + outlineLayer;
            int w = (editingCodename ? playerWidth : idWidth) + (9-outlineLayer*2);
            int h = boxHeight + (9-outlineLayer*2);
            g.drawRect(x,y,w,h);
        }
    }

    public void keyPressed(KeyEvent ke)
    {
        System.out.println(ke.getKeyCode());
        switch(ke.getKeyCode())
        {
            case KeyEvent.VK_TAB:
                playerSelected++;
                break;
        }
    }
    public void keyReleased(KeyEvent ke)
    {
    }
    public void keyTyped(KeyEvent ke){}
}
