package team01.photon;

public class BasicPlayer implements Player {
    private int id;
    private String codename;
    private int score;

    public BasicPlayer() {
        this.id = 0;
        this.codename = "Joker";
        this.score = 777;
    }

    public BasicPlayer(int id, String codename) {
        this.id = id;
        this.codename = codename;
        this.score = 0;
    }

    @Override
    public String codename() {
        return codename;
    }

    @Override
    public int id() {
        return id;
    }

    @Override
    public int score() {
        return score;
    }

    @Override
    public void score(int newScore) {
        score = newScore;
    }

    @Override
    public void addToScore(int amount) {
        score += amount;
    }
}
