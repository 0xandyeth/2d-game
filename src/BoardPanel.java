import javax.swing.*;
import java.awt.*;

public class BoardPanel extends Panel {

    JPanel pnlButton = new JPanel();
    JButton btnAdd = new JButton("Connect Wallet");

    BoardPanel(){
        JFrame frame = new JFrame();
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        setBackground(Color.black);
        setDoubleBuffered(true);
        this.setFocusable(true);
        btnAdd.setBackground(Color.white);

    }

    public void startGame(){

    }
}
