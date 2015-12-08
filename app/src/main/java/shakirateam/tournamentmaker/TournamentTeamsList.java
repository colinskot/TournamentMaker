package shakirateam.tournamentmaker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Mark on 2015-12-07.
 */
public class TournamentTeamsList extends Activity{
    private Tournament tournament;
    private ArrayList<Team> teams = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.teams_noplus_layout);

        tournament = (Tournament) getIntent().getBundleExtra("extra").get("tournament");
        teams = (ArrayList<Team>) getIntent().getBundleExtra("extra").get("teams");

        ListView listView = ( ListView ) findViewById(R.id.listview);
        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();
        String names[];
        int logos[];
        String gender[];
        if (teams != null) {
            names = new String[teams.size()];
            logos = new int[teams.size()];
            gender = new String[teams.size()];

            for (int i = 0; i < teams.size(); i++) {
                names[i] = teams.get(i).getName();
                if (teams.get(i).getGender())
                    gender[i] = "Male";
                else
                    gender[i] = "Female";
                logos[i] = 0;
            }


            for (int i = 0; i < teams.size(); i++) {
                HashMap<String, String> hm = new HashMap<String, String>();
                if (teams.get(i).getGender() == tournament.getGender()) {
                    hm.put("name", names[i]);
                    hm.put("gender", gender[i]);
                    hm.put("logo", Integer.toString(logos[i]));
                }
                aList.add(hm);
            }

            // Keys used in Hashmap
            String[] from = {"logo", "name", "gender"};

            // Ids of views in listview_layout
            int[] to = {R.id.logo, R.id.team, R.id.gender};

            SimpleAdapter adapterT = new SimpleAdapter(getBaseContext(), aList, R.layout.teams_row_layout, from, to);

            // Getting a reference to listview of main.xml layout file
            //ListView listView = ( ListView ) findViewById(R.id.listview);

            // Setting the adapter to the listView
            listView.setAdapter(adapterT);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> tourneyView, View view, int position, long id) {

                    //String tournamentPicked = String.valueOf(tourneyView.getItemAtPosition(position));
                    tournament.addTeam(teams.get(position));
                    Bundle extra = new Bundle();
                    extra.putSerializable("tournament", tournament);
                    Intent intent = new Intent(TournamentTeamsList.this, TournamentInfo.class);
                    intent.putExtra("tournament", extra);

                    startActivityForResult(intent, 9);
                    finish();
                }
            });
        }
    }

    private void refreshTeamsList(ArrayList<Team> teams){
        ListView listView = ( ListView ) findViewById(R.id.listview);
        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();
        String names[] = new String[teams.size()];
        int logos[] = new int[teams.size()];
        String gender;
        if (teams.get(0).getGender())
            gender = "Male";
        else
            gender = "Female";

        for (int i = 0; i < teams.size(); i++){
            names[i] = teams.get(i).getName();
            logos[i] = 0;
        }



        for(int i=0;i<teams.size();i++){
            HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("name", names[i]);
            hm.put("gender", gender);
            hm.put("logo", Integer.toString(logos[i]));
            aList.add(hm);
        }

        // Keys used in Hashmap
        String[] from = { "logo","name","gender" };

        // Ids of views in listview_layout
        int[] to = { R.id.logo,R.id.team,R.id.gender};

        SimpleAdapter adapterT = new SimpleAdapter(getBaseContext(), aList, R.layout.teams_row_layout, from, to);

        // Getting a reference to listview of main.xml layout file
        //ListView listView = ( ListView ) findViewById(R.id.listview);

        // Setting the adapter to the listView
        listView.setAdapter(adapterT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 0){
            teams = null;
            teams = ((Tournament)getIntent().getBundleExtra("extra").getSerializable("teams")).teamsList();
            refreshTeamsList(teams);
        }
    }
}
