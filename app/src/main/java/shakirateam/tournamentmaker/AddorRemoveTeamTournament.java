package shakirateam.tournamentmaker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Dylan on 2015-12-03.
 */
public class AddorRemoveTeamTournament extends Activity {

    String addOrRemoveStr="";
    int addOrRemove=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addorremove_team_tournament);

        addOrRemoveStr=getIntent().getStringExtra("AddorRemove");
        addOrRemove=Integer.parseInt(addOrRemoveStr);

        TextView txtaddOrRemove = (TextView ) findViewById(R.id.txtAddorRemove);
        Button btnaddorremove=(Button) findViewById(R.id.btnAddorRemove);


        if(addOrRemove==1){

           txtaddOrRemove.setText("Enter the Team Name to add:");
            btnaddorremove.setText("Add to Tournament");

        }
        else{

           txtaddOrRemove.setText("Enter the Team Name to remove:");
            btnaddorremove.setText("Remove from Tournament");


        }

    }

    public void onClickAddorRemove(View view) {

        if(addOrRemove==1){

            ArrayList<Team> team = (ArrayList<Team>)getIntent().getBundleExtra("extra").getSerializable("teams");
            Tournament tournament = (Tournament) getIntent().getBundleExtra("extra").getSerializable("tournament");
            Bundle extra = new Bundle();
            extra.putSerializable("teams", team);
            extra.putSerializable("tournament", tournament);
            Intent intent = new Intent(getApplicationContext(), TournamentTeamsList.class);

            intent.putExtra("extra", extra);


            startActivity(intent);
            finish();
        }
        else{

        }


    }

}
