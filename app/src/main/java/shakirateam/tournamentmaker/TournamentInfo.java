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

    private ArrayList<Tournament> tournaments = new ArrayList<Tournament>();
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

        tournaments = (ArrayList<Tournament>) extra.getSerializable("tournamentsList");



        tournamentName=getIntent().getStringExtra("selectedTournament");
        TournamentName = Integer.parseInt(tournamentName);
        tournamentType=tournaments.get(TournamentName).getType();
        tournamentGender=String.valueOf(tournaments.get(TournamentName).getGender());
        String tournamentActive=String.valueOf(tournaments.get(TournamentName).getActivity());


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
        Bundle extra = new Bundle();
        extra.putSerializable("tournamentsList", tournaments );

        Intent intent = new Intent(getApplicationContext(), PasswordCheck.class); //Application Context and Activity
        intent.putExtra("WHATTODO",whattodo);
        intent.putExtra("TournamentName", tournamentName);
        intent.putExtra("extra",extra);

        startActivityForResult(intent, 0);


    }
    public void onClickAdd(View view) {

        Bundle extra = new Bundle();
        extra.putSerializable("tournamentsList", tournaments );

        String whattodo= String.valueOf(2);

        int num=1;
        String numstr= String.valueOf(num);
        Intent intent = new Intent(getApplicationContext(), PasswordCheck.class); //Application Context and Activity
        intent.putExtra("WHATTODO",whattodo);
        intent.putExtra("AddorRemove",numstr);
        intent.putExtra("extra",extra);
        startActivityForResult(intent, 0);

    }
    public void onClickRemove(View view) {

        Bundle extra = new Bundle();
        extra.putSerializable("tournamentsList", tournaments );

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
        Bundle extra = new Bundle();
        extra.putSerializable("tournamentsList", tournaments );

        Intent intent = new Intent(getApplicationContext(), Games.class); //Application Context and Activity
        intent.putExtra("selectedTournament",tournamentName);
        intent.putExtra("extra",extra);
        startActivityForResult(intent, 0);

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_CANCELED) return;

        if (requestCode == 0) {

        }
        if (requestCode == 1) {

        }
        if (requestCode == 2) {

        }






    }






}
