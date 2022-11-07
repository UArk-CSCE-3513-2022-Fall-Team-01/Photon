package team01.photon;
import javax.swing.*;
public class Game extends JFrame
{
    public static void main(String[] args){
        Splash splashScreen = new Splash(3000); //Create a splash screen that lasts for 3 seconds
		splashScreen.show(); //Show the splash screen

        EntryGraphicsView game = new EntryGraphicsView();
        game.run();
    }
}
