import javax.swing.BorderFactory;
import javax.swing.JButton;
public class MyButton extends JButton {
    static boolean firstPlayer = true;                  // player 1 uses tick
    static CheckBoard checkBoard = new CheckBoard();
    static boolean cantClick = false;                   // the ability to click any cells
    static int numClicked = 0;
    boolean ticked = false;                              // is a cell ticked?
    MyButton () {
		this.setFocusable(false);
		this.setBorder(BorderFactory.createEtchedBorder());
    }
    // @Override
	// public void actionPerformed(ActionEvent e) {
	// 	if(e.getSource()==this && !ticked && !cantClick) {
    //         numClicked += 1;
    //         int cell = (this.getBounds().x/163) + ((this.getBounds().y -1) / 156) * 3;
    //         if (firstPlayer) {
    //             ImageIcon tick = new ImageIcon(new ImageIcon("tick.png").getImage().
    //             getScaledInstance(50, 50, Image.SCALE_DEFAULT));
    //             this.setIcon(tick);
    //             checkBoard.check.set(cell,1);
    //         } else {
    //             ImageIcon cross = new ImageIcon(new ImageIcon("cross.png").getImage().
    //             getScaledInstance(50, 50, Image.SCALE_DEFAULT));
    //             this.setIcon(cross);
    //             checkBoard.check.set(cell,2);
    //         }
    //         if (checkBoard.checkWin()) {cantClick = true;}
    //         firstPlayer ^= true;
    //         ticked = true;
    //     }
    // }
}