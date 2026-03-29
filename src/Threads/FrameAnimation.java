package Threads;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

public class FrameAnimation extends JFrame {
    boolean isRunning = true;
    double a,b;



    int xi = 10;
    int xf = 10;

    int y = 200;
    int yf = 200;
    int yi = 200;
    JButton btnstop,btnstart;
    int x=10;
    PannelAnimation pa;


    FrameAnimation() {
        setTitle("Animation");
        setSize(900,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        btnstop = new JButton("Stop");
        btnstart = new JButton("Start");

        JPanel pn = new JPanel();pn.setBackground(Color.GRAY );
        pn.add(btnstop);
        pn.add(btnstart);
        this.add(pn,BorderLayout.NORTH);

        pa = new PannelAnimation();
        this.add(pa);

        Animation animation = new Animation();
        animation.start();

        btnstart.addActionListener(new  ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isRunning = true;

            }
        });

        btnstop.addActionListener(new  ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isRunning = false;
            }
        });
        pa.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                xf = e.getX();
                yf = e.getY();

                a= (yf-yi)/(double)(xf-xi);
                b = yi-a*xi;

                x= xi +1;

                Graphics g = pa.getGraphics();
                g.drawRect(xf,yf,100,100);
            }
        });

    }

    class Animation extends Thread {
        int pas = 10;
        public void run() {
            while (true) {
                System.out.println(isRunning);
                while (isRunning && x > xi && x < xf) {
                    x += pas;

                    y = (int) (a*x + b);

                    pa.repaint();
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                if (x >= 800) {
                    pas*=-1;
                    x+=pas;
                }
            }

        }
    }


    class PannelAnimation extends JPanel {
        PannelAnimation() {
            this.setBackground(Color.yellow);
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);

            g.setColor(Color.green);
            g.fillOval(x,y,100,100);

            g.setColor(Color.red);
            g.drawString(new Date().toLocaleString(),x,100);
        }
    }

    public static void main(String[] args) {
        new FrameAnimation().setVisible(true);
    }

}
