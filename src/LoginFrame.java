import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    private PlayerService playerService;

    public LoginFrame() {

        playerService = new PlayerService();

        setTitle("Tic Tac Toe Login");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        initializeComponents();

        setVisible(true);
    }

    private void initializeComponents() {

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));

        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");

        usernameField = new JTextField();
        passwordField = new JPasswordField();

        loginButton = new JButton("Login");

        panel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));

        panel.add(usernameLabel);
        panel.add(usernameField);

        panel.add(passwordLabel);
        panel.add(passwordField);

        panel.add(new JLabel());
        panel.add(loginButton);

        add(panel);

        loginButton.addActionListener(e -> login());

    }

    private void login() {

        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        Player player = playerService.login(username, password);

        if (player != null) {

            JOptionPane.showMessageDialog(
                    this,
                    "Welcome " + player.getUsername() + "!"
            );

            dispose();

            new MainMenuFrame(player);

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid username or password.",
                    "Login Failed",
                    JOptionPane.ERROR_MESSAGE
            );

        }

    }

}