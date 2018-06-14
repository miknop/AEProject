package com.AEProjekt.submarine.controllerz;


import com.AEProjekt.submarine.UserInputTest;
import com.AEProjekt.submarine.users.User;
import com.AEProjekt.submarine.InputLevel.*;
import com.AEProjekt.submarine.equations.EquationGenerator;
import com.AEProjekt.submarine.equations.*;
import com.AEProjekt.submarine.figures.Ship;
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
        inputLevel = new InputLevel1();
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
    public String userInputTest(@ModelAttribute("userInput") InputLevel1 userInput, Model model)
    {

        model.addAttribute("user", user);
        model.addAttribute("userInput", this.inputLevel);

        this.inputLevel = userInput;

        //storyExecution(this.user);

        return "exampleMainController";
    }

    @GetMapping("/example") // Die URL, für keine Subseite einfach @GetMapping()
    public String example(@RequestParam(name="gleichung", required=false, defaultValue="gleichung") String gleichung, Model model)
    {
        LinearEquation equation = EquationGenerator.generateLinearEquation();
        model.addAttribute("gleichung", equation);
        model.addAttribute("submarine", new Submarine(EquationGenerator.generatePointBelowSea(equation)));
        model.addAttribute("plane", new Submarine(EquationGenerator.generatePointAboveSea(equation)));
        return "example";
    }

    @GetMapping("/level1") // Die URL, für keine Subseite einfach @GetMapping()
    public String level1(Model model, iLInput input)
    {
        LinearEquation equation = EquationGenerator.generateLinearEquation();
        model.addAttribute("gleichung", equation);
        model.addAttribute("submarine", new Submarine(EquationGenerator.generatePointBelowSea(equation)));
        model.addAttribute("plane", new Submarine(EquationGenerator.generatePointAboveSea(equation)));
        model.addAttribute("input", new InputLevel1());
        return "level1";
    }

    @PostMapping("/level1") // Die URL, für keine Subseite einfach @GetMapping()
    public String level1Input(@ModelAttribute("userInput") InputLevel1 userInput, Model model)
    {
        LinearEquation equation = EquationGenerator.generateLinearEquation();
        model.addAttribute("gleichung", equation);
        model.addAttribute("submarine", new Submarine(EquationGenerator.generatePointBelowSea(equation)));
        model.addAttribute("plane", new Submarine(EquationGenerator.generatePointAboveSea(equation)));
        model.addAttribute("input", userInput);
        model.addAttribute("result", true); //TODO Überprüfen ob wirklich richtig
        return "level1";
    }

    @GetMapping("/level2") // Die URL, für keine Subseite einfach @GetMapping()
    public String level2(Model model, iLInput input)
    {
        LinearEquation equation = EquationGenerator.generateLinearEquation();
        model.addAttribute("gleichung", equation);
        model.addAttribute("submarine", new Submarine(EquationGenerator.generatePointBelowSea(equation)));
        model.addAttribute("plane", new Submarine(EquationGenerator.generatePointAboveSea(equation)));
        model.addAttribute("input", new InputLevel1());
        return "level1";
    }

    @PostMapping("/level2") // Die URL, für keine Subseite einfach @GetMapping()
    public String level2Input(@ModelAttribute("userInput") InputLevel1 userInput, Model model)
    {
        LinearEquation equation = EquationGenerator.generateLinearEquation();
        model.addAttribute("gleichung", equation);
        model.addAttribute("submarine", new Submarine(EquationGenerator.generatePointBelowSea(equation)));
        model.addAttribute("plane", new Submarine(EquationGenerator.generatePointAboveSea(equation)));
        model.addAttribute("result", true); //TODO Überprüfen ob wirklich richtig
        return "level2";
    }

    @GetMapping("/level3") // Die URL, für keine Subseite einfach @GetMapping()
    public String level3(Model model, iLInput input)
    {
        LinearEquation equation = EquationGenerator.generateLinearEquation();
        model.addAttribute("gleichung", equation);
        model.addAttribute("submarine", new Submarine(EquationGenerator.generatePointBelowSea(equation)));
        model.addAttribute("plane", new Submarine(EquationGenerator.generatePointAboveSea(equation)));
        model.addAttribute("input", new InputLevel1());
        return "level1";
    }

    @PostMapping("/level3") // Die URL, für keine Subseite einfach @GetMapping()
    public String level3Input(@ModelAttribute("userInput") InputLevel1 userInput, Model model)
    {
        LinearEquation equation = EquationGenerator.generateLinearEquation();
        model.addAttribute("gleichung", equation);
        model.addAttribute("submarine", new Submarine(EquationGenerator.generatePointBelowSea(equation)));
        model.addAttribute("plane", new Submarine(EquationGenerator.generatePointAboveSea(equation)));
        model.addAttribute("result", true); //TODO Überprüfen ob wirklich richtig
        return "level3";
    }

    @GetMapping("/level4") // Die URL, für keine Subseite einfach @GetMapping()
    public String level4(Model model, iLInput input)
    {
        LinearEquation equation = EquationGenerator.generateLinearEquation();
        model.addAttribute("gleichung", equation);
        model.addAttribute("submarine", new Submarine(EquationGenerator.generatePointBelowSea(equation)));
        model.addAttribute("plane", new Submarine(EquationGenerator.generatePointAboveSea(equation)));
        model.addAttribute("input", new InputLevel1());
        return "level4";
    }

    @PostMapping("/level4") // Die URL, für keine Subseite einfach @GetMapping()
    public String level4Input(@ModelAttribute("userInput") InputLevel1 userInput, Model model)
    {
        LinearEquation equation = EquationGenerator.generateLinearEquation();
        model.addAttribute("gleichung", equation);
        model.addAttribute("submarine", new Submarine(EquationGenerator.generatePointBelowSea(equation)));
        model.addAttribute("plane", new Submarine(EquationGenerator.generatePointAboveSea(equation)));
        model.addAttribute("result", true); //TODO Überprüfen ob wirklich richtig
        return "level4";
    }




















    /*public void playLevel(iLevel level)
    {
        if(level instanceof  Level1)
        {
            int m1 = ((InputLevel1) inputLevel).getP2Y() - ((InputLevel1) inputLevel).getP1Y();
            int m2 = ((InputLevel1) inputLevel).getP2X() - ((InputLevel1) inputLevel).getP1X();

            int m = 0;
            double m_doub = 0;

            //Es darf nicht durch null geteilt werden
            if(m2 != 0)
            {
                m = m1/m2;
                m_doub = (double)m1 / (double)m2;
            }



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

        if(level instanceof  Level2)
        {
            Point temp_point = new Point(((Level2) level).getSubmarine().getPoint().getX(), ((InputLevel2) inputLevel).getPFX());

            if(temp_point.compareTo(((Level2) level).getSubmarine().getPoint()) == 0)
            {
                ((Level2) level).getLevelbeatcounter().fillResultOfRound(true);
                ((Level2) level).equipLevelNoRS();
            }
            else
            {
                ((Level2) level).getLevelbeatcounter().fillResultOfRound(false);
            }
        }*/

        /*if(level instanceof Level3)
        {
            Point temp_point = new Point(((InputLevel3) inputLevel).getPX(), ((Level3) level).getSubmarine().getPoint().getY());

            if(temp_point.compareTo(((Level3) level).getSubmarine().getPoint()) == 0)
            {
                ((Level3) level).getLevelbeatcounter().fillResultOfRound(true);
                ((Level3) level).equipLevelNoRS();
            }
            else
            {
                ((Level3) level).getLevelbeatcounter().fillResultOfRound(false);
            }
        }*/
        /*
        if(level instanceof Level4)
        {
            LinearEquation temp_linearequation = new LinearEquation(((InputLevel4) inputLevel).getUserNumeratorInput(),((InputLevel4) inputLevel).getUserDenominatorInput(), ((InputLevel4) inputLevel).getUserYInput());

            if(temp_linearequation.compareTo(((Level4) level).getLinEq()) == 0)
            {
                ((Level4) level).getLevelbeatcounter().fillResultOfRound(true);
                ((Level4) level).equipLevelNoRS();
            }
            else
            {
                ((Level4) level).getLevelbeatcounter().fillResultOfRound(false);
            }
        }
    } */




    //TODO Login Funktion entwickeln (wo kommt user her?)
   /* public void storyExecution(User user)
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











    }*/

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
