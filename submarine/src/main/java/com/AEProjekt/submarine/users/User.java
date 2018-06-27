package com.AEProjekt.submarine.users;

import com.AEProjekt.submarine.levelz.Level1;
import com.AEProjekt.submarine.levelz.Level2;
import com.AEProjekt.submarine.levelz.Level3;
import com.AEProjekt.submarine.levelz.Level4;
import com.AEProjekt.submarine.levelz.iLevel;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Comparable<User> {

    private String username;
    private String classNumber;
    private iLevel level = new Level1();

    private int scoreLevel1 = 0;
    private int scoreLevel2 = 0;
    private int scoreLevel3 = 0;
    private int scoreLevel4 = 0;

    private int totalScore = scoreLevel1 + scoreLevel2 + scoreLevel3 + scoreLevel4;

    /* Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.

     */
    @Override
    public int compareTo(User user) {
        return this.totalScore - user.getTotalScore();
    }
}
