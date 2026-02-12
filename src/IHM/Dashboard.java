package IHM;

import javax.swing.*;

public class Dashboard extends JFrame {
    JMenuBar menuBar;
    JMenu menutp1, menutp2;
    JMenuItem itemFlow, itemGrid, itemBorder, itemcv, itemGP;
    JDesktopPane desktop;

    public Dashboard() {
        this.setTitle("Dashboard");
        this.setSize(900, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        this.menuBar = new JMenuBar();


        this.itemFlow = new JMenuItem("Flow");
        this.itemGrid =  new JMenuItem("Grid");
        this.itemBorder = new JMenuItem("Border");

        this.itemcv = new JMenuItem("Currilculum vitae");
        this.itemGP = new JMenuItem("gerer profil");

        this.menutp1 = new JMenu("TP1");
        this.menutp1.add(itemFlow);
        this.menutp1.add(itemGrid);
        this.menutp1.add(itemBorder);

        this.menutp2 = new JMenu("TP2");
        this.menutp2.add(itemcv);
        this.menutp2.add(itemGP);

        this.menuBar.add(this.menutp1);
        this.menuBar.add(this.menutp2);


        EcouteurListner ecouteurListner = new EcouteurListner(this);
        this.itemFlow.addActionListener(ecouteurListner);
        this.itemGrid.addActionListener(ecouteurListner);
        this.itemBorder.addActionListener(ecouteurListner);
        this.itemcv.addActionListener(ecouteurListner);
        this.itemGP.addActionListener(ecouteurListner);

        this.setJMenuBar(this.menuBar);

        desktop = new JDesktopPane();
        this.add(desktop);
    }

}