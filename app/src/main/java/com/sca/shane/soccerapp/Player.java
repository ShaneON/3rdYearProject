package com.sca.shane.soccerapp;

import android.widget.Button;

/**
 * Created by Shane on 04/03/2016.
 */
public class Player {

    private String name;
    private String position;
    private String number;
    private String playerID;
    private Button playerButton;

    private int goals;
    private int assists;
    private int lostBalls;
    private int fouls;
    private int tackles;
    private int interceptions;
    private int clearances;
    private int saves;
    private int yellowCards;
    private int redCard;
    private int shotsOnTarget;
    private int shotsOffTarget;
    private int offside;
    private int OOP;
    private boolean subbed;

    public Player(String n, String s, String p, String id)
    {
        name = n;
        position = p;
        number = s;
        playerID = id;
    }

    public void setName(String s)
    {
        name = s;
    }

    public void setPosition(String s)
    {
        position = s;
    }

    public void setPlayerID(String p)
    {
        playerID = p;
    }

    public String getPlayerID()
    {
        return playerID;
    }

    void setPlayerNum(String s)
    {
        number = s;
    }

    public void findActionAndIncrement(String s)
    {
        if("assists".equals(getVariableName(s))) setAssists();
        else if("goals".equals(getVariableName(s))) setGoals();
        else if("interceptions".equals(getVariableName(s))) setInterceptions();
        else if("saves".equals(getVariableName(s))) setSaves();
        else if("yellowCards".equals(getVariableName(s))) setYellowCards();
        else if("redCard".equals(getVariableName(s))) setRedCard();
        else if("lostBalls".equals(getVariableName(s))) setLostBalls();
        else if("shotsOnTarget".equals(getVariableName(s))) setShotsOnTarget();
        else if("shotsOffTarget".equals(getVariableName(s))) setShotsOffTarget();
        else if("clearances".equals(getVariableName(s))) setClearances();
        else if("tackles".equals(getVariableName(s))) setTackles();
        else setOOP();
    }

    public String getVariableName(String s)
    {
        if(s.equals("Goal")) return "goals";
        if(s.equals("Assist")) return "assists";
        if(s.equals("Lost Ball")) return "lostBalls";
        if(s.equals("Save")) return "saves";
        if(s.equals("Offside")) return "offside";
        if(s.equals("Clearance")) return "clearance";
        if(s.equals("Tackle")) return "tackle";
        if(s.equals("Foul")) return "foul";
        if(s.equals("Interception")) return "interception";
        if(s.equals("Yellow Card")) return "yellowCard";
        if(s.equals("Red Card")) return "redCard";
        if(s.equals("Shot On Target")) return "shotOnTarget";
        if(s.equals("Shot Off Target")) return "shotOffTarget";
        else return "oop";
    }


    public void setSubbed(boolean b)
    {
        subbed = b;
    }

    public boolean getSubbed()
    {
        return subbed;
    }

    public void setPlayerButton(Button button)
    {
        playerButton = button;
    }

    public String getName()
    {
        return name;
    }

    public String getPosition()
    {
        return position;
    }

    public String getNumber()
    {
        return number;
    }

    public int getGoals()
    {
        return goals;
    }

    public int getAssists()
    {
        return assists;
    }

    public int getLostBalls()
    {
        return lostBalls;
    }

    public int getFouls()
    {
        return fouls;
    }

    public int getTackles()
    {
        return tackles;
    }

    public int getInterceptions()
    {
        return interceptions;
    }

    public int getClearances()
    {
        return clearances;
    }

    public int getSaves()
    {
        return saves;
    }

    public int getYellowCards()
    {
        return yellowCards;
    }

    public int getRedCard()
    {
        return redCard;
    }

    public int getShotsOnTarget()
    {
        return shotsOnTarget;
    }

    public int getShotsOffTarget()
    {
        return shotsOffTarget;
    }

    public int getOOP()
    {
        return OOP;
    }

    public int getOffside() {
        return offside;
    }

    public void setOffside(int offside) {
        this.offside = offside;
    }

    public void setOOP()
    {
        OOP++;
    }

    public void setShotsOnTarget()
    {
        shotsOnTarget++;
    }

    public void setShotsOffTarget()
    {
        shotsOffTarget++;
    }

    public void setGoals()
    {
        goals++;
    }

    public void setAssists()
    {
        assists++;
    }

    public void setLostBalls()
    {
        lostBalls++;
    }

    public void setFouls()
    {
        fouls++;
    }

    public void setTackles()
    {
        tackles++;
    }

    public void setInterceptions()
    {
        interceptions++;
    }

    public void setClearances()
    {
        clearances++;
    }

    public void setSaves()
    {
        saves++;
    }

    public void setYellowCards()
    {
        yellowCards++;
    }

    public void setRedCard()
    {
        redCard = 1;
    }

}
