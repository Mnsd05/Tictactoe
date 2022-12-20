import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import java.awt.Dimension;
import java.awt.event.*;
public class GameFrame extends JFrame implements ActionListener {
    Tictactoe game = new Tictactoe();
    GameFrame () {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(500, 500));
        this.setResizable(false);
        this.setVisible(true);
        this.add(game);
        Tictactoe.resetButton.addActionListener(this);
        try {
            Thread.sleep(2000);
          } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
        MyButton.cantClick = false;
        game.first_label.setVisible(false);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
      if (e.getSource() == Tictactoe.resetButton) {
        this.remove(game);
        Tictactoe game = new Tictactoe();
        this.add(game);
        SwingUtilities.updateComponentTreeUI(this);
        try {
          Thread.sleep(2000);
        } catch (InterruptedException a) {
          // TODO Auto-generated catch block
          a.printStackTrace();
        }
        game.first_label.setVisible(false);

        MyButton.cantClick = false;

        for (int i = 0; i < 9; ++i) {
          MyButton.checkBoard.check.set(i, 0);
        }
        MyButton.numClicked = 0;
      }
      
    }
}
