package IHM;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EcouteurLabel extends MouseAdapter {

    GestionProfils gestionProfils ;

    EcouteurLabel(GestionProfils gestionProfils) {
        this.gestionProfils = gestionProfils;
    }


    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() == gestionProfils.lbNom){
            this.gestionProfils.lbNom.setForeground(Color.red);
        }
        if(e.getSource() == gestionProfils.lbPrenom) {
            this.gestionProfils.lbPrenom.setForeground(Color.red);
        }
        if(e.getSource() == gestionProfils.lbPseudo) {
            this.gestionProfils.lbPseudo.setForeground(Color.red);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.gestionProfils.lbNom.setForeground(null);
        this.gestionProfils.lbPrenom.setForeground(null);
        this.gestionProfils.lbPseudo.setForeground(null);
    }



//if(e.getSource()==gestionProfils.lbNom) {
//        this.gestionProfils.lbNom.setForeground(null);
//    }
//        if(e.getSource()==gestionProfils.lbPrenom) {
//        this.gestionProfils.lbPrenom.setForeground(null);
//    }
//        if(e.getSource()==gestionProfils.lbPseudo) {
//        this.gestionProfils.lbPseudo.setForeground(null);
//    }










//    @Override
//    public void mouseExited(MouseEvent e) {
//        if(e.getSource()==gestionProfils.lbPrenom) {
//            this.gestionProfils.lbNom.setForeground(null);
//        }
//    }
//
//    @Override
//    public void mousePressed(MouseEvent e) {
//        if(e.getSource()==gestionProfils.lbPseudo) {
//            this.gestionProfils.lbPseudo.setForeground(null);
//        }
//    }
}
