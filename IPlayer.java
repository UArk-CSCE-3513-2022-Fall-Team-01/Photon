public interface IPlayer {
    public int id();
    public String codename();
    public void codename(String newCodename);
    public int hitPoints();
    public void hitPoints(int newHitPoints);
    public void takeDamage(int amount);
    public int score();
    public void score(int newScore);
    public void addScore(int amount);
    public void deductScore(int amount);
}