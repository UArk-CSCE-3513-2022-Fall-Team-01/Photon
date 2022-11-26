package team01.photon;

import team01.photon.playview.MainView;

public class Game {
    private Splash splashScreen;
    private EntryGraphicsView entryScreen;
    private GameModel model;
    private MainView actionScreen;

    public static void main(String[] args) {
        Game self = new Game();
    }

    public Game() {
        run();
    }

    public void run() {
        splashScreen = new Splash(3000); // Create a splash screen that lasts for 3 seconds
        splashScreen.show(); // Show the splash screen

        entryScreen = new EntryGraphicsView(this);
        entryScreen.run();
    }

    public void switchToPlayScreen() {
        entryScreen.setVisible(false);
        model = new GameModel();
        model.importEntryGraphicsData(entryScreen.entryScreen);
        actionScreen = new MainView(model, null);
        actionScreen.setVisible(true);
        model.startCountdown();
    }
}
