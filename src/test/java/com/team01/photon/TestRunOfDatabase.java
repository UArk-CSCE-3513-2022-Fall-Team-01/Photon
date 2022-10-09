package com.team01.photon;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;

public class TestRunOfDatabase {
    public static void main(String[] args) throws URISyntaxException, SQLException{
        // Maybe read this in from an envvar, this is pretty silly long
        String databaseUrl = "postgres://khyacvkqcqzula:7729064e3f06b199386c32316fe70331aecc1226c07e239be190b6e7278d102b@ec2-3-229-165-146.compute-1.amazonaws.com:5432/dcamjfk8aqn4h8";
        IPlayerDatabase database = new HerokuPostgreDatabase(new URI(databaseUrl));

        System.out.println("Trying to get codename for id 1 from database...");
        System.out.println(database.getCodename(1));

        System.out.println("Trying to add record of id=0 codename='Major Tom'");
        boolean addTestResult =  database.addPlayerRecord(0, "Major Tom");
        System.out.println("Test result: " + addTestResult);

        System.out.println("Trying to get codename for id 0 from database...");
        System.out.println(database.getCodename(0));
    }
}
