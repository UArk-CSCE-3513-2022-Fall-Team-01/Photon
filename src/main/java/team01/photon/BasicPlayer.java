package team01.photon;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.EventListenerList;

public class BasicPlayer implements Player {
    private int id;
    private String codename;
    private int score;
    private boolean leaderStatus = false;

    private EventListenerList listeners;

    public BasicPlayer() {
        this(0, "Joker");
    }

    public BasicPlayer(int id, String codename) {
        this.id = id;
        this.codename = codename;
        this.score = 0;
        listeners = new EventListenerList();
    }

    @Override
    public String getCodename() {
        return codename;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public void setScore(int newScore) {
        int oldScore = score;
        newScore = newScore < 0 ? 0 : newScore; //If the new score is below zero, set to just zero
        score = newScore;
        if (newScore != oldScore)
            fireChangeEvent();
    }

    @Override
    public void addToScore(int amount) {
        setScore(getScore() + amount);
    }

    @Override
    public void addChangeListener(ChangeListener listener) {
        listeners.add(ChangeListener.class, listener);
    }

    @Override
    public void clearChangeListeners() {
        listeners = new EventListenerList();
    }

    protected void fireChangeEvent() {
        for (ChangeListener tmp : listeners.getListeners(ChangeListener.class)) {
            tmp.stateChanged(new ChangeEvent(this));
        }
    }

    @Override
    public void removeChangeListener(ChangeListener listener) {
        listeners.remove(ChangeListener.class, listener);
    }

    @Override
    public int compareTo(Player o) {
        return getScore() - o.getScore();
    }

    @Override
    public boolean getLeaderStatus() {
        return leaderStatus;
    }

    @Override
    public void setLeaderStatus(boolean value) {
        boolean oldStatus = leaderStatus;
        leaderStatus = value;
        if (value != oldStatus)
            fireChangeEvent();
    }
}
