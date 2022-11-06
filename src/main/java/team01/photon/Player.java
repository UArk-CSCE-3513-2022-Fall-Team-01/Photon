package team01.photon;

import javax.swing.event.ChangeListener;

public interface Player {
    public int getId();

    public String getCodename();

    public int getScore();

    public void setScore(int newScore);

    public void addToScore(int newScore);

    public void addChangeListener(ChangeListener listener);

    public void clearChangeListeners();
}
