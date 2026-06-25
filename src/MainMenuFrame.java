import javax.swing.*;
import java.awt.*;

public class MainMenuFrame extends JFrame {

    private Player player;

    public MainMenuFrame(Player player) {

        this.player = player;

        setTitle("Tic Tac Toe");
        setSize(400,350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        initialize();

        setVisible(true);
    }

    private void initialize() {

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6,1,10,10));
        panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        JLabel welcome =
                new JLabel("Welcome, " + player.getUsername(),
                        SwingConstants.CENTER);

        JButton playButton =
                new JButton("Start Game");

        JButton statisticsButton =
                new JButton("Statistics");

        JButton topButton =
                new JButton("Top Scorers");

        JButton logoutButton =
                new JButton("Logout");

        panel.add(welcome);
        panel.add(playButton);
        panel.add(statisticsButton);
        panel.add(topButton);
        panel.add(logoutButton);

        add(panel);

        playButton.addActionListener(e -> {
            dispose();
            new GameFrame(player);
        });

        statisticsButton.addActionListener(e -> {
            dispose();
            new StatisticsFrame(player);
        });

        topButton.addActionListener(e -> {
            dispose();
            new TopScorersFrame(player);
        });

        logoutButton.addActionListener(e -> {
            dispose();
            new LoginFrame();
        });

    }

}