package com.team01.photon;
import java.awt.Image;
import javax.swing.*;

class Splash {
    JFrame frame;                 // GUI window to add components.
    JLabel label;                 // GUI display area for strings or images. 

    public Splash(){
        label = new JLabel();
        frame = new JFrame();

        addImage();               // Adds image to the frame.
        createFrame();            // Creates the frame.
    }
    public void createFrame(){
        frame.setUndecorated(true);                          // Gets rid of the tittle bar
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setSize(871, 555);                 // Sets the size of the window.
        frame.setLocationRelativeTo(null);                   // Sets the location to the center of the screen. 
        frame.setVisible(true);                              // Makes the window visible.
        frame.setResizable(false);                   // Prevents the manual resize of the window. 
    }
    public void addImage(){        
        ImageIcon image = new ImageIcon(this.getClass().getResource("/logo.jpg"));    // Creates ImageIcon component. 
        Image newImage1 = image.getImage();                       // Transforms image.
        Image newImage2 = newImage1.getScaledInstance(871, 555,  java.awt.Image.SCALE_SMOOTH); // Scales the image. 
        ImageIcon icon = new ImageIcon(newImage2);                // Adds the scaled image to icon 
        
        label.setIcon(icon);                                      // Adds icon to label.
        label.setHorizontalAlignment(JLabel.CENTER);              // Moves image to the center horizontally.
        label.setVerticalAlignment(JLabel.CENTER);                // Moves image to the center vertically.
        frame.add(label);                                         // Adds label to frame to display image. 
    }

}
