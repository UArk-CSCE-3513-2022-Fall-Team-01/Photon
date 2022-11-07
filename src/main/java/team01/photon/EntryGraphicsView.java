package team01.photon;

import javax.swing.JFrame;

public class EntryGraphicsView extends JFrame
{
    public Game game;
    public boolean doRepaintLoop;
    public EntryGraphics entryScreen;

    public Player[] redTeam;
    public Player[] greenTeam;

    public HerokuPostgreDatabase herokuDB;

    public EntryGraphicsView(Game game)
    {
        this.game = game;

        doRepaintLoop = true;
        int frameW = 800;
        int frameH = 1000;

        entryScreen = new EntryGraphics(this,frameW,frameH);

        //JFrame settings
        this.setTitle("Photon");
        this.add(entryScreen); //Display the entry screen graphics first
        this.pack();
        this.setSize(frameW,frameH);
        this.setResizable(false); //Makes window unresizable
        this.setLocationRelativeTo(null); // Places frame in the center of the screen.
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE); // Finishes the program when we press the X button.
        this.setFocusTraversalKeysEnabled(false); //Required to capture Tab key inputs
        this.setVisible(true); //Make it appear

        //Add a key listener for keyboard input
        this.addKeyListener(entryScreen);

        //Set up teams and the Heroku database connection
        redTeam = new Player[15];
        greenTeam = new Player[15];
        try {
            herokuDB = new HerokuPostgreDatabase("postgres://kpzobqnwpafnyz:c2b612290e4aca89454e4c97e18d21cf0586baabdd41701f9c0162ce24cea4d7@ec2-52-207-90-231.compute-1.amazonaws.com:5432/d48c8dhcuoropm");
        }catch(Exception e){
            System.out.println("There was a problem linking to the database");
            e.printStackTrace();
        }

    }

    public void run()
    {
        while(doRepaintLoop)
        {
            entryScreen.repaint();


            try
            {
                Thread.sleep(40);
            } catch(Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
    }
}
