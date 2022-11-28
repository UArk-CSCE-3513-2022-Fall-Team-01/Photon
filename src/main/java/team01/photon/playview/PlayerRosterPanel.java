package team01.photon.playview;

import java.util.List;
import java.util.Collection;
import java.util.LinkedList;

import javax.swing.Box;
import javax.swing.BoxLayout;

import team01.photon.Player;

public class PlayerRosterPanel extends BasePanel {
    LinkedList<PlayerPanel> playerPanels;

    public PlayerRosterPanel() {
        super();
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    }

    public PlayerRosterPanel(Collection<Player> players) {
        this();

        playerPanels = new LinkedList<>();

        for (Player player : players) {
            PlayerPanel tmp = new PlayerPanel(player);

            playerPanels.add(tmp);

            add(tmp);
        }

        finishList();
    }

    public void reassignPlayers(List<Player> players) {
        for (int i = 0; i < players.size(); i++) {
            playerPanels.get(i).changePlayer(players.get(i));
        }
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
