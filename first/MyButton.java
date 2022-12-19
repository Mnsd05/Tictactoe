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
}