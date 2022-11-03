package team01.photon.playview;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.SwingConstants;

public class PlayerPanel extends BasePanel {
    private final PlayerNameLabel name;
    private PlayerScoreLabel score;
    private static final String lorem = "Placeholder";

    public PlayerPanel() {
        super(new GridBagLayout());

        name = new PlayerNameLabel(lorem, Constants.FG_COLOR, SwingConstants.LEADING);
        score = new PlayerScoreLabel(Constants.FG_COLOR, SwingConstants.LEADING);

        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.LINE_START;
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 1;
        c.ipady = 1;
        c.weightx = 1.0;

        add(name, c);

        c.anchor = GridBagConstraints.LINE_END;
        c.gridx = 1;
        c.fill = GridBagConstraints.NONE;
        c.weightx = 0.0;

        add(score, c);
    }

    // TODO: Test out flipping the orientation. It should work if using
    // setComponentOrientation
}
