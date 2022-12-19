import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.util.Random;
import javax.swing.ImageIcon;
import java.awt.event.*;
import java.awt.Image;
public class Tictactoe implements ActionListener {
  JLayeredPane layeredPane = new JLayeredPane();        // to contain overlapping components
  JPanel board = new JPanel();                          // to contain 9 cells
  Label finalLabel = new Label();
  MyButton[] buttonsList = new MyButton[9];
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
      layeredPane.add (board,new Integer(0));  

      MyButton.cantClick = true;                          // prevent clicking at the start of the game

      MyButton.cantClick = false;                         
       
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
                    finalLabel.setText("Player 1 wins");
                    layeredPane.add(finalLabel, new Integer(100));
                  }else if (MyButton.firstPlayer) {
                    finalLabel.setText("Player 2 wins");
                    layeredPane.add(finalLabel, new Integer(100));
                  }
            } if (MyButton.numClicked == 9 && !MyButton.cantClick) {
              finalLabel.setText("Draw");
              layeredPane.add(finalLabel, new Integer(100));
            }
        }
    }
    }
}


