package shakirateam.tournamentmaker;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private ArrayList<Tournament> tournaments = new ArrayList<Tournament>();
    private ArrayList<Team> teams = new ArrayList<Team>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // When implementing the real code, the ListAdapter will take values from Tourney Instances

        Button plus = (Button) findViewById(R.id.create);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CreationChooser.class));
            }
        });

        String TESTtypeOfTournament[] = {
                "Knockout",
                "Round Robin",
                "Combination",
        };

        boolean TESTgenders[] = {
                true,
                false,
                false,
        };

        boolean TESTactives[] ={
                true,
                false,
                false
        };
        String TESTpasswords[] = {
                "",
                "123",
                "321",
        };
        Team TESTteams[]={
           new Team("Team1","ic_logo_01",true),
           new Team("Team2","ic_logo_02",false),
           new Team("Team3","ic_logo_03",false),

        };

        ArrayList<Team> testteams = new ArrayList<Team>();
            testteams.add(TESTteams[0]);
            testteams.add(TESTteams[1]);
            testteams.add(TESTteams[2]);

        teams=testteams;

        String numberOfTeams[] = {"Teams Registered: 2", "Teams Registered: 3",
                "Teams Registered: 6"} ;

        //input Test values for 3 tournaments
    for(int i=0;i<3;i++) {

         tournaments.add(new Tournament(TESTtypeOfTournament[i],TESTgenders[i],TESTactives[i],TESTpasswords[i],testteams));
    }






        Scanner fileScan = null;//filescanner is made

        boolean found = true; //setting true, assume file exists
        File tournamentsfile = new File("tournaments.txt");
        try {//tries searching for file indictaed

            fileScan = new Scanner(tournamentsfile);
        }
        catch (FileNotFoundException exception) {
            found = false;
        }

        if(found==true){
           tournaments = readTournamentFile(tournamentsfile);
        }
        else{

            writeTournamentsFile();
        }


        updateTournamentList(tournaments);


        writeTeamFile();




    }// end onCreate method


    public void updateTournamentList(ArrayList<Tournament> newTournamentList) {
        tournaments=newTournamentList;

        // All ListAdapter items: name of tournament, type of tournament, gender, number of teams
        // First: name of tournament from listOfTournamentNames
        ArrayList<CustomTournamentItem> items = new ArrayList<CustomTournamentItem>();

        // Add all the values into the array list
        for(int i = 0; i < tournaments.size(); i++) {
            String g;
            if (tournaments.get(i).getGender()==(true))
                g = "Mens";
            else
                g = "Womens";
            items.add(new CustomTournamentItem("Tournament "+i, tournaments.get(i).getType(),g, "3"));
        }

        TournamentListAdapter customAdapter = new TournamentListAdapter(this, items);

        // Scrollable list of items
        ListView listView = (ListView) findViewById(R.id.tournamentListView);

        // Tells the ListView what data to use
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> tourneyView, View view, int position, long id) {

                String tournamentPicked = String.valueOf(tourneyView.getItemAtPosition(position));

                openTournamentInfo(position);

            }
        });


    }



    public void openTournamentInfo(int TPicked) {
        String TPickedstr= String.valueOf(TPicked);
        Bundle extra = new Bundle();
        extra.putSerializable("tournamentsList", tournaments );

        Intent intent = new Intent(getApplicationContext(), TournamentInfo.class); //Application Context and Activity
        intent.putExtra("selectedTournament",TPickedstr);
        intent.putExtra("extra",extra);

        startActivityForResult(intent, 0);

    }

    public void openTournamentCreator(View view) {


        Intent intent = new Intent(getApplicationContext(), CreationChooser.class); //Application Context and Activity
        startActivityForResult(intent, 0);

    }

    public void openTeams(View view) {


        Intent intent = new Intent(getApplicationContext(), Teams.class); //Application Context and Activity
        startActivityForResult(intent, 0);

    }

    public void addTournament(Tournament t){
        tournaments.add(t);
    }



    /**
     * Parses tournament information into an array
     * @param file
     * @return ArrayList<Tournament>
     */
    public ArrayList<Tournament> readTournamentFile(File file){
        ArrayList<Tournament> tourny = new ArrayList<>();

        try {

            Scanner scanner = new Scanner(file);
            scanner.useDelimiter(":");


            String type, gender, active, password;

            ArrayList<Team> tournamentteams = new ArrayList<>();


            Boolean g, a;
            while(scanner.hasNext()) {

                tournamentteams = null;

                type = scanner.next();
                gender = scanner.next();
                if (gender.equals("male"))
                    g = true;
                else
                    g = false;

                active = scanner.next();
                if (active.equals("true"))
                    a = true;
                else
                    a = false;

                password = scanner.next();

                while (scanner.hasNextInt()){
                    tournamentteams.add(teams.get(scanner.nextInt()));
                }

                tourny.add(new Tournament(type, g, a, password, teams));
            }
        } catch (Exception e) {
            System.out.println("Error reading file...");
        }
        return tourny;
    }

    public ArrayList<Team> readTeams(File file){

        ArrayList<Team> teams = new ArrayList<>();
        try{
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter(":");

            String name, gender, logo;

            Boolean g;
            Boolean exit = false;
            while(scanner.hasNext()) {

                name = scanner.next();
                logo = scanner.next();
                gender = scanner.next();
                if (gender.equals("male"))
                    g = true;
                else
                    g = false;

                teams.add(new Team(name,logo,g));
            }

        } catch (Exception e) {
            System.out.println("Error reading file...");
        }

        return teams;
    }








    public void writeTournamentsFile() {
        String file = "tournaments.txt";
        try {
            FileOutputStream outputStream = openFileOutput(file, Context.MODE_PRIVATE);
            for (int i = 0; i <=(tournaments.size()); i++){
                outputStream.write((tournaments.get(i).toString()).getBytes());

            }

            outputStream.write(("!").getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public void writeTeamFile() {
        String file = "teams.txt";
        try {
            FileOutputStream outputStream = openFileOutput(file, Context.MODE_PRIVATE);
            for (int i = 0; i <=(teams.size()); i++){
                outputStream.write((teams.get(i).toString()).getBytes());

            }

            outputStream.write(("!").getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_CANCELED) return;

        if (requestCode == 0) {

        }
        if (requestCode == 1) {

        }
        if (requestCode == 2) {

        }






    }




}// end MainActivity class
