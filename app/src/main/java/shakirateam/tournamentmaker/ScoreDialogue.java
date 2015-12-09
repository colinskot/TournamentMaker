package shakirateam.tournamentmaker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Colin on 2015-12-04.
 */
public class ScoreDialogue extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.score_popup);

        Button btnConfirmScore = (Button) findViewById(R.id.confirmDialogue);

        final EditText score1 = (EditText) findViewById(R.id.score1);
        final EditText score2 = (EditText) findViewById(R.id.score2);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout(width - 500, (height/3));
    }

    public void openConfirmDialogue(View view) {

        Intent intent = new Intent(getApplicationContext(), ConfirmDialogue.class); //Application Context and Activity

        final EditText score1 = (EditText) findViewById(R.id.score1);
        final EditText score2 = (EditText) findViewById(R.id.score2);



        intent.putExtra("score1", score1.getText().toString());
        intent.putExtra("score2", score2.getText().toString());

        finish();
        startActivityForResult(intent, 0);
    }

}
