package team01.photon;
import java.util.HashMap;

public class Team{
    
    private int score;
    private String name;
    HashMap<Integer, Player> players = new HashMap<Integer, Player>();

    public Team(String name){
        this.name = name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setScore(int score){
        this.score = score;
    }
    public int getScore(){
        return score;
    }
    public void addScore(int score){
        this.score = this.score + score;
    }

}