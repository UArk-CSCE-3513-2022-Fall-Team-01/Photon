package team01.photon.playview;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import team01.photon.Team;

public class TeamPanel extends BasePanel implements ActionListener {
    private transient TeamNameLabel name;
    private transient TeamScoreLabel score;
    private transient Team linkedTeam;
    private static final String PLACEHOLDER = "Team";
    private Timer flashTimer;
    private static final int FLASH_INTERVAL = 1000;

    public TeamPanel(Team team) {
        super();
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

        linkedTeam = team;
        this.name = new TeamNameLabel(team.getName(), Constants.FG_COLOR, SwingConstants.LEADING);
        this.score = new TeamScoreLabel(team.getScore(), Constants.FG_COLOR, SwingConstants.TRAILING);

        add(this.name);
        add(Box.createHorizontalGlue());
        add(this.score);

        flashTimer = new Timer(FLASH_INTERVAL / 2, this);
    }

    public void updateInfo() {
        score.setScore(linkedTeam.getScore());
        if(linkedTeam.getLeaderStatus()) {
            flashTimer.start();
        } else {
            flashTimer.stop();
            score.setVisible(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        score.setVisible(!score.isVisible());
    }
}
