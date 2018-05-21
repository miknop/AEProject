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
        beatCounter++;
    }

    public void fillResultOfRound (boolean resultOfRound)
    {
        beatList.add(resultOfRound);
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
