package com.team01.photon;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Color;
import java.awt.Graphics;

public class PlayView extends JFrame {
    private static final Dimension DEFAULT_SIZE = new Dimension(1280, 720);
    private static final String DEFAULT_TITLE = "Photon: Game Action";

    private Model model;
    private Controller controller;

    public PlayView(Model model, Controller controller) {
        this(DEFAULT_TITLE, model, controller);
    }

    public PlayView(String title, Model model, Controller controller) throws HeadlessException {
        super(title);

        this.model = model;
        this.controller = controller;

        setPreferredSize(DEFAULT_SIZE);
        setMinimumSize(DEFAULT_SIZE);
        setSize(DEFAULT_SIZE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(PlayViewConstants.BG_COLOR);
    }
}
