package com.team01.photon;

import java.awt.GridLayout;

import javax.swing.BoxLayout;

import com.team01.photon.PlayView.MainView;
import com.team01.photon.PlayView.PlayerPanel;

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
