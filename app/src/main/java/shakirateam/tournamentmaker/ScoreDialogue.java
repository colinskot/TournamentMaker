package shakirateam.tournamentmaker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Colin on 2015-12-04.
 */
public class ScoreDialogue extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.score_popup);
    }

    public void openConfirmDialogue(View view) {

        Intent intent = new Intent(getApplicationContext(), ConfirmDialogue.class); //Application Context and Activity
        startActivityForResult(intent, 0);
    }

}
