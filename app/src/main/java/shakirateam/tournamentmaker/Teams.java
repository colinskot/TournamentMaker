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
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class Teams extends Activity{

        public ArrayList<Team> teams = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);

        String listOfTeamNames[] = new String[]{
                "Team 1",
                "Team 2",
                "Team 3",
                "Team 4",
                "Team 5",
                "Team 6",
                "Team 7",
                "Team 8",
                "Team 9",
                "Team 10",
                "Team 11",
                "Team 12"
        };

        String genders[] = new String[] {
                "Male",
                "Female",
                "Female",
                "Male",
                "Male",
                "Male",
                "Female",
                "Male",
                "Female",
                "Female",
                "Male",
                "Female"
        };

        int teamlogos[] = new int[] {
                R.drawable.ic_logo_00,
                R.drawable.ic_logo_01,
                R.drawable.ic_logo_02,
                R.drawable.ic_logo_03,
                R.drawable.ic_logo_04,
                R.drawable.ic_logo_05,
                R.drawable.ic_logo_00,
                R.drawable.ic_logo_01,
                R.drawable.ic_logo_02,
                R.drawable.ic_logo_03,
                R.drawable.ic_logo_04,
                R.drawable.ic_logo_05
        };




        // Each row in the list stores country name, currency and flag
        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();

        for(int i=0;i<12;i++){
            HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("name", listOfTeamNames[i]);
            hm.put("gender", genders[i]);
            hm.put("logo", Integer.toString(teamlogos[i]) );
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
    }
    public void openTeamCreator(View view) {


        Intent intent = new Intent(getApplicationContext(), CreationChooser.class); //Application Context and Activity
        startActivityForResult(intent, 0);

    }
}