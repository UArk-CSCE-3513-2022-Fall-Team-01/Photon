package team01.photon;

import team01.photon.playview.MainView;

public class Game
{
    private static Splash splashScreen;
    private static EntryGraphicsView entryScreen;
    private static GameModel model;
    private static MainView actionScreen;

    public static void main(String[] args) {
        splashScreen = new Splash(3000); //Create a splash screen that lasts for 3 seconds
		splashScreen.show(); //Show the splash screen

        entryScreen = new EntryGraphicsView();
        entryScreen.run();
    }

    public static void switchToPlayScreen() {
        entryScreen.setVisible(false);
        model = new GameModel();
        model.importEntryGraphicsData(entryScreen.entryScreen);
        actionScreen = new MainView(model, null);
        actionScreen.setVisible(true);
    }
}
