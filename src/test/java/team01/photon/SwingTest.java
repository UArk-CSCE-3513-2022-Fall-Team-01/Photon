package team01.photon;

import java.awt.ComponentOrientation;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;

import team01.photon.playview.MainView;
import team01.photon.playview.TeamPane;

public class SwingTest {
    public static void main(String[] args) {
        MainView view = new MainView(null, null);

        view.setLayout(new BoxLayout(view.getContentPane(), BoxLayout.LINE_AXIS));

        TeamPane tmp;

        tmp = new TeamPane();
        tmp.addPlaceholderTeam();
        view.add(tmp);

        view.add(Box.createRigidArea(new Dimension(427, 0)));

        tmp = new TeamPane();
        tmp.addPlaceholderTeam();
        view.add(tmp);

        view.setVisible(true);
    }
}
