package shakirateam.tournamentmaker;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // When implementing the real code, the ListAdapter will take values from Tourney Instances
        String listOfTournamentNames[] = {
                "TD Tourney",
                "Other",
                "Randoms",
                "IDK",
                "Tough Shit",
                "Intra",
                "Hardcore",
                "Butterflies",
                "Something",
                "I hope",
                "At this point",
                "It's Scrolling"
        };

        String typeOfTournament[] = {
                "Knockout",
                "Knockout",
                "Round Robin",
                "Combination",
                "Round Robin",
                "Knockout",
                "Round Robin",
                "Round Robin",
                "Knockout",
                "Round Robin",
                "Combination",
                "Combination"
        };

        String genders[] = {
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

        String numberOfTeams[] = {
                "shakirateam.tournamentmaker.Teams Registered: 3",
                "shakirateam.tournamentmaker.Teams Registered: 6",
                "shakirateam.tournamentmaker.Teams Registered: 2",
                "shakirateam.tournamentmaker.Teams Registered: 8",
                "shakirateam.tournamentmaker.Teams Registered: 2",
                "shakirateam.tournamentmaker.Teams Registered: 1",
                "shakirateam.tournamentmaker.Teams Registered: 5",
                "shakirateam.tournamentmaker.Teams Registered: 9",
                "shakirateam.tournamentmaker.Teams Registered: 0",
                "shakirateam.tournamentmaker.Teams Registered: 10",
                "shakirateam.tournamentmaker.Teams Registered: 3",
                "shakirateam.tournamentmaker.Teams Registered: 5"
        };

        // All ListAdapter items: name of tournament, type of tournament, gender, number of teams
        // First: name of tournament from listOfTournamentNames
        ListAdapter theAdapter = new ArrayAdapter<String>(this, R.layout.tournament_row_layout,
                R.id.textView, listOfTournamentNames);

        // Second: type of tournament
        ListAdapter theAdapter2 = new ArrayAdapter<String>(this, R.layout.tournament_row_layout,
                R.id.textView2, typeOfTournament);
        // Third: gender
        ListAdapter theAdapter3 = new ArrayAdapter<String>(this, R.layout.tournament_row_layout,
                R.id.textView3, genders);

        // Fourth: number of teams
        ListAdapter theAdapter4 = new ArrayAdapter<String>(this, R.layout.tournament_row_layout,
                R.id.textView4, numberOfTeams);

        // Scrollable list of items
        ListView listView = (ListView) findViewById(R.id.tournamentView);


        // Tells the ListView what data to use
        listView.setAdapter(theAdapter4);
        listView.setAdapter(theAdapter3);
        listView.setAdapter(theAdapter2);
        listView.setAdapter(theAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> tourneyView, View view, int position, long id) {

                String tournamentPicked = String.valueOf(tourneyView.getItemAtPosition(position))
                        + " Selected";

                Toast.makeText(MainActivity.this, tournamentPicked, Toast.LENGTH_SHORT).show();

            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.

    }// end onCreate method

    public void OpenTeams(View view) {


        Intent intent = new Intent(getApplicationContext(), Teams.class); //Application Context and Activity
        startActivityForResult(intent, 0);
    }
}// end MainActivity class
