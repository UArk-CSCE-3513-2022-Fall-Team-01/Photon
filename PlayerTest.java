public class PlayerTest implements IPlayer {
    private int id;
    private String codename;
    private int hitPoints;
    private int score;

    public PlayerTest() {
        this.id = 0;
        this.codename = "Joker";
        this.hitPoints = 10;
        this.score = 777;
    }

    public PlayerTest(int id, String codename, int hitPoints, int score) {
        this.id = id;
        this.codename = codename;
        this.hitPoints = hitPoints;
        this.score = score;
    }

    @Override
    public void addScore(int amount) {
        this.score += amount;
    }

    @Override
    public String codename() {
        return codename;
    }

    @Override
    public void codename(String newCodename) {
        this.codename = newCodename;
    }

    @Override
    public void deductScore(int amount) {
        this.score -= amount;
    }

    @Override
    public int hitPoints() {
        return this.hitPoints;
    }

    @Override
    public void hitPoints(int newHitPoints) {
        this.hitPoints = newHitPoints;
    }

    @Override
    public int id() {
        return this.id;
    }

    @Override
    public int score() {
        return this.score;
    }

    @Override
    public void score(int newScore) {
        this.score = newScore;
    }

    @Override
    public void takeDamage(int amount) {
        this.hitPoints -= amount;
    }
}
