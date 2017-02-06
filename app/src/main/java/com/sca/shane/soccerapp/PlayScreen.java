package com.sca.shane.soccerapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shane on 04/03/2016.
 */
public class PlayScreen extends AppCompatActivity {

    SQLiteDatabase teamDB = null;
    private Event event;
    Player selectedPlayer;
    private String itemSelectedFromDialog;
    LayoutInflater inflater;
    PopupWindow popup;
    LinearLayout linear;
    int numPlayed = 11;

    Player player1;
    Player player2;
    Player player3;
    Player player4;
    Player player5;
    Player player6;
    Player player7;
    Player player8;
    Player player9;
    Player player10;
    Player player11;
    Player player12;
    Player player13;
    Player player14;

    boolean subbing = false;
    String [] benchedArray = {"player12", "player13", "player14"};

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button button10;
    Button button11;

    String actionName;
    String positionName;

    ArrayList<String> receivedBenchedNums;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_screen);
        linear = (LinearLayout) findViewById(R.id.linear);
        Intent activity = getIntent();
        ArrayList<String> receivedShirtNums = activity.getExtras().getStringArrayList("Player Number Array");
        receivedBenchedNums = activity.getExtras().getStringArrayList("Benched Number Array");
        final String message = "Long click player icon to see their name!";
        Toast.makeText(PlayScreen.this, message,
                Toast.LENGTH_LONG).show();
        playerSetup(receivedShirtNums);
    }

    private void insertPlayer(String dbID, String num, String name, String pos)
    {
        teamDB.execSQL("CREATE TABLE IF NOT EXISTS '" + dbID + "' " +
                "(shirtNum integer, name VARCHAR, position VARCHAR" +
                ", actionArea VARCHAR, Goals integer default 0, Fouls integer default 0, Assists integer default 0, Saves integer default 0," +
                " Tackles integer default 0, LostBalls integer default 0, Interceptions integer default 0," +
                " Offsides integer default 0, OOP integer default 0, " +
                "Clearances integer default 0, YellowCards integer default 0, RedCards integer default 0, ShotsOnTarget integer default 0, " +
                "ShotsOffTarget integer default 0, TeamName VARCHAR);");

        teamDB.execSQL("INSERT INTO '" + dbID + "' (shirtNum, name, position, actionArea) VALUES ('" + num +
                "', '" + name + "', '" + pos + "', 'ownBox');");
        teamDB.execSQL("INSERT INTO '" + dbID + "' (actionArea) VALUES ('leftDef');");
        teamDB.execSQL("INSERT INTO '" + dbID + "' (actionArea) VALUES ('rightDef');");
        teamDB.execSQL("INSERT INTO '" + dbID + "' (actionArea) VALUES ('leftMid');");
        teamDB.execSQL("INSERT INTO '" + dbID + "' (actionArea) VALUES ('rightMid');");
        teamDB.execSQL("INSERT INTO '" + dbID + "' (actionArea) VALUES ('leftFwd');");
        teamDB.execSQL("INSERT INTO '" + dbID + "' (actionArea) VALUES ('rightFwd');");
        teamDB.execSQL("INSERT INTO '" + dbID + "' (actionArea) VALUES ('oppBox');");
    }

    private void playerSetup(ArrayList<String> num)
    {
        teamDB = this.openOrCreateDatabase("myTeam",
                MODE_PRIVATE, null);

        String [] [] temp = new String [11] [2];
        String [] playerArray = {"player1", "player2", "player3", "player4", "player5",
                "player6", "player7", "player8", "player9", "player10", "player11" };

        for(int i = 0; i < 11; i++)
        {
            Cursor cursor = teamDB.rawQuery("SELECT name, position FROM players WHERE shirtNum = ?", new String[] { num.get(i) });
            int nameColumn = cursor.getColumnIndex("name");
            int positionColumn = cursor.getColumnIndex("position");
            cursor.moveToFirst();
            String name = cursor.getString(nameColumn);
            String position = cursor.getString(positionColumn);
            temp[i][0] = name;
            temp[i][1] = position;
            insertPlayer(playerArray[i], num.get(i), temp[i][0], temp[i][1]);
        }

        player1 = new Player(temp[0][0], num.get(0), temp[0][1], "player1");
        button1 = (Button) findViewById(R.id.buttonPlayer1);
        button1.setText(num.get(0));

        player2 = new Player(temp[1][0], num.get(1), temp[1][1], "player2");
        button2 = (Button) findViewById(R.id.buttonPlayer2);
        button2.setText(num.get(1));

        player3 = new Player(temp[2][0], num.get(2), temp[2][1], "player3");
        button3 = (Button) findViewById(R.id.buttonPlayer3);
        button3.setText(num.get(2));

        player4 = new Player(temp[3][0], num.get(3), temp[3][1], "player4");
        button4 = (Button) findViewById(R.id.buttonPlayer4);
        button4.setText(num.get(3));

        player5 = new Player(temp[4][0], num.get(4), temp[4][1], "player5");
        button5 = (Button) findViewById(R.id.buttonPlayer5);
        button5.setText(num.get(4));

        player6 = new Player(temp[5][0], num.get(5), temp[5][1], "player6");
        button6 = (Button) findViewById(R.id.buttonPlayer6);
        button6.setText(num.get(5));

        player7 = new Player(temp[6][0], num.get(6), temp[6][1], "player7");
        button7 = (Button) findViewById(R.id.buttonPlayer7);
        button7.setText(num.get(6));

        player8 = new Player(temp[7][0], num.get(7), temp[7][1], "player8");
        button8 = (Button) findViewById(R.id.buttonPlayer8);
        button8.setText(num.get(7));

        player9 = new Player(temp[8][0], num.get(8), temp[8][1], "player9");
        button9 = (Button) findViewById(R.id.buttonPlayer9);
        button9.setText(num.get(8));


        player10 = new Player(temp[9][0], num.get(9), temp[9][1], "player10");
        button10 = (Button) findViewById(R.id.buttonPlayer10);
        button10.setText(num.get(9));

        player11 = new Player(temp[10][0], num.get(10), temp[10][1], "player11");
        button11 = (Button) findViewById(R.id.buttonPlayer11);
        button11.setText(num.get(10));

    }

    public void onClickOptions(View view)
    {
        GridView gridView = new GridView(this);
        final AlertDialog builder = new AlertDialog.Builder(this).create();
        List<String> optionList = new ArrayList<>();
        optionList.add("Save Match Data");
        optionList.add("Return To Main Menu");
        optionList.add("Substitute Player");

        gridView.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, optionList));
        gridView.setNumColumns(1);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String option = parent.getItemAtPosition(position).toString();

                if (option.equals("Save Match Data")) {
                    saveInCSV();
                } else if (option.equals("Return To Main Menu")) {
                    goToMenu();
                } else {
                    final String message = "Click the player to be subbed.";
                    Toast.makeText(PlayScreen.this, message,
                            Toast.LENGTH_LONG).show();
                    subbing = true;
                }

                builder.dismiss();
            }
        });

        builder.setView(gridView);
        builder.setTitle("Options");
        builder.show();
    }

    void goToMenu()
    {
        Intent menuIntent = new Intent(this, MainMenu.class);
        final int result = 1;
        startActivity(menuIntent);
    }


    void displayBench(Button b, Player p)
    {
        final Player player = p;
        final Button btn = b;
        GridView gridView = new GridView(this);
        final AlertDialog builder = new AlertDialog.Builder(this).create();
        List<String> benchList = new ArrayList<>();

        for(int i = 0; i < receivedBenchedNums.size(); i++) {
            Cursor cursor = teamDB.rawQuery("SELECT name FROM players WHERE shirtNum = ?", new String[]{receivedBenchedNums.get(i)});
            int nameColumn = cursor.getColumnIndex("name");
            cursor.moveToFirst();
            String name = cursor.getString(nameColumn);
            benchList.add(name);
        }

        gridView.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, benchList));
        gridView.setNumColumns(1);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String option = parent.getItemAtPosition(position).toString();
                addSubPlayer(option, btn, player);
                builder.dismiss();
            }
        });


        builder.setView(gridView);
        builder.setTitle("Select The Substitute");
        builder.show();
    }

    void addSubPlayer(String s, Button b, Player p)
    {
        numPlayed++;
        Cursor cursor = teamDB.rawQuery("SELECT name, position, shirtNum FROM players WHERE name = ?", new String[] { s });
        int nameColumn = cursor.getColumnIndex("name");
        int positionColumn = cursor.getColumnIndex("position");
        int numColumn = cursor.getColumnIndex("shirtNum");
        cursor.moveToFirst();
        String name = cursor.getString(nameColumn);
        String position = cursor.getString(positionColumn);
        String shirtNum = cursor.getString(numColumn);
        String playerID = "player" + numPlayed;
        insertPlayer(playerID, shirtNum, name, position);
        p.setPlayerNum(shirtNum);
        p.setName(name);
        p.setPosition(position);
        b.setText(shirtNum);
        subbing = false;
    }

    private void showAlertDialog() {

        GridView gridView = new GridView(this);
        final AlertDialog builder = new AlertDialog.Builder(this).create();
        List<String> actionList = new ArrayList<>();
        actionList.add("Goal");
        actionList.add("Assist");
        actionList.add("Lost Ball");
        actionList.add("Save");
        actionList.add("Offside");
        actionList.add("Clearance");
        actionList.add("Tackle");
        actionList.add("Foul");
        actionList.add("Interception");
        actionList.add("Yellow Card");
        actionList.add("Red Card");
        actionList.add("OOP");
        actionList.add("Shot On Target");
        actionList.add("Shot Off Target");

        gridView.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, actionList));
        gridView.setNumColumns(2);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                itemSelectedFromDialog = parent.getItemAtPosition(position).toString();
                event.setAction(itemSelectedFromDialog);
                saveData();
                builder.dismiss();
            }
        });

        builder.setView(gridView);
        builder.setTitle("Actions");
        builder.show();
    }

    public void saveData()
    {
        actionName = event.getTableName(itemSelectedFromDialog);
        positionName = event.getPosition();
        int playerNum = event.getPlayerNum();
        String currentPlayer = selectedPlayer.getPlayerID();

        try
        {
            teamDB = this.openOrCreateDatabase("myTeam",
                    MODE_PRIVATE, null);

            teamDB.execSQL("UPDATE '" + currentPlayer + "' SET " + actionName + " = " + actionName + " + 1 " + " WHERE actionArea = ? ",
                    new String[] { positionName } );
            if(actionName.equals("Goals"))
                    teamDB.execSQL("UPDATE '" + currentPlayer + "' SET shotsOnTarget = shotsOnTarget  + 1 " + " WHERE actionArea = ? ",
                    new String[] { positionName } );
        }
        catch(Exception e){}
    }

    public void onPlayer1Click(View view) {

        String toastName = player1.getName();
        final String toastMessage = "You have selected " + toastName + ".";
        Toast.makeText(PlayScreen.this, toastMessage,
                Toast.LENGTH_SHORT).show();

        Button b = (Button) view;
        if(!subbing) {

            String playerNum = b.getText().toString();
            event = new Event();
            event.setPlayerNum(playerNum);
            selectedPlayer = player1;
            b.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    selectedPlayer = player1;
                    final String name = selectedPlayer.getName();
                    Toast.makeText(PlayScreen.this, name,
                            Toast.LENGTH_SHORT).show();
                    return true;
                }
            });
        }
        else{

            displayBench(b, player1);
        }
    }

    public void onPlayer2Click(View view) {

        String toastName = player2.getName();
        final String toastMessage = "You have selected " + toastName + ".";
        Toast.makeText(PlayScreen.this, toastMessage,
                Toast.LENGTH_SHORT).show();

        Button b = (Button) view;
        if(!subbing) {

            String playerNum = b.getText().toString();
            event = new Event();
            event.setPlayerNum(playerNum);
            selectedPlayer = player2;
            b.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    selectedPlayer = player2;
                    final String name = selectedPlayer.getName();
                    Toast.makeText(PlayScreen.this, name,
                            Toast.LENGTH_SHORT).show();
                    return true;
                }
            });
        }
        else{

            displayBench(b, player2);
        }
    }

    public void onPlayer3Click(View view) {

        String toastName = player3.getName();
        final String toastMessage = "You have selected " + toastName + ".";
        Toast.makeText(PlayScreen.this, toastMessage,
                Toast.LENGTH_SHORT).show();

        Button b = (Button) view;
        if(!subbing) {

            String playerNum = b.getText().toString();
            event = new Event();
            event.setPlayerNum(playerNum);
            selectedPlayer = player3;
            b.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    selectedPlayer = player3;
                    final String name = selectedPlayer.getName();
                    Toast.makeText(PlayScreen.this, name,
                            Toast.LENGTH_SHORT).show();
                    return true;
                }
            });
        }
        else{

            displayBench(b, player3);
        }
    }

    public void onPlayer4Click(View view) {

        String toastName = player4.getName();
        final String toastMessage = "You have selected " + toastName + ".";
        Toast.makeText(PlayScreen.this, toastMessage,
                Toast.LENGTH_SHORT).show();

        Button b = (Button) view;
        if(!subbing) {

            String playerNum = b.getText().toString();
            event = new Event();
            event.setPlayerNum(playerNum);
            selectedPlayer = player4;
            b.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    selectedPlayer = player4;
                    final String name = selectedPlayer.getName();
                    Toast.makeText(PlayScreen.this, name,
                            Toast.LENGTH_SHORT).show();
                    return true;
                }
            });
        }
        else{

            displayBench(b, player4);
        }
    }

    public void onPlayer5Click(View view) {

        String toastName = player5.getName();
        final String toastMessage = "You have selected " + toastName + ".";
        Toast.makeText(PlayScreen.this, toastMessage,
                Toast.LENGTH_SHORT).show();

        Button b = (Button) view;
        if(!subbing) {

            String playerNum = b.getText().toString();
            event = new Event();
            event.setPlayerNum(playerNum);
            selectedPlayer = player5;
            b.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    selectedPlayer = player5;
                    final String name = selectedPlayer.getName();
                    Toast.makeText(PlayScreen.this, name,
                            Toast.LENGTH_SHORT).show();
                    return true;
                }
            });
        }
        else{

            displayBench(b, player5);
        }
    }

    public void onPlayer6Click(View view) {

        String toastName = player6.getName();
        final String toastMessage = "You have selected " + toastName + ".";
        Toast.makeText(PlayScreen.this, toastMessage,
                Toast.LENGTH_SHORT).show();

        Button b = (Button) view;
        if(!subbing) {

            String playerNum = b.getText().toString();
            event = new Event();
            event.setPlayerNum(playerNum);
            selectedPlayer = player6;
            b.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    selectedPlayer = player6;
                    final String name = selectedPlayer.getName();
                    Toast.makeText(PlayScreen.this, name,
                            Toast.LENGTH_SHORT).show();
                    return true;
                }
            });
        }
        else{

            displayBench(b, player6);
        }
    }

    public void onPlayer7Click(View view) {

        String toastName = player7.getName();
        final String toastMessage = "You have selected " + toastName + ".";
        Toast.makeText(PlayScreen.this, toastMessage,
                Toast.LENGTH_SHORT).show();

        Button b = (Button) view;
        if(!subbing) {

            String playerNum = b.getText().toString();
            event = new Event();
            event.setPlayerNum(playerNum);
            selectedPlayer = player7;
            b.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    selectedPlayer = player7;
                    final String name = selectedPlayer.getName();
                    Toast.makeText(PlayScreen.this, name,
                            Toast.LENGTH_SHORT).show();
                    return true;
                }
            });
        }
        else{

            displayBench(b, player7);
        }
    }

    public void onPlayer8Click(View view) {

        String toastName = player8.getName();
        final String toastMessage = "You have selected " + toastName + ".";
        Toast.makeText(PlayScreen.this, toastMessage,
                Toast.LENGTH_SHORT).show();

        Button b = (Button) view;
        if(!subbing) {

            String playerNum = b.getText().toString();
            event = new Event();
            event.setPlayerNum(playerNum);
            selectedPlayer = player8;
            b.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    selectedPlayer = player8;
                    final String name = selectedPlayer.getName();
                    Toast.makeText(PlayScreen.this, name,
                            Toast.LENGTH_SHORT).show();
                    return true;
                }
            });
        }
        else{

            displayBench(b, player8);
        }
    }

    public void onPlayer9Click(View view) {

        String toastName = player9.getName();
        final String toastMessage = "You have selected " + toastName + ".";
        Toast.makeText(PlayScreen.this, toastMessage,
                Toast.LENGTH_SHORT).show();

        Button b = (Button) view;
        if(!subbing) {

            String playerNum = b.getText().toString();
            event = new Event();
            event.setPlayerNum(playerNum);
            selectedPlayer = player9;
            b.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    selectedPlayer = player9;
                    final String name = selectedPlayer.getName();
                    Toast.makeText(PlayScreen.this, name,
                            Toast.LENGTH_SHORT).show();
                    return true;
                }
            });
        }
        else{

            displayBench(b, player9);
        }
    }

    public void onPlayer10Click(View view) {

        String toastName = player10.getName();
        final String toastMessage = "You have selected " + toastName + ".";
        Toast.makeText(PlayScreen.this, toastMessage,
                Toast.LENGTH_SHORT).show();

        Button b = (Button) view;
        if(!subbing) {

            String playerNum = b.getText().toString();
            event = new Event();
            event.setPlayerNum(playerNum);
            selectedPlayer = player10;
            b.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    selectedPlayer = player10;
                    final String name = selectedPlayer.getName();
                    Toast.makeText(PlayScreen.this, name,
                            Toast.LENGTH_SHORT).show();
                    return true;
                }
            });
        }
        else{

            displayBench(b, player10);
        }
    }

    public void onPlayer11Click(View view) {

        String toastName = player11.getName();
        final String toastMessage = "You have selected " + toastName + ".";
        Toast.makeText(PlayScreen.this, toastMessage,
                Toast.LENGTH_SHORT).show();

        Button b = (Button) view;
        if(!subbing) {

            String playerNum = b.getText().toString();
            event = new Event();
            event.setPlayerNum(playerNum);
            selectedPlayer = player11;
            b.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    selectedPlayer = player11;
                    final String name = selectedPlayer.getName();
                    Toast.makeText(PlayScreen.this, name,
                            Toast.LENGTH_SHORT).show();
                    return true;
                }
            });
        }
        else{

            displayBench(b, player11);
        }
    }

    public void onOwnBoxClick(View view) {

        if(selectedPlayer != null)
        {
            event.setPosition("ownBox");
            showAlertDialog();
        }
        else{
            Toast.makeText(PlayScreen.this, "Please select a player first",
                    Toast.LENGTH_SHORT).show();
        }

    }

    public void onLeftDefClick(View view) {

        if(selectedPlayer != null)
        {
            event.setPosition("leftDef");
            showAlertDialog();
        }
        else{
            Toast.makeText(PlayScreen.this, "Please select a player first",
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void onRightDefClick(View view) {

        if(selectedPlayer != null)
        {
            event.setPosition("rightDef");
            showAlertDialog();
        }
        else{
            Toast.makeText(PlayScreen.this, "Please select a player first",
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void onLeftMidClick(View view) {

        if(selectedPlayer != null)
        {
            event.setPosition("leftMid");
            showAlertDialog();
        }
        else{
            Toast.makeText(PlayScreen.this, "Please select a player first",
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void onLeftFwdClick(View view) {

        if(selectedPlayer != null)
        {
            event.setPosition("leftFwd");
            showAlertDialog();
        }
        else{
            Toast.makeText(PlayScreen.this, "Please select a player first",
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void onRightFwdClick(View view) {

        if(selectedPlayer != null)
        {
            event.setPosition("rightFwd");
            showAlertDialog();
        }
        else{
            Toast.makeText(PlayScreen.this, "Please select a player first",
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void onRightMidClick(View view) {

        if(selectedPlayer != null)
        {
            event.setPosition("rightMid");
            showAlertDialog();
        }
        else{
            Toast.makeText(PlayScreen.this, "Please select a player first",
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void onOppBoxClick(View view) {

        if(selectedPlayer != null)
        {
            event.setPosition("oppBox");
            showAlertDialog();
        }
        else{
            Toast.makeText(PlayScreen.this, "Please select a player first",
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void saveInCSV() {

        Cursor cursor = teamDB.rawQuery("SELECT opposition, homeAway FROM team", null);
        cursor.moveToLast();
        int oppCol = cursor.getColumnIndex("opposition");
        int hACol = cursor.getColumnIndex("homeAway");
        String opp = cursor.getString(oppCol);
        String hA = cursor.getString(hACol);
        String folderName = "/" + opp + "_at_" + hA;

        File root = Environment.getExternalStorageDirectory();
        File dir = new File(root.getAbsolutePath() + folderName);

        if (!dir.exists())
        {
            dir.mkdirs();
        }

        String [] actionArray = {"Goals", "Fouls", "Assists", "Saves",
                "Tackles", "lostBalls", "Interceptions", "Offsides", "Clearances", "YellowCards", "RedCards", "ShotsOnTarget",
                "ShotsOffTarget", "OOP"};

        ArrayList<String> playerArray = new ArrayList<>();
        playerArray.add("player1");
        playerArray.add("player2");
        playerArray.add("player3");
        playerArray.add("player4");
        playerArray.add("player5");
        playerArray.add("player6");
        playerArray.add("player7");
        playerArray.add("player8");
        playerArray.add("player9");
        playerArray.add("player10");
        playerArray.add("player11");

        if(numPlayed == 12) playerArray.add("player12");
        else if(numPlayed == 13) playerArray.add("player13");
        else if(numPlayed == 14) playerArray.add("player14");

        try {

            String [] nextLine = {"\n"};
            CSVWriter csvWrite;

            for(int j = 0; j < numPlayed; j++) {
                String fileName = playerArray.get(j) + ".csv";
                File file = new File(dir, fileName);

                file.createNewFile();
                csvWrite = new CSVWriter(new FileWriter(file));
                cursor = teamDB.rawQuery("SELECT shirtNum, name, position FROM " + playerArray.get(j) + "", null);
                csvWrite.writeNext(cursor.getColumnNames());
                cursor.moveToNext();
                String[] details = {cursor.getString(0), cursor.getString(1), cursor.getString(2)};
                csvWrite.writeNext(details);
                csvWrite.writeNext(nextLine);

                for (int i = 0; i < actionArray.length; i++) {

                    String[] actionTitle = {actionArray[i]};
                    cursor = teamDB.rawQuery("SELECT actionArea, " + actionArray[i] + " FROM " + playerArray.get(j) + "", null);
                    csvWrite.writeNext(actionTitle);
                    csvWrite.writeNext(nextLine);
                    csvWrite.writeNext(cursor.getColumnNames());
                    while (cursor.moveToNext()) {

                        String[] arrStr = new String[19];
                        //Which column you want to exprort
                        for (int k = 0; k < 2; k++) {
                            arrStr[k] = cursor.getString(k);
                        }
                        csvWrite.writeNext(arrStr);
                    }

                    csvWrite.writeNext(nextLine);
                    cursor.close();
                }

                int goals = 0;
                int shotsOffTarget = 0;
                int shotsOnTarget = 0;
                String[] actionTitle = {"Shots vs Goals "};
                cursor = teamDB.rawQuery("SELECT Goals, ShotsOffTarget, ShotsOnTarget FROM " + playerArray.get(j) + "", null);
                csvWrite.writeNext(actionTitle);
                csvWrite.writeNext(nextLine);
                csvWrite.writeNext(cursor.getColumnNames());
                while (cursor.moveToNext()) {

                    String[] arrStr = new String[19];
                    //Which column you want to exprort
                    for (int k = 0; k < 3; k++) {
                        arrStr[k] = cursor.getString(k);
                    }
                    goals = goals + Integer.parseInt(arrStr[0]);
                    shotsOnTarget = shotsOnTarget + Integer.parseInt(arrStr[1]);
                    shotsOffTarget = shotsOffTarget + Integer.parseInt(arrStr[2]);

                }
                String [] goalArray = {Integer.toString(goals), Integer.toString(shotsOffTarget), Integer.toString(shotsOnTarget)};
                csvWrite.writeNext(goalArray);
                csvWrite.writeNext(nextLine);
                cursor.close();

                int fouls = 0;
                int redCards = 0;
                int yellowCards = 0;
                int lostBalls = 0;
                int offsides = 0;
                int oop = 0;
                actionTitle[0] = "Bad Play";
                cursor = teamDB.rawQuery("SELECT Fouls, RedCards, YellowCards, LostBalls, Offsides, OOP FROM " + playerArray.get(j) + "", null);
                csvWrite.writeNext(actionTitle);
                csvWrite.writeNext(nextLine);
                csvWrite.writeNext(cursor.getColumnNames());
                while (cursor.moveToNext()) {

                    String[] arrStr = new String[19];
                    //Which column you want to exprort
                    for (int k = 0; k < 6; k++) {
                        arrStr[k] = cursor.getString(k);
                    }

                    fouls = fouls + Integer.parseInt(arrStr[0]);
                    redCards = redCards + Integer.parseInt(arrStr[1]);
                    yellowCards = yellowCards + Integer.parseInt(arrStr[2]);
                    lostBalls = lostBalls + Integer.parseInt(arrStr[3]);
                    offsides = offsides + Integer.parseInt(arrStr[4]);
                    oop = oop + Integer.parseInt(arrStr[5]);

                }
                String [] badArray = {Integer.toString(fouls), Integer.toString(redCards),
                        Integer.toString(yellowCards), Integer.toString(lostBalls), Integer.toString(offsides), Integer.toString(oop)};
                csvWrite.writeNext(badArray);
                csvWrite.writeNext(nextLine);
                cursor.close();

                goals = 0;
                int assists = 0;
                int clearances = 0;
                int saves = 0;
                int interceptions = 0;
                actionTitle[0] = "Good Play";
                cursor = teamDB.rawQuery("SELECT Goals, Assists, Clearances, Saves, Interceptions FROM " + playerArray.get(j) + "", null);
                csvWrite.writeNext(actionTitle);
                csvWrite.writeNext(nextLine);
                csvWrite.writeNext(cursor.getColumnNames());
                while (cursor.moveToNext()) {

                    String[] arrStr = new String[19];
                    //Which column you want to exprort
                    for (int k = 0; k < 5; k++) {
                        arrStr[k] = cursor.getString(k);
                    }

                    goals = goals + Integer.parseInt(arrStr[0]);
                    assists = assists + Integer.parseInt(arrStr[1]);
                    clearances = clearances + Integer.parseInt(arrStr[2]);
                    saves = saves + Integer.parseInt(arrStr[3]);
                    interceptions = interceptions + Integer.parseInt(arrStr[4]);

                }
                String [] goodArray = {Integer.toString(goals), Integer.toString(assists), Integer.toString(clearances),
                        Integer.toString(saves), Integer.toString(interceptions)};
                csvWrite.writeNext(goodArray);
                csvWrite.writeNext(nextLine);
                cursor.close();

                csvWrite.close();
            }
        }
        catch(Exception sqlEx)
        {
            Log.e("MainActivity", sqlEx.getMessage(), sqlEx);
        }
    }
}
