package shakirateam.tournamentmaker;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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


        }
        else{

        }


    }

}
