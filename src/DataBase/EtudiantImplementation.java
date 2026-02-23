package DataBase;

import java.sql.*;

public class EtudiantImplementation implements EtudiantDAO{
    Connection con=null;

    EtudiantImplementation(){
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
        return 0;
    }

    @Override
    public int updateEtudiant(int cin, String nom, String prenom, double moyenne) {

        return 0;
    }

    @Override
    public ResultSet selectEtudiant(String requete_selection) {
        if (con!=null){
            try {
                Statement st= con.createStatement();
                ResultSet rs= st.executeQuery(requete_selection);
                afficherResultset(rs);
                return rs;


            } catch (SQLException e) {
                System.out.println("Erreur de selection"+e.getMessage());
            }
        }
        return null;
    }

    @Override
    public void afficherResultset(ResultSet rs) {

    }
}