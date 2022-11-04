package team01.photon.playview;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.SwingConstants;

import team01.photon.Team;

public class TeamPane extends BasePanel {
    public TeamPane() {
        super();
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    }

    public TeamPane(Team team) {
        this();
        add(new TeamNameLabel(team.name(), Constants.FG_COLOR, SwingConstants.CENTER));
        add(new PlayerRosterPanel(team.players()));
    }

    public void addPlaceholderTeam() {
        add(new TeamNameLabel("Placeholder Team", Color.GREEN, SwingConstants.CENTER));

        PlayerRosterPanel tmp = new PlayerRosterPanel();
        tmp.addPlaceholderPlayers();
        add(tmp);
    }
}
