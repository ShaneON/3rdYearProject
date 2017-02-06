package com.sca.shane.soccerapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by hp on 08/03/2016.
 */
public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_menu);
    }


    public void onRecordMatchDataClick(View view) {

        Intent pickOpp = new Intent(this, PickOpp.class);
        final int result = 1;
        startActivity(pickOpp);
    }

    public void onSetUpTeam(View view) {

        Intent teamName = new Intent(this, TeamName.class);
        final int result = 1;
        startActivity(teamName);

    }
}
