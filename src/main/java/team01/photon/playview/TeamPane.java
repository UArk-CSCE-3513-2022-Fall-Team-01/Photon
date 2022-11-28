package team01.photon.playview;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import team01.photon.Team;

public class TeamPane extends BasePanel implements ChangeListener {
    private transient TeamPanel teamInfo;
    private transient PlayerRosterPanel membersInfo;
    private transient Team linkedTeam;

    public TeamPane() {
        super();
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    }

    public TeamPane(Team team) {
        this();

        linkedTeam = team;
        teamInfo = new TeamPanel(linkedTeam);
        membersInfo = new PlayerRosterPanel(linkedTeam.getPlayers());
        team.addChangeListener(this);

        add(teamInfo);
        add(membersInfo);
    }

    public void addPlaceholderTeam(Color color) {
        add(new TeamNameLabel("Placeholder Team", color, SwingConstants.CENTER));

        PlayerRosterPanel tmp = new PlayerRosterPanel();
        tmp.addPlaceholderPlayers();
        add(tmp);
    }

    @Override
    public void stateChanged(ChangeEvent arg0) {
        teamInfo.updateScore();
        membersInfo.reassignPlayers(linkedTeam.getLeaderboard());
    }
}
