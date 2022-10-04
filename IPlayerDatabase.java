public interface IPlayerDatabase {
    public String getCodename(int id);
    public boolean addPlayerRecord(int id, String codename);
}
