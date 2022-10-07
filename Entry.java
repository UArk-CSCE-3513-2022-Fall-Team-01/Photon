// Entry Screen class
import java.awt.Color;

import javax.swing.*;

class Entry {
    JFrame frame;
    JPanel panel;

    public Entry(){
        frame = new JFrame("Laser Tag");
        panel = new JPanel();

        frame();
    }
    public void frame(){
        frame.setVisible(true);
        frame.setSize(1000, 1000);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

    }
    // I am thinking of using JPanel two create two panels. One for each team. Then maybe use the BoxLayout to make all the cells in the column.
    public void teamPanel(){
        panel.setBounds(100, 100, 100, 100);
        panel.setBackground(Color.white);
        frame.add(panel);

    }
}
