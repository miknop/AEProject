package com.AEProjekt.submarine.levelz;

import lombok.Data;

import java.util.ArrayList;

@Data
public class LevelBeatCounter {
    private ArrayList<Boolean> beatList;
    private int totalTriesCounter;
    private int totalFailsCounter;


    public LevelBeatCounter() {
        beatList = new ArrayList<>();
    }


    public void fillResultOfRound(boolean resultOfRound) {

        beatList.add(resultOfRound);
        totalTriesCounter++;

        if (!resultOfRound) {
            totalFailsCounter++;
        }

        if (beatList.size() >= 8) {
            beatList.remove(0);
        }

    }


    public ArrayList<Boolean> getBeatList() {
        return beatList;
    }

    public void setBeatList(ArrayList<Boolean> beatList) {
        this.beatList = beatList;
    }
}
