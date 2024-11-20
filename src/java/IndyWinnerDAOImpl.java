/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Het
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IndyWinnerDAOImpl implements IndyWinnerDAO {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/indywinners";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Het@2004";

    @Override
    public List<IndyWinner> getWinners(int limit, int offset) throws SQLException {
        if (limit <= 0) throw new IllegalArgumentException("Limit must be greater than 0");
        if (offset < 0) throw new IllegalArgumentException("Offset cannot be negative");

        List<IndyWinner> winners = new ArrayList<>();
        String query = "SELECT year, winnerName, carName FROM IndyWinners ORDER BY year DESC LIMIT ? OFFSET ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, limit);
            stmt.setInt(2, offset);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    winners.add(new IndyWinner(
                            rs.getInt("year"),
                            rs.getString("winnerName"),
                            rs.getString("carName")
                    ));
                }
            }
        }
        return winners;
    }

    @Override
    public int getWinnerCount() throws SQLException {
        String query = "SELECT COUNT(*) FROM IndyWinners";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return 0;
    }
}
