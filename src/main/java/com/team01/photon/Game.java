package com.team01.photon;
import javax.swing.*;
public class Game{
    public static void main(String[] args){
        Splash splash = new Splash(3000); //Create a splash screen that lasts for 3 seconds
		splash.show(); //Show the splash screen

        int frameW = 800;
        int frameH = 1000;

        JFrame frame = new JFrame("Photon");
        EntryGraphics entryScreen = new EntryGraphics(frameW,frameH);
        frame.add(entryScreen);

        frame.pack();
        frame.setSize(frameW, frameH);                     // Size frame.
        frame.setResizable(false);                         // Prevents the manual resize of the window.
        frame.setLocationRelativeTo(null);                         // Places frame in the center of the screen.
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);         // Finishes the program when we press the X button.


        frame.setVisible(true);


        //Entry screen manipulation
        boolean team = false; //False is editing team red side, true is editing team blue side
    }
}