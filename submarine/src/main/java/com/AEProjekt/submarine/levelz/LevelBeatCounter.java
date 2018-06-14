package com.AEProjekt.submarine.levelz;

import java.util.ArrayList;

public class LevelBeatCounter {
    private int beatCounter = 0;
    private ArrayList<Boolean> beatList;



    public LevelBeatCounter()
    {
        beatList = new ArrayList<Boolean>();
    }



    private void increaseRound()
    {
        if(beatCounter >= 6)
        {
            beatCounter = 0;
        }
        else
        {
            beatCounter++;
        }

    }

    public void fillResultOfRound (boolean resultOfRound)
    {
        //Die Datenstruktur ist jetzt gross genug um nun elementweise mit index zu arbeiten
        if(beatList.size() >= 7)
        {
            beatList.set(beatCounter, resultOfRound);
        }
        else
        {
            beatList.add(resultOfRound);
        }



        increaseRound();
    }


    public int getBeatCounter() {
        return beatCounter;
    }
    public void setBeatCounter(int beatCounter) {
        this.beatCounter = beatCounter;
    }
    public ArrayList<Boolean> getBeatList() {
        return beatList;
    }
    public void setBeatList(ArrayList<Boolean> beatList) {
        this.beatList = beatList;
    }
}
