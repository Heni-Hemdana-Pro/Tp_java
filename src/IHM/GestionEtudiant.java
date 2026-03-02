package IHM;

import Adapter.EtudiantTableModel;
import DataBase.EtudiantImplementation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

public class GestionEtudiant extends JFrame {
    JTable table;
    EtudiantTableModel model;
    JTextField cin, nom, prenom, moyenne;
    JLabel nomlabel, prenomlabel, cinlabel, moyennelabel;
    JButton saveboutton;

    JPanel panelform;
    JPopupMenu popup;
    JMenuItem supprimer;

    GestionEtudiant(){
        setTitle("Gestion Etudiant");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        String requete = "select * from Etudiant";
        EtudiantImplementation imp = new EtudiantImplementation();
        ResultSet rs = imp.selectEtudiant(requete);

        model = new EtudiantTableModel(rs, imp);
        table = new JTable();
        table.setModel(model);

        this.table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if(e.getButton() == MouseEvent.BUTTON3){
                    int row = table.rowAtPoint(e.getPoint());
                    if(row >= 0){
                        table.setRowSelectionInterval(row, row);
                        GestionEtudiant.this.popup = new JPopupMenu();
                        GestionEtudiant.this.supprimer = new JMenuItem("supprimer");

                        supprimer.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                int cin = (Integer) model.getValueAt(row, 0);
                                model.supprimerEtudiant(cin);
                            }
                        });

                        popup.add(supprimer);
                        popup.show(table, e.getX(), e.getY());



                    }

                }
            }
        });

        this.add(new JScrollPane(table), BorderLayout.CENTER);

        this.panelform = new JPanel();
        this.panelform.setLayout(new FlowLayout());

        this.cinlabel = new JLabel("Cin :");
        this.nomlabel = new JLabel("Nom :");
        this.prenomlabel = new JLabel("Prenom :");
        this.moyennelabel = new JLabel("Moyenne :");

        this.cin = new JTextField(10);
        this.nom = new JTextField(15);
        this.prenom = new JTextField(15);
        this.moyenne = new JTextField(5);

        this.saveboutton = new JButton("Ajouter");

        this.saveboutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    int cinVal = Integer.parseInt(cin.getText());
                    String nomVal = nom.getText();
                    String prenomVal = prenom.getText();
                    double moyenneVal = Double.parseDouble(moyenne.getText());

                    model.ajouterEtudiant(cinVal, nomVal, prenomVal, moyenneVal);
                    

            }
        });

        this.panelform.add(cinlabel);
        this.panelform.add(cin);
        this.panelform.add(nomlabel);
        this.panelform.add(nom);
        this.panelform.add(prenomlabel);
        this.panelform.add(prenom);
        this.panelform.add(moyennelabel);
        this.panelform.add(moyenne);
        this.panelform.add(saveboutton);


        this.add(panelform, BorderLayout.NORTH);
    }

    public static void main(String[] args) {
        GestionEtudiant g = new GestionEtudiant();
        g.setVisible(true);

    }
}