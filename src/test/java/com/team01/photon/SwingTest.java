package com.team01.photon;

import java.awt.GridLayout;

import javax.swing.BoxLayout;

public class SwingTest {
    public static void main(String[] args) {
        PlayView view = new PlayView(null, null);
        GridLayout layout = new GridLayout(15, 2);
        view.setLayout(layout);

        view.add(new PlayViewPlayerRecord());
        view.add(new PlayViewPlayerRecord());
        view.add(new PlayViewPlayerRecord());
        view.add(new PlayViewPlayerRecord());
        view.add(new PlayViewPlayerRecord());
        view.add(new PlayViewPlayerRecord());
        view.add(new PlayViewPlayerRecord());
        view.add(new PlayViewPlayerRecord());
        view.add(new PlayViewPlayerRecord());
        view.add(new PlayViewPlayerRecord());
        view.add(new PlayViewPlayerRecord());
        view.add(new PlayViewPlayerRecord());
        view.add(new PlayViewPlayerRecord());
        view.add(new PlayViewPlayerRecord());
        view.add(new PlayViewPlayerRecord());

        view.add(new PlayViewPlayerRecord());
        view.add(new PlayViewPlayerRecord());
        view.add(new PlayViewPlayerRecord());
        view.add(new PlayViewPlayerRecord());
        view.add(new PlayViewPlayerRecord());
        view.add(new PlayViewPlayerRecord());
        view.add(new PlayViewPlayerRecord());
        view.add(new PlayViewPlayerRecord());
        view.add(new PlayViewPlayerRecord());
        view.add(new PlayViewPlayerRecord());
        view.add(new PlayViewPlayerRecord());
        view.add(new PlayViewPlayerRecord());
        view.add(new PlayViewPlayerRecord());
        view.add(new PlayViewPlayerRecord());
        view.add(new PlayViewPlayerRecord());

        view.setVisible(true);
    }
}
