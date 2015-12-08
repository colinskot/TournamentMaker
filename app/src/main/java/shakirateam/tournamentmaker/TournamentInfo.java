package shakirateam.tournamentmaker;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

import java.util.ArrayList;


/**
 * Created by Dylan on 2015-12-03.
 */
public class TournamentInfo extends Activity {

    private Tournament tournament;
    private ArrayList<Team> teams;
    private ArrayList<Team> totalTeams;
    String tournamentName="Tournament Name";
    int TournamentName=0;
    String tournamentType="Type";
    String tournamentGender="Gender";
    boolean tournamentActiveboolean=false;
    int teamsRegistered=0;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournament_info);

        Bundle extra = getIntent().getBundleExtra("extra");
        //Bundle team = getIntent().getBundleExtra("team");

        tournament = (Tournament) extra.getSerializable("tournament");
        teams = tournament.teamsList();



        tournamentName="Tournament";
        //TournamentName = Integer.parseInt(tournamentName);
        tournamentType=tournament.getType();
        tournamentGender = "Womens";
        if (tournament.getGender() == true)
            tournamentGender = "Mens";

        String tournamentActive=String.valueOf(tournament.getActivity());


        TextView tournamentTitle = (TextView ) findViewById(R.id.txtTournamentName);
        tournamentTitle.setText("Tournament");
        TextView tournamentTypeText = (TextView ) findViewById(R.id.txtTournamentType);
        tournamentTypeText.setText(tournamentType);
        TextView tournamentGenderText = (TextView ) findViewById(R.id.txtGender);

        tournamentGenderText.setText(tournamentGender);

        TextView tournamentActiveText = (TextView ) findViewById(R.id.txtActive);

        if(tournamentActive.equals("true")){
            tournamentActiveboolean=true;
            tournamentActiveText.setText("Active");


        }
        else{
            tournamentActiveboolean=false;
            tournamentActiveText.setText("Not Active");
        }



        checkActiveTournament();


    }

    public void checkActiveTournament() {
        Button btnViewGames = (Button) findViewById(R.id.btnViewGames);

        if(tournamentActiveboolean==true){
            TextView tournamentActiveText = (TextView ) findViewById(R.id.txtActive);
            tournamentActiveText.setText("Active");
            //btnViewGames.setEnabled(true);
            btnViewGames.setText("View Games");

            Button btnAddTeam = (Button) findViewById(R.id.btnAddTeam);
            btnAddTeam.setEnabled(false);

            Button btnRemoveTeam = (Button) findViewById(R.id.btnRemoveTeam);
            btnRemoveTeam.setEnabled(false);

            Button btnStart = (Button) findViewById(R.id.btnStart);
            btnStart.setEnabled(false);

            btnStart.setText("Started");
        }
        else {

            //btnViewGames.setEnabled(false);

        }





    }
    public void onClickStart(View view) {

        tournamentActiveboolean=true;
        checkActiveTournament();

    }
    public void onClickDelete(View view) {
        String whattodo= String.valueOf(1);
        Bundle extra = new Bundle();
        extra.putSerializable("tournament", tournament);

        Intent intent = new Intent(getApplicationContext(), PasswordCheck.class); //Application Context and Activity
        intent.putExtra("WHATTODO",whattodo);

        intent.putExtra("extra", extra);

        startActivityForResult(intent, 0);


    }
    public void onClickAdd(View view) {

        Bundle extra = new Bundle();
        Bundle team = new Bundle();
        extra.putSerializable("tournament", tournament);
        extra.putSerializable("teams", teams);

        String whattodo= String.valueOf(2);

        int num=1;
        String numstr= String.valueOf(num);
        Intent intent = new Intent(getApplicationContext(), PasswordCheck.class); //Application Context and Activity
        intent.putExtra("WHATTODO",whattodo);
        intent.putExtra("AddorRemove",numstr);
        intent.putExtra("extra",extra);
        //intent.putExtra("team", team);

        startActivityForResult(intent, 0);

    }
    public void onClickRemove(View view) {

        Bundle extra = new Bundle();
        extra.putSerializable("tournament", tournament);

        String whattodo= String.valueOf(3);

        int num=0;
        String numstr= String.valueOf(num);
        Intent intent = new Intent(getApplicationContext(), PasswordCheck.class); //Application Context and Activity
        intent.putExtra("AddorRemove",numstr);
        intent.putExtra("WHATTODO",whattodo);
        intent.putExtra("extra",extra);
        startActivityForResult(intent, 0);

    }


    public void openTournamentGames(View view) {
        Button btn = (Button) findViewById(R.id.btnViewGames);
        Intent intent;
        Bundle extra;
        if (btn.getText().toString().equals("View Teams")){
            intent =  new Intent(TournamentInfo.this, TournamentTeamsList.class);
            extra = new Bundle();
            extra.putSerializable("tournament", tournament);

            intent.putExtra("extra", extra);
            startActivityForResult(intent, 0);
        }else {
            extra = new Bundle();
            extra.putSerializable("tournament", tournament);

            intent = new Intent(getApplicationContext(), Games.class); //Application Context and Activity

            intent.putExtra("extra", extra);
            startActivity(intent);
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_CANCELED) return;

        if (requestCode == 0) {

        }
        if (requestCode == 1) {

        }
        if (requestCode == 2) {

        }
        if (requestCode == 9){
            tournament = (Tournament) getIntent().getBundleExtra("extra").getSerializable("tournament");
        }






    }






}
