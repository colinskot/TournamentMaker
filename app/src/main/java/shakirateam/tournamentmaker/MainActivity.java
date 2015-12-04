package shakirateam.tournamentmaker;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

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



        // All ListAdapter items: name of tournament, type of tournament, gender, number of teams
        // First: name of tournament from listOfTournamentNames
        ArrayList<CustomTournamentItem> items = new ArrayList<CustomTournamentItem>();


        Scanner fileScan = null;//filescanner is made

        boolean found = true; //setting true, assume file exists

        try {//tries searching for file indictaed

            fileScan = new Scanner(new File("tournaments.txt"));
        }
        catch (FileNotFoundException exception) {
            found = false;
        }

        if(found==true){
           tournaments= readTournamentFile();

        }
        else{

            writeTournamentsFile();
        }


        // Add all the values into the array list
        for(int i = 0; i < tournaments.size(); i++) {
            String g;
            if (tournaments.get(i).getGender()==(true))
                g = "male";
            else
                g = "female";
            items.add(new CustomTournamentItem("Tournament "+i, tournaments.get(i).getType(),g, numberOfTeams[i]));
        }


        writeTeamFile();












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

    }// end onCreate method




    public void openTournamentInfo(int TPicked) {
        String TPickedstr= String.valueOf(TPicked);

        Intent intent = new Intent(getApplicationContext(), TournamentInfo.class); //Application Context and Activity
        intent.putExtra("selectedTournament",TPickedstr);
        startActivityForResult(intent, 0);

    }





    public void addTournament(Tournament t){
        tournaments.add(t);
    }



    /**
     * Parses tournament information into an array

     * @return ArrayList<Tournament>
     */

    public ArrayList<Tournament> readTournamentFile(){
        ArrayList<Tournament> tourny = new ArrayList<>();

        try {

            Scanner scanner = new Scanner("tournaments.txt");
            scanner.useDelimiter(":");


            String type, gender, active, password;

            ArrayList<Team> teams = new ArrayList<>();


            Boolean g, a;
            while(scanner.hasNext()) {

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

                teams = readTournamentTeams(scanner);

                tourny.add(new Tournament(type, g, a, password, teams));
            }
        } catch (Exception e) {
            System.out.println("Error reading file...");
        }
        return tourny;
    }







    public ArrayList<Team> readTournamentTeams(Scanner scanner){
        ArrayList<Team> teams = new ArrayList<>();


        String name, gender, logo;
        Boolean g;
        Boolean exit = false;
        while(scanner.hasNext() || exit == true) {

            name = scanner.next();
            if (name.equals("!"))
                exit = true;
            logo = scanner.next();
            gender = scanner.next();
            if (gender.equals("male"))
                g = true;
            else
                g = false;
            teams.add(new Team(name, logo, g));

        }

        return teams;
    }








    public void writeTournamentsFile() {

        try {
            FileOutputStream outputStream = openFileOutput("tournaments.txt", Context.MODE_PRIVATE);
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

        try {
            FileOutputStream outputStream = openFileOutput("teams.txt", Context.MODE_PRIVATE);
            for (int i = 0; i <=(teams.size()); i++){
                outputStream.write((teams.get(i).toString()).getBytes());

            }

            outputStream.write(("!").getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}// end MainActivity class
