package shakirateam.tournamentmaker;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;


/**
 * Created by Dylan on 2015-12-03.
 */
public class TournamentInfo extends Activity {


    String tournamentName="Tournament Name";
    String tournamentType="Type";
    String tournamentGender="Gender";
    boolean tournamentActive=false;
    int teamsRegistered=0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournament_info);

        tournamentName=getIntent().getStringExtra("selectedTournament");

        TextView tournamentTitle = (TextView ) findViewById(R.id.txtTournamentName);
        tournamentTitle.setText(tournamentName);

        checkActiveTournament();


    }

    public void checkActiveTournament() {
        Button btnViewGames = (Button) findViewById(R.id.btnViewGames);

        if(tournamentActive==true){

            btnViewGames.setEnabled(true);

            Button btnAddTeam = (Button) findViewById(R.id.btnAddTeam);
            btnAddTeam.setEnabled(false);

            Button btnRemoveTeam = (Button) findViewById(R.id.btnRemoveTeam);
            btnRemoveTeam.setEnabled(false);

            Button btnStart = (Button) findViewById(R.id.btnStart);
            btnStart.setEnabled(false);

            btnStart.setText("Started");
        }
        else {

            btnViewGames.setEnabled(false);

        }





    }
    public void onClickStart(View view) {

        tournamentActive=true;
        checkActiveTournament();

    }
    public void onClickDelete(View view) {
        String whattodo= String.valueOf(1);

        Intent intent = new Intent(getApplicationContext(), PasswordCheck.class); //Application Context and Activity
        intent.putExtra("WHATTODO",whattodo);
        intent.putExtra("TournamentName",tournamentName);

        startActivityForResult(intent, 0);

    }
    public void onClickAdd(View view) {
        String whattodo= String.valueOf(2);

        int num=1;
        String numstr= String.valueOf(num);
        Intent intent = new Intent(getApplicationContext(), PasswordCheck.class); //Application Context and Activity
        intent.putExtra("WHATTODO",whattodo);
        intent.putExtra("AddorRemove",numstr);
        startActivityForResult(intent, 0);

    }
    public void onClickRemove(View view) {
        String whattodo= String.valueOf(3);

        int num=0;
        String numstr= String.valueOf(num);
        Intent intent = new Intent(getApplicationContext(), PasswordCheck.class); //Application Context and Activity
        intent.putExtra("AddorRemove",numstr);
        intent.putExtra("WHATTODO",whattodo);
        startActivityForResult(intent, 0);

    }

    public void openTournamentGames(View view) {

        Intent intent = new Intent(getApplicationContext(), Games.class); //Application Context and Activity
        intent.putExtra("selectedTournament",tournamentName);
        startActivityForResult(intent, 0);

    }



}
