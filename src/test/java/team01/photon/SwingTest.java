package team01.photon;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;

import team01.photon.playview.MainView;
import team01.photon.playview.MatchPane;
import team01.photon.playview.TeamPane;

public class SwingTest {
    public static void main(String[] args) {
        MainView view = new MainView(null, null);

        view.setLayout(new BoxLayout(view.getContentPane(), BoxLayout.LINE_AXIS));
        view.getInsets().set(18, 32, 18, 32);

        TeamPane tmp;

        tmp = new TeamPane();
        tmp.addPlaceholderTeam(Color.RED);
        view.add(tmp);

        view.add(new MatchPane(null));

        tmp = new TeamPane();
        tmp.addPlaceholderTeam(Color.GREEN);
        view.add(tmp);

        view.setVisible(true);
    }
}
