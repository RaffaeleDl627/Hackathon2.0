package model;
import java.util.ArrayList;
public class Utenti extends IscrittoAllaPiattaforma{
    public Team[] teams;

    public Utenti(Team[] teams) {
        this.teams = teams;
    }

    public Team[] getTeams() {
        return teams;
    }

}
