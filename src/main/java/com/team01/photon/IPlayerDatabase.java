package com.team01.photon;
public interface IPlayerDatabase {
    public String getCodename(int id);
    public boolean addPlayerRecord(int id, String codename);
}
