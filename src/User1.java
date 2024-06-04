import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class User1 extends JFrame implements ActionListener, KeyListener {

    JLabel label;
    JButton button;
    JTextField textField;
    private JPasswordField passwordField;
    JLabel usernameLabel;
    JLabel passwordLabel;

    public User1() {

        label = new JLabel("Bank LogIn");
        label.setFont(new Font("MV Oval", Font.BOLD, 30));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.TOP);

        usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 12));

        passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 12));

        textField = new JTextField(20);
        textField.setPreferredSize(new Dimension(200, 30));
        textField.setFont(new Font("MV Oval", Font.BOLD, 20));
        textField.setForeground(new Color(55, 18, 18));
        textField.setBackground(new Color(220, 86, 86));
        textField.setCaretColor(new Color(55, 18, 18));

        passwordField = new JPasswordField(20);
        passwordField.setPreferredSize(new Dimension(200, 30));
        passwordField.setFont(new Font("Consolas", Font.PLAIN, 20));
        passwordField.setForeground(new Color(55, 18, 18));
        passwordField.setBackground(new Color(220, 86, 86));
        passwordField.setCaretColor(new Color(55, 18, 18));

        button = new JButton("Login");

        this.setTitle("Bank account [User1]");
        this.setSize(500, 500);
        this.setLocation(100, 200);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setBackground(new Color(183, 85, 85, 239));
        this.setLayout(new BorderLayout());

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 10, 10, 10);
        loginPanel.add(label, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        loginPanel.add(usernameLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        loginPanel.add(textField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        loginPanel.add(passwordLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        loginPanel.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.CENTER;
        loginPanel.add(button, gbc);

        this.add(loginPanel, BorderLayout.CENTER);
        this.setVisible(true);

        button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Implement login action
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
