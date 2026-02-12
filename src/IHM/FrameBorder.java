package IHM;

import javax.swing.*;
import java.awt.*;

public class FrameBorder extends JInternalFrame {
    JButton btn1, btn2, btn3, btn4, btn5,  btn6;
    JPanel panel;

    public FrameBorder() {
        this.setTitle("FrameFlow");
        this.setSize(900, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout( new BorderLayout());

        this.setMaximizable(true);
        this.setIconifiable(true);
        this.setResizable(true);
        this.setClosable(true);

        this.btn1 = new JButton("Boutton 1");
        this.btn2 = new JButton("Boutton 2");
        this.btn3 = new JButton("Boutton 3");
        this.btn4 = new JButton("Boutton 4");
        this.btn5 = new JButton("Boutton 5");
        this.btn6 = new JButton("Boutton 6");

        this.add(btn1, BorderLayout.NORTH);
        this.add(btn2, BorderLayout.CENTER);
        this.add(btn3, BorderLayout.EAST);
        this.add(btn4, BorderLayout.WEST);


        this.panel = new JPanel();
        this.panel.setLayout(new FlowLayout());
        this.panel.add(btn5);
        this.panel.add(btn6);

        this.add(panel, BorderLayout.SOUTH);
    }
}



