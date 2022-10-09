package com.team01.photon;
import java.net.URI;
import java.sql.*;

public class HerokuPostgreDatabase implements IPlayerDatabase {
    private URI dbUri;
    private Connection connection;
    private static final String TABLE_NAME = "PLAYER";

    public HerokuPostgreDatabase(URI dbUri) throws SQLException {
        this.dbUri = dbUri;
        this.connection = getConnection(this.dbUri);
    }

    private String formatDbUrl(URI dbUri) {
        return "jdbc:postgresql://" + dbUri.getHost() + ':'
            + dbUri.getPort() + dbUri.getPath() + "?sslmode=require";
    }

    private Connection getConnection(URI dbUri) throws SQLException {
        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = formatDbUrl(dbUri);
        
        return DriverManager.getConnection(dbUrl, username, password);
    }

    @Override
    public String getCodename(int id) {
        String result = "";

        try (Statement statement = this.connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + TABLE_NAME
                + " WHERE ID = " + id + ";");

            if (resultSet.next()) {
                result = resultSet.getString("Codename");
            }

            resultSet.close();
        } catch (SQLException e) {
            System.err.println("Invalid SQL statement.");
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public boolean addPlayerRecord(int id, String codename) {
        boolean result = false;
        String sql = "INSERT INTO " + TABLE_NAME + " (ID, CODENAME)"
            + " VALUES (" + id + ", '" + codename + "')";

        if (getCodename(id).isBlank()) {
            try (Statement statement = this.connection.createStatement()) {
                statement.executeUpdate(sql);

                // Since we should've just created the record, lookup again to confirm
                if (!getCodename(id).isBlank()) {
                    result = true;
                }
            } catch (SQLException e) {
                System.err.println("Invalid SQL statement.");
                e.printStackTrace();
            }
        }

        return result;
    }
}
