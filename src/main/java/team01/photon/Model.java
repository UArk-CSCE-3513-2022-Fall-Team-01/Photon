package team01.photon;

public interface Model {
    public void addTeam(Team team);

    public void addPlayer(Player player, Team team);

    public void playerHit(Player attacker, Player victim);

    public void startMatch();

    public boolean readyToStart();
}
