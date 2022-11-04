package team01.photon.playview;

import java.awt.Container;
import java.util.Collection;

import javax.swing.Box;
import javax.swing.BoxLayout;

import team01.photon.Player;

public class PlayerRosterPanel extends BasePanel {
    public PlayerRosterPanel() {
        super();
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    }

    public PlayerRosterPanel(Collection<Player> players) {
        this();

        for (Player player : players) {
            add(new PlayerPanel(player));
        }

        finishList();
    }

    public void addPlaceholderPlayers() {
        final int amount = 15;

        for (int i = 0; i < amount; i++) {
            add(new PlayerPanel("Placeholder Player", 99999));
        }

        finishList();
    }

    private void finishList() {
        add(Box.createVerticalGlue());
    }
}
