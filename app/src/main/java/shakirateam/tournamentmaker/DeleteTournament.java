package shakirateam.tournamentmaker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by Dylan on 2015-12-03.
 */
public class DeleteTournament extends Activity {

    private ArrayList<Tournament> tournaments = new ArrayList<Tournament>();
    private Tournament tournament;
    String tournamentName="Tournament";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.deletetournamentpopup);
        Bundle extra = getIntent().getBundleExtra("extra");
        tournaments = (ArrayList<Tournament>) extra.getSerializable("tournaments");
        //tournament = getIntent().getExtra("AddorRemove");

    }

    public void onClickDeleteTournament(View view) {
/**
        tournaments.remove(tournament);

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        Bundle extra = new Bundle();
        extra.putSerializable("tournaments", tournaments);
        startActivity(intent);
 **/
        finish();

    }

}
