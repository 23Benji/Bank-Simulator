import javax.swing.*;
import java.awt.*;

public class User {
    private String username;
    private String password;
    private double balance;

    public User(String username, String password, double balance) {
        this.username = username;
        this.password = password;
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    public boolean authenticate(String password) {
        return this.password.equals(password);
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
    public void openUserFrame() {
        JFrame userFrame = new JFrame("User Frame - " + username);
        userFrame.setSize(500, 500);
        userFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        userFrame.setLocationRelativeTo(null); // Center the frame on the screen

        // Add user-specific content to the frame
        JLabel welcomeLabel = new JLabel("Welcome, " + username + "!");
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        userFrame.add(welcomeLabel, BorderLayout.CENTER);

        userFrame.setVisible(true);
    }
}
