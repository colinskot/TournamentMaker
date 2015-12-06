package shakirateam.tournamentmaker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

/**
 * Created by Mark on 2015-11-24.
 */
public class TournamentCreator extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.tournamentcreator);

        Button confirm = (Button) findViewById(R.id.tournament_creation_confirmation);

        final EditText password = (EditText) findViewById(R.id.tournament_password);

        final RadioGroup tournamenttype = (RadioGroup) findViewById(R.id.radioGroup2);
        final RadioGroup tournamentgender = (RadioGroup) findViewById(R.id.radioGroup3);


        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Tournament t;

                int typeid = tournamenttype.getCheckedRadioButtonId();

                String type;

                if (typeid == R.id.radioButton2)
                    type = "Knockout";
                else if (typeid == R.id.radioButton)
                    type = "RoundRobin";
                else
                    type = "Combination";

                boolean gender;

                if (tournamentgender.getCheckedRadioButtonId() == R.id.male_radio)
                    gender = true;
                else
                    gender = false;


                t = new Tournament(type, gender, password.getText().toString());
                startActivity(new Intent(TournamentCreator.this, MainActivity.class));
                finish();
            }
        });
    }


}
