package com.sca.shane.soccerapp;

import android.widget.Button;

/**
 * Created by Shane on 05/03/2016.
 */
public class Event {

    private int playerNum;
    private String position;
    private String action;

    public void setPlayerNum(String num) {
        int shirtNum = Integer.parseInt(num);
        playerNum = shirtNum;
    }

    public void setPosition(String p) { position = p; }

    public void setAction(String a) { action = a; }

    public int getPlayerNum() { return playerNum; }

    public String getPosition()
    {
        return position;
    }

    public String getAction() { return action; }

    public String getTableName(String s)
    {
        if(s.equals("Goal")) return "Goals";
        if(s.equals("Assist")) return "Assists";
        if(s.equals("Lost Ball")) return "LostBalls";
        if(s.equals("Save")) return "Saves";
        if(s.equals("Offside")) return "Offsides";
        if(s.equals("Clearance")) return "Clearances";
        if(s.equals("Tackle")) return "Tackles";
        if(s.equals("Foul")) return "Fouls";
        if(s.equals("Interception")) return "Interceptions";
        if(s.equals("Yellow Card")) return "YellowCards";
        if(s.equals("Red Card")) return "RedCards";
        if(s.equals("Shot On Target")) return "ShotsOnTarget";
        if(s.equals("Shot Off Target")) return "ShotsOffTarget";
        else return "OOP";
    }

    public String getPositionColumn(String s)
    {
        if(s.equals("Own Box")) return "ownBox";
        if(s.equals("Left Def")) return "leftDef";
        if(s.equals("Right Def")) return "rightDef";
        if(s.equals("Left Mid")) return "leftMid";
        if(s.equals("Right Mid")) return "rightMid";
        if(s.equals("Left Fwd")) return "leftFwd";
        if(s.equals("Right Fwd")) return "rightFwd";
        else return "oppBox";

    }
}
