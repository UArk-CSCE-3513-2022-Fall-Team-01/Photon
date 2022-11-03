package com.team01.photon;

import java.awt.LayoutManager;

import javax.swing.JPanel;

public abstract class PlayViewPanel extends JPanel {

    protected PlayViewPanel(LayoutManager layoutManager) {
        super(layoutManager);
    }

    protected PlayViewPanel() {
        super();
    }

}
