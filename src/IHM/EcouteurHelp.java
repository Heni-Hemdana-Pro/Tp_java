package IHM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EcouteurHelp extends MouseAdapter {

    GestionProfils gestionProfils ;

    EcouteurHelp(GestionProfils gestionProfils) {
        this.gestionProfils = gestionProfils;
    }

    public void mouseEntered(MouseEvent e) {
        if(e.getSource()==gestionProfils.tfNom){
            this.gestionProfils.lbHelp.setText("  le nom ne doit pas depasser 10 caractere");
        }
        if(e.getSource()==gestionProfils.tfPrenom){
            this.gestionProfils.lbHelp.setText(" le prenom ne doit pas depasser 10 caractere");;
        }
        if(e.getSource()==gestionProfils.tfPseudo){
            this.gestionProfils.lbHelp.setText(" le pseudo doit etre specifique");;
        }
    }

    public void mouseExited(MouseEvent e) {
        this.gestionProfils.lbHelp.setText("Help");
    }

}


//if(e.getSource()==gestionProfils.lbNom) {
//        this.gestionProfils.lbHelp.setText("Help");
//        }
//                if(e.getSource()==gestionProfils.lbPrenom) {
//        this.gestionProfils.lbHelp.setText("Help");
//        }
//                if(e.getSource()==gestionProfils.lbPseudo) {
//
//        this.gestionProfils.lbHelp.setText("Help");