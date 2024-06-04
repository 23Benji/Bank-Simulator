import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class User1Info extends JPanel implements ActionListener {

    private JLabel moneyLabel;
    private JButton sendMoneyButton;
    private JComboBox<String> recipientComboBox;
    private JTextField amountField;
    private JButton confirmButton;
    private User currentUser;
    private User user1;
    private User user2;

    public User1Info(User currentUser, User user1, User user2) {
        this.currentUser = currentUser;
        this.user1 = user1;
        this.user2 = user2;

        this.setBackground(new Color(240, 240, 240)); // Soft background color

        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        moneyLabel = new JLabel("Current Balance: $" + currentUser.getBalance());
        moneyLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Change font to Arial, bold, size 24
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(moneyLabel, gbc);

        sendMoneyButton = new JButton("Send Money");
        sendMoneyButton.addActionListener(this);
        sendMoneyButton.setFocusable(false);
        sendMoneyButton.setBackground(new Color(255, 165, 0)); // Orange color
        sendMoneyButton.setForeground(Color.WHITE); // White text color
        sendMoneyButton.setFont(new Font("Arial", Font.BOLD, 16)); // Change font to Arial, bold, size 16
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(sendMoneyButton, gbc);

        String[] recipients = {user1.getUsername(), user2.getUsername()};
        recipientComboBox = new JComboBox<>(recipients);
        amountField = new JTextField(10);
        confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(this);
        confirmButton.setBackground(new Color(0, 128, 0)); // Green color
        confirmButton.setForeground(Color.WHITE); // White text color
        confirmButton.setFont(new Font("Arial", Font.BOLD, 16)); // Change font to Arial, bold, size 16

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        this.add(new JLabel("To: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        this.add(recipientComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        this.add(new JLabel("Amount: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        this.add(amountField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        this.add(confirmButton, gbc);

        // Initially hide recipient and amount fields
        recipientComboBox.setVisible(false);
        amountField.setVisible(false);
        confirmButton.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sendMoneyButton) {
            // Remove current user's name from recipient list
            String[] recipients = {user1.getUsername(), user2.getUsername()};
            if (currentUser.getUsername().equals(user1.getUsername())) {
                recipientComboBox.setModel(new DefaultComboBoxModel<>(new String[]{user2.getUsername()}));
            } else {
                recipientComboBox.setModel(new DefaultComboBoxModel<>(new String[]{user1.getUsername()}));
            }

            recipientComboBox.setVisible(true);
            amountField.setVisible(true);
            confirmButton.setVisible(true);
        } else if (e.getSource() == confirmButton) {
            String recipientUsername = (String) recipientComboBox.getSelectedItem();
            String amountText = amountField.getText();

            try {
                double amount = Double.parseDouble(amountText);

                if (amount <= 0) {
                    JOptionPane.showMessageDialog(this, "Amount must be positive", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (amount > currentUser.getBalance()) {
                    JOptionPane.showMessageDialog(this, "Insufficient funds", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    User recipient = recipientUsername.equals(user1.getUsername()) ? user1 : user2;
                    currentUser.withdraw(amount);
                    recipient.deposit(amount);
                    moneyLabel.setText("Current Balance: $" + currentUser.getBalance());
                    JOptionPane.showMessageDialog(this, "Sent $" + amount + " to " + recipientUsername, "Transaction Complete", JOptionPane.INFORMATION_MESSAGE);

                    // Reset fields
                    recipientComboBox.setVisible(false);
                    amountField.setVisible(false);
                    confirmButton.setVisible(false);
                    amountField.setText("");

                    // Update balance in other windows (if open)
                    Window[] windows = Window.getWindows();
                    for (Window window : windows) {
                        if (window instanceof JFrame) {
                            JFrame frame = (JFrame) window;
                            Container contentPane = frame.getContentPane();
                            if (contentPane.getComponentCount() > 0 && contentPane.getComponent(0) instanceof User1Info) {
                                User1Info userInfoPanel = (User1Info) contentPane.getComponent(0);
                                userInfoPanel.updateBalanceLabels();
                            }
                        }
                    }
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid amount", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void updateBalanceLabels() {
        moneyLabel.setText("Current Balance: $" + currentUser.getBalance());
    }
}
