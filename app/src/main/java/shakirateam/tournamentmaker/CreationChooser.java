package shakirateam.tournamentmaker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

/**
 * Created by Mark on 2015-11-24.
 */
public class CreationChooser extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

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
                startActivity(new Intent(CreationChooser.this, teamcreator.class));
                finish();
            }
        });

        tournament.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CreationChooser.this, TournamentCreator.class));
                finish();
            }
        });
    }
}
