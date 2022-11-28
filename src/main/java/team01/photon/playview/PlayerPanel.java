package team01.photon.playview;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import team01.photon.Player;

public class PlayerPanel extends BasePanel implements ChangeListener, ActionListener {
    private transient PlayerNameLabel name;
    private transient PlayerScoreLabel score;
    private transient Player linkedPlayer;
    private static final String PLACEHOLDER = "Player";
    private Timer flashTimer;
    private static final int FLASH_INTERVAL = 1000;

    public PlayerPanel() {
        this(PLACEHOLDER, 0);
    }

    public PlayerPanel(Player player) {
        this(player.getCodename(), player.getScore());
        linkedPlayer = player;
        player.addChangeListener(this);
    }

    public PlayerPanel(String name, int score) {
        super();
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

        this.name = new PlayerNameLabel(name, Constants.FG_COLOR, SwingConstants.LEADING);
        this.score = new PlayerScoreLabel(score, Constants.FG_COLOR, SwingConstants.LEADING);

        add(this.name);
        add(Box.createHorizontalGlue());
        add(this.score);

        flashTimer = new Timer(FLASH_INTERVAL / 2, this);
    }

    public void changePlayer(Player player) {
        linkedPlayer.removeChangeListener(this);
        linkedPlayer = player;
        linkedPlayer.addChangeListener(this);
        setPlayerName(linkedPlayer.getCodename());
        setPlayerScore(linkedPlayer.getScore());
    }

    public void setPlayerName(String name) {
        this.name.setText(name);
    }

    public void setPlayerScore(int score) {
        this.score.setScore(score);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        score.setScore(linkedPlayer.getScore());
        updateTimer();
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        setVisible(!isVisible());
    }

    private void updateTimer() {
        if (linkedPlayer.getLeaderStatus()) {
            flashTimer.start();
        } else {
            flashTimer.stop();
            setVisible(true);
        }
    }
}
