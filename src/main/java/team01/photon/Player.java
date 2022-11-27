package team01.photon;

public interface Player extends ChangeNotifier, Comparable<Player> {
    public int getId();

    public String getCodename();

    public int getScore();

    public void setScore(int newScore);

    public void addToScore(int newScore);
}
