import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class User2 extends JFrame implements ActionListener {

    JLabel label;
    JButton button;
    JTextField textField;
    JPasswordField passwordField;

    public User2() {
        label = new JLabel("Bank LogIn");
        label.setFont(new Font("MV Boli", Font.BOLD, 30));
        label.setHorizontalAlignment(SwingConstants.CENTER);

        textField = new JTextField(20);
        textField.setFont(new Font("Consolas", Font.PLAIN, 20));
        textField.setForeground(new Color(26, 55, 18));
        textField.setBackground(new Color(155, 220, 86));
        textField.setCaretColor(new Color(32, 55, 18));

        passwordField = new JPasswordField(20);
        passwordField.setFont(new Font("Consolas", Font.PLAIN, 20));
        passwordField.setForeground(new Color(37, 55, 18));
        passwordField.setBackground(new Color(155, 220, 86));
        passwordField.setCaretColor(new Color(35, 55, 18));

        button = new JButton("Login");
        button.addActionListener(this); // Add action listener to the button

        this.setTitle("Bank account [User2]");
        this.setSize(500, 500);
        this.setLocation(700, 200);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setBackground(new Color(132, 183, 85, 239));
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Add some padding

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(label, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(textField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(button, gbc);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = textField.getText();
        String password = new String(passwordField.getPassword());

        if (username.equals("User2") && password.equals("Password.2")) {
            this.getContentPane().setBackground(new Color(131, 220, 86));
            this.getContentPane().removeAll();
            JLabel welcomeLabel = new JLabel("Welcome, User2");
            welcomeLabel.setFont(new Font("MV Boli", Font.BOLD, 30));
            welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
            this.setLayout(new BorderLayout());
            this.add(welcomeLabel, BorderLayout.CENTER);
            this.revalidate();
            this.repaint();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid login credentials", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}