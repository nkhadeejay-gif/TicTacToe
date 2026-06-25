import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    private Player currentPlayer;
    private PlayerService playerService;
    private GameLogic gameLogic;

    private JButton[] buttons;
    private JLabel statusLabel;
    private JButton backButton;

    public GameFrame(Player player) {

        currentPlayer = player;
        playerService = new PlayerService();
        gameLogic = new GameLogic();

        setTitle("Tic Tac Toe");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initializeGUI();

        setVisible(true);
    }

    private void initializeGUI() {

        setLayout(new BorderLayout());

        statusLabel = new JLabel("Your Turn (X)", SwingConstants.CENTER);
        add(statusLabel, BorderLayout.NORTH);

        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(3, 3));

        buttons = new JButton[9];

        for (int i = 0; i < 9; i++) {

            buttons[i] = new JButton("");

            buttons[i].setFont(new Font("Arial", Font.BOLD, 40));

            final int index = i;

            buttons[i].addActionListener(e -> handlePlayerMove(index));

            boardPanel.add(buttons[i]);

        }

        add(boardPanel, BorderLayout.CENTER);

        backButton = new JButton("Back to Menu");

        backButton.addActionListener(e -> {

            dispose();
            new MainMenuFrame(currentPlayer);

        });

        add(backButton, BorderLayout.SOUTH);

    }

    private void handlePlayerMove(int index) {

        if (!gameLogic.makeMove(index, 'X')) {
            return;
        }

        buttons[index].setText("X");

        if (gameLogic.checkWinner('X')) {
            finishGame("WIN");
            return;
        }

        if (gameLogic.isDraw()) {
            finishGame("DRAW");
            return;
        }

        int computerMove = gameLogic.computerMove();

        if (computerMove != -1) {
            buttons[computerMove].setText("O");
        }

        if (gameLogic.checkWinner('O')) {
            finishGame("LOSE");
            return;
        }

        if (gameLogic.isDraw()) {
            finishGame("DRAW");
        }

    }

    private void finishGame(String result) {

        playerService.updateStatistics(currentPlayer, result);

        JOptionPane.showMessageDialog(this, result);

        dispose();

        new MainMenuFrame(currentPlayer);

    }

}