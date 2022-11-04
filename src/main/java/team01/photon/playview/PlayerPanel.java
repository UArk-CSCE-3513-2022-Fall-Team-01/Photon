package team01.photon.playview;

import javax.swing.Box;
import javax.swing.BoxLayout;
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
        super();
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

        this.name = new PlayerNameLabel(name, Constants.FG_COLOR, SwingConstants.LEADING);
        this.score = new PlayerScoreLabel(score, Constants.FG_COLOR, SwingConstants.LEADING);

        add(this.name);
        add(Box.createHorizontalGlue());
        add(this.score);
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
