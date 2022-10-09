package com.team01.photon;
public interface IPlayer {
    public int id();
    public String codename();
    public void codename(String newCodename);
    public boolean isAlive();
    public void hit();
    public int score();
    public void score(int newScore);
    public void addScore(int amount);
    public void deductScore(int amount);
}