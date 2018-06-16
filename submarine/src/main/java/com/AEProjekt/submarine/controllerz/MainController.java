package com.AEProjekt.submarine.controllerz;


import com.AEProjekt.submarine.UserInputTest;
import com.AEProjekt.submarine.users.User;
import com.AEProjekt.submarine.InputLevel.*;
import com.AEProjekt.submarine.equations.EquationGenerator;
import com.AEProjekt.submarine.equations.*;
import com.AEProjekt.submarine.figures.Ship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.AEProjekt.submarine.levelz.*;
import jdk.internal.util.xml.impl.Input;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.AEProjekt.submarine.UserInputTest;
import com.AEProjekt.submarine.equations.EquationGenerator;
import com.AEProjekt.submarine.equations.LinearEquation;
import com.AEProjekt.submarine.figures.Submarine;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

//@Data
//@AllArgsConstructor

@Controller
public class MainController {
    private EquationGenerator generator;
    private LinearEquation linearEquation = null;
    private iLInput inputLevel;
    private InputControl validInput;
    private User user;
    private Ship ship;



    public MainController()
    {
        inputLevel = new InputLevel2();
        user = new User();
    }


    @GetMapping("/exampleMainController")
    public String bootstrapTest(Model model)
    {
        model.addAttribute("user", user);
        model.addAttribute("userInput", this.inputLevel);

        return "exampleMainController";
    }

    @PostMapping("/exampleMainController")
    public String userInputTest(@Autowired @ModelAttribute("userInput") iLInput userInput, Model model)
    {

        model.addAttribute("user", user);
        model.addAttribute("userInput", this.inputLevel);

        this.inputLevel = userInput;

        storyExecution(this.user);

        return "exampleMainController";
    }



    public void playLevel(iLevel level)
    {
        if(level instanceof  Level1)
        {
            int m1 = ((InputLevel1) inputLevel).getP2Y() - ((InputLevel1) inputLevel).getP1Y();
            int m2 = ((InputLevel1) inputLevel).getP2X() - ((InputLevel1) inputLevel).getP1X();
            int m = m1/m2;
            double m_doub = (double)m1 / (double)m2;


            LinearEquation temp_linearequation = new LinearEquation(m1, m2, (int)((double)((InputLevel1) inputLevel).getP1Y() + m_doub * (double)((InputLevel1) inputLevel).getP1X() * (-1)));


            if(temp_linearequation.compareTo( ((Level1) level).getLinEq()) == 0)
            {
                ((Level1) level).getLevelbeatcounter().fillResultOfRound(true);
                ((Level1) level).equipLevelNoRS();
            }
            else
            {
                ((Level1) level).getLevelbeatcounter().fillResultOfRound(false);
            }

        }

        if(level instanceof Level2)
        {
            Point temp_point = new Point(((Level2) level).getSubmarine().getXPosition(), ((InputLevel2) inputLevel).getPFX());

            if(temp_point.compareTo(((Level2) level).getSubmarine().getPoint()) == 0)
            {
                ((Level2) level).getLevelbeatcounter().fillResultOfRound(true);
                ((Level2) level).equipLevelNoRS();
            }
            else
            {
                ((Level2) level).getLevelbeatcounter().fillResultOfRound(false);
            }
        }

    }





    //TODO Login Funktion entwickeln (wo kommt user her?)
    public void storyExecution(User user)
    {








        if((user.getLevel() instanceof Level4) && isLevelBeat(user) && user.getLevel().getLevelbeatcounter().getBeatCounter() == 7)
        {



            System.out.println("Du hast gewonnen!");


        }

        else
        {

            //Jedes level hat sein eigenen Beatcounter und es muss nicht gecastet werden
            playLevel((user.getLevel()));

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


            //Nachdem die runde gespielt wurde, kann nun eine entscheidung getroffen werden, ob er in das naechste kommt
            setToNextLevel(user);
        }











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
            {
                user.setLevel(new Level2());
                this.inputLevel = new InputLevel2();
            }
            else if (user.getLevel() instanceof  Level2)
            {
                user.setLevel(new Level3());
                this.inputLevel = new InputLevel3();
            }

            else if (user.getLevel() instanceof  Level3)
            {
                user.setLevel(new Level4());
                this.inputLevel = new InputLevel4();
            }

        }


    }


    //Die genauere fragestellung die hier erfüllt werden soll ist doch eher, kann der user das level noch gewinnen
    public boolean isLevelBeat(User user)
    {


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
