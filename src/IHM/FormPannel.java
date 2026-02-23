package IHM;

import Data.Profil;
import Data.DataProfil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class FormPannel extends JPanel {
    Profil profil;
    DataProfil dataProfil;
    JLabel lbl_bonjour, lbl_Langues;
    JPanel mainPanel, LanguePanel, NamePanel, PanelLangue, BouttonPannel, panelAnnee;
    JButton btnPlus;
    JComboBox<String> Cycle;
    JPanel panelAnnees;
    JButton btnSave, btnFermer;

    HashMap<String, JSpinner> languesSpinners;

    public FormPannel(Profil profil, DataProfil dataProfil) {

        this.profil = profil;
        this.dataProfil = dataProfil;
        this.languesSpinners = new HashMap<>();

        this.setLayout(new BorderLayout());
        this.mainPanel = new JPanel();
        this.mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));


        this.NamePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        this.lbl_bonjour = new JLabel("Bonjour " + profil.getNom() + " " + profil.getPrenom());
        this.lbl_bonjour.setFont(new Font("Arial", Font.BOLD, 20));

        this.NamePanel.add(lbl_bonjour);
        this.mainPanel.add(this.NamePanel);


        this.LanguePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        this.lbl_Langues = new JLabel("Langues:");
        this.LanguePanel.add(lbl_Langues);

        this.btnPlus = new JButton("+");
        this.btnPlus.addActionListener(new ActionListener() {

            JPanel languePanel, PannelLangue;
            JLabel langueLabel;
            JSpinner spinner;


            @Override
            public void actionPerformed(ActionEvent e) {
                String langue = JOptionPane.showInputDialog(FormPannel.this, "Entrez le nom de la langue:");

                    this.languePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

                    this.langueLabel = new JLabel(langue + ":");
                    this.languePanel.add(langueLabel);

                    this.spinner = new JSpinner(new SpinnerNumberModel(1, 1, 5, 1));
                    this.languePanel.add(spinner);

                    this.PannelLangue = new JPanel(new FlowLayout(FlowLayout.CENTER));

                    FormPannel.this.PanelLangue.add(languePanel);
                    FormPannel.this.languesSpinners.put(langue, spinner);
                    FormPannel.this.PanelLangue.revalidate();
                    FormPannel.this.PanelLangue.repaint();

            }
        });
        this.LanguePanel.add(btnPlus);
        this.mainPanel.add(this.LanguePanel);

        this.PanelLangue = new JPanel();
        this.PanelLangue.setLayout(new BoxLayout(PanelLangue, BoxLayout.Y_AXIS));
        this.mainPanel.add(this.PanelLangue);


        this.Cycle = new JComboBox<>(new String[]{"1er cycle", "2eme cycle"});
        this.Cycle.setPreferredSize(new Dimension(50, 30));
        this.Cycle.addActionListener(new ActionListener() {

            JLabel LabelAnnee;
            JCheckBox cb1, cb2, cb3;

            @Override
            public void actionPerformed(ActionEvent e) {

                FormPannel.this.panelAnnees.removeAll();

                String Cycle = (String) FormPannel.this.Cycle.getSelectedItem();

                if ("1er cycle".equals(Cycle)) {
                    this.LabelAnnee = new JLabel("Année: ");
                    FormPannel.this.panelAnnee.add(this.LabelAnnee);
                    this.cb1 = new JCheckBox("1");
                    this.cb2 = new JCheckBox("2");
                    FormPannel.this.panelAnnee.add(this.cb1);
                    FormPannel.this.panelAnnee.add(this.cb2);
                }
                else if ("2eme cycle".equals(Cycle)) {
                    this.LabelAnnee = new JLabel("Année: ");
                    FormPannel.this.panelAnnee.add(this.LabelAnnee);
                    this.cb1 = new JCheckBox("1");
                    this.cb2 = new JCheckBox("2");
                    this.cb3 = new JCheckBox("3");
                    FormPannel.this.panelAnnee.add(this.cb1);
                    FormPannel.this.panelAnnee.add(this.cb2);
                    FormPannel.this.panelAnnee.add(this.cb3);
                }

                FormPannel.this.panelAnnee.revalidate();
                FormPannel.this.panelAnnee.repaint();

            }
        });
        this.mainPanel.add(Cycle);
        this.panelAnnee = new JPanel(new FlowLayout(FlowLayout.CENTER));
        this.mainPanel.add(panelAnnee);



        this.btnSave = new JButton("Save");
        this.btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        btnFermer = new JButton("Fermer");
        btnFermer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });

        this.BouttonPannel  = new JPanel();
        this.BouttonPannel.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.BouttonPannel.add(this.btnSave);
        this.BouttonPannel.add(this.btnFermer);

        mainPanel.add(this.BouttonPannel);

        this.add(new JScrollPane(mainPanel), BorderLayout.CENTER);
    }

}