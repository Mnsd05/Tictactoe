import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
public class Label extends JLabel {
    Label() {
      this.setFont(new Font("MV Boli",Font.PLAIN,20));
      this.setHorizontalAlignment(JLabel.CENTER);
      this.setVerticalAlignment(JLabel.CENTER);
      this.setBounds(140,200,200,40);
      this.setBackground(Color.GRAY);
      this.setOpaque(true);
    }
}


