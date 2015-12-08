package shakirateam.tournamentmaker;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Mark on 2015-12-04.
 */
public class Knockout extends TournamentType implements Serializable {

    private ArrayList<Game> currentStandings = new ArrayList<>();
    private ArrayList<Game> nextStandings = new ArrayList<>();
    private ArrayList<Team> participatingTeams = new ArrayList<>();

    public Knockout(ArrayList<Team> teams){

        participatingTeams = teams;
        int shifted = 0;
        if (participatingTeams.size() % 2 == 1) {
            nextStandings.add(new Game(participatingTeams.get(participatingTeams.size() - 1)));
            shifted = 1;
        }

        for (int i = 0;  i < participatingTeams.size()-shifted; i += 2){
            currentStandings.add(new Game(participatingTeams.get(i), participatingTeams.get(i+1)));
        }
    }

    public ArrayList<Game> getCurrentStandings(){
        return currentStandings;
    }


}
