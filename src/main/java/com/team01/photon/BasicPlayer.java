package com.team01.photon;

public class BasicPlayer implements Player {
    private int id;
    private String codename;
    private boolean isAlive;
    private int score;

    public BasicPlayer() {
        this.id = 0;
        this.codename = "Joker";
        this.isAlive = true;
        this.score = 777;
    }

    public BasicPlayer(int id, String codename, boolean isAlive, int score) {
        this.id = id;
        this.codename = codename;
        this.isAlive = isAlive;
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
    public void hit() {
        this.isAlive = false;
    }

    @Override
    public boolean isAlive() {
        return this.isAlive;
    }
}
