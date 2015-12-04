package shakirateam.tournamentmaker;

import java.util.ArrayList;

/**
 * Created by Mark on 2015-12-04.
 */
public class TournamentType {


    public Team determineWinner(int s1, int s2, Game game){
        return game.inputScore(s1, s2);
    }


}
