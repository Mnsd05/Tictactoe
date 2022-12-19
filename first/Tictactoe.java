import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.util.Random;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import java.awt.event.*;
import java.awt.Image;
public class Tictactoe implements ActionListener {
  JFrame frame1 = new JFrame(); 
  JLayeredPane layeredPane = new JLayeredPane(); 
  JPanel board = new JPanel(); 
  Label finalLabel = new Label();
  MyButton[] buttonsList = new MyButton[9];
    Tictactoe ()  {            
      frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(new Dimension(500, 500));
        frame1.setResizable(false);
        frame1.setVisible(true);
          // to contain overlapping components
          //                   to contain 9 cells
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
      
      frame1.add(layeredPane);
      frame1.setVisible(true);

      MyButton.cantClick = true;                          // prevent clicking at the start of the game

      Label first_label = new Label();                    // set label displaying the player to start first
      if (MyButton.firstPlayer) first_label.setText("Player 1 moves first");
      else first_label.setText("Player 2 moves first");
      layeredPane.add(first_label, new Integer(200));
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      first_label.setVisible(false);

      MyButton.cantClick = false;                         
       
  }
  @Override
	public void actionPerformed(ActionEvent e) {
    for (int i = 0; i < 9; ++i) {
      	if(e.getSource()==buttonsList[i] && !buttonsList[i].ticked && !buttonsList[i].cantClick) {
          buttonsList[i].numClicked += 1;
            // int cell = (this.getBounds().x/163) + ((this.getBounds().y -1) / 156) * 3;
            if (buttonsList[i].firstPlayer) {
                ImageIcon tick = new ImageIcon(new ImageIcon("tick.png").getImage().
                getScaledInstance(50, 50, Image.SCALE_DEFAULT));
                buttonsList[i].setIcon(tick);
                buttonsList[i].checkBoard.check.set(i,1);
            } else {
                ImageIcon cross = new ImageIcon(new ImageIcon("cross.png").getImage().
                getScaledInstance(50, 50, Image.SCALE_DEFAULT));
                buttonsList[i].setIcon(cross);
                buttonsList[i].checkBoard.check.set(i,2);
            }
            buttonsList[i].firstPlayer ^= true;
            buttonsList[i].ticked = true;
            if (buttonsList[i].checkBoard.checkWin()) {
              buttonsList[i].cantClick = true;
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


// while (true) {
//   System.out.println("");                         // without this line cannot execute if statement
//   if (MyButton.cantClick && !MyButton.firstPlayer) {
//     finalLabel.setText("Player 1 wins");
//     layeredPane.add(finalLabel, new Integer(100));
//     break;
//   }else if (MyButton.cantClick && MyButton.firstPlayer) {
//     finalLabel.setText("Player 2 wins");
//     layeredPane.add(finalLabel, new Integer(100));
//     break;
//   }else if (MyButton.numClicked == 9 && !MyButton.cantClick) {
//     finalLabel.setText("Draw");
//     layeredPane.add(finalLabel, new Integer(100));
//     break;
//   }
// }