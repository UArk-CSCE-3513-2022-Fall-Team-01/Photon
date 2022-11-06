package team01.photon;

import java.util.HashMap;

public class PlayerDatabaseStub implements PlayerDatabase {
    private HashMap<Integer, String> database;

    public PlayerDatabaseStub() {
        database = new HashMap<>(30);
        database.put(1, "Opus");
        database.put(2, "Adam");
        database.put(3, "Ben");
        database.put(4, "Leo");
        database.put(5, "Colin");
    }

    @Override
    public String getCodenameById(int id) {
        return database.get(id);
    }

    @Override
    public boolean addPlayerRecord(int id, String codename) {
        boolean result;
        if (database.containsKey(id)) {
            result = false;
        } else {
            database.put(id, codename);
            result = true;
        }

        return result;
    }

}
