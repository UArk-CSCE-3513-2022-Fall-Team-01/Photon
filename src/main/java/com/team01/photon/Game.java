package com.team01.photon;
import javax.swing.*;
public class Game extends JFrame
{
    public EntryGraphics entryScreen;
    public Game()
    {
        int frameW = 800;
        int frameH = 1000;

        entryScreen = new EntryGraphics(frameW,frameH);

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

    }

    public void run()
    {
        while(true)
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
    public static void main(String[] args){
        Splash splashScreen = new Splash(3000); //Create a splash screen that lasts for 3 seconds
		splashScreen.show(); //Show the splash screen

        Game game = new Game();
        game.run();
    }
}