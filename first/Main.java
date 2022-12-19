import javax.swing.JFrame;
import java.awt.Dimension;

public class Main {
    public static void main(String[] args) {
        JFrame frame1 = new JFrame(); 
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(new Dimension(500, 500));
        frame1.setResizable(false);
        frame1.setVisible(true);
        Tictactoe game = new Tictactoe();
        frame1.add(game.layeredPane);
        frame1.setVisible(true);
        Label first_label = new Label();                    // set label displaying the player to start first
        if (MyButton.firstPlayer) first_label.setText("Player 1 moves first");
        else first_label.setText("Player 2 moves first");
        game.layeredPane.add(first_label, new Integer(200));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        first_label.setVisible(false);
     }
}
