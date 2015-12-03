package shakirateam.tournamentmaker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

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

        String numberOfTeams[] = {"Games Registered: 2", "Games Registered: 3",
                "Games Registered: 2", "Games Registered: 0", "Games Registered: 9",
                "Games Registered: 1", "Games Registered: 10", "Games Registered: 2",
                "Games Registered: 2", "Games Registered: 5", "Games Registered: 6",
                "Games Registered: 8"};

        // All ListAdapter items: name of tournament, type of tournament, gender, number of teams
        // First: name of tournament from listOfTournamentNames
        ArrayList<CustomTournamentItem> items = new ArrayList<CustomTournamentItem>();

        // Add all the values into the array list
        for(int i = 0; i < listOfTournamentNames.length; i++) {
            items.add(new CustomTournamentItem(listOfTournamentNames[i], typeOfTournament[i], genders[i], numberOfTeams[i]));
        }

        TournamentListAdapter customAdapter = new TournamentListAdapter(this, items);

        // Scrollable list of items
        ListView listView = (ListView) findViewById(R.id.tournamentListView);

        // Tells the ListView what data to use
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> tourneyView, View view, int position, long id) {

                String tournamentPicked = String.valueOf(tourneyView.getItemAtPosition(position))
                        + " Selected";

                Toast.makeText(MainActivity.this, tournamentPicked, Toast.LENGTH_SHORT).show();

                openTournamentInfo(tournamentPicked);

            }
        });

    }// end onCreate method

    public void openTournamentInfo(String TPicked) {

        Intent intent = new Intent(getApplicationContext(), TournamentInfo.class); //Application Context and Activity
        intent.putExtra("selectedTournament",TPicked);
        startActivityForResult(intent, 0);

    }


}// end MainActivity class
