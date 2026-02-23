package Data;

import java.util.HashMap;

public class Profil {
    String nom;
    String prenom;
    String pseudo;
    HashMap<String, Integer> langues;
    String cycleIngenieur;
    HashMap<String, Boolean> annees;

    public Profil(String nom, String prenom, String pseudo) {
        this.nom = nom;
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.langues = new HashMap<>();
        this.annees = new HashMap<>();
        this.cycleIngenieur = "";
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getPseudo() {
        return pseudo;
    }

    public HashMap<String, Integer> getLangues() {
        return langues;
    }

    public String getCycleIngenieur() {
        return cycleIngenieur;
    }

    public HashMap<String, Boolean> getAnnees() {
        return annees;
    }




    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setCycleIngenieur(String cycleIngenieur) {
        this.cycleIngenieur = cycleIngenieur;
    }
}







//    // Méthodes pour gérer les langues
//    public void ajouterLangue(String langue, int niveau) {
//        this.langues.put(langue, niveau);
//    }
//
//    public void supprimerLangue(String langue) {
//        this.langues.remove(langue);
//    }
//
//    // Méthodes pour gérer les années
//    public void setAnnee(String annee, boolean selected) {
//        this.annees.put(annee, selected);
//    }

