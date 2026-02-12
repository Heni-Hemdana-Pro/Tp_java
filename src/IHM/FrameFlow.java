
package IHM;

import javax.swing.*;
import java.awt.*;

public class FrameFlow extends JInternalFrame {
    JButton btn1, btn2, btn3, btn4, btn5;

    public FrameFlow() {
        this.setTitle("FrameBorder");
        this.setSize(900, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        this.setMaximizable(true);
        this.setIconifiable(true);
        this.setResizable(true);
        this.setClosable(true);

        this.btn1 = new JButton("Boutton1");
        this.btn2 = new JButton("Boutton2");
        this.btn3 = new JButton("Boutton3");
        this.btn4 = new JButton("Boutton4");
        this.btn5 = new JButton("Boutton5");


        this.add(btn1);
        this.add(btn2);
        this.add(btn3);
        this.add(btn4);
        this.add(btn5);
    }
}
