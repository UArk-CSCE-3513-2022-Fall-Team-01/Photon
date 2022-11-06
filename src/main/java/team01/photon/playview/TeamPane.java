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
        add(new TeamNameLabel(team.getName(), Constants.FG_COLOR, SwingConstants.CENTER));
        // TODO: When Team class has getPlayers()
        // add(new PlayerRosterPanel(team.getPlayers()));
    }

    public void addPlaceholderTeam(Color color) {
        add(new TeamNameLabel("Placeholder Team", color, SwingConstants.CENTER));

        PlayerRosterPanel tmp = new PlayerRosterPanel();
        tmp.addPlaceholderPlayers();
        add(tmp);
    }
}
