package com.AEProjekt.submarine.levelz;

import java.util.ArrayList;

public class LevelBeatCounter {
    private int beatCounter = 0;
    private ArrayList<Boolean> beatList;

    //private int beatCounterNew = 0;

    public LevelBeatCounter()
    {
        beatList = new ArrayList<Boolean>();
    }

    /*
    public LevelBeatCounter()
    {
        beatList = new ArrayList<Boolean>();
        for(int i = 0; i < 7; i++)
        {
            beatList.add(false);
        }
    }
    */

    private void increaseRound()
    {
        beatCounter++;
    }

    public void fillResultOfRound (boolean resultOfRound)
    {
        beatList.add(resultOfRound);
        increaseRound();
    }
/*
    public void fillResultOfRoundNew (boolean resultOfRound)
    {
        beatList.add(resultOfRound);

        increaseRound();
        beatCounterNew++;
        if(beatCounterNew == 6)
        {
            beatCounterNew = 0;
        }
    }
*/
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
