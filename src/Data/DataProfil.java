package Data;

import java.util.ArrayList;

public class DataProfil {

    ArrayList<Profil> data;

    public DataProfil() {
        this.data = new ArrayList<>();
    }

    public void addProfile(Profil p) {
        this.data.add(p);
    }


    public Profil getProfilByPseudo(String pseudo) {
        for (Profil p : data) {
            if (p.getPseudo().equals(pseudo)) {
                return p;
            }
        }
        return null;
    }
}

