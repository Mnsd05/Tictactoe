import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
public class ResetButton extends JButton {
    ResetButton () {
        this.setFocusable(false);
		this.setBorder(BorderFactory.createEtchedBorder());
        this.setBounds(140,200,200,100);
        this.setFont(new Font("Comic Sans", Font.BOLD, 20));
        this.setBackground(Color.red);
        this.setForeground(Color.white);
    }
}
