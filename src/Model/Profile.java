package Model;

public class Profile {
    String name;
    String prenom;
    String pseudo;

    public String getPrenom() {
        return prenom;
    }

    public String getPseudo() {
        return pseudo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }


    public Profile() {
        this.name = "";
        this.prenom = "";
        this.pseudo = "";
    }

    public Profile(String name, String prenom, String pseudo) {
        this.name = name;
        this.prenom = prenom;
        this.pseudo = pseudo;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
