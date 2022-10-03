import javax.swing.*;

class Splash {
    JFrame frame;
    JLabel image = new JLabel(new ImageIcon("logo.jpg"));   //Creating object of JLabel and adding image using the ImageIcon class

    public Splash(){
        createFrame();
        addImage();
    }

    public void createFrame(){
        frame = new JFrame();
        frame.getContentPane().setLayout(null);
        frame.setUndecorated(true);                // Gets rid of the tittle bar.
        frame.setSize(500, 300);                  // Sets the size of the window.
        frame.setLocationRelativeTo(null);                    // Sets the location to the center of the screen. 
        frame.setVisible(true);                                // Makes the window visible.
        
    }
    public void addImage(){
        image.setSize(200,100);                     // Setting size of the image
        frame.add(image);                           	        // Adding image to the frame.
    }

}
