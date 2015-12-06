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
    int TournamentName=0;
    String tournamentType="Type";
    String tournamentGender="Gender";
    boolean tournamentActiveboolean=false;
    int teamsRegistered=0;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournament_info);

        tournamentName=getIntent().getStringExtra("selectedTournament");
        TournamentName = Integer.parseInt(tournamentName);
        tournamentType=getIntent().getStringExtra("tournamentType");
        tournamentGender=getIntent().getStringExtra("tournamentGender");
        String tournamentActive=getIntent().getStringExtra("tournamentActive");


        TextView tournamentTitle = (TextView ) findViewById(R.id.txtTournamentName);
        tournamentTitle.setText("Tournament "+TournamentName);
        TextView tournamentTypeText = (TextView ) findViewById(R.id.txtTournamentType);
        tournamentTypeText.setText(tournamentType);
        TextView tournamentGenderText = (TextView ) findViewById(R.id.txtGender);

        if(tournamentGender.equals("true")){

            tournamentGenderText.setText("Mens");
        }
        else{
            tournamentGenderText.setText("Womens");
        }

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

        tournamentActiveboolean=true;
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
