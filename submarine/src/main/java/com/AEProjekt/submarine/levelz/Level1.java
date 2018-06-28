/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.AEProjekt.submarine.levelz;  // created at 5/7/2018

import com.AEProjekt.submarine.equations.EquationGenerator;
import com.AEProjekt.submarine.equations.LinearEquation;
import com.AEProjekt.submarine.figures.Plane;
import com.AEProjekt.submarine.figures.Submarine;
import com.AEProjekt.submarine.figures.iFigure;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Michel
 */
@Data
@AllArgsConstructor
//@NoArgsConstructor
public class Level1 implements iLevel {

    private iFigure plane = null;

    private iFigure sub = null;

    private LinearEquation linEq = null;

    private LevelBeatCounter levelbeatcounter;


    public Level1() {
        equipLevel();
    }

    /**
     * Rüstet das Level mit allen nötigen Variablen aus.
     * Die generierte Gerade, den oberen und unteren Punkt,
     * sowie den Counter für die Besiegung.
     * Sie wird tendenziel aufgerufen, wenn der User gerade frisch
     * nach einem Level aufstieg in das neue Level kommt.
     * @author Simon Freygang
     */
    public void equipLevel() {
        linEq = EquationGenerator.generateLinearEquation();
        plane = new Plane(EquationGenerator.generatePointAboveSea(linEq));
        sub = new Submarine(EquationGenerator.generatePointBelowSea(linEq));
        levelbeatcounter = new LevelBeatCounter();
    }
    /**
     * Das Gleiche wie die equipLevel(), nur das hier nicht der Counter für die
     * besiegung zurückgesetzt wird. Sie wird tendenziel dann aufgerufen, wenn
     * der Benutzer nach erfolg, oder misserfolg einer Überprüfung ein neues Spiel braucht.
     * Seine bepunktungsfortschritt geht logischerweise nicht verloren.
     * @author Simon Freygang
     */
    public void equipLevelNoRS() {
        linEq = EquationGenerator.generateLinearEquation();
        plane = new Plane(EquationGenerator.generatePointAboveSea(linEq));
        sub = new Submarine(EquationGenerator.generatePointBelowSea(linEq));
    }

}
