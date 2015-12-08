package shakirateam.tournamentmaker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Mark on 2015-11-24.
 */
public class TournamentCreator extends Activity{

    private ArrayList<Tournament> tournaments = new ArrayList<>();
    String type;
    String passwordstring;
    boolean gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extra = getIntent().getBundleExtra("extra");
        tournaments=(ArrayList<Tournament>) extra.getSerializable("tournamentsList");

        setContentView(R.layout.tournamentcreator);

        Button confirm = (Button) findViewById(R.id.tournament_creation_confirmation);

        final EditText password = (EditText) findViewById(R.id.tournament_password);

        final RadioGroup tournamenttype = (RadioGroup) findViewById(R.id.radioGroup2);
        final RadioGroup tournamentgender = (RadioGroup) findViewById(R.id.radioGroup3);





        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int typeid = tournamenttype.getCheckedRadioButtonId();

                passwordstring= password.getText().toString();

                if (typeid == R.id.radioButton2) {
                    type = "Knockout";
                }
                else if (typeid == R.id.radioButton){
                    type = "Round Robin";
                }

                else {
                    type = "Combination";
                }


                if (tournamentgender.getCheckedRadioButtonId() == R.id.male_radio_tournament) {
                    gender = true;
                }
                else {
                    gender = false;
                }

                CreateTournament();


            }
        });
    }

    public void CreateTournament(){

        Toast.makeText(TournamentCreator.this, tournaments.get(1).getType(), Toast.LENGTH_SHORT).show();

        tournaments.add(new Tournament(type, gender, false, passwordstring));

        Bundle extra = new Bundle();
        extra.putSerializable("tournamentsList", tournaments);

        Intent iData = new Intent();
        iData.putExtra("extra",extra);

        setResult(0,iData);


        finish();
    }

}
