package IHM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GestionProfils extends javax.swing.JInternalFrame {
    JPanel northPanel;
    JLabel lbNom, lbPrenom, lbPseudo, lbHelp;
    JTextField tfNom, tfPrenom, tfPseudo;
    JButton saveButton;
    JSplitPane jsp;
    JList<String> jl;
    DefaultListModel<String> model;
    JTabbedPane jtp;


    DefaultListModel<String> listModel;
    DefaultListModel<String> listModel1;

    public GestionProfils() {
        this.setTitle("Gestion Profils");
        this.setSize(800, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());


        this.setMaximizable(true);
        this.setIconifiable(true);
        this.setResizable(true);
        this.setClosable(true);

        this.northPanel = new JPanel();
        this.northPanel.setLayout(new FlowLayout());

        this.lbNom = new JLabel("Nom");
        this.lbPrenom = new JLabel("Prenom");
        this.lbPseudo = new JLabel("Pseudo");
        this.lbHelp = new JLabel("Help");

        this.tfNom = new JTextField(15);
        this.tfPrenom = new JTextField(15);
        this.tfPseudo = new JTextField(15);

        this.saveButton = new JButton("Enregistrer");
        this.saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.addElement(tfPseudo.getText());
            }
        });

        this.northPanel.add(lbNom);
        this.northPanel.add(tfNom);
        this.northPanel.add(lbPrenom);
        this.northPanel.add(tfPrenom);
        this.northPanel.add(lbPseudo);
        this.northPanel.add(tfPseudo);
        this.northPanel.add(saveButton);

        this.add(this.northPanel, BorderLayout.NORTH);
        this.add(lbHelp, BorderLayout.SOUTH);

        this.jsp = new JSplitPane();
        this.add(this.jsp, BorderLayout.CENTER);

        this.jl = new JList<>();
        this.jl.setPreferredSize(new Dimension(400, 300));
        this.model = new DefaultListModel<>();
        this.jl.setModel(this.model);

        this.jtp  = new JTabbedPane();
//        this.jtp.addTab("T1", new JPanel());
//        this.jtp.addTab("T2", new JPanel());

        this.jsp.setLeftComponent(jl);
        this.jsp.setRightComponent(jtp);

        this.lbNom.addMouseListener(new EcouteurLabel(this));
        this.lbPrenom.addMouseListener(new EcouteurLabel(this));
        this.lbPseudo.addMouseListener(new EcouteurLabel(this));

        this.tfNom.addMouseListener(new EcouteurHelp(this));
        this.tfPrenom.addMouseListener(new EcouteurHelp(this));
        this.tfPseudo.addMouseListener(new EcouteurHelp(this));



        jl.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2) {
                    String ps = jl.getSelectedValue();
                    FormPannel fp = new FormPannel(ps);
                    jtp.addTab(ps, fp);
                }
                if(e.getButton() == MouseEvent.BUTTON3) {
                    MyPopUpMenu popup = new MyPopUpMenu(GestionProfils.this);
                    popup.show(jl, e.getX(), e.getY());
                }
            }
        });


    }

}
