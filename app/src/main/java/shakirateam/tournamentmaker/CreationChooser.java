package shakirateam.tournamentmaker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Mark on 2015-11-24.
 */
public class CreationChooser extends Activity {

    private ArrayList<Tournament> tournaments = new ArrayList<Tournament>();
    private ArrayList<Team> teams = new ArrayList<Team>();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        Bundle extra = getIntent().getBundleExtra("extra");
        tournaments = (ArrayList<Tournament>) extra.getSerializable("tournamentsList");

        Bundle extra2 = getIntent().getBundleExtra("extra2");
        teams=(ArrayList<Team>) extra2.getSerializable("teamsList");

        setContentView(R.layout.creatorpopup);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout(width-20, height/5);

        Button team = (Button) findViewById(R.id.team_creation_button);
        Button tournament = (Button) findViewById(R.id.tournament_creation_button);

        team.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle extra = new Bundle();
                extra.putSerializable("teamsList", teams );

                Intent intent = new Intent(CreationChooser.this, teamcreator.class);
                intent.putExtra("extra",extra);

                startActivity(intent);
                finish();
            }
        });

        tournament.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Bundle extra = new Bundle();
                extra.putSerializable("tournamentsList", tournaments );

                Intent intent = new Intent(CreationChooser.this, TournamentCreator.class);
                intent.putExtra("extra",extra);
                startActivity(intent);
                finish();
            }
        });
    }
}
