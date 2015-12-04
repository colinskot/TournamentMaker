package shakirateam.tournamentmaker;

import java.util.ArrayList;

/**
 * Created by Mark on 2015-12-04.
 */
public class Tournament {
    private ArrayList<Team> teams = new ArrayList<Team>();
    private Boolean Gender;
    private String TOURNAMENT_TYPE;
    private String password;

    public Tournament(String type, Boolean gender, String password){
        Gender = gender;
        TOURNAMENT_TYPE = type;
        this.password = password;
    }

    public Boolean getGender(){
        return Gender;
    }
    public void setGender(Boolean gender){
        Gender = gender;
    }

    public void addTeam(Team toadd){
        if (!teams.contains(toadd))
            teams.add(toadd);
    }
    public void removeTeam(Team toremove){
        teams.remove(toremove);
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(TOURNAMENT_TYPE + ":" + Gender + ":" + password + ":");
        for (Team t : teams) {
            buffer.append(t.toString() + ":");
        }
        return buffer.toString();
    }
}
