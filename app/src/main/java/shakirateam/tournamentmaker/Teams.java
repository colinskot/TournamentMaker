package shakirateam.tournamentmaker; /**
 * Created by Dylan on 2015-11-23.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class Teams extends Activity{

        public ArrayList<Team> teams = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);


        Bundle extra = getIntent().getBundleExtra("extra");
        teams = (ArrayList<Team>) extra.getSerializable("teamsList");

        updateTeamList(teams);



    }

    public void updateTeamList(ArrayList<Team> newTeamList) {

        // Each row in the list stores country name, currency and flag
        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();

        for(int i=0;i<teams.size();i++){
            HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("name", String.valueOf(teams.get(i).getName()));
            String Gender;

            if(teams.get(i).getGender()==true){
                Gender="Mens";

            }
            else{
                Gender="Womens";
            }

            hm.put("gender", Gender);
            hm.put("logo", String.valueOf(teams.get(i).getLogo()) );
            aList.add(hm);
        }

        // Keys used in Hashmap
        String[] from = { "logo","name","gender" };

        // Ids of views in listview_layout
        int[] to = { R.id.logo,R.id.team,R.id.gender};

        // Instantiating an adapter to store each items
        // R.layout.listview_layout defines the layout of each item
        SimpleAdapter adapterT = new SimpleAdapter(getBaseContext(), aList, R.layout.teams_row_layout, from, to);

        // Getting a reference to listview of main.xml layout file
        ListView listView = ( ListView ) findViewById(R.id.listview);

        // Setting the adapter to the listView
        listView.setAdapter(adapterT);


        Bundle extra = new Bundle();
        extra.putSerializable("teamsList", teams);

        Intent intent = new Intent(getApplicationContext(), Teams.class); //Application Context and Activity
        intent.putExtra("extra", extra);
        setResult(0, intent);
   }


    public void openTeamCreator(View view) {

        Bundle extra = new Bundle();
        extra.putSerializable("teamsList", teams);
        Intent intent = new Intent(getApplicationContext(), teamcreator.class); //Application Context and Activity
        intent.putExtra("extra",extra);
        startActivityForResult(intent, 0);

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {



            if (data != null) {
                Bundle extra = data.getBundleExtra("extra");
                teams = (ArrayList<Team>) extra.getSerializable("teamsList");
                updateTeamList(teams);
            }
        }












    }
}