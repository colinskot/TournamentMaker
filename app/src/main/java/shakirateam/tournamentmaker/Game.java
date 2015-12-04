package shakirateam.tournamentmaker;

import android.widget.Toast;

/**
 * Created by Mark on 2015-12-04.
 */
public class Game {
    private Team[] teams = new Team[2];

    public Game(){
        teams[0] = null;
        teams[1] = null;
    }

    public Game(Team team){
        teams[0] = team;
    }

    public Game(Team team1, Team team2){
        teams[0] = team1;
        teams[1] = team2;
    }

    public Team inputScore(int score1, int score2){
        if (score1 >= score2)
            return teams[0];
        else
            return teams[1];
    }

    public Team[] getTeams(){
        return teams;
    }

    public int getNumTeams(){
        if (getFirstTeam() == null && getSecondTeam() == null)
            return 0;
        else if (getSecondTeam() == null || getFirstTeam() == null)
            return 1;
        else
            return 2;

    }

    public void setFirstTeam(Team team){
        teams[0] = team;
    }
    public void setSecondTeam(Team team){
        teams[1] = team;
    }

    public Team getFirstTeam(){
        return teams[0];
    }

    public Team getSecondTeam(){
        return teams[1];
    }
}
