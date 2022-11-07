package team01.photon.playview;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import team01.photon.Team;

public class TeamPanel extends BasePanel implements ChangeListener {
    private transient TeamNameLabel name;
    private transient TeamScoreLabel score;
    private transient Team linkedTeam;
    private static final String PLACEHOLDER = "Team";

    public TeamPanel(Team team) {
        super();
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

        linkedTeam = team;
        this.name = new TeamNameLabel(team.getName(), Constants.FG_COLOR, SwingConstants.LEADING);
        this.score = new TeamScoreLabel(team.getScore(), Constants.FG_COLOR, SwingConstants.TRAILING);

        add(this.name);
        add(Box.createHorizontalGlue());
        add(this.score);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        score.setScore(linkedTeam.getScore());
    }

}
