package com.sca.shane.soccerapp;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Shane on 01/03/2016.
 */
public class AddPlayers extends AppCompatActivity {

    private Spinner positionSpinner;
    SQLiteDatabase teamDB = null;
    Button addPlayerButton;
    EditText nameEditText, numEditText, playerListEditText;
    String itemSelectedInSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.add_players);

        addItemsToPositionSpinner();
        addListenerToPositionSpinner();
        addPlayerButton = (Button) findViewById(R.id.add_player_button);
        nameEditText = (EditText) findViewById(R.id.nameEditText);
        numEditText = (EditText) findViewById(R.id.numEditText);
        playerListEditText = (EditText) findViewById(R.id.playerListEditText);
    }


    public void createDB(View view) {

        try{
            teamDB = this.openOrCreateDatabase("myTeam",
                 MODE_PRIVATE, null);

            teamDB.execSQL("CREATE TABLE IF NOT EXISTS players " +
                    "(shirtNum integer primary key, name VARCHAR, position VARCHAR," +
                    " TeamName VARCHAR);");
        }
        catch(Exception e){}

        String playerName = nameEditText.getText().toString();
        String playerNum = numEditText.getText().toString();


        teamDB.execSQL("INSERT OR IGNORE INTO players (shirtNum, name, position) VALUES ('" + playerNum + "', '" + playerName + "', '" + itemSelectedInSpinner + "');");

        Cursor cursor = teamDB.rawQuery("SELECT * FROM players", null);

        int shirtNumColumn = cursor.getColumnIndex("shirtNum");
        int nameColumn = cursor.getColumnIndex("name");
        int positionColumn = cursor.getColumnIndex("position");

        cursor.moveToFirst();

        String playerList = "";

        if(cursor != null && (cursor.getCount() > 0)){
            do{
                String shirtNum = cursor.getString(shirtNumColumn);
                String name = cursor.getString(nameColumn);
                String position = cursor.getString(positionColumn);
                playerList = playerList + shirtNum + " : " + name + " : " + position + "\n";

            }while(cursor.moveToNext());
        }

        playerListEditText.setText(playerList);
    }

    public void addListenerToPositionSpinner() {
        positionSpinner = (Spinner) findViewById(R.id.position_spinner);

        positionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                itemSelectedInSpinner = parent.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void addItemsToPositionSpinner(){

        ArrayAdapter<CharSequence> positionSpinnerAdapter =
                ArrayAdapter.createFromResource(this, R.array.positions,
                        android.R.layout.simple_spinner_item);

        positionSpinnerAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        positionSpinner = (Spinner) findViewById(R.id.position_spinner);
        positionSpinner.setAdapter(positionSpinnerAdapter);
    }

    public void onClickNextPage(View view) {

        Intent goToMenu = new Intent(this, MainMenu.class);

        final int result = 1;

        startActivity(goToMenu);


    }
}
