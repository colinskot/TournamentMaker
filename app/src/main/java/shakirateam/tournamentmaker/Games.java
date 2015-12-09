package shakirateam.tournamentmaker; /**
* Created by Dylan on 2015-11-23.
*/
import java.util.ArrayList;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class Games extends Activity{


    /*String tournamentName="Tournament Games";
            String listOfTeamNames1[] = new String[]{
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

    String listOfTeamNames2[] = new String[] {
            "Team 13",
            "Team 14",
            "Team 15",
            "Team 16",
            "Team 17",
            "Team 18",
            "Team 19",
            "Team 20",
            "Team 21",
            "Team 22",
            "Team 23",
            "Team 24"
    };

    int teamlogos1[] = new int[] {
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
    int teamlogos2[] = new int[] {
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
    };*/

    ArrayList<Game> games = new ArrayList<>();
    Knockout knockout;
    Tournament tournament;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);

        Bundle extra = getIntent().getBundleExtra("extra");

        tournament = (Tournament) extra.getSerializable("tournament");
        knockout = new Knockout(tournament.teamsList());
        games = knockout.getCurrentStandings();

        extra = new Bundle();


           createUserInterface();


    }

    int picked = -1;

    public void createUserInterface() {
            ArrayList<CustomGameItem> gameItems = new ArrayList<>();


            // Add all the values into the array list
            for(Game g : games) {
                    gameItems.add(new CustomGameItem(g.getFirstTeam().getName(), g.getSecondTeam().getName(), g.getFirstTeam().getLogo(),g.getSecondTeam().getLogo()));
            }


            // Instantiating an adapter to store each items
            // R.layout.listview_layout defines the layout of each item
            customlistadapter adapter = new customlistadapter(this,gameItems);

            // Getting a reference to listview of main.xml layout file
            ListView listView = ( ListView ) findViewById(R.id.listOfGames);

            // Setting the adapter to the listView
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> tourneyView, View view, int position, long id) {

                    picked = position;

                }
            });

            TextView tournamentTitle = (TextView ) findViewById(R.id.tournamentGamesTitle);
            tournamentTitle.setText("Tournament" + " Games");
    }

    public void openScoreDialogue(View view) {

            Intent intent = new Intent(getApplicationContext(), ScoreDialogue.class); //Application Context and Activity
            startActivityForResult(intent, 0);
    }

@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    if (resultCode == RESULT_OK){
        if (requestCode == 0){
            if (picked != -1){
                int score1 = Integer.parseInt(data.getStringExtra("score1"));
                int score2 = Integer.parseInt(data.getStringExtra("score2"));
                knockout.determineWinner(score1, score2, games.get(picked));
            }
        }
    }
}
}
