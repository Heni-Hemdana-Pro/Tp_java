package IHM;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class EcouteurListner implements ActionListener {

    Dashboard dashboard;

    EcouteurListner(Dashboard dashboard) {
        this.dashboard = dashboard;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == dashboard.itemFlow) {
            FrameFlow frameFlow = new FrameFlow();
            frameFlow.setVisible(true);
            this.dashboard.desktop.add(frameFlow);
        }
        if(e.getSource() == dashboard.itemGrid) {
            FrameGrid frameGrid = new FrameGrid();
            frameGrid.setVisible(true);
            this.dashboard.desktop.add(frameGrid);
        }
        if(e.getSource() == dashboard.itemBorder) {
            FrameBorder frameBorder = new FrameBorder();
            frameBorder.setVisible(true);
            this.dashboard.desktop.add(frameBorder);
        }
        if(e.getSource() == dashboard.itemcv) {
            CreationCV curriculumVitae = new CreationCV();
            curriculumVitae.setVisible(true);
            this.dashboard.desktop.add(curriculumVitae);
        }
        if(e.getSource() == dashboard.itemGP) {
            GestionProfils gestionProfils = new GestionProfils();
            gestionProfils.setVisible(true);
            this.dashboard.desktop.add(gestionProfils);
        }
    }
}
