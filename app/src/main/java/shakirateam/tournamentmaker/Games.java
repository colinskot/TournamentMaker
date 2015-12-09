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
                games = knockout.getCurrentStandings();
                createUserInterface();
            }
        }
    }
}
}
