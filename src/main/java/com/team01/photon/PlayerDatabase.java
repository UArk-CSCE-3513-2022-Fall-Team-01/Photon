package com.team01.photon;
public interface PlayerDatabase {
    // Returns the codename is one exists, and an empty string if not
    public String getCodename(int id);

    // Returns true if the record was succesfully added, and false if it wasn't or already exists
    public boolean addPlayerRecord(int id, String codename);
}
