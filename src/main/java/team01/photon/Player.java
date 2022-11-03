package team01.photon;

public interface Player {
    public int id();

    public String codename();

    public int score();

    public void score(int newScore);

    public void addToScore(int newScore);
}
