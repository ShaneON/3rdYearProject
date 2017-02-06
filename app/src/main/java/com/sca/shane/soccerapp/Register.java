package com.sca.shane.soccerapp;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Shane on 26/02/2016.
 */
public class Register extends AppCompatActivity {

    //SQLiteDatabase soccerDB = null;
    //Button createTeamButton;

    //EditText nameEditText, passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);


    }

    public void onCreateTeamClick(View view) {

        //try{
            //soccerDB = this.openOrCreateDatabase("TeamData",
                   // MODE_PRIVATE, null);

            //soccerDB.execSQL("CREATE TABLE IF NOT EXISTS team " +
                //"(id integer")
        //}

        Intent createTeamIntent = new Intent(this, TeamName.class);
        final int result = 1;
        startActivity(createTeamIntent);
    }
}
