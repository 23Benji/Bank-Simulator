import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("admin1", "Password.1", 1000.00);
        User user2 = new User("admin2", "Password.2", 1000.00);

        new MainLoginFrame(user1, user2);
    }
}