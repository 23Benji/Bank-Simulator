import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("User1", "Passcode.1", 10000.00);
        User user2 = new User("User2", "User2.ps", 1000.00);
        User user3 = new User("User3", "Password.User3", 1000.00);
        User user4 = new User("User4", "usEr.ps.4", 1000.00);


        new MainLoginFrame(user1, user2,user3,user4);
    }
}