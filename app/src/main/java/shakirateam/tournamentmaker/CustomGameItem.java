package shakirateam.tournamentmaker;

/**
 * Created by Dylan on 2015-12-02.
 */
public class CustomGameItem {
    private String team1;
    private String team2;
    private int logo1;
    private int logo2;

    public CustomGameItem(String team1, String team2, int logo1, int logo2) {
        this.team1 = team1;
        this.team2 = team2;
        this.logo1 = logo1;
        this.logo2 = logo2;
    }

    public String getTeam1() {
        return team1;
    }

    public String getTeam2() {
        return team2;
    }

    public int getLogo1() {
        return logo1;
    }

    public int getLogo2() {
        return logo2;
    }

}
