package IHM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CurriculumVitae extends JFrame {
    JTextField tf_nom;
    JLabel lb_nom;
    JTextField tf_prenom;
    JLabel lb_prenom;
    JButton btn_valider ,btn_quitter;
    JLabel lb_title;
    CurriculumVitae(){

        //cretaion de l'interface
        this.setTitle("Curriculum Vitae");
        this.setSize(800,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //positionnement
        this.setLayout(new FlowLayout());
        lb_title=new JLabel("Curriculum Vitae Form");
        lb_title.setForeground(Color.white);
        lb_title.setBackground(Color.green);
        lb_title.setOpaque(true);
        lb_title.setPreferredSize(new Dimension(800,50));
        lb_title.setHorizontalAlignment(JLabel.CENTER);
        lb_title.setFont(new Font(Font.MONOSPACED,Font.BOLD|Font.ITALIC,30));
        this.add(lb_title);

        lb_nom=new  JLabel("NOM");
        tf_nom= new JTextField(20);

        this.add(lb_nom);
        this.add(tf_nom);

        lb_prenom=new  JLabel("Prenom");
        tf_prenom= new JTextField(20);

        this.add(lb_prenom);
        this.add(tf_prenom);

        btn_valider=new JButton("valider");
        this.add(btn_valider);

        btn_quitter=new JButton("quitter");
        this.add(btn_quitter);

        this.setVisible(true);

        //Event : ecouteur
        btn_quitter.addActionListener(new EcouteurButton());
        btn_valider.addActionListener(new EcouteurButton());
    }

    class EcouteurButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
           if(e.getSource()==btn_quitter){
               System.exit(0);
           }
           if(e.getSource()==btn_valider)
           {
               String nom=tf_nom.getText();
               String prenom=tf_prenom.getText();

               File f=new File("Cv.html");
               try {
                   FileWriter fw=new FileWriter(f,false);
                   fw.write("<html>" +
                           "<title> generative cv </title>"  +
                           "<body> <h2> " + nom + " " + prenom + "</h2> </body>" +
                           "</html>"
                   );
                   fw.close();
                   Desktop.getDesktop().open(f);
               } catch (IOException ex) {
                   throw new RuntimeException(ex);
               }
           }
        }
    }
}
// Jliste multiselection

// Jradionutton
// JCombobox


// Jcalender
// JFilechoser
// Jcolorchoser
// generer pdf