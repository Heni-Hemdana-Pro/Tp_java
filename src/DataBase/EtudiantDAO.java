package DataBase;

import java.sql.ResultSet;

public interface EtudiantDAO {
    int insertEtudiant(int cin,String nom,String prenom,double moyenne);
    int deleteEtudiant(int cin);
    int updateEtudiant(int cin,String nom,String prenom,double moyenne);
    ResultSet selectEtudiant(String requete_selection);
    void afficherResultset(ResultSet rs);
}
