package shakirateam.tournamentmaker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

/**
 * Created by Colin on 2015-12-04.
 */

public class ConfirmDialogue extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.confirm_popup);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout(width - 420, (height / 3) - 150);
    }

    public void onCancel(View view){
        finish();
    }

    public void onYes(View view){

        String score1 = getIntent().getExtras().getString("score1");
        String score2 = getIntent().getExtras().getString("score2");

        setResult(RESULT_OK, getIntent());

        finish();
    }
}
