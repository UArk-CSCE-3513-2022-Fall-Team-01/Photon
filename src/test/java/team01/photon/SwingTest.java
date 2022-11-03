package team01.photon;

import java.awt.GridLayout;

import javax.swing.BoxLayout;

import team01.photon.playview.MainView;
import team01.photon.playview.PlayerPanel;

public class SwingTest {
    public static void main(String[] args) {
        MainView view = new MainView(null, null);
        GridLayout layout = new GridLayout(15, 2);
        view.setLayout(layout);

        view.add(new PlayerPanel());
        view.add(new PlayerPanel());
        view.add(new PlayerPanel());
        view.add(new PlayerPanel());
        view.add(new PlayerPanel());
        view.add(new PlayerPanel());
        view.add(new PlayerPanel());
        view.add(new PlayerPanel());
        view.add(new PlayerPanel());
        view.add(new PlayerPanel());
        view.add(new PlayerPanel());
        view.add(new PlayerPanel());
        view.add(new PlayerPanel());
        view.add(new PlayerPanel());
        view.add(new PlayerPanel());

        view.add(new PlayerPanel());
        view.add(new PlayerPanel());
        view.add(new PlayerPanel());
        view.add(new PlayerPanel());
        view.add(new PlayerPanel());
        view.add(new PlayerPanel());
        view.add(new PlayerPanel());
        view.add(new PlayerPanel());
        view.add(new PlayerPanel());
        view.add(new PlayerPanel());
        view.add(new PlayerPanel());
        view.add(new PlayerPanel());
        view.add(new PlayerPanel());
        view.add(new PlayerPanel());
        view.add(new PlayerPanel());

        view.setVisible(true);
    }
}
