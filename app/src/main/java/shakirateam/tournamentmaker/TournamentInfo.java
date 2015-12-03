package shakirateam.tournamentmaker;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;
import android.view.View;


/**
 * Created by Dylan on 2015-12-03.
 */
public class TournamentInfo extends Activity {


    String tournamentName="Tournament Name";
    String tournamentType="Type";
    String tournamentGender="Gender";
    String tournamentActive="Active";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournament_info);

        tournamentName=getIntent().getStringExtra("selectedTournament");

        TextView tournamentTitle = (TextView ) findViewById(R.id.txtTournamentName);
        tournamentTitle.setText(tournamentName);

    }

    public void openTournamentGames(View view) {

        Intent intent = new Intent(getApplicationContext(), Games.class); //Application Context and Activity
        intent.putExtra("selectedTournament",tournamentName);
        startActivityForResult(intent, 0);

    }



}
