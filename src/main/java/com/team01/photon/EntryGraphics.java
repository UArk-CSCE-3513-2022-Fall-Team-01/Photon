package com.team01.photon;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Arrays;

public class EntryGraphics extends JPanel
{
    public Game game;

    private final int frameW;
    private final int frameH;
    public int playerSelected;
    public boolean teamSelected; //False for red, true for green
    public boolean editingCodename; //False means entering ID, true means entering/editing codename

    //Spacing variables
    private final int pixelsBetweenBoxes;
    private final int boxHeight;
    private final int idWidth;
    private final int playerWidth;
    private final int redTeamX; //X value to start drawing the selection box for red team
    private final int greenTeamX; //X value to start drawing the selection box for blue team
    private final int startingY; //Y value to start drawing the selection box

    public String editText;
    public String temporaryIDText;
    private Font textFont;



    public EntryGraphics(Game game, int width, int height)
    {
        this.game = game;
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
        greenTeamX = 445;
        startingY = 120;

        textFont = new Font("SANS_SERIF",Font.PLAIN,35);
        editText = "";
        temporaryIDText = "";
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

        int x = (teamSelected ? greenTeamX : redTeamX) + (editingCodename ? idWidth + pixelsBetweenBoxes : 0);
        int y = startingY + playerSelected*(pixelsBetweenBoxes+boxHeight);
        int w = (editingCodename ? playerWidth : idWidth);
        int h = boxHeight;

        for(int outlineLayer = 0; outlineLayer < 5; outlineLayer++)
        {
            int olX = x + outlineLayer;
            int olY = y + outlineLayer;
            int olW = w + (9-outlineLayer*2);
            int olH = h + (9-outlineLayer*2);
            g.drawRect(olX,olY,olW,olH);
        }

        //Current text input drawing
        g.setFont(textFont);
        g.drawString(editText,x + pixelsBetweenBoxes, y + boxHeight);
        g.drawString(temporaryIDText,teamSelected ? greenTeamX : redTeamX + pixelsBetweenBoxes, y + boxHeight);


        //Stored IDs and codenames drawing
        g.setColor(Color.BLACK);

        //Red team IDs
        for(int id = 0; id < 15; id++)
        {
            x = redTeamX;
            y = startingY + id*(pixelsBetweenBoxes+boxHeight);

            if(game.redTeam[id] != null){
                int playerID = game.redTeam[id].id();
                g.drawString(Integer.toString(playerID),x + pixelsBetweenBoxes, y + boxHeight);
            }
        }

        //Green team IDs
        for(int id = 0; id < 15; id++)
        {
            x = greenTeamX;
            y = startingY + id*(pixelsBetweenBoxes+boxHeight);

            if(game.greenTeam[id] != null){
                int playerID = game.greenTeam[id].id();
                g.drawString(Integer.toString(playerID),x + pixelsBetweenBoxes, y + boxHeight);
            }
        }

        //Red team names
        for(int id = 0; id < 15; id++)
        {
            x = redTeamX + idWidth + pixelsBetweenBoxes;
            y = startingY + id*(pixelsBetweenBoxes+boxHeight);

            if(game.redTeam[id] != null){
                String playerName = game.redTeam[id].codename();
                g.drawString(playerName,x + pixelsBetweenBoxes, y + boxHeight);
            }
        }

        //Red team names
        for(int id = 0; id < 15; id++)
        {
            x = greenTeamX + idWidth + pixelsBetweenBoxes;
            y = startingY + id*(pixelsBetweenBoxes+boxHeight);

            if(game.greenTeam[id] != null){
                String playerName = game.greenTeam[id].codename();
                g.drawString(playerName,x + pixelsBetweenBoxes, y + boxHeight);
            }
        }

    }
}
