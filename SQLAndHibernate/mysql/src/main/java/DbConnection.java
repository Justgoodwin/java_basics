import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {

    private Connection connection;
    private Statement statement;
    private final String url;
    private final String user;
    private final String pass;

    public DbConnection(String url, String user, String pass) {
        this.url = url;
        this.user = user;
        this.pass = pass;
    }

    public boolean getConnection () {
        try {
            connection = DriverManager.getConnection(url, user, pass);

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Statement getStatement() {
        if (getConnection()) {
            try {
                return connection.createStatement();
            }catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

}
