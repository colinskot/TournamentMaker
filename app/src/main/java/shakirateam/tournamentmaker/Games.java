package shakirateam.tournamentmaker; /**
 * Created by Dylan on 2015-11-23.
 */
import java.util.ArrayList;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;


public class Games extends Activity{


        String tournamentName="Tournament Games";
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
        };


        @Override
        public void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_games);

                tournamentName=getIntent().getStringExtra("selectedTournament");

               createUserInterface();


        }

        public void createUserInterface() {
                ArrayList<CustomGameItem> gameItems = new ArrayList<CustomGameItem>();


                // Add all the values into the array list
                for(int i = 0; i < listOfTeamNames1.length; i++) {
                        gameItems.add(new CustomGameItem(listOfTeamNames1[i], listOfTeamNames2[i], teamlogos1[i],teamlogos2[i]));
                }


                // Instantiating an adapter to store each items
                // R.layout.listview_layout defines the layout of each item
                customlistadapter adapter = new customlistadapter(this,gameItems);

                // Getting a reference to listview of main.xml layout file
                ListView listView = ( ListView ) findViewById(R.id.listview);

                // Setting the adapter to the listView
                listView.setAdapter(adapter);

                TextView tournamentTitle = (TextView ) findViewById(R.id.tournamentGamesTitle);
                tournamentTitle.setText(tournamentName+" Games");
        }

        public void setInfo(String TName) {
                tournamentName=TName;
                createUserInterface();
        }
}
