package team01.photon;

import java.awt.Image;
import javax.swing.*;

class Splash {

    private final int t; // The time before the splash screen hides

    public Splash(int time) {
        t = time;
    }

    public void show() {
        JFrame frame = new JFrame();
        frame.setUndecorated(true); // Gets rid of the title bar
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setSize(871, 555); // Sets the size of the window.
        frame.setLocationRelativeTo(null); // Sets the location to the center of the screen.
        frame.setResizable(false); // Prevents the manual resize of the window.

        ImageIcon image = new ImageIcon(this.getClass().getResource("/images/photon.jpg")); // Creates ImageIcon
                                                                                            // component.
        Image newImage1 = image.getImage(); // Transforms image.
        Image newImage2 = newImage1.getScaledInstance(871, 555, java.awt.Image.SCALE_SMOOTH); // Scales the image.
        ImageIcon icon = new ImageIcon(newImage2); // Adds the scaled image to icon
        JLabel label = new JLabel(icon);

        label.setIcon(icon); // Adds icon to label.
        label.setHorizontalAlignment(JLabel.CENTER); // Moves image to the center horizontally.
        label.setVerticalAlignment(JLabel.CENTER); // Moves image to the center vertically.
        frame.add(label);

        frame.setVisible(true); // Makes the window visible.

        try {
            Thread.sleep(t);
        } catch (Exception e) {
            e.printStackTrace();
        }

        frame.setVisible(false);
    }
}
