package team01.photon;

import java.awt.Color;
import java.time.Duration;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GameModel implements Model, ChangeListener {
    private static final int COUNTDOWN_SECONDS = 30;
    private static final Duration MATCH_LENGTH = Duration.ofMinutes(30);

    HashSet<Team> teams;
    HashMap<Integer, Player> players;
    GameTimer timer;
    EventFeedQueue eventQueue;
    Player leadingPlayer;
    Team leadingTeam;

    LinkedList<Player> playerLeaderboard;
    LinkedList<Team> teamLeaderboard;

    public boolean gameInProgress = false;

    public GameModel() {
        teams = new HashSet<>();
        players = new HashMap<>();
        timer = new CountdownTimer();
        timer.addChangeListener(this);
        eventQueue = new EventFeedQueue();
    }

    public void importEntryGraphicsData(EntryGraphics data) {
        Team tmpRedTeam = new Team("Alpha Red", Color.RED);
        Team tmpGreenTeam = new Team("Alpha Grn", Color.GREEN);

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

    // Sort places it in ascending order. Reverse to flip to descending
    // Updates the leading player and team as well
    private void sortLeaderboards() {
        if (!Objects.isNull(leadingPlayer))
            leadingPlayer.setLeaderStatus(false);
        if (!Objects.isNull(leadingTeam))
            leadingTeam.setLeaderStatus(false);

        Collections.sort(playerLeaderboard);
        Collections.reverse(playerLeaderboard);

        Collections.sort(teamLeaderboard);
        Collections.reverse(teamLeaderboard);

        leadingPlayer = getTopScoringPlayer();
        leadingTeam = getTopScoringTeam();

        if (!Objects.isNull(leadingPlayer))
            leadingPlayer.setLeaderStatus(true);
        if (!Objects.isNull(leadingTeam))
            leadingTeam.setLeaderStatus(true);
    }

    // Returns null if there's a tie
    public Player getTopScoringPlayer() {
        return getGreatestListItem(playerLeaderboard);
    }

    // Returns null if there's a tie
    public Team getTopScoringTeam() {
        return getGreatestListItem(teamLeaderboard);
    }

    public List<Team> getTeamLeaderboard() {
        return teamLeaderboard;
    }

    public List<Player> getPlayerLeaderboard() {
        return playerLeaderboard;
    }

    // Get highest value list item, but return null if a tie exists
    private <T extends Comparable<T>> T getGreatestListItem(List<T> list) {
        Iterator<T> iter = list.iterator();
        T result = iter.next();

        if (iter.hasNext() && result.compareTo(iter.next()) == 0)
            result = null;

        return result;
    }

    @Override
    public void addTeam(Team team) {
        teams.add(team);
    }

    @Override
    public void addPlayer(Player player, Team team) {
        if (!teams.contains(team))
            teams.add(team);

        players.put(player.getId(), player);
        team.addPlayer(player.getId(), player);
    }

    @Override
    public void playerHit(int attackerID, int victimID) {
        playerHit(getPlayerById(attackerID), getPlayerById(victimID));
    }

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

        for (Team tmp : teams) {
            tmp.addPlayerScores();
        }

        sortLeaderboards();
    }

    public void startCountdown() {
        timer.setTime(COUNTDOWN_SECONDS);
        timer.start();
    }

    @Override
    public void startMatch() {
        playerLeaderboard = new LinkedList<>(players.values());
        teamLeaderboard = new LinkedList<>(teams);
        gameInProgress = true;
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
        }
    }

}
