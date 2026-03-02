package Adapter;

import DataBase.EtudiantImplementation;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class EtudiantTableModel extends AbstractTableModel {
    ResultSetMetaData rsmd;
    ArrayList<Object[]> data = new ArrayList<>();
    EtudiantImplementation imp;

    public EtudiantTableModel(ResultSet rs, EtudiantImplementation imp) {
        this.imp = imp;
        try {
            rsmd = rs.getMetaData();
            while(rs.next()) {
                Object[] ligne = new Object[rsmd.getColumnCount()];
                for (int i = 0; i < rsmd.getColumnCount(); i++) {
                    ligne[i] = rs.getObject(i+1);
                }
                data.add(ligne);
            }
        } catch (SQLException e) {
            System.out.println("Erreur constructeur: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        try {
            return rsmd.getColumnCount();  // ← CORRECTION ICI : retourner la valeur !
        } catch (SQLException e) {
            System.out.println("Erreur getColumnCount: " + e.getMessage());
            return 0;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data.get(rowIndex)[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        try {
            return rsmd.getColumnName(column+1);
        } catch (SQLException e) {
            System.out.println("Erreur getColumnName: " + e.getMessage());
            return "Col" + column;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return getColumnName(columnIndex).equalsIgnoreCase("Moyenne");
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        int cin = (Integer) data.get(rowIndex)[0];
        String nom = (String) data.get(rowIndex)[1];
        String prenom = (String) data.get(rowIndex)[2];
        double newMoyenne = Double.parseDouble(aValue.toString());

        int a = imp.updateEtudiant(cin, nom, prenom, newMoyenne);

        if(a > 0) {
            data.get(rowIndex)[columnIndex] = aValue;
            fireTableCellUpdated(rowIndex, columnIndex);
        } else {
            JOptionPane.showMessageDialog(null, "Erreur de modification");
        }
    }

    public void ajouterEtudiant(int cin, String nom, String prenom, double moyenne) {
        int a = imp.insertEtudiant(cin, nom, prenom, moyenne);  // ← insertEtudiant, pas updateEtudiant

        if(a > 0) {
            data.add(new Object[]{cin, nom, prenom, moyenne});
            fireTableDataChanged();
        } else {
            JOptionPane.showMessageDialog(null, "Erreur de l'ajout");
        }
    }

//    public void supprimerEtudiant(int cin) {
//        int a = imp.deleteEtudiant(cin);
//
//        if(a > 0) {
//
//            fireTableDataChanged();
//        } else {
//            JOptionPane.showMessageDialog(null, "Erreur de suppression");
//        }
//    }

    public void supprimerEtudiant(int cin) {
        int a = imp.deleteEtudiant(cin);

        if(a > 0) {
            // Trouver et supprimer la ligne correspondante dans data
            for(int i = 0; i < data.size(); i++) {
                if((Integer)data.get(i)[0] == cin) {
                    data.remove(i);
                    break;
                }
            }
            fireTableDataChanged();
            JOptionPane.showMessageDialog(null, "Étudiant supprimé avec succès!");
        } else {
            JOptionPane.showMessageDialog(null, "Erreur de suppression");
        }
    }
}