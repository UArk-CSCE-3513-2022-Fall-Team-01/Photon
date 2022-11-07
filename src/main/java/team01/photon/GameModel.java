package team01.photon;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GameModel implements Model, ChangeListener {
    private static final int COUNTDOWN_SECONDS = 30;
    private static final Duration MATCH_LENGTH = Duration.ofMinutes(30);

    ArrayList<Team> teams;
    HashMap<Integer, Player> players;
    GameTimer timer;

    public GameModel() {
        teams = new ArrayList<>();
        players = new HashMap<>();
        // TODO: Instantiate timer when it's ready
        timer.addChangeListener(this);
    }

    @Override
    public void addTeam(Team team) {
        // TODO: Add checking for existing team. Maybe use a Set / HashSet instead?
        teams.add(team);
    }

    @Override
    public void addPlayer(Player player, Team team) {
        players.put(player.getId(), player);
        // TODO: Add player to team once that's implemented
    }

    @Override
    public void playerHit(Player attacker, Player victim) {
        // TODO: Sprint 4
        // Check behavior on Trello
    }

    public void startCountdown() {
        timer.setTime(COUNTDOWN_SECONDS);
        timer.start();
    }

    @Override
    public void startMatch() {
        // TODO: Finish in Sprint 4?
    }

    @Override
    public boolean readyToStart() {
        boolean result = false;

        for (Team team : teams) {
            // TODO: When implemented, make sure all teams have at least 1 player, and that
            // there are at least 2 teams
            // Add to the below a for loop for each team that checks for at least 1 player
            result = teams.size() >= 2;
        }

        return result;
    }

    @Override
    public Collection<Team> getTeams() {
        return teams;
    }

    @Override
    public Collection<Player> getPlayers() {
        return players.values();
    }

    @Override
    public Player getPlayerById(int id) {
        return players.get(id);
    }

    @Override
    public GameTimer getTimer() {
        return timer;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == timer && timer.getTime().isZero()) {
            startMatch();
            // TODO: Check that this would actually work, and also set timer to new value
        }
    }

}
