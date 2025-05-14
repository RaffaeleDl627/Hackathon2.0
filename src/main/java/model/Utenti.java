package model;

public class Utenti extends IscrittoAllaPiattaforma{
    private Team[] teams;

    public Utenti(Team[] teams) {
        this.teams = teams;
    }

    public Team[] getTeams() {
        return teams;
    }

}
