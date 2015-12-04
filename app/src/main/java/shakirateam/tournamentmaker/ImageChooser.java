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

        final RadioGroup rd = (RadioGroup) findViewById(R.id.imageradiogroup);

        Button confirm = (Button) findViewById(R.id.imageselectconfirm);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ImageChooser.this, teamcreator.class);

                int id = rd.getCheckedRadioButtonId();
                String image = null;
                ImageView im = (ImageView) findViewById(R.id.imageView);

                if (id == R.id.radioButton7)
                    image = "ic_logo_00";
                else if (id == R.id.radioButton8)
                    image = "ic_logo_00";
                else if (id == R.id.radioButton9)
                    image = "ic_logo_00";
                else if (id == R.id.radioButton6)
                    image = "ic_logo_00";
                else if (id == R.id.radioButton5)
                    image = "ic_logo_00";
                else if (id == R.id.radioButton4)
                    image = "ic_logo_00";

                if (image != null){
                    startActivity(intent.putExtra(image, image));
                }

            }
        });



    }
}
