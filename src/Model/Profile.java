package Model;

import java.util.List;

public class Profile {
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String adresse;
    private String sexe;
    private String nationalite;
    private int experienceAnnees;
    private String imagePath;
    private String couleurFavorite;
    private List<String> langues;
    private List<String> competences;
    private List<String> hobbies;
    private boolean permisConduire;
    private boolean disponible;

    // Constructeur
    public Profile() {
        this.couleurFavorite = "#2980b9";
    }

    // Getters et Setters
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }

    public String getSexe() { return sexe; }
    public void setSexe(String sexe) { this.sexe = sexe; }

    public String getNationalite() { return nationalite; }
    public void setNationalite(String nationalite) { this.nationalite = nationalite; }

    public int getExperienceAnnees() { return experienceAnnees; }
    public void setExperienceAnnees(int experienceAnnees) { this.experienceAnnees = experienceAnnees; }

    public String getImagePath() { return imagePath;}
    public void setImagePath(String imagePath) { this.imagePath = imagePath; }

    public String getCouleurFavorite() { return couleurFavorite; }
    public void setCouleurFavorite(String couleurFavorite) { this.couleurFavorite = couleurFavorite; }

    public List<String> getLangues() { return langues; }
    public void setLangues(List<String> langues) { this.langues = langues; }

    public List<String> getCompetences() { return competences; }
    public void setCompetences(List<String> competences) { this.competences = competences; }

    public List<String> getHobbies() { return hobbies; }
    public void setHobbies(List<String> hobbies) { this.hobbies = hobbies; }

    public boolean isPermisConduire() { return permisConduire; }
    public void setPermisConduire(boolean permisConduire) { this.permisConduire = permisConduire; }

    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
}