package team01.photon;

import java.util.Collection;
import java.util.List;

public interface Model {
    public void addTeam(Team team);

    public void addPlayer(Player player, Team team);

    public Collection<Team> getTeams();

    public Collection<Player> getPlayers();

    public Player getPlayerById(int id);

    public GameTimer getTimer();

    public void playerHit(Player attacker, Player victim);

    public void playerHit(PlayerHitEvent e);

    public void startMatch();

    public boolean readyToStart();

    public Player getTopScoringPlayer();

    public Team getTopScoringTeam();

    public List<Player> getPlayerLeaderboard();

    public List<Team> getTeamLeaderboard();
}
