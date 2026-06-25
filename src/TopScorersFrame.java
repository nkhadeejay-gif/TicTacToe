import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class TopScorersFrame extends JFrame {

    public TopScorersFrame(Player player) {

        setTitle("Top Scorers");
        setSize(500,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        PlayerService playerService = new PlayerService();

        List<Player> players = playerService.getTopPlayers();

        String[] columns = {
                "Username",
                "Wins",
                "Losses",
                "Draws",
                "Score"
        };

        DefaultTableModel model = new DefaultTableModel(columns, 0);

        for (Player p : players) {

            model.addRow(new Object[]{
                    p.getUsername(),
                    p.getWins(),
                    p.getLosses(),
                    p.getDraws(),
                    p.getScore()
            });

        }

        JTable table = new JTable(model);

        JButton backButton = new JButton("Back");

        backButton.addActionListener(e -> {

            dispose();
            new MainMenuFrame(player);

        });

        add(new JScrollPane(table), BorderLayout.CENTER);
        add(backButton, BorderLayout.SOUTH);

        setVisible(true);

    }

}