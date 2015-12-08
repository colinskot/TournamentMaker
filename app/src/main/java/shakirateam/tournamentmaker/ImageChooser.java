package shakirateam.tournamentmaker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by Mark on 2015-12-03.
 */
public class ImageChooser extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.team_image_selection);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout(width - 20, height);



    }


    public void onClick(View v) {

        Intent intent = new Intent(getApplicationContext(), teamcreator.class);

        //int id = rd.getCheckedRadioButtonId();
        String image = null;
        ImageView im = (ImageView) findViewById(R.id.imageView);

        switch (v.getId()) {
            case R.id.myButton:
                intent.putExtra("image", Integer.toString(R.drawable.ic_logo_00));
                setResult(RESULT_OK, intent);
                //Toast.makeText(this, intent.getExtras().getString("image"), Toast.LENGTH_LONG).show();
                finish();
                break;
            case R.id.imageButton:
                intent.putExtra("image", Integer.toString(R.drawable.ic_logo_02));
                setResult(RESULT_OK, intent);
                finish();
                break;
            case R.id.imageButton2:
                intent.putExtra("image", Integer.toString(R.drawable.ic_logo_04));
                setResult(RESULT_OK, intent);
                finish();
                break;
            case R.id.imageButton3:
                intent.putExtra("image", Integer.toString(R.drawable.ic_logo_01));
                setResult(RESULT_OK, intent);
                finish();
                break;
            case R.id.imageButton4:
                intent.putExtra("image", Integer.toString(R.drawable.ic_logo_03));
                setResult(RESULT_OK, intent);
                finish();
                break;
            case R.id.imageButton5:
                intent.putExtra("image", Integer.toString(R.drawable.ic_logo_05));
                setResult(RESULT_OK, intent);
                finish();
                break;
        }

    }
}
