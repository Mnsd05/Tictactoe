import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.util.Random;
import javax.swing.ImageIcon;
import java.awt.event.*;
import java.awt.Image;
public class Tictactoe extends JLayeredPane implements ActionListener {
  JPanel board = new JPanel();                          // to contain 9 cells
  Label finalLabel = new Label();
  Label first_label = new Label();                    // set label displaying the player to start first
  MyButton[] buttonsList = new MyButton[9];
  static ResetButton resetButton = new ResetButton();
    Tictactoe ()  {            
    
      board.setBounds(0,0,480,460);
      board.setLayout(new GridLayout(3,3,10,10));
      
      Random rd = new Random();                          // random to pick the player to start first
      boolean tickFirst = rd.nextBoolean();
      for (int i = 0; i < 9; ++i) {
          buttonsList[i] = new MyButton();              // initialize a cell
          buttonsList[i].addActionListener(this);
          board.add(buttonsList[i]);
          if (!tickFirst) MyButton.firstPlayer = false;
      }
      this.add (board,new Integer(0));  
      
      MyButton.cantClick = true;                          // prevent clicking at the start of the game

      if (MyButton.firstPlayer) first_label.setText("Player 1 moves first");
      else first_label.setText("Player 2 moves first");
      this.add(first_label, new Integer(200));                        

  }
  @Override
	public void actionPerformed(ActionEvent e) {
      for (int i = 0; i < 9; ++i) {
      	  if(e.getSource()==buttonsList[i] && !buttonsList[i].ticked && !MyButton.cantClick) {
                MyButton.numClicked += 1;
            if (MyButton.firstPlayer) {
                ImageIcon tick = new ImageIcon(new ImageIcon("Tictactoe/first/tick.png").getImage().
                getScaledInstance(50, 50, Image.SCALE_DEFAULT));
                buttonsList[i].setIcon(tick);
                MyButton.checkBoard.check.set(i,1);
            } else {
                ImageIcon cross = new ImageIcon(new ImageIcon("Tictactoe/first/cross.png").getImage().
                getScaledInstance(50, 50, Image.SCALE_DEFAULT));
                buttonsList[i].setIcon(cross);
                MyButton.checkBoard.check.set(i,2);
            }
            MyButton.firstPlayer ^= true;
            buttonsList[i].ticked = true;
            if (MyButton.checkBoard.checkWin()) {
              MyButton.cantClick = true;
              if (!MyButton.firstPlayer) {
                    resetButton.setText("<html>Player 1 wins<br />Click to reset</html>");
                    this.add(resetButton,new Integer(100));
                  }else if (MyButton.firstPlayer) {
                    resetButton.setText("<html>Player 2 wins<br />Click to reset</html>");
                    this.add(resetButton,new Integer(100));
                  }
            } if (MyButton.numClicked == 9 && !MyButton.cantClick) {
                resetButton.setText("<html>Draw<br />Click to reset</html>");
                this.add(resetButton,new Integer(100));
            }
        }
    }
    }
}
