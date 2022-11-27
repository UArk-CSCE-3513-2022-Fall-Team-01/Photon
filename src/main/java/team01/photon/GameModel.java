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
    EventFeedQueue eventQueue;

    public GameModel() {
        teams = new ArrayList<>();
        players = new HashMap<>();
        timer = new CountdownTimer();
        timer.addChangeListener(this);
        eventQueue = new EventFeedQueue();
    }

    public void importEntryGraphicsData(EntryGraphics data) {
        Team tmpRedTeam = new Team("Alpha Red");
        Team tmpGreenTeam = new Team("Alpha Grn");

        int i = 0;
        for (int id : data.redTeamIDs) {
            if (id < 0)
                break;
            Player tmp = new BasicPlayer(id, data.redTeamNames[i]);
            addPlayer(tmp, tmpRedTeam);
            i++;
        }

        i = 0;
        for (int id : data.greenTeamIDs) {
            if (id < 0)
                break;
            Player tmp = new BasicPlayer(id, data.greenTeamNames[i]);
            addPlayer(tmp, tmpGreenTeam);
            i++;
        }

        teams.add(tmpRedTeam);
        teams.add(tmpGreenTeam);
    }

    @Override
    public void addTeam(Team team) {
        // TODO: Add checking for existing team. Maybe use a Set / HashSet instead?
        teams.add(team);
    }

    @Override
    public void addPlayer(Player player, Team team) {
        players.put(player.getId(), player);
        team.addPlayer(player.getId(), player);
    }

    @Override
    public void playerHit(int attackerID, int victimID) { playerHit(getPlayerById(attackerID),getPlayerById(victimID)); }

    @Override
    public void playerHit(Player attacker, Player victim) {
        playerHit(new PlayerHitEvent(attacker, victim));
    }

    @Override
    public void playerHit(PlayerHitEvent e) {
        final int HIT_VALUE = 10;
        e.getAttacker().addToScore(HIT_VALUE);
        e.getVictim().addToScore(-HIT_VALUE);

        eventQueue.add(e);
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
        boolean result = true;

        result = teams.size() >= 2;
        for (Team team : teams) {
            if (!team.getPlayers().isEmpty()) {
                result = false;
                break;
            }
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
