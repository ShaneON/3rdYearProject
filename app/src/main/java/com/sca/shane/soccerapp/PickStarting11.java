package com.sca.shane.soccerapp;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by hp on 08/03/2016.
 */
public class PickStarting11 extends AppCompatActivity {

    SQLiteDatabase teamDB = null;
    TextView playerText1, playerText2, playerText3, playerText4, playerText5, playerText6,
            playerText7, playerText8, playerText9, playerText10, playerText11, playerText12,
            playerText13, playerText14, playerText15, playerText16, playerText17, playerText18,
            playerText19, playerText20, playerText21, playerText22, playerText23;

    int numPlayersPicked = 0;
    ArrayList<String> startingPlayerNums = new ArrayList<>();
    ArrayList<String> benchedNums = new ArrayList<>();
    int numPlayers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pick_starting_11);

        playerText1 = (CheckBox) findViewById(R.id.checkBoxStarting1);
        playerText2 = (CheckBox) findViewById(R.id.checkBoxStarting2);
        playerText3 = (CheckBox) findViewById(R.id.checkBoxStarting3);
        playerText4 = (CheckBox) findViewById(R.id.checkBoxStarting4);
        playerText5 = (CheckBox) findViewById(R.id.checkBoxStarting5);
        playerText6 = (CheckBox) findViewById(R.id.checkBoxStarting6);
        playerText7 = (CheckBox) findViewById(R.id.checkBoxStarting7);
        playerText8 = (CheckBox) findViewById(R.id.checkBoxStarting8);
        playerText9 = (CheckBox) findViewById(R.id.checkBoxStarting9);
        playerText10 = (CheckBox) findViewById(R.id.checkBoxStarting10);
        playerText11 = (CheckBox) findViewById(R.id.checkBoxStarting11);
        playerText12 = (CheckBox) findViewById(R.id.checkBoxStarting12);
        playerText13 = (CheckBox) findViewById(R.id.checkBoxStarting13);
        playerText14 = (CheckBox) findViewById(R.id.checkBoxStarting14);
        playerText15 = (CheckBox) findViewById(R.id.checkBoxStarting15);
        playerText16 = (CheckBox) findViewById(R.id.checkBoxStarting16);
        playerText17 = (CheckBox) findViewById(R.id.checkBoxStarting17);
        playerText18 = (CheckBox) findViewById(R.id.checkBoxStarting18);
        playerText19 = (CheckBox) findViewById(R.id.checkBoxStarting19);
        playerText20 = (CheckBox) findViewById(R.id.checkBoxStarting20);
        playerText21 = (CheckBox) findViewById(R.id.checkBoxStarting21);
        playerText22 = (CheckBox) findViewById(R.id.checkBoxStarting22);
        playerText23 = (CheckBox) findViewById(R.id.checkBoxStarting23);

        teamDB = this.openOrCreateDatabase("myTeam",
                MODE_PRIVATE, null);

        Cursor cursor = teamDB.rawQuery("SELECT * FROM players", null);

        int shirtNumColumn = cursor.getColumnIndex("shirtNum");
        int nameColumn = cursor.getColumnIndex("name");
        int positionColumn = cursor.getColumnIndex("position");

        cursor.moveToFirst();

        String playerList = "";

        if(cursor != null && (cursor.getCount() > 0)){

            String shirtNum = cursor.getString(shirtNumColumn);
            String name = cursor.getString(nameColumn);
            String position = cursor.getString(positionColumn);
            String text = shirtNum + " : " + position + " : " + name + "\n";
            playerText1.setText(text);
            benchedNums.add(shirtNum);
            numPlayers++;
        }
        if(cursor.moveToNext())
        {
            String shirtNum = cursor.getString(shirtNumColumn);
            String name = cursor.getString(nameColumn);
            String position = cursor.getString(positionColumn);
            String text = shirtNum + " : " + position + " : " + name + "\n";
            playerText2.setText(text);
            benchedNums.add(shirtNum);
            numPlayers++;
        }
        if(cursor.moveToNext())
        {
            String shirtNum = cursor.getString(shirtNumColumn);
            String name = cursor.getString(nameColumn);
            String position = cursor.getString(positionColumn);
            String text = shirtNum + " : " + position + " : " + name + "\n";
            playerText3.setText(text);
            benchedNums.add(shirtNum);
            numPlayers++;
        }
        if(cursor.moveToNext())
        {
            String shirtNum = cursor.getString(shirtNumColumn);
            String name = cursor.getString(nameColumn);
            String position = cursor.getString(positionColumn);
            String text = shirtNum + " : " + position + " : " + name + "\n";
            playerText4.setText(text);
            benchedNums.add(shirtNum);
            numPlayers++;
        }
        if(cursor.moveToNext())
        {
            String shirtNum = cursor.getString(shirtNumColumn);
            String name = cursor.getString(nameColumn);
            String position = cursor.getString(positionColumn);
            String text = shirtNum + " : " + position + " : " + name + "\n";
            playerText5.setText(text);
            benchedNums.add(shirtNum);
            numPlayers++;
        }
        if(cursor.moveToNext())
        {
            String shirtNum = cursor.getString(shirtNumColumn);
            String name = cursor.getString(nameColumn);
            String position = cursor.getString(positionColumn);
            String text = shirtNum + " : " + position + " : " + name + "\n";
            playerText6.setText(text);
            benchedNums.add(shirtNum);
            numPlayers++;
        }
        if(cursor.moveToNext())
        {
            String shirtNum = cursor.getString(shirtNumColumn);
            String name = cursor.getString(nameColumn);
            String position = cursor.getString(positionColumn);
            String text = shirtNum + " : " + position + " : " + name + "\n";
            playerText7.setText(text);
            benchedNums.add(shirtNum);
            numPlayers++;
        }
        if(cursor.moveToNext())
        {
            String shirtNum = cursor.getString(shirtNumColumn);
            String name = cursor.getString(nameColumn);
            String position = cursor.getString(positionColumn);
            String text = shirtNum + " : " + position + " : " + name + "\n";
            playerText8.setText(text);
            benchedNums.add(shirtNum);
            numPlayers++;
        }
        if(cursor.moveToNext())
        {
            String shirtNum = cursor.getString(shirtNumColumn);
            String name = cursor.getString(nameColumn);
            String position = cursor.getString(positionColumn);
            String text = shirtNum + " : " + position + " : " + name + "\n";
            playerText9.setText(text);
            benchedNums.add(shirtNum);
            numPlayers++;
        }
        if(cursor.moveToNext())
        {
            String shirtNum = cursor.getString(shirtNumColumn);
            String name = cursor.getString(nameColumn);
            String position = cursor.getString(positionColumn);
            String text = shirtNum + " : " + position + " : " + name + "\n";
            playerText10.setText(text);
            benchedNums.add(shirtNum);
            numPlayers++;
        }
        if(cursor.moveToNext())
        {
            String shirtNum = cursor.getString(shirtNumColumn);
            String name = cursor.getString(nameColumn);
            String position = cursor.getString(positionColumn);
            String text = shirtNum + " : " + position + " : " + name + "\n";
            playerText11.setText(text);
            benchedNums.add(shirtNum);
            numPlayers++;
        }
        if(cursor.moveToNext())
        {
            String shirtNum = cursor.getString(shirtNumColumn);
            String name = cursor.getString(nameColumn);
            String position = cursor.getString(positionColumn);
            String text = shirtNum + " : " + position + " : " + name + "\n";
            playerText12.setText(text);
            benchedNums.add(shirtNum);
            numPlayers++;
        }
        if(cursor.moveToNext())
        {
            String shirtNum = cursor.getString(shirtNumColumn);
            String name = cursor.getString(nameColumn);
            String position = cursor.getString(positionColumn);
            String text = shirtNum + " : " + position + " : " + name + "\n";
            playerText13.setText(text);
            benchedNums.add(shirtNum);
            numPlayers++;
        }
        if(cursor.moveToNext())
        {
            String shirtNum = cursor.getString(shirtNumColumn);
            String name = cursor.getString(nameColumn);
            String position = cursor.getString(positionColumn);
            String text = shirtNum + " : " + position + " : " + name + "\n";
            playerText14.setText(text);
            benchedNums.add(shirtNum);
            numPlayers++;
        }
        if(cursor.moveToNext())
        {
            String shirtNum = cursor.getString(shirtNumColumn);
            String name = cursor.getString(nameColumn);
            String position = cursor.getString(positionColumn);
            String text = shirtNum + " : " + position + " : " + name + "\n";
            playerText15.setText(text);
            benchedNums.add(shirtNum);
            numPlayers++;
        }
        if(cursor.moveToNext())
        {
            String shirtNum = cursor.getString(shirtNumColumn);
            String name = cursor.getString(nameColumn);
            String position = cursor.getString(positionColumn);
            String text = shirtNum + " : " + position + " : " + name + "\n";
            playerText16.setText(text);
            benchedNums.add(shirtNum);
            numPlayers++;
        }
        if(cursor.moveToNext())
        {
            String shirtNum = cursor.getString(shirtNumColumn);
            String name = cursor.getString(nameColumn);
            String position = cursor.getString(positionColumn);
            String text = shirtNum + " : " + position + " : " + name + "\n";
            playerText17.setText(text);
            benchedNums.add(shirtNum);
            numPlayers++;
        }
        if(cursor.moveToNext())
        {
            String shirtNum = cursor.getString(shirtNumColumn);
            String name = cursor.getString(nameColumn);
            String position = cursor.getString(positionColumn);
            String text = shirtNum + " : " + position + " : " + name + "\n";
            playerText18.setText(text);
            benchedNums.add(shirtNum);
            numPlayers++;
        }
        if(cursor.moveToNext())
        {
            String shirtNum = cursor.getString(shirtNumColumn);
            String name = cursor.getString(nameColumn);
            String position = cursor.getString(positionColumn);
            String text = shirtNum + " : " + position + " : " + name + "\n";
            playerText19.setText(text);
            benchedNums.add(shirtNum);
            numPlayers++;
        }
        if(cursor.moveToNext())
        {
            String shirtNum = cursor.getString(shirtNumColumn);
            String name = cursor.getString(nameColumn);
            String position = cursor.getString(positionColumn);
            String text = shirtNum + " : " + position + " : " + name + "\n";
            playerText20.setText(text);
            benchedNums.add(shirtNum);
            numPlayers++;
        }
        if(cursor.moveToNext())
        {
            String shirtNum = cursor.getString(shirtNumColumn);
            String name = cursor.getString(nameColumn);
            String position = cursor.getString(positionColumn);
            String text = shirtNum + " : " + position + " : " + name + "\n";
            playerText21.setText(text);
            benchedNums.add(shirtNum);
            numPlayers++;
        }
        if(cursor.moveToNext())
        {
            String shirtNum = cursor.getString(shirtNumColumn);
            String name = cursor.getString(nameColumn);
            String position = cursor.getString(positionColumn);
            String text = shirtNum + " : " + position + " : " + name + "\n";
            playerText22.setText(text);
            benchedNums.add(shirtNum);
            numPlayers++;
        }
        if(cursor.moveToNext())
        {
            String shirtNum = cursor.getString(shirtNumColumn);
            String name = cursor.getString(nameColumn);
            String position = cursor.getString(positionColumn);
            String text = shirtNum + " : " + position + " : " + name + "\n";
            playerText23.setText(text);
            benchedNums.add(shirtNum);
            numPlayers++;
        }
    }

    public void filterBenchedArray()
    {
        for(int i = 0; i < benchedNums.size(); i++)
        {
            for(int j = 0; j < startingPlayerNums.size(); j++)
            {
                if(benchedNums.get(i).equals(startingPlayerNums.get(j)))
                {
                    benchedNums.remove(i);
                }
            }
        }
    }

    public void goToPlayScreen(View view)
    {
        if(numPlayersPicked == 11) {
            filterBenchedArray();
            Intent playScreen = new Intent(this, PlayScreen.class);
            playScreen.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            playScreen.putExtra("Player Number Array", startingPlayerNums);
            playScreen.putExtra("Benched Number Array", benchedNums);
            final int result = 1;
            startActivity(playScreen);
            finish();
        }
        else{
            Toast.makeText(PickStarting11.this, "Please check 11 players",
                    Toast.LENGTH_LONG).show();
        }
    }

    public int onCheckPlayerBox(View view) {

        CheckBox check = (CheckBox) view;
        String num = check.getText().toString();
        if(num.equals("N/A")) return 1;
        else {

            if(check.isChecked()) {
                if (numPlayersPicked < 11) {
                    numPlayersPicked++;
                }
                else return 1;
                if (hasNoDigitInSecondPosition(num))
                    startingPlayerNums.add(num.substring(0, 1));
                else startingPlayerNums.add(num.substring(0, 2));
            }
            else {
                numPlayersPicked--;
                if (hasNoDigitInSecondPosition(num)) startingPlayerNums.remove(num.substring(0, 1));
                else startingPlayerNums.remove(num.substring(0, 2));
            }
        }

        return 1;
    }

    private boolean hasNoDigitInSecondPosition(String s)
    {
        if(s.charAt(1) == '1' ||
            s.charAt(1) == '2' ||
            s.charAt(1) == '3' ||
            s.charAt(1) == '4' ||
            s.charAt(1) == '5' ||
            s.charAt(1) == '6' ||
            s.charAt(1) == '7' ||
            s.charAt(1) == '8' ||
            s.charAt(1) == '9' ||
            s.charAt(1) == '0') return false;
        else return true;
    }


}
