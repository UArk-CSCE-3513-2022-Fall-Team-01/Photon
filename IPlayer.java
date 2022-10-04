public interface IPlayer {
    public int id();
    public String codename();
    public String codename(String newCodename);
    public int hitPoints();
    public int hitPoints(int newHitPoints);
    public int takeDamage(int amount);
    public int score();
    public int score(int newScore);
    public int addScore(int amount);
    public int deductScore(int amount);
}