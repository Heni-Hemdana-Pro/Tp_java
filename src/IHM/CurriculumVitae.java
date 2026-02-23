package IHM;


import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;


public class CurriculumVitae extends JFrame {

    JTextField tfNom, tfPrenom, tfEmail, tfTelephone, tfAdresse, tfHobbies;
    JComboBox<String> comboNationalite;
    JRadioButton rbMasculin, rbFeminin;
    ButtonGroup groupeSexe;
    JCheckBox cbPermis, cbDisponible;
    JSpinner spinnerExperience;
    JList<String> listLangues, listCompetences;
    JButton btnImage, btnCouleur, btnAfficher, btnQuitter, btnReset;
    JLabel lblImage, lblCouleurPreview;
    String imagePath = "";  // Chemin de l'image sélectionnée
    Color couleurCV = new Color(41, 128, 185); // Couleur par défaut (Bleu)

    public CurriculumVitae() {
        // Config fenêtre principale
        setTitle("Générateur de CV Professionnel");
        setSize(900, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fermer l'app quand on clique sur X
        setLocationRelativeTo(null);                 // Centrer la fenêtre à l'écran

        // Création du panneau principal
        JPanel contenue = new JPanel(new BorderLayout());
        contenue.setBackground(Color.LIGHT_GRAY);
        setContentPane(contenue); // Définir ce panneau comme contenu de la fenêtre

        contenue.add(creerHeader(), BorderLayout.NORTH);

        //CRÉATION DU PANEL PRINCIPAL (CENTRE)
        JPanel panelPrincipale = new JPanel();
        // BoxLayout
        panelPrincipale.setLayout(new BoxLayout(panelPrincipale, BoxLayout.Y_AXIS));
        panelPrincipale.setBackground(new Color(236, 240, 241));
        panelPrincipale.setBorder(new EmptyBorder(20, 30, 20, 30));

        // Ajouter toutes les sections une par une
        panelPrincipale.add(creerInfosPersonnelles());
        panelPrincipale.add(Box.createVerticalStrut(15)); // Espace vertical

        panelPrincipale.add(creerContact());
        panelPrincipale.add(Box.createVerticalStrut(15));

        panelPrincipale.add(creerDetailsPro());
        panelPrincipale.add(Box.createVerticalStrut(15));

        panelPrincipale.add(creerCompetences());
        panelPrincipale.add(Box.createVerticalStrut(15));

        panelPrincipale.add(creerHobbies());
        panelPrincipale.add(Box.createVerticalStrut(15));

        panelPrincipale.add(creerPersonnalisation());
        panelPrincipale.add(Box.createVerticalStrut(20));

        //SCROLLPANE
        JScrollPane scrollPane = new JScrollPane(panelPrincipale);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); // Barre verticale si nécessaire
        contenue.add(scrollPane, BorderLayout.CENTER); // Placer au centre

        // Ajout de footer
        contenue.add(creerFooter(), BorderLayout.SOUTH);
        setVisible(true);
    }


    public JPanel creerHeader() {
        JPanel header = new JPanel(new GridBagLayout());
        header.setBackground(new Color(41, 128, 185));
        header.setPreferredSize(new Dimension(900, 100));

        // Panel titre
        JPanel titrePanel = new JPanel();
        titrePanel.setLayout(new BoxLayout(titrePanel, BoxLayout.Y_AXIS)); // Vertical
        titrePanel.setBackground(new Color(41, 128, 185)); // Même couleur

        JLabel titre = new JLabel("GÉNÉRATEUR DE CV");
        titre.setFont(new Font("Segoe UI", Font.BOLD, 32)); // Police: Segoe UI, Gras, 32px
        titre.setForeground(Color.WHITE); // Texte blanc
        titre.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrer horizontalement

        titrePanel.add(titre);
        header.add(titrePanel);
        return header;
    }


    public JPanel creerInfosPersonnelles() {
        JPanel section = creerSection("Informations Personnelles", new Color(41, 128, 185));

        // NOM
        JPanel pNom = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pNom.setBackground(Color.WHITE);
        pNom.add(new JLabel("Nom *:"));
        tfNom = new JTextField(20);
        pNom.add(tfNom);
        section.add(pNom);

        // PRÉNOM
        JPanel pPrenom = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pPrenom.setBackground(Color.WHITE);
        pPrenom.add(new JLabel("Prénom *:"));
        tfPrenom = new JTextField(20);
        pPrenom.add(tfPrenom);
        section.add(pPrenom);

        // BOUTONS RADIO
        JPanel pSexe = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pSexe.setBackground(Color.WHITE);
        pSexe.add(new JLabel("Sexe:"));

        //deux boutons radio
        rbMasculin = new JRadioButton("Masculin");
        rbFeminin = new JRadioButton("Féminin");
        rbMasculin.setBackground(Color.WHITE); // Fond transparent
        rbFeminin.setBackground(Color.WHITE);

        // Grouper les boutons radio
        groupeSexe = new ButtonGroup();
        groupeSexe.add(rbMasculin);
        groupeSexe.add(rbFeminin);


        pSexe.add(rbMasculin);
        pSexe.add(rbFeminin);
        section.add(pSexe);

        // NATIONALITÉ
        JPanel pNat = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pNat.setBackground(Color.WHITE);
        pNat.add(new JLabel("Nationalité:"));


        String[] nationalites = {"Tunisienne", "Française", "Algérienne", "Marocaine", "Américaine", "Britannique", "Autre"};
        comboNationalite = new JComboBox<>(nationalites); // Créer la liste déroulante
        pNat.add(comboNationalite);
        section.add(pNat);

        return section;
    }

    public JPanel creerContact() {
        JPanel section = creerSection("Coordonnées", new Color(52, 152, 219));

        // Email
        JPanel pEmail = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pEmail.setBackground(Color.WHITE);
        pEmail.add(new JLabel("Email:"));
        tfEmail = new JTextField(20);
        pEmail.add(tfEmail);
        section.add(pEmail);

        // Téléphone
        JPanel pTel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pTel.setBackground(Color.WHITE);
        pTel.add(new JLabel("Téléphone:"));
        tfTelephone = new JTextField(20);
        pTel.add(tfTelephone);
        section.add(pTel);

        // Adresse
        JPanel pAdresse = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pAdresse.setBackground(Color.WHITE);
        pAdresse.add(new JLabel("Adresse:"));
        tfAdresse = new JTextField(30);
        pAdresse.add(tfAdresse);
        section.add(pAdresse);

        return section;
    }

    public JPanel creerDetailsPro() {
        JPanel section = creerSection("Détails Professionnels", Color.green); // Vert

        // SPINNER EXPÉRIENCE
        JPanel panelExperience = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelExperience.setBackground(Color.WHITE);
        panelExperience.add(new JLabel("Années d'expérience:"));

        spinnerExperience = new JSpinner(new SpinnerNumberModel(0, 0, 50, 1));
        panelExperience.add(spinnerExperience);
        panelExperience.add(new JLabel("an(s)"));
        section.add(panelExperience);

        // CHECKBOXES
        JPanel panelCheck = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelCheck.setBackground(Color.WHITE);

        cbPermis = new JCheckBox("Permis de conduire");
        cbDisponible = new JCheckBox("Disponible immédiatement");
        cbPermis.setBackground(Color.WHITE);
        cbDisponible.setBackground(Color.WHITE);

        panelCheck.add(cbPermis);
        panelCheck.add(cbDisponible);
        section.add(panelCheck);

        return section;
    }


    public JPanel creerCompetences() {
        JPanel section = creerSection("Compétences et Langues", Color.orange); // Orange

        JPanel conteneur = new JPanel(new GridLayout(1, 2, 20, 0));
        conteneur.setBackground(Color.WHITE);

        // LANGUES
        JPanel panelLangues = new JPanel(new BorderLayout());
        panelLangues.setBackground(Color.WHITE);
        panelLangues.add(new JLabel("Langues"), BorderLayout.NORTH); // Label en haut

        String[] langues = {"Français", "Anglais", "Arabe", "Espagnol", "Allemand", "Italien", "Chinois"};
        listLangues = new JList<>(langues); // Créer la liste

        // Mode de sélection: permet de sélectionner plusieurs éléments en cliquant
        listLangues.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        // Ajouter un scroll
        JScrollPane scrollLangues = new JScrollPane(listLangues);
        scrollLangues.setPreferredSize(new Dimension(280, 120));
        panelLangues.add(scrollLangues, BorderLayout.CENTER);
        conteneur.add(panelLangues);

        // COMPÉTENCES
        JPanel panelCompetence = new JPanel(new BorderLayout());
        panelCompetence.setBackground(Color.WHITE);
        panelCompetence.add(new JLabel("Compétences"), BorderLayout.NORTH);

        String[] competences = {"Java", "Python", "JavaScript", "C++", "SQL", "HTML/CSS", "React", "Angular", "Spring Boot"};
        listCompetences = new JList<>(competences);
        listCompetences.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        JScrollPane scrollComp = new JScrollPane(listCompetences);
        scrollComp.setPreferredSize(new Dimension(280, 120));
        panelCompetence.add(scrollComp, BorderLayout.CENTER);
        conteneur.add(panelCompetence); // Ajouter à droite du conteneur

        section.add(conteneur);
        return section;
    }


    public JPanel creerHobbies() {
        JPanel section = creerSection("Centres d'Intérêt", new Color(155, 89, 182));

        JPanel pHobbies = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pHobbies.setBackground(Color.WHITE);
        pHobbies.add(new JLabel("Vos hobbies:"));
        tfHobbies = new JTextField(40);
        pHobbies.add(tfHobbies);
        section.add(pHobbies);

        return section;
    }


    public JPanel creerPersonnalisation() {
        JPanel section = creerSection("Personnalisation", Color.red); // Rouge

        // Panel horizontal avec espacement
        JPanel ligne = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
        ligne.setBackground(Color.WHITE);

        // BOUTON PHOTO
        btnImage = new JButton("Choisir une photo");
        btnImage.setBackground(new Color(52, 152, 219));
        btnImage.setForeground(Color.WHITE);
        btnImage.setUI(new javax.swing.plaf.basic.BasicButtonUI());
        lblImage = new JLabel("Aucune image");
        ligne.add(btnImage);
        ligne.add(lblImage);

        // BOUTON COULEUR
        btnCouleur = new JButton("Couleur du CV");
        btnCouleur.setBackground(new Color(52, 152, 219));
        btnCouleur.setForeground(Color.WHITE);
        btnCouleur.setUI(new javax.swing.plaf.basic.BasicButtonUI());

        // Label carré pour prévisualiser la couleur
        lblCouleurPreview = new JLabel("        "); // Espaces pour avoir une largeur
        lblCouleurPreview.setOpaque(true);
        lblCouleurPreview.setBackground(couleurCV);
        lblCouleurPreview.setPreferredSize(new Dimension(80, 35));
        lblCouleurPreview.setBorder(new LineBorder(Color.DARK_GRAY, 2));

        ligne.add(btnCouleur);
        ligne.add(lblCouleurPreview);

        section.add(ligne);
        return section;
    }

    public JPanel creerFooter() {
        JPanel footer = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 15));
        footer.setBackground(new Color(52, 73, 94));
        footer.setPreferredSize(new Dimension(900, 80));

        btnAfficher = creerBouton("Afficher le CV", new Color(52, 152, 219));
        btnQuitter = creerBouton("Quitter", new Color(231, 76, 60));

        footer.add(btnAfficher);
        footer.add(btnQuitter);

        // Quand on clique sur btnImage, appeler la méthode choisirImage()
        btnImage.addActionListener(e -> choisirImage());

        // Quand on clique sur btnCouleur, appeler choisirCouleur()
        btnCouleur.addActionListener(e -> choisirCouleur());

        // Quand on clique sur btnAfficher, appeler afficherCV()
        btnAfficher.addActionListener(e -> afficherCV());

        // Quand on clique sur btnQuitter
        btnQuitter.addActionListener(e -> {
            System.exit(0);
        });

        return footer;
    }


    public JPanel creerSection(String titre, Color couleur) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);

        // Bordure composée: bordure colorée + marges internes
        panel.setBorder(new CompoundBorder(
                new LineBorder(couleur, 3, true),
                new EmptyBorder(15, 15, 15, 15)
        ));
        panel.setMaximumSize(new Dimension(840, 500)); // Largeur max

        // TITRE DE LA SECTION
        JLabel lblTitre = new JLabel(titre);
        lblTitre.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTitre.setForeground(couleur);
        lblTitre.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(lblTitre);
        panel.add(Box.createVerticalStrut(10));

        // LIGNE SÉPARATRICE
        JSeparator sep = new JSeparator();
        sep.setForeground(couleur);
        sep.setMaximumSize(new Dimension(810, 2));
        panel.add(sep);
        panel.add(Box.createVerticalStrut(15));

        return panel;
    }

    public JButton creerBouton(String texte, Color couleur) {
        JButton btn = new JButton(texte);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btn.setBackground(couleur);
        btn.setForeground(Color.WHITE);
        btn.setPreferredSize(new Dimension(180, 45));
        btn.setUI(new javax.swing.plaf.basic.BasicButtonUI()); // Style personnalisé

        btn.setBorder(new CompoundBorder(
                new LineBorder(couleur.darker(), 3),  // darker() rend la couleur plus foncée
                new EmptyBorder(10, 20, 10, 20)
        ));
        return btn;
    }


    public void choisirImage() {
        JFileChooser chooser = new JFileChooser(); // Créer le sélecteur

        // Filtrer pour n'afficher que les images
        chooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
            public boolean accept(File f) {
                // Accepter les dossiers et les fichiers .jpg, .png
                return f.isDirectory() ||
                        f.getName().toLowerCase().endsWith(".jpg") ||
                        f.getName().toLowerCase().endsWith(".png");
            }
            // Description du filtre
            public String getDescription() {
                return "Images (JPG, PNG)";
            }
        });

        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            // Si un fichier a été sélectionné
            imagePath = chooser.getSelectedFile().getAbsolutePath(); // Chemin complet
            lblImage.setText("✓ " + chooser.getSelectedFile().getName()); // Afficher le nom
        }
    }


    public void choisirCouleur() {
        Color c = JColorChooser.showDialog(this, "Choisissez la couleur de votre CV", couleurCV);

        if (c != null) { // Si l'utilisateur a choisi une couleur
            couleurCV = c;
            lblCouleurPreview.setBackground(c); // Mettre à jour l'aperçu
        }
    }

    /** MÉTHODE : Générer et afficher l'aperçu du CV */

    public void afficherCV() {
        // Vérifier que les champs obligatoires sont remplis
        if (tfNom.getText().trim().isEmpty() || tfPrenom.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Le nom et le prénom sont obligatoires !",
                    "Attention", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // HTML
        String html = "<html><body style='font-family: Arial; padding: 20px;'>";

        // HEADER avec photo et couleur choisie
        html += "<div style='background: " + toHex(couleurCV) + "; padding: 20px; color: white;'>";
        html += "<table width='100%'><tr>";

        // Photo à gauche (si elle existe)
        if (!imagePath.isEmpty()) {
            html += "<td width='120' valign='top'>";
            html += "<img src='file:///" + imagePath.replace("\\", "/") + "' width='100' height='100' style='border-radius: 50%; border: 3px solid white;'>";
            html += "</td>";
        }

        // Nom et prénom
        html += "<td valign='middle'>";
        html += "<h1 style='margin: 0;'>" + tfPrenom.getText().toUpperCase() + " " + tfNom.getText().toUpperCase() + "</h1>";
        html += "</td>";
        html += "</tr></table>";
        html += "</div><br>";

        // CONTACT
        html += "<div style='border-left: 3px solid " + toHex(couleurCV) + "; padding-left: 15px;'>";
        html += "<h3>CONTACT</h3>";
        // Ajouter seulement si le champ n'est pas vide
        if (!tfEmail.getText().isEmpty())
            html += "<p>Email: " + tfEmail.getText() + "</p>";
        if (!tfTelephone.getText().isEmpty())
            html += "<p>Téléphone: " + tfTelephone.getText() + "</p>";
        if (!tfAdresse.getText().isEmpty())
            html += "<p>Adresse: " + tfAdresse.getText() + "</p>";
        html += "</div><br>";

        // INFORMATIONS
        html += "<div style='border-left: 3px solid " + toHex(couleurCV) + "; padding-left: 15px;'>";
        html += "<h3>INFORMATIONS</h3>";
        if (rbMasculin.isSelected())
            html += "<p>Sexe: Masculin</p>";
        else if (rbFeminin.isSelected())
            html += "<p>Sexe: Féminin</p>";
        html += "<p>Nationalité: " + comboNationalite.getSelectedItem() + "</p>";
        html += "<p>Expérience: " + spinnerExperience.getValue() + " an(s)</p>";
        html += "<p>Permis: " + (cbPermis.isSelected() ? "Oui" : "Non") + "</p>";
        html += "<p>Disponibilité: " + (cbDisponible.isSelected() ? "Immédiate" : "À négocier") + "</p>";
        html += "</div><br>";

        // LANGUES
        if (!listLangues.isSelectionEmpty()) {
            html += "<div style='border-left: 3px solid " + toHex(couleurCV) + "; padding-left: 15px;'>";
            html += "<h3>LANGUES</h3><ul>";
            // Boucle sur toutes les langues sélectionnées
            for (String l : listLangues.getSelectedValuesList()) {
                html += "<li>" + l + "</li>";
            }
            html += "</ul></div><br>";
        }

        // COMPÉTENCES
        if (!listCompetences.isSelectionEmpty()) {
            html += "<div style='border-left: 3px solid " + toHex(couleurCV) + "; padding-left: 15px;'>";
            html += "<h3>COMPÉTENCES</h3><ul>";
            for (String c : listCompetences.getSelectedValuesList()) {
                html += "<li>" + c + "</li>";
            }
            html += "</ul></div><br>";
        }

        // HOBBIES
        if (!tfHobbies.getText().trim().isEmpty()) {
            html += "<div style='border-left: 3px solid " + toHex(couleurCV) + "; padding-left: 15px;'>";
            html += "<h3>CENTRES D'INTÉRÊT</h3>";
            html += "<p>" + tfHobbies.getText() + "</p>";
            html += "</div>";
        }

        html += "</body></html>";

        // AFFICHAGE
        JEditorPane editorPane = new JEditorPane("text/html", html); // Composant pour afficher du HTML
        editorPane.setEditable(false); // Non modifiable

        JScrollPane scrollPane = new JScrollPane(editorPane);
        scrollPane.setPreferredSize(new Dimension(600, 500));

        // Afficher dans une boîte de dialogue
        JOptionPane.showMessageDialog(this, scrollPane, "Aperçu de votre CV", JOptionPane.PLAIN_MESSAGE);
    }

    /**  Convertir une couleur en code hexadécimal */
    public String toHex(Color c) {
        return String.format("#%02x%02x%02x", c.getRed(), c.getGreen(), c.getBlue());
    }
}