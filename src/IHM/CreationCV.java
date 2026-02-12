package IHM;

import javax.swing.*;
import java.awt.*;

public class CreationCV extends JInternalFrame {

    JPanel mainPanel;
    JLabel lbNom, lbPrenom, lbCompetences, lbNiveau, lbGenre, lbInfos, lbExperience, lbPhoto, lbCouleur;
    JTextField tfNom, tfPrenom;
    JList<String> listCompetences;
    DefaultListModel<String> model;
    JComboBox<String> comboNiveau;
    JRadioButton radioHomme, radioFemme, radioAutre;
    ButtonGroup groupeGenre;
    JCheckBox checkPermis, checkVehicule, checkMobilite;
    JSpinner spinnerExperience;
    JButton btnPhoto, btnCouleur;
    JScrollPane scrollPane, scrollCompetences;

    public CreationCV() {
        this.setTitle("Création de CV");
        this.setSize(600, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setLocationRelativeTo(null);

        this.setMaximizable(true);
        this.setIconifiable(true);
        this.setResizable(true);
        this.setClosable(true);


        // Panel principal
        this.mainPanel = new JPanel();
        this.mainPanel.setLayout(new BoxLayout(this.mainPanel, BoxLayout.Y_AXIS));
        this.mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Nom et Prénom
        this.lbNom = new JLabel("Nom:");
        this.tfNom = new JTextField(20);

        this.lbPrenom = new JLabel("Prénom:");
        this.tfPrenom = new JTextField(20);

        // JList - Compétences
        this.lbCompetences = new JLabel("Compétences (sélection multiple):");
        String[] competences = {"Java", "Python", "JavaScript", "C++", "SQL", "HTML/CSS"};
        this.model = new DefaultListModel<>();
        for (String comp : competences) {
            this.model.addElement(comp);
        }
        this.listCompetences = new JList<>(this.model);
        this.listCompetences.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        this.scrollCompetences = new JScrollPane(this.listCompetences);
        this.scrollCompetences.setPreferredSize(new Dimension(500, 80));

        // JComboBox - Niveau d'études
        this.lbNiveau = new JLabel("Niveau d'études:");
        String[] niveaux = {"Bac", "Bac+2", "Bac+3", "Bac+5", "Doctorat"};
        this.comboNiveau = new JComboBox<>(niveaux);

        // JRadioButton - Genre
        this.lbGenre = new JLabel("Genre:");
        this.radioHomme = new JRadioButton("Homme");
        this.radioFemme = new JRadioButton("Femme");
        this.radioAutre = new JRadioButton("Autre");
        this.groupeGenre = new ButtonGroup();
        this.groupeGenre.add(this.radioHomme);
        this.groupeGenre.add(this.radioFemme);
        this.groupeGenre.add(this.radioAutre);

        // JCheckBox - Informations supplémentaires
        this.lbInfos = new JLabel("Informations supplémentaires:");
        this.checkPermis = new JCheckBox("Permis de conduire");
        this.checkVehicule = new JCheckBox("Véhicule personnel");
        this.checkMobilite = new JCheckBox("Mobilité géographique");

        // JSpinner - Années d'expérience
        this.lbExperience = new JLabel("Années d'expérience:");
        SpinnerModel spinnerModel = new SpinnerNumberModel(0, 0, 50, 1);
        this.spinnerExperience = new JSpinner(spinnerModel);

        // JFileChooser - Photo
        this.lbPhoto = new JLabel("Photo:");
        this.btnPhoto = new JButton("Choisir une photo");

        // JColorChooser - Couleur
        this.lbCouleur = new JLabel("Couleur du thème:");
        this.btnCouleur = new JButton("Choisir une couleur");

        // Ajouter tous les composants
        this.mainPanel.add(this.lbNom);
        this.mainPanel.add(this.tfNom);
        this.mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        this.mainPanel.add(this.lbPrenom);
        this.mainPanel.add(this.tfPrenom);
        this.mainPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        this.mainPanel.add(this.lbCompetences);
        this.mainPanel.add(this.scrollCompetences);
        this.mainPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        this.mainPanel.add(this.lbNiveau);
        this.mainPanel.add(this.comboNiveau);
        this.mainPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        this.mainPanel.add(this.lbGenre);
        this.mainPanel.add(this.radioHomme);
        this.mainPanel.add(this.radioFemme);
        this.mainPanel.add(this.radioAutre);
        this.mainPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        this.mainPanel.add(this.lbInfos);
        this.mainPanel.add(this.checkPermis);
        this.mainPanel.add(this.checkVehicule);
        this.mainPanel.add(this.checkMobilite);
        this.mainPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        this.mainPanel.add(this.lbExperience);
        this.mainPanel.add(this.spinnerExperience);
        this.mainPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        this.mainPanel.add(this.lbPhoto);
        this.mainPanel.add(this.btnPhoto);
        this.mainPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        this.mainPanel.add(this.lbCouleur);
        this.mainPanel.add(this.btnCouleur);

        // JScrollPane pour tout le contenu
        this.scrollPane = new JScrollPane(this.mainPanel);
        this.scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        this.add(this.scrollPane);
        this.setVisible(true);
    }

}