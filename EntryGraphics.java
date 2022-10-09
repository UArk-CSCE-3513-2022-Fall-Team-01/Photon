import java.awt.*;
import javax.swing.*;

public class EntryGraphics extends JPanel
{
    private int frameW;
    private int frameH;

    private int playersPerTeam = 15; //The number of boxes to be made for player/ID input

    public EntryGraphics(int width, int height)
    {
        frameW = width;
        frameH = height;
    }

    @Override
    public void paintComponent(final Graphics g)
    {
        //Spacing variables
        int boxHeight = 45;
        int idBoxWidth = 70;
        int playerBoxWidth = 200;
        int pixelGap = 5;
        int playerNumGap = 40;
        int titleGap = 100;
        int teamLabelGap = 50;

        //Default background
        g.setColor(Color.BLACK);
        g.fillRect(0,0,frameW,frameH);

        ImageIcon entryImage = new ImageIcon("images/entryscreen.png");
        g.drawImage(entryImage.getImage(),0,0,null);

        //Team panels
        /*g.setColor(new Color(200,0,0));
        g.fillRect(pixelGap,titleGap-pixelGap,frameW/2,frameH - titleGap*2);
        g.setColor(new Color(0,200,0));
        g.fillRect(frameW/2,titleGap-pixelGap,frameW/2 - pixelGap,frameH - titleGap*2);

        g.setColor(Color.LIGHT_GRAY);
        for(int team = 0; team < 2; team++)
        {
            for(int player = 0; player < playersPerTeam; player++)
            {
                int teamOffset = (frameW/2) + ((playerBoxWidth + idBoxWidth + pixelGap*2)*(team-1) + (playerNumGap)*team); //The X start of each team ID column
                g.fillRect(teamOffset, titleGap + teamLabelGap + (pixelGap+boxHeight)*player, idBoxWidth, boxHeight);
                g.fillRect(teamOffset + pixelGap + idBoxWidth, titleGap + teamLabelGap + (pixelGap+boxHeight)*player, playerBoxWidth, boxHeight);
            }
        }*/
    }
}
