package shakirateam.tournamentmaker;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Mark on 2015-12-04.
 */
public class Tournament implements Serializable {
    private ArrayList<Team> teams = new ArrayList<Team>();//Teams involved in the tournament
    private boolean Gender;//Gender of the tournament
    private String TOURNAMENT_TYPE;//Knockout, Round robin, combination
    private String password;//Password in order to change tournament settings
    private boolean isActive = false;//Activity of the tournament (as in whether settings can or can't be changed)


    /**
     * Constructor to be used on initial Tournament creation
     * @param type Tournament Type
     * @param gender Gender of the tournament
     * @param password Password to be inputted in order to change settings
     */
    public Tournament(String type, boolean gender,boolean active, String password){
        Gender = gender;
        TOURNAMENT_TYPE = type;
        this.password = password;
    }

    /**
     * Constructor to be used when loading previously created tournaments
     * NOT FOR INITIAL CREATION
     * @param type Tournament Type
     * @param gender Gender of the tournament
     * @param activity Whether or not the tournament isActive
     * @param password Password to be inputted in order to change settings
     * @param teams The ArrayList of teams involved in this tournament
     */
    public Tournament (String type, boolean gender, boolean activity, String password, ArrayList<Team> teams){
        Gender = gender;
        isActive = activity;
        TOURNAMENT_TYPE = type;
        this.password = password;
        this.teams = teams;
    }

    /**
     * Get the gender of the tournament
     * @return Gender
     */
    public boolean getGender(){
        return Gender;
    }
    public String getType(){
        return TOURNAMENT_TYPE;
    }
    public String getPassword(){
        return password;
    }
    /**
     * Set the gender of the tournament (Should not really change, but just in case)
     * Resets the teams ArrayList
     * @param gender
     */
    public void setGender(boolean gender){
        Gender = gender;
        teams = new ArrayList<>();
    }

    /**
     * For adding teams to a tournament
     * @param toadd The team to be added
     */
    public void addTeam(Team toadd){

        if (!teams.contains(toadd))
            teams.add(toadd);
    }


    /**
     * For removing a team from a tournament
     * @param toRemove
     */
    public void removeTeam(Team toRemove){
        teams.remove(toRemove);
    }

    public int getNumTeams(){
        return teams.size();
    }

    public ArrayList<Team> teamsList(){
        return teams;
    }

    /**
     * Sets whether or not the tournament is active
     * @param active
     */
    public void setActive(boolean active){
        isActive = active;
    }

    /**
     * Get the tournament's activity
     * @return
     */
    public boolean getActivity(){
        return isActive;
    }

    /**
     * Get the tournament information as a String
     * Everything is separated by colons (:)
     * @return All tournament info in a String
     */
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(TOURNAMENT_TYPE + ":" + Gender + ":" + isActive + ":" + password + ":");
        for (Team t : teams) {
            buffer.append(t.getId() + ":");
        }
        return buffer.toString();
    }
}
