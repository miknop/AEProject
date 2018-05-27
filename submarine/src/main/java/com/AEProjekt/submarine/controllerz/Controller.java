package com.AEProjekt.submarine.controllerz;


import com.AEProjekt.submarine.UserInputTest;
import com.AEProjekt.submarine.users.User;
import com.AEProjekt.submarine.InputLevel.*;
import com.AEProjekt.submarine.equations.EquationGenerator;
import com.AEProjekt.submarine.equations.*;
import com.AEProjekt.submarine.figures.Ship;
import com.AEProjekt.submarine.levelz.*;
import jdk.internal.util.xml.impl.Input;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Data
@AllArgsConstructor

public class Controller {
    private EquationGenerator generator;
    private LinearEquation linearEquation = null;
    private iLInput inputLevel;
    private InputControl validInput;
    private User user;
    private Ship ship;





    public Controller()
    {
        //if(user == null)
            user = new User();
    }



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
                ((Level1) level).getLevelbeatcounter().fillResultOfRound(false);
            }

        }

    }



    public void storyBeforeExecution(UserInputTest aninputtest)
    {
        inputLevel = new InputLevel1();

        ((InputLevel1) inputLevel).setP1X(aninputtest.getPunkt1().getX());
        ((InputLevel1) inputLevel).setP1Y(aninputtest.getPunkt1().getY());
        ((InputLevel1) inputLevel).setP2X(aninputtest.getPunkt2().getX());
        ((InputLevel1) inputLevel).setP2Y(aninputtest.getPunkt2().getY());



        storyExecution(user);


    }

    //TODO Login Funktion entwickeln (wo kommt user her?)
    public void storyExecution(User user)
    {







        //while (isLevelBeat(user) && !(user.getLevel() instanceof Level4) &&  user.getLevel().getLevelbeatcounter().getBeatCounter() < 7 ) {
        if((user.getLevel() instanceof Level4) && isLevelBeat(user) && user.getLevel().getLevelbeatcounter().getBeatCounter() == 7)
        {



            System.out.println("Du hast gewonnen!");


        }

        else
        {

            if(!isLevelBeat(user))
            {
                if(user.getLevel() instanceof  Level1)
                    user.setLevel(new Level1());
                else if (user.getLevel() instanceof  Level2)
                    user.setLevel(new Level2());
                else if (user.getLevel() instanceof  Level3)
                    user.setLevel(new Level3());
                else if (user.getLevel() instanceof  Level4)
                    user.setLevel(new Level4());
            }

            //Jedes level hat sein eigenen Beatcounter und es muss nicht gecastet werden
            playLevel((user.getLevel()));
            //Nachdem die runde gespielt wurde, kann nun eine entscheidung getroffen werden, ob er in das naechste kommt
            setToNextLevel(user);
        }










        //Pruefe ob schon eine Gleichung generiert wurde
        //wenn nein, generiere
        /*
        if(linearEquation == null && !(user.getLevel() instanceof Level5))
        {
            linearEquation = EquationGenerator.generateLinearEquation();

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

    private void moveFigure(User user)
    {

    }

    private void prepareLevel(iEquationType et, iLevel lv)
    {

    }

    public ArrayList<Boolean> generateRoundsList(int tt)
    {
        return null;
    }


    public void setToNextLevel(User user)
    {
        //Die Fragstellung hier ist doch, koennte er es nach wie vor gewinnen und hat er seinen soll erfuellt
        if(isLevelBeat(user) && user.getLevel().getLevelbeatcounter().getBeatCounter() == 7)
        {
            if(user.getLevel() instanceof  Level1)
                user.setLevel(new Level2());
            else if (user.getLevel() instanceof  Level2)
                user.setLevel(new Level3());
            else if (user.getLevel() instanceof  Level3)
                user.setLevel(new Level4());
        }


    }
    //Die genauere fragestellung die hier erfüllt werden soll ist doch eher, kann der user das level noch gewinnen
    public boolean isLevelBeat(User user)
    {
        /*
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
        */

        int wrongs = 0;
        for(int i = 0; i < ((user.getLevel()).getLevelbeatcounter().getBeatCounter()); i++)
        {
            if((user.getLevel()).getLevelbeatcounter().getBeatList().get(i) == false) {
                wrongs++;
            }
        }

        if(wrongs >= 2)
        {
            return false;
        }
        else
        {
            return true;
        }



    }

}
