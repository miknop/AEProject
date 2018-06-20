package com.AEProjekt.submarine.levelz;

import java.util.ArrayList;

public class LevelBeatCounter {
    //private int beatCounter = 0;
    private ArrayList<Boolean> beatList;



    public LevelBeatCounter()
    {
        beatList = new ArrayList<Boolean>();
    }



    public void fillResultOfRound (boolean resultOfRound)
    {

        beatList.add(resultOfRound);

        if(beatList.size() >= 8)
        {
            beatList.remove(0);
        }




        //increaseRound();
    }



    public ArrayList<Boolean> getBeatList() {
        return beatList;
    }
    public void setBeatList(ArrayList<Boolean> beatList) {
        this.beatList = beatList;
    }
}
