package team01.photon.playview;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import javax.swing.Timer;

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
        this.name = new TeamNameLabel(team.getName(), linkedTeam.getColor(), SwingConstants.LEADING);
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
            score.setForeground(Constants.FG_COLOR);
        }
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        score.setForeground(Constants.deriveComplement(score.getForeground()));
    }
}
