package DataBase;

import java.sql.*;

public class EtudiantImplementation implements EtudiantDAO{
    Connection con=null;

    public EtudiantImplementation(){
        con=DataBaseConnection.makeConnection();
    }

    @Override
    public int insertEtudiant(int cin, String nom, String prenom, double moyenne) {
        String requete_insertion ="insert into etudiant values(?,?,?,?)";
        if (con!=null){
            try {
                PreparedStatement ps = con.prepareStatement(requete_insertion);
                ps.setInt(1,cin);
                ps.setString(2,nom);
                ps.setString(3,prenom);
                ps.setDouble(4,moyenne);

                int a=ps.executeUpdate();
                if(a>0){
                    System.out.println("insert ok");
                    return a;
                }
            } catch (SQLException e) {
                System.out.println("Erreur d'insertion"+e.getMessage());
            }
        }
        return 0;
    }

    @Override
    public int deleteEtudiant(int cin) {
        String requete_suppression = "delete from etudiant where cin=?";
        if (con!=null){
            try {
                PreparedStatement ps = con.prepareStatement(requete_suppression);
                ps.setInt(1,cin);
                int a = ps.executeUpdate();
                if(a>0){
                    System.out.println("delete ok");
                    return a;
                }
            } catch (SQLException e) {
                System.out.println("Erreur de suppression"+e.getMessage());
            }
        }
        return 0;
    }

    @Override
    public int updateEtudiant(int cin, String nom, String prenom, double moyenne) {
        String requete_modification = "update etudiant set nom=?, prenom=?, moyenne=? where cin=?";
        if (con!=null){
            try {
                PreparedStatement ps = con.prepareStatement(requete_modification);
                ps.setString(1,nom);
                ps.setString(2,prenom);
                ps.setDouble(3,moyenne);
                ps.setInt(4,cin);
                int a = ps.executeUpdate();
                if(a>0){
                    System.out.println("update ok");
                    return a;
                }
            } catch (SQLException e) {
                System.out.println("Erreur de modification"+e.getMessage());
            }
        }
        return 0;
    }


    @Override
    public ResultSet selectEtudiant(String requete_selection) {
        if (con!=null){
            try {
                Statement st= con.createStatement();
                ResultSet rs= st.executeQuery(requete_selection);
                return rs;


            } catch (SQLException e) {
                System.out.println("Erreur de selection"+e.getMessage());
            }
        }
        return null;
    }

    @Override
    public void afficherResultset(ResultSet rs) {
        try {
            ResultSetMetaData rsmd = rs.getMetaData();
            int nbcol = rsmd.getColumnCount();
            for (int i = 0; i < nbcol; i++) {
                System.out.print(rsmd.getColumnName(i+1) + "\t\t\t");
            }
            System.out.println("\n-------|----------|----------------|------");

            while (rs.next()) {
                for (int i = 0; i < nbcol; i++ ) {
                    System.out.print(rs.getObject(i+1) +  "\t\t");
                }
                System.out.println();
            }

        } catch (SQLException e) {
            System.out.println("Erreur d'affichage"+e.getMessage());
        }
    }

}