package team01.photon;

import java.util.Collection;
import java.util.HashMap;

public class Team implements Comparable<Team> {

    private int score;
    private String name;
    private HashMap<Integer, Player> players = new HashMap<>(15);

    public Team(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int score) {
        this.score = this.score + score;
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
        int newScore = 0;
        for(Player numPlayer : players.values()) {
            newScore += numPlayer.getScore();
        }
        this.score = newScore;
    }

    @Override
    public int compareTo(Team o) {
        return getScore() - o.getScore();
    }
}
