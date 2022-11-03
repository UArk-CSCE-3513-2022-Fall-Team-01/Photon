package team01.photon;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;

public class HerokuPostgreDatabase implements PlayerDatabase {
    private URI dbUri;
    private Connection connection;
    private static final String DB_TABLE_NAME = "players";
    private static final String DBURL_ENVVAR_NAME = "DATABASE_URL";

    // Pick up system's env var for the URL
    public HerokuPostgreDatabase() throws SQLException, URISyntaxException {
        this.dbUri = new URI(System.getenv(DBURL_ENVVAR_NAME));
        initConnection();
    }

    // Pass in a String of the Heroku app's DATABASE_URL
    public HerokuPostgreDatabase(String databaseUrl) throws SQLException, URISyntaxException {
        this.dbUri = new URI(databaseUrl);
        initConnection();
    }

    @Override
    public String getCodename(int id) {
        String result = "";

        try (Statement statement = this.connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + DB_TABLE_NAME
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
        String sql = "INSERT INTO " + DB_TABLE_NAME + " (ID, CODENAME)"
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

    private void initConnection() throws SQLException {
        this.connection = getConnection(this.dbUri);
    }

    // Using Heroku's DATABASE_URL with PostgreSQL JDBC requires some formatting of
    // the string
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
}
