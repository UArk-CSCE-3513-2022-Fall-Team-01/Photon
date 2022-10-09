import java.awt.Dimension;
import java.awt.Color;
import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;

class Entry extends JFrame{
    JFrame frame;
    JPanel panel1;
    JPanel panel2;
    JTable table1;

    int x1 = 200;                          // X-Cordinate of panel1.
    int y1 = 100;                          // Y-Cordinate of panel.
    int w1 = 300;                          // Width of panel.
    int h1 = 600;                          // Height of panel.

    int x2 = x1 + w1;                      // X-Cordinate of panel2.
    int y2 = y1;                           // Y_Cordinate of panel2.
    int w2 = w1;                           // Width of panel2.
    int h2 = h1;                           // Height of panel2.

    int rows = 2;                          // Jtable rows.
    int columns = 5;                       // Jtable columns.

    String[] tableHeader = {"ID", "CODENAME"};
    String[][] tableColumns = {
        {" ", " "},
        {" ", " "},
        {" ", " "},
        {" ", " "},
        {" ", " "}
    };

    public Entry(){
        frame = new JFrame("Laser Tag");
        panel1 = new JPanel();
        panel2 = new JPanel();
        table1 = new JTable(tableColumns, tableHeader);


        addFrame();
        addPanel();
        addTable();
    }
    public void addFrame(){
        frame.setVisible(true);                                    // Makes frame visible.
        frame.setLayout(null);                               // Null because we are adding components manually.
        frame.setSize(1000, 1000);                     // Size frame.
        frame.setResizable(false);                         // Prevents the manual resize of the window. 
        frame.getContentPane().setBackground(Color.BLACK);           // Background color.
        frame.setLocationRelativeTo(null);                         // Places frame in the center of the screen.
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);         // Finishes the program when we press the X bottom.

    }
    public void addPanel(){                                          // Method that created the team panels
        panel1.setBounds(x1, y1, w1, h1);
        panel1.setBackground(Color.RED);

        panel2.setBounds(x2, y2, w2, h2);
        panel2.setBackground(Color.BLUE);
        
        frame.add(panel1);                                            // Panels added to the frame.
        frame.add(panel2);
    }
    public void addTable(){                                           // Creates the input fields for the team panels 
        JScrollPane scrollPane = new JScrollPane(table1);             // Without this the table has no labels 
        panel1.add(scrollPane);                                       // Adds table to the panel
    }
}
