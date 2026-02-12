package IHM;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MyPopUpMenu extends JPopupMenu {
    JMenuItem modifier,supprimer,supprimer_tout;
    GestionProfils gp;

    public MyPopUpMenu(GestionProfils gestionProfils) {
        this.gp = gestionProfils;

        this.modifier = new JMenuItem("Modifier");
        this.supprimer = new JMenuItem("Supprimer");
        this.supprimer_tout = new JMenuItem("Supprimer tout");

        this.add(modifier);
        this.add(supprimer);
        this.add(supprimer_tout);

        this.supprimer_tout.addActionListener(new  ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                gp.model.clear();
                gp.jtp.removeAll();
            }
        });

        this.supprimer.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int index = gp.jl.getSelectedIndex();
                String Pseudo = gp.jl.getSelectedValue();
                gp.model.remove(index);


                for (int i = gp.jtp.getTabCount() - 1; i >= 0; i--) {
                    if (gp.jtp.getTitleAt(i).equals(Pseudo)) {
                        gp.jtp.removeTabAt(i);
                    }
                }

            }
        });

    }
}
