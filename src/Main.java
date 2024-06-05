import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("a", "a", 10000.00);
        User user2 = new User("Levi", "levi.ps", 1000.00);
        User user3 = new User("Mihaela", "mihaela.ps", 1000.00);
        User user4 = new User("admin", "admin.ps.1", 1000.00);


        new MainLoginFrame(user1, user2,user3,user4);
    }
}