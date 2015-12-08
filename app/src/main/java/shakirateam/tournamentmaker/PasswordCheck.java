package shakirateam.tournamentmaker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.app.Activity;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Dylan on 2015-12-04.
 */
public class PasswordCheck extends Activity {

    Tournament tournament;
    String tournamentPassword="";
    String tournamentname="";
    int whatToOpen=0;
    String addOrRemoveStr="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passwordcheck_popup);
        Bundle extra = getIntent().getBundleExtra("extra");
        tournament = (Tournament) extra.getSerializable("tournament");
        tournamentPassword = tournament.getPassword();
        if(getIntent().getStringExtra("AddorRemove")!=null) {
             addOrRemoveStr = getIntent().getStringExtra("AddorRemove");

        }
        if(getIntent().getStringExtra("TournamentName")!=null) {
             addOrRemoveStr = getIntent().getStringExtra("AddorRemove");

        }
        String whatToOpenStr = getIntent().getStringExtra("WHATTODO");
        whatToOpen = Integer.parseInt(whatToOpenStr);




    }

    public void onClickEnter(View view) {
        TextView passwordTextbox = (TextView) findViewById(R.id.textboxPassword);
        String inputPassword = passwordTextbox.getText().toString();

        if(inputPassword.equals(tournamentPassword)){
            if(whatToOpen==1){
                //open Delete Tournament
                Intent intent = new Intent(getApplicationContext(), DeleteTournament.class); //Application Context and Activity
                intent.putExtra("TournamentName",tournamentname);

                startActivityForResult(intent, 0);
                finish();
            }
            else if(whatToOpen==2){
                //open Add Team
                Bundle extra = getIntent().getBundleExtra("extra");
                ArrayList<Team> teams = (ArrayList<Team>) extra.getSerializable("teams");
                extra.putSerializable("team", teams);
                extra.putString("whatList", Integer.toString(whatToOpen));
                Intent intent = new Intent(getApplicationContext(), TournamentTeamsList.class); //Application Context and Activity
                intent.putExtra("AddorRemove",addOrRemoveStr);
                intent.putExtra("team", teams);
                intent.putExtra("extra", extra);
                startActivityForResult(intent, 0);


            }
            else if(whatToOpen==3){
                //Open Remove Team
                Intent intent = new Intent(getApplicationContext(), AddorRemoveTeamTournament.class); //Application Context and Activity
                intent.putExtra("AddorRemove",addOrRemoveStr);
                startActivityForResult(intent, 0);
                finish();
            }
            else if(whatToOpen==4){
                //Open Edit Score

            }

        }
        else{

            Toast.makeText(PasswordCheck.this, "Incorrect Password", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK){
            Bundle extra = data.getBundleExtra("extra");
            Tournament t = (Tournament) extra.getSerializable("tournament");
            //Toast.makeText(getApplicationContext(), Integer.toString(t.getNumTeams()), Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, TournamentInfo.class);
            intent.putExtra("extra", extra);
            setResult(RESULT_OK, intent);
            finish();
        }else{
            finish();
        }
    }
}
