package com.team01.photon;

public class SwingTest {
    public static void main(String[] args) {
        PlayView view = new PlayView(null, null);

        view.setVisible(true);

        while (true) {
            view.repaint();
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
