package DataBase;

import java.sql.*;

public class Test {
    public static void main(String[] args){
        System.out.println("Start");
        EtudiantImplementation etudiantDAO = new EtudiantImplementation();

        // Insérer quelques étudiants (optionnel)
        etudiantDAO.insertEtudiant(123, "Hemdana", "Heni", 15.5);

        System.out.println("\n=== Affichage des étudiants ===\n");

        // Sélectionner tous les étudiants
        ResultSet rs = etudiantDAO.selectEtudiant("select * from etudiant");

        // Afficher les résultats
        if(rs != null) {
            etudiantDAO.afficherResultset(rs);
        }

        else {
            System.out.println("Aucun résultat trouvé");
        }
    }
}
