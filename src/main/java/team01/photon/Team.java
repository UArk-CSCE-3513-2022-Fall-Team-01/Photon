package team01.photon;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.EventListenerList;

public class Team implements Comparable<Team>, ChangeNotifier {

    private int score;
    private String name;
    private HashMap<Integer, Player> players = new HashMap<>(15);
    private EventListenerList listeners;
    private boolean leaderStatus = false;

    public Team(String name) {
        this.name = name;
        listeners = new EventListenerList();
    }

    // Returns players in team in descending-score order
    public List<Player> getLeaderboard() {
        LinkedList<Player> tmp = new LinkedList<>(players.values());

        Collections.sort(tmp);
        Collections.reverse(tmp);

        return tmp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setScore(int score) {
        int oldScore = score;
        this.score = score;
        if (score != oldScore)
            fireChangeEvent();
    }

    public int getScore() {
        return score;
    }

    public void addScore(int score) {
        this.score = this.score + score;
        if (score != 0)
            fireChangeEvent();
    }

    public void addPlayer(int key, Player player) {
        players.put(key, player);
    }

    public void removePlayer(int key) {
        players.remove(key);
    }

    public Collection<Player> getPlayers() {
        return players.values();
    }

    public void addPlayerScores(){
        int oldScore = score;
        int newScore = 0;
        for(Player numPlayer : players.values()) {
            newScore += numPlayer.getScore();
        }
        this.score = newScore;
        if (newScore != oldScore)
            fireChangeEvent();
    }

    public boolean getLeaderStatus() {
        return leaderStatus;
    }

    public void setLeaderStatus(boolean value) {
        boolean oldStatus = leaderStatus;
        leaderStatus = value;
        if (value != oldStatus)
            fireChangeEvent();
    }

    @Override
    public int compareTo(Team o) {
        return getScore() - o.getScore();
    }

    @Override
    public void addChangeListener(ChangeListener listener) {
        listeners.add(ChangeListener.class, listener);
    }

    @Override
    public void removeChangeListener(ChangeListener listener) {
        listeners.remove(ChangeListener.class, listener);
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
}
