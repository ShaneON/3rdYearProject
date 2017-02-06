package com.sca.shane.soccerapp;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * Created by hp on 08/03/2016.
 */
public class PickOpp extends AppCompatActivity {

    private EditText oppTeamNameEditText;
    SQLiteDatabase teamDB = null;

    Spinner homeAwaySpinner;
    String itemSelectedInSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pick_opp);
        addItemsToHomeAwaySpinner();
        addListenerToHomeAwaySpinner();

        oppTeamNameEditText = (EditText) findViewById(R.id.editText3);
    }

    public void addItemsToHomeAwaySpinner(){

        ArrayAdapter<CharSequence> homeAwaySpinnerAdapter =
                ArrayAdapter.createFromResource(this, R.array.home_Away,
                        android.R.layout.simple_spinner_item);

        homeAwaySpinnerAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        homeAwaySpinner = (Spinner) findViewById(R.id.spinnerHomeOrAway);
        homeAwaySpinner.setAdapter(homeAwaySpinnerAdapter);
    }

    public void addListenerToHomeAwaySpinner() {
        homeAwaySpinner = (Spinner) findViewById(R.id.spinnerHomeOrAway);

        homeAwaySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                itemSelectedInSpinner = parent.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    public void pickStarting(View view)
    {
        String oppTeamName = oppTeamNameEditText.getText().toString();

        try{
            teamDB = this.openOrCreateDatabase("myTeam",
                    MODE_PRIVATE, null);

            teamDB.execSQL("CREATE TABLE IF NOT EXISTS team " +
                    "(teamName VARCHAR, opposition VARCHAR, homeAway VARCHAR);");
        }
        catch(Exception e){}

        teamDB.execSQL("INSERT INTO team (opposition, homeAway) VALUES ('" + oppTeamName + "', '" + itemSelectedInSpinner + "');");

        Intent pickStarting = new Intent(this, PickStarting11.class);
        final int result = 1;
        startActivity(pickStarting);
    }
}
