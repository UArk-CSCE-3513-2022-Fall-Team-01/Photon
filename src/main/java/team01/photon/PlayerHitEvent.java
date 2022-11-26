package team01.photon;

public class PlayerHitEvent {
    private Player attacker;
    private Player victim;

    public PlayerHitEvent(Player attacker, Player victim) {
        this.attacker = attacker;
        this.victim = victim;
    }

    public Player getAttacker() {
        return attacker;
    }

    public Player getVictim() {
        return victim;
    }
}
