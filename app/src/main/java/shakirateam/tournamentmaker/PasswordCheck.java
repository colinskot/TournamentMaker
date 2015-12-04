package shakirateam.tournamentmaker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.app.Activity;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Dylan on 2015-12-04.
 */
public class PasswordCheck extends Activity {

    String tournamentPassword="";
    String tournamentname="";
    int whatToOpen=0;
    String addOrRemoveStr="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passwordcheck_popup);

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

            }
            else if(whatToOpen==2){
                //open Add Team
                Intent intent = new Intent(getApplicationContext(), AddorRemoveTeamTournament.class); //Application Context and Activity
                intent.putExtra("AddorRemove",addOrRemoveStr);
                startActivityForResult(intent, 0);



            }
            else if(whatToOpen==3){
                //Open Remove Team
                Intent intent = new Intent(getApplicationContext(), AddorRemoveTeamTournament.class); //Application Context and Activity
                intent.putExtra("AddorRemove",addOrRemoveStr);
                startActivityForResult(intent, 0);

            }
            else if(whatToOpen==4){
                //Open Edit Score

            }

        }
        else{

            Toast.makeText(PasswordCheck.this, "Incorrect Password", Toast.LENGTH_SHORT).show();
        }

    }
}
