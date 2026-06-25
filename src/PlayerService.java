import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerService {

    public Player login(String username, String password) {

        String sql =
                "SELECT * FROM players WHERE username=? AND password=?";

        try (
                Connection conn = DatabaseManager.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                return new Player(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getInt("wins"),
                        rs.getInt("losses"),
                        rs.getInt("draws"),
                        rs.getInt("score")
                );

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return null;

    }

    public void updateStatistics(Player player, String result) {

        if (result.equals("WIN")) {
            player.setWins(player.getWins() + 1);
            player.setScore(player.getScore() + 3);

        } else if (result.equals("LOSE")) {
            player.setLosses(player.getLosses() + 1);

        } else if (result.equals("DRAW")) {
            player.setDraws(player.getDraws() + 1);
            player.setScore(player.getScore() + 1);
        }

        String sql =
                "UPDATE players SET wins=?, losses=?, draws=?, score=? WHERE id=?";

        try (
                Connection conn = DatabaseManager.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setInt(1, player.getWins());
            stmt.setInt(2, player.getLosses());
            stmt.setInt(3, player.getDraws());
            stmt.setInt(4, player.getScore());
            stmt.setInt(5, player.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    public Player getPlayerById(int id) {

        String sql = "SELECT * FROM players WHERE id=?";

        try (
                Connection conn = DatabaseManager.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                return new Player(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getInt("wins"),
                        rs.getInt("losses"),
                        rs.getInt("draws"),
                        rs.getInt("score")
                );

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return null;

    }

    public List<Player> getTopPlayers() {

        List<Player> players = new ArrayList<>();

        String sql = "SELECT * FROM players ORDER BY score DESC, wins DESC LIMIT 5";

        try (
                Connection conn = DatabaseManager.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()
        ) {

            while (rs.next()) {

                players.add(new Player(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getInt("wins"),
                        rs.getInt("losses"),
                        rs.getInt("draws"),
                        rs.getInt("score")
                ));

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return players;

    }
}
