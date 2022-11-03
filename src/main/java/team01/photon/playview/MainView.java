package team01.photon.playview;

import java.awt.Dimension;
import java.awt.HeadlessException;

import javax.swing.JFrame;

import team01.photon.Controller;
import team01.photon.Model;
import team01.photon.View;

public class MainView extends JFrame implements View {
    private static final Dimension DEFAULT_SIZE = new Dimension(1280, 720);
    private static final String DEFAULT_TITLE = "Photon: Game Action";

    private Model model;
    private Controller controller;

    public MainView(Model model, Controller controller) {
        this(DEFAULT_TITLE, model, controller);
    }

    public MainView(String title, Model model, Controller controller) throws HeadlessException {
        super(title);

        this.model = model;
        this.controller = controller;

        setPreferredSize(DEFAULT_SIZE);
        setMinimumSize(DEFAULT_SIZE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Constants.BG_COLOR);
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        
    }
}
