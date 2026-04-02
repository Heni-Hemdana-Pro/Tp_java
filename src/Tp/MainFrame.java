package Tp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends JFrame {

    // positions des cercles
    volatile int x1 = 30,  y1 = 200;
    volatile int x2 = 820, y2 = 200;

    // rectangle cible
    volatile boolean rectDefined = false;
    int rectX, rectY, tx, ty;

    // droites affines
    double a1, b1, a2, b2;

    // synchronisation
    volatile int arrivedCount = 0;

    // données dashboard
    List<String> times1 = new ArrayList<>();
    List<String> times2 = new ArrayList<>();

    AnimPanel animPanel = new AnimPanel();
    DashFrame dashFrame = new DashFrame();

    MainFrame() {
        setTitle("Animation");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JButton restart = new JButton("Restart");
        restart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rectDefined = false;
                x1 = 30;  y1 = 200;
                x2 = 820; y2 = 200;
                arrivedCount = 0;
                animPanel.repaint();
            }
        });

        JPanel top = new JPanel();
        top.add(restart);
        add(top, BorderLayout.NORTH);
        add(animPanel, BorderLayout.CENTER);

        animPanel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (rectDefined) return;
                tx = e.getX(); ty = e.getY();
                rectX = tx - 40; rectY = ty - 40;

                // calcul droite affine : y = ax + b
                a1 = (ty - y1) / (double)(tx - x1);  b1 = y1 - a1 * x1;
                a2 = (ty - y2) / (double)(tx - x2);  b2 = y2 - a2 * x2;

                arrivedCount = 0;
                rectDefined = true;
                animPanel.repaint();
            }
        });

        new Thread1().start();
        new Thread2().start();

        setSize(900, 500);
        setLocationRelativeTo(null);
        dashFrame.setLocation(getX() + 920, getY());
        dashFrame.setVisible(true);
    }

    // méthode synchronisée : 1er thread attend, 2ème réveille
    synchronized void rendezvous() throws InterruptedException {
        arrivedCount++;
        if (arrivedCount == 1) wait(5000);  // 1er arrivé : attend
        else notifyAll(); // 2ème arrivé : réveille
        arrivedCount = 0;
    }

    class Thread1 extends Thread {
        public void run() {
            while (true) {
                while (!rectDefined) {
                    try {
                        sleep(80);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                // avancer vers le rectangle sur la droite affine
                while (x1 < tx - 2) {
                    x1 += 5;
                    y1 = (int)(a1 * x1 + b1);
                    animPanel.repaint();
                    try {
                        sleep(30);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                String heure = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
                try { rendezvous(); } catch (InterruptedException e) { continue; }

                times1.add(heure);
                dashFrame.refresh();
                rectDefined = false;
            }
        }
    }

    class Thread2 extends Thread {
        public void run() {
            while (true) {
                while (!rectDefined) {
                    try {
                        sleep(80);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                // avancer vers le rectangle sur la droite affine
                while (x2 > tx + 2) {
                    x2 -= 5;
                    y2 = (int)(a2 * x2 + b2);
                    animPanel.repaint();
                    try {
                        sleep(30);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                String heure = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
                try { rendezvous(); } catch (InterruptedException e) { continue; }

                times2.add(heure);
                dashFrame.refresh();
            }
        }
    }

    class AnimPanel extends JPanel {
        AnimPanel() { setBackground(Color.WHITE); setPreferredSize(new Dimension(900, 450)); }

        public void paint(Graphics g) {
            super.paint(g);
            if (rectDefined) {
                g.setColor(Color.BLACK);
                g.drawRect(rectX, rectY, 80, 80);
            }
            // cercle T1
            g.setColor(Color.BLUE);  g.fillOval(x1, y1, 40, 40);
            g.setColor(Color.WHITE); g.drawString("T1", x1+12, y1+25);
            // cercle T2
            g.setColor(Color.RED);   g.fillOval(x2, y2, 40, 40);
            g.setColor(Color.WHITE); g.drawString("T2", x2+12, y2+25);
        }
    }

    class DashFrame extends JFrame {
        DashPanel p1 = new DashPanel(times1);
        DashPanel p2 = new DashPanel(times2);

        DashFrame() {
            setTitle("Dashboard");
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            JTabbedPane tabs = new JTabbedPane();
            tabs.addTab("T1", p1);
            tabs.addTab("T2", p2);
            add(tabs);
            setSize(400, 350);
        }

        void refresh() { p1.repaint(); p2.repaint(); }
    }

    class DashPanel extends JPanel {
        List<String> times;
        DashPanel(List<String> times) {
            this.times = times;
            setBackground(Color.WHITE);
        }

        public void paint(Graphics g) {
            super.paint(g);
            int colW = getWidth() / 3;
            g.setColor(Color.BLACK);
            g.setFont(new Font("Monospaced", Font.PLAIN, 12));
            for (int i = 0; i < times.size(); i++) {
                int col = (i / 10) % 3; // 10 lignes par colonne, cycle sur 3
                int row = i % 10;
                g.drawString(times.get(i), 5 + col * colW, 20 + row * 20);
            }
            // séparateurs
            g.setColor(Color.LIGHT_GRAY);
            g.drawLine(colW,   0, colW,   getHeight());
            g.drawLine(colW*2, 0, colW*2, getHeight());
        }
    }


    static void sleep(int ms) {
        try { Thread.sleep(ms); } catch (InterruptedException ignored) {}
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
    }
}