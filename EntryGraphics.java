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
        g.setColor(Color.RED);
        g.fillRect(0,0,frameW/2,frameH);
        g.setColor(Color.BLUE);
        g.fillRect(frameW/2,0,frameW/2,frameH);
    }
}
