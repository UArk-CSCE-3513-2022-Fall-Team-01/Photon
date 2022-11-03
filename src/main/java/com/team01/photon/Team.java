package com.team01.photon;

import java.util.Collection;

public interface Team {
    public String name();

    public int score();

    public void score(int score);

    public void addToScore();

    public void addPlayer(Player player);

    public Collection<Player> players();
}
