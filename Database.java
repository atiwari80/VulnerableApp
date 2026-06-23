// Database.java modified to prevent SQL injection by using a PreparedStatement.
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database {
    // ...
    public void query(String userInput) {
        String query = "SELECT * FROM table WHERE column = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, userInput);
            stmt.executeQuery();
        } catch (SQLException e) {
            // Handle the exception.
        }
    }
    // ...
}