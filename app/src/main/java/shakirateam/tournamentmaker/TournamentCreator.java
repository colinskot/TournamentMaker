package shakirateam.tournamentmaker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Mark on 2015-11-24.
 */
public class TournamentCreator extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.tournamentcreator);

        Button confirm = (Button) findViewById(R.id.tournament_creation_confirmation);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TournamentCreator.this, MainActivity.class));
            }
        });
    }
}
