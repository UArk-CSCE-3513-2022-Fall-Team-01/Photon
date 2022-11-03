package team01.photon.playview;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.SwingConstants;

import team01.photon.Player;

public class PlayerPanel extends BasePanel {
    private transient PlayerNameLabel name;
    private transient PlayerScoreLabel score;
    private static final String PLACEHOLDER = "Player";

    public PlayerPanel() {
        this(PLACEHOLDER, 0);
    }

    public PlayerPanel(Player player) {
        this(player.codename(), player.score());
    }

    public PlayerPanel(String name, int score) {
        super(new GridBagLayout());

        this.name = new PlayerNameLabel(name, Constants.FG_COLOR, SwingConstants.LEADING);
        this.score = new PlayerScoreLabel(score, Constants.FG_COLOR, SwingConstants.LEADING);

        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.LINE_START;
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 1;
        c.ipady = 1;
        c.weightx = 1.0;

        add(this.name, c);

        c.anchor = GridBagConstraints.LINE_END;
        c.gridx = 1;
        c.fill = GridBagConstraints.NONE;
        c.weightx = 0.0;

        add(this.score, c);
    }

    public void setPlayerName(String name) {
        this.name.setText(name);
    }

    public void setPlayerScore(int score) {
        this.score.setScore(score);
    }

    // TODO: Test out flipping the orientation. It should work if using
    // setComponentOrientation
}
