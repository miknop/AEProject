package com.AEProjekt.submarine.controllerz;


import com.AEProjekt.submarine.users.User;
import com.AEProjekt.submarine.InputLevel.*;
import com.AEProjekt.submarine.equations.EquationGenerator;
import com.AEProjekt.submarine.equations.*;
import com.AEProjekt.submarine.figures.Ship;
import com.AEProjekt.submarine.levelz.*;

import java.util.ArrayList;

public class Controller {
    private EquationGenerator equation;
    private linearEquation linearequation;
    private iLInput inputLevel;
    private InputControl validInput;
    private User user;
    private Ship ship;



    public void storyExecution()
    {
        //Pruefe ob schon eine Gleichung generiert wurde
        //wenn nein, generiere
        if(linearequation == null && !(user.getLevel() instanceof Level5))
        {
            equation = new EquationGenerator();
            equation.generateEquation(1);
            int m1 = equation.getUfoY() - equation.getSubmarineY();
            int m2 = equation.getUfoX() - equation.getSubmarineX();
            int m = m1/m2;

            linearequation = new linearEquation(m1,m2, equation.getSubmarineY() + m * equation.getSubmarineX() * (-1));


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

                linearEquation temp_linearequation = new linearEquation((int)m1,(int)m2, (int)(inputLevel.getP1Y() + m * inputLevel.getP1X() * (-1)));
                //Wenn jetzt nun diese zwei geraden identischh sind, kann er im level aufsteigen (mann muss doch irgendwas definieren um zwei klassen comparen zu koennen??).
                // if(temp_linearequation.equals(linearEquation)) //sry ich muste mal compilen
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

        }
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

    public void isLevelBeat(int ml)
    {

    }

}
