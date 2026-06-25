import javax.swing.*;
import java.awt.*;

public class StatisticsFrame extends JFrame {

    public StatisticsFrame(Player player) {

        PlayerService playerService = new PlayerService();
        Player latest = playerService.getPlayerById(player.getId());

        setTitle("My Statistics");
        setSize(300, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(new GridLayout(6, 1));

        add(new JLabel("Username : " + latest.getUsername()));
        add(new JLabel("Wins : " + latest.getWins()));
        add(new JLabel("Losses : " + latest.getLosses()));
        add(new JLabel("Draws : " + latest.getDraws()));
        add(new JLabel("Score : " + latest.getScore()));

        JButton backButton = new JButton("Back");

        backButton.addActionListener(e -> {

            dispose();
            new MainMenuFrame(player);

        });

        add(backButton);

        setVisible(true);

    }

}