import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainLoginFrame extends JFrame implements ActionListener, KeyListener {

    JLabel label;
    JButton button;
    JTextField textField;
    JPasswordField passwordField;
    private User user1;
    private User user2;
    private User user3;
    private User user4;

    public MainLoginFrame(User user1, User user2, User user3, User user4) {
        this.user1 = user1;
        this.user2 = user2;
        this.user3 = user3;
        this.user4 = user4;

        label = new JLabel("Bank LogIn");
        label.setFont(new Font("MV Boli", Font.BOLD, 30));
        label.setHorizontalAlignment(SwingConstants.CENTER);

        textField = new JTextField(20);
        textField.setFont(new Font("Consolas", Font.PLAIN, 20));
        textField.setForeground(new Color(55, 18, 18));
        textField.setBackground(new Color(220, 86, 86));
        textField.setCaretColor(new Color(55, 18, 18));

        passwordField = new JPasswordField(20);
        passwordField.setFont(new Font("Consolas", Font.PLAIN, 20));
        passwordField.setForeground(new Color(55, 18, 18));
        passwordField.setBackground(new Color(220, 86, 86));
        passwordField.setCaretColor(new Color(255, 255, 255));

        button = new JButton("Login");
        button.setBackground(new Color(101, 45, 45));
        button.setForeground(Color.WHITE);
        button.setFocusable(false);
        button.addActionListener(this);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        textField.addKeyListener(this);
        passwordField.addKeyListener(this);

        this.setTitle("Bank account [Login]");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null); // Center the frame on screen
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(183, 85, 85, 239));
        this.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

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

        if (user1.getUsername().equals(username) && user1.authenticate(password)) {
            openUserInfoWindow(user1);
        } else if (user2.getUsername().equals(username) && user2.authenticate(password)) {
            openUserInfoWindow(user2);
        } else if (user3.getUsername().equals(username) && user3.authenticate(password)) {
            openUserInfoWindow(user3);
        } else if (user4.getUsername().equals(username) && user4.authenticate(password)) {
            openUserInfoWindow(user4);
        } else {
            JOptionPane.showMessageDialog(this, "Invalid login credentials", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void openUserInfoWindow(User user) {
        JFrame userFrame = new JFrame("User Info: " + user.getUsername());
        userFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        userFrame.setSize(500, 500);
        userFrame.getContentPane().add(new UserInfoWindow(user, user1, user2, user3, user4));
        userFrame.setVisible(true);
        if (user==user1){
            userFrame.setLocation(10,10);
        } else if (user==user2) {
            userFrame.setLocation(850,10);
        } else if (user==user3) {
            userFrame.setLocation(850,350);
        }else {
            userFrame.setLocation(10,550);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            button.doClick();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
