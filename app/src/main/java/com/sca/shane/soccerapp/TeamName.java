package com.sca.shane.soccerapp;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * Created by Shane on 01/03/2016.
 */
public class TeamName extends AppCompatActivity {

    private EditText teamNameEditText;
    private Button createTeamButton;

    SQLiteDatabase teamDB = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.team_name);
        teamNameEditText = (EditText) findViewById(R.id.team_name_edit_text);
        createTeamButton = (Button) findViewById(R.id.create_team_button);
    }

    public void onCreateTeam(View view) {

        String teamName = teamNameEditText.getText().toString();

        try{
            teamDB = this.openOrCreateDatabase("myTeam",
                    MODE_PRIVATE, null);

            teamDB.execSQL("CREATE TABLE IF NOT EXISTS team " +
                    "(teamName VARCHAR, opposition VARCHAR, homeAway VARCHAR);");
        }
        catch(Exception e){}

        teamDB.execSQL("INSERT INTO team (teamName) VALUES ('" + teamName + "');");

        Intent goAddPlayers = new Intent(this, AddPlayers.class);

        final int result = 1;

        startActivity(goAddPlayers);

    }

}
