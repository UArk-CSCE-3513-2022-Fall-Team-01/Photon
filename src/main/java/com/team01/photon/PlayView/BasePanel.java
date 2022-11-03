package com.team01.photon.PlayView;

import java.awt.LayoutManager;

import javax.swing.JPanel;

public abstract class BasePanel extends JPanel {

    protected BasePanel(LayoutManager layoutManager) {
        super(layoutManager);
        setOpaque(false);
    }

    protected BasePanel() {
        super();
        setOpaque(false);
    }

}
