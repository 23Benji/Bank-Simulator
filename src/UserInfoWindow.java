import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInfoWindow extends JPanel implements ActionListener {

    private JLabel moneyLabel;
    private JLabel userLabel;
    private JButton sendMoneyButton;
    private JComboBox<String> recipientComboBox;
    private JTextField amountField;
    private JButton confirmButton;
    private User currentUser;
    private User user1;
    private User user2;
    private User user3;
    private User user4;

    public UserInfoWindow(User currentUser, User user1, User user2, User user3, User user4) {
        this.currentUser = currentUser;
        this.user1 = user1;
        this.user2 = user2;
        this.user3 = user3;
        this.user4 = user4;

        userLabel = new JLabel(currentUser.getUsername());
        userLabel.setFont(new Font("MV Boli", Font.BOLD, 30));
        userLabel.setHorizontalAlignment(SwingConstants.CENTER);

        this.setBackground(new Color(144, 196, 144));
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(userLabel, gbc);

        moneyLabel = new JLabel("Current Balance: $" + currentUser.getBalance());
        moneyLabel.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(moneyLabel, gbc);

        sendMoneyButton = new JButton("Send Money");
        sendMoneyButton.addActionListener(this);
        sendMoneyButton.setFocusable(false);
        sendMoneyButton.setBackground(new Color(255, 165, 0));
        sendMoneyButton.setForeground(Color.WHITE);
        sendMoneyButton.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(sendMoneyButton, gbc);

        String[] recipients = {user1.getUsername(), user2.getUsername(), user3.getUsername(), user4.getUsername()};
        recipientComboBox = new JComboBox<>(recipients);
        amountField = new JTextField(10);
        confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(this);
        confirmButton.setBackground(new Color(0, 128, 0));
        confirmButton.setForeground(Color.WHITE);
        confirmButton.setFont(new Font("Arial", Font.BOLD, 16));

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        this.add(new JLabel("To: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        this.add(recipientComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        this.add(new JLabel("Amount: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        this.add(amountField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
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
            String[] recipients = {user1.getUsername(), user2.getUsername(), user3.getUsername(), user4.getUsername()};
            if (currentUser.getUsername().equals(user1.getUsername())) {
                recipientComboBox.setModel(new DefaultComboBoxModel<>(new String[]{user2.getUsername(), user3.getUsername(), user4.getUsername()}));
            } else if (currentUser.getUsername().equals(user2.getUsername())) {
                recipientComboBox.setModel(new DefaultComboBoxModel<>(new String[]{user1.getUsername(), user3.getUsername(), user4.getUsername()}));
            } else if (currentUser.getUsername().equals(user3.getUsername())) {
                recipientComboBox.setModel(new DefaultComboBoxModel<>(new String[]{user1.getUsername(), user2.getUsername(), user4.getUsername()}));
            } else {
                recipientComboBox.setModel(new DefaultComboBoxModel<>(new String[]{user1.getUsername(), user2.getUsername(), user3.getUsername()}));
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
                    User recipient;
                    if (recipientUsername.equals(user1.getUsername())) {
                        recipient = user1;
                    } else if (recipientUsername.equals(user2.getUsername())) {
                        recipient = user2;
                    } else if (recipientUsername.equals(user3.getUsername())) {
                        recipient = user3;
                    } else {
                        recipient = user4;
                    }
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
                            if (contentPane.getComponentCount() > 0 && contentPane.getComponent(0) instanceof UserInfoWindow) {
                                UserInfoWindow userInfoPanel = (UserInfoWindow) contentPane.getComponent(0);
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
