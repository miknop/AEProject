package com.AEProjekt.submarine.controllerz;


import com.AEProjekt.submarine.users.User;
import com.AEProjekt.submarine.InputLevel.*;
import com.AEProjekt.submarine.equations.EquationGenerator;
import com.AEProjekt.submarine.equations.*;
import com.AEProjekt.submarine.figures.Ship;
import com.AEProjekt.submarine.levelz.*;
import jdk.internal.util.xml.impl.Input;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

public class Controller {
    private EquationGenerator generator;
    private LinearEquation linearEquation = null;
    private iLInput inputLevel;
    private InputControl validInput;
    private User user;
    private Ship ship;







    public void playLevel(iLevel level)
    {
        if(level instanceof  Level1)
        {
            int m1 = ((InputLevel1) inputLevel).getP2Y() - ((InputLevel1) inputLevel).getP1Y();
            int m2 = ((InputLevel1) inputLevel).getP2X() - ((InputLevel1) inputLevel).getP1X();
            int m = m1/m2;


            LinearEquation temp_linearequation = new LinearEquation(m1, m2, ((InputLevel1) inputLevel).getP1Y() + m * ((InputLevel1) inputLevel).getP1X() * (-1));


            if(temp_linearequation.compareTo( ((Level1) level).getLinEq()) == 0)
            {
                ((Level1) level).getLevelbeatcounter().fillResultOfRound(true);
            }
            else
            {
                ((Level1) level).getLevelbeatcounter().fillResultOfRound(true);
            }

        }

    }

    @GetMapping("/testforinputs")

    public void fillInputForLevels(@RequestParam(name="current_level", required=false) String currentLevel,
                                   @RequestParam(name="y_1", required=false) int y1,
                                   @RequestParam(name="x_1", required=false) int x1,
                                   @RequestParam(name="y_2", required=false) int y2,
                                   @RequestParam(name="x_2", required=false) int x2

                                   )
    {

        //InputLevel1 inputLevel;
        iLInput inputLevel = new InputLevel1();
        ((InputLevel1)inputLevel).setP1Y(y1);
        ((InputLevel1)inputLevel).setP1X(x1);
        ((InputLevel1)inputLevel).setP2Y(y2);
        ((InputLevel1)inputLevel).setP2X(x2);

    }

    //TODO Login Funktion entwickeln (wo kommt user her?)
    public void storyExecution(User user)
    {



        /*
        - Der User ist eingeloggt und die UI wird angezeigt
        - Level ist erzeugt, Gleichung auch--> Gleichung an Frontend schicken
        - Gleichung anzeigen (Im Frontend)
        - User gibt input
        - Input validieren und ob er die Aufgabe richtig geloest hat
        - Solange wiederholen bis level geschlagen wurde

         */


        // generiere Level und erzeuge Gleichung sowie Figuren
        //Level1 level1 = new Level1();




        //while (!user.isLevel1Beaten()) {

            //Achtung, noch Endlosschleife
            //level1.equipLevel();

            //Fuer den level reset
            //Hat der Benutzer 5 versuche erreicht und ist das level immer noch nicht besiegt muss zurueck getzt werden
            if(((Level1) user.getLevel()).getLevelbeatcounter().getBeatCounter() >= 5 && !user.isLevel1Beaten())
            {
                user.setLevel(new Level1());
            }

            playLevel(((Level1) user.getLevel()));
            //playLevel() -> methode, die ein iLevel übergeben bekommt und jedes mal läuft,
            // solange ein Level nicht geschlagen wurde.
            // jedes mal, wenn etwas richtig oder falsch gemacht wurde, wird die Liste (weiß noch nicht genau wohin mit der Liste)
            // mit Fail oder Win gefüllt.
            // Bei Fail wird equipLevel neu aufgerufen, bei Win auch, es sei denn, die abbruchbedingung für levelIsBeaten ist erfüllt
            // und das level ist geschlagen

        //}










        //Pruefe ob schon eine Gleichung generiert wurde
        //wenn nein, generiere
        /*
        if(linearEquation == null && !(user.getLevel() instanceof Level5))
        {
            generator = new EquationGenerator();


            linearEquation = (LinearEquation) generator.getEquation();

        }


        if(user.getLevel() instanceof Level1)
        {

            if(inputLevel == null)
            {
                //Gebe an das frontend die eingabemoeglichkeiten fuer lv1 frei

            }
            else if(inputLevel.isInputValid() == false)
            {
                //Wie oben, nur noch mit zusatz Meldung das der spieler kein erfolg hat
                //loeschung der input instanz erforderlich?
            }
            else if(inputLevel.isInputValid() == true)
            {
                double m1 = inputLevel.getP2Y() - inputLevel.getP1Y();
                double m2 = inputLevel.getP2X() - inputLevel.getP1X();
                double m = m1/m2;

                LinearEquation temp_linearequation = new LinearEquation((int)m1,(int)m2, (int)(inputLevel.getP1Y() + m * inputLevel.getP1X() * (-1)));
                //Wenn jetzt nun diese zwei geraden identischh sind, kann er im level aufsteigen (mann muss doch irgendwas definieren um zwei klassen comparen zu koennen??).
                // if(temp_linearequation.equals(LinearEquation)) //sry ich muste mal compilen
                if(true)
                {
                    //In jedem fall dem user das neue Level zuweisen
                    user.setLevel(new Level2());
                    //Ggf. win meldung an das Frontend
                }
                else
                {
                    //Meldung an das Frontend das er nicht getroffen hat
                }
            }

        }
        else if (user.getLevel() instanceof Level2)
        {

        }
        else if (user.getLevel() instanceof Level3)
        {

        }
        else if (user.getLevel() instanceof Level4)
        {

        }*/
    }

    private void moveFigure()
    {

    }

    private void prepareLevel(iEquationType et, iLevel lv)
    {

    }

    public ArrayList<Boolean> generateRoundsList(int tt)
    {
        return null;
    }

    //Kontrolliert ob level bestanden wurde, ist gueltig fuer alle Level
    public boolean isLevelBeat(User user)
    {
        if(user.getLevel() instanceof  Level1)
        {
            if(user.isLevel1Beaten())
            {
                return true;
            }
            else
            {

                if(((Level1) user.getLevel()).getLevelbeatcounter().getBeatCounter() < 5)
                {
                    return false;
                }
                else
                {
                    boolean nothingWrong = true;
                    for(int i = 0; i < (((Level1) user.getLevel()).getLevelbeatcounter().getBeatCounter()); i++)
                    {
                        if(((Level1) user.getLevel()).getLevelbeatcounter().getBeatList().get(i) == false) {
                            nothingWrong = false;
                        }
                    }
                    if(nothingWrong)
                    {
                        user.setLevel1Beaten(true);
                        user.setLevel(new Level2());
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
