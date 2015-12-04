package shakirateam.tournamentmaker;

import java.util.ArrayList;

/**
 * Created by Mark on 2015-12-04.
 */
public class Tournament {
    private ArrayList<Team> teams = new ArrayList<Team>();
    private boolean Gender;
    private String TOURNAMENT_TYPE;
    private String password;
    private boolean isActive = false;

    public Tournament(String type, boolean gender, String password){
        Gender = gender;
        TOURNAMENT_TYPE = type;
        this.password = password;
    }
    public Tournament (String type, boolean gender, boolean activity, String password, ArrayList<Team> teams){
        Gender = gender;
        isActive = activity;
        TOURNAMENT_TYPE = type;
        this.password = password;
        this.teams = teams;
    }

    public boolean getGender(){
        return Gender;
    }
    public void setGender(boolean gender){
        Gender = gender;
    }

    public void addTeam(Team toadd){
        if (!teams.contains(toadd))
            teams.add(toadd);
    }
    public void removeTeam(Team toremove){
        teams.remove(toremove);
    }

    public void setActive(boolean active){
        isActive = active;
    }
    public boolean getActivity(){
        return isActive;
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(TOURNAMENT_TYPE + ":" + Gender + ":" + isActive + ":" + password + ":");
        for (Team t : teams) {
            buffer.append(t.toString() + ":");
        }
        return buffer.toString();
    }
}
