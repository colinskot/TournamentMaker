package shakirateam.tournamentmaker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class teamcreator extends AppCompatActivity {
    private ArrayList<Team> teams = new ArrayList<Team>();
    boolean tgender;
    String tname;
    int logo;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teamcreator);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Team Creator");
        setSupportActionBar(toolbar);

        Bundle extra = getIntent().getBundleExtra("extra");
        teams=(ArrayList<Team>) extra.getSerializable("teamsList");


        image = (ImageView) findViewById(R.id.imageView);
        logo = R.drawable.ic_logo_00;
        final RadioGroup teamGender = (RadioGroup) findViewById(R.id.radioGroupGender);
        final EditText teamNametxt = (EditText) findViewById(R.id.teamnametext);
        Button confirm = (Button) findViewById(R.id.confirm_button);
        Button img = (Button) findViewById(R.id.image_button);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tname = teamNametxt.getText().toString();

                if (teamGender.getCheckedRadioButtonId() == R.id.male_radio) {
                    tgender = true;
                } else {
                    tgender = false;
                }

                CreateTeam();

                finish();
            }
        });
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(teamcreator.this, ImageChooser.class), 1);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK){
            logo = Integer.parseInt(data.getExtras().getString("image"));
            System.out.println(logo);




            image.setImageResource(logo);
        }


    }

    public void CreateTeam(){


        teams.add(new Team(tname, logo, tgender));

        Bundle extra = new Bundle();
        extra.putSerializable("teamsList", teams);

        Intent iData = new Intent();
        iData.putExtra("extra",extra);

        setResult(RESULT_OK, iData);


        finish();
    }

}
