package com.AEProjekt.submarine.levelz;

import lombok.Data;

import java.util.ArrayList;

/**
 * This class counts the number of tries and fails a user experiences while playing on level.
 *
 */
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
}
