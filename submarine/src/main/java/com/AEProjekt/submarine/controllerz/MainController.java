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


    //Level1
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
        this.inputLevel = userInput;
        model.addAttribute("user", user);
        model.addAttribute("userInput", this.inputLevel);
        model.addAttribute("userInputValid", this.inputLevel.isInputValid());

        storyExecution(this.user);

        if(user.getLevel() instanceof Level2)
        {
            return "exampleMainController2";
        }
        else
        {
            return "exampleMainController";
        }
    }
    //Level2
    /*
    Folgende Änderungen müssen immer gemacht werden
    @GetMapping("/exampleMainControllerX")
    public String bootstrapTestX(Model model)

    return "exampleMainControllerX";
    @PostMapping("/exampleMainControllerX")
    public String userInputTestX(@ModelAttribute("userInput") InputLevelX userInput, Model model)
    if(user.getLevel() instanceof LevelX+1)
    return "exampleMainControllerX+1";
    return "exampleMainControllerX";
     */

    @GetMapping("/exampleMainController2")
    public String bootstrapTest2(Model model)
    {
        model.addAttribute("user", user);
        model.addAttribute("userInput", this.inputLevel);

        return "exampleMainController2";
    }
    @PostMapping("/exampleMainController2")
    public String userInputTest2(@ModelAttribute("userInput") InputLevel2 userInput, Model model)
    {
        this.inputLevel = userInput;
        model.addAttribute("user", user);
        model.addAttribute("userInput", this.inputLevel);
        model.addAttribute("userInputValid", this.inputLevel.isInputValid());

        storyExecution(this.user);

        if(user.getLevel() instanceof Level3)
        {
            return "exampleMainController3";
        }
        else
        {
            return "exampleMainController2";
        }
    }
    //Level3
    @GetMapping("/exampleMainController3")
    public String bootstrapTest3(Model model)
    {
        model.addAttribute("user", user);
        model.addAttribute("userInput", this.inputLevel);

        return "exampleMainController3";
    }
    @PostMapping("/exampleMainController3")
    public String userInputTest3(@ModelAttribute("userInput") InputLevel3 userInput, Model model)
    {
        this.inputLevel = userInput;
        model.addAttribute("user", user);
        model.addAttribute("userInput", this.inputLevel);
        model.addAttribute("userInputValid", this.inputLevel.isInputValid());

        storyExecution(this.user);

        if(user.getLevel() instanceof Level4)
        {
            return "exampleMainController4";
        }
        else
        {
            return "exampleMainController3";
        }
    }
    //Level4
    @GetMapping("/exampleMainController4")
    public String bootstrapTest4(Model model)
    {
        model.addAttribute("user", user);
        model.addAttribute("userInput", this.inputLevel);

        return "exampleMainController4";
    }
    @PostMapping("/exampleMainController4")
    public String userInputTest4(@ModelAttribute("userInput") InputLevel4 userInput, Model model)
    {
        this.inputLevel = userInput;
        model.addAttribute("user", user);
        model.addAttribute("userInput", this.inputLevel);
        model.addAttribute("userInputValid", this.inputLevel.isInputValid());

        storyExecution(this.user);

        //if(user.getLevel() instanceof Level5) -- Fuer die erweiterbarkeit mit einem Weiteren Level braucht man das
        if(isLevelBeat(user))
        {
            return "exampleMainControllerWin";
        }
        else
        {
            return "exampleMainController4";
        }
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

    public void playLevel(iLevel level)
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
                ((Level1) level).equipLevelNoRS();
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
                ((Level2) level).equipLevelNoRS();
            }
        }

        if(level instanceof Level3)
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
                ((Level3) level).equipLevelNoRS();
            }
        }

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
                ((Level4) level).equipLevelNoRS();
            }
        }
    }




    //TODO Login Funktion entwickeln (wo kommt user her?)
    public void storyExecution(User user)
    {








        if((user.getLevel() instanceof Level4) && isLevelBeat(user))
        {



            System.out.println("Du hast gewonnen!");


        }

        else
        {

            //Jedes level hat sein eigenen Beatcounter und es muss nicht gecastet werden
            if(inputLevel.isInputValid() == true)
            {
                playLevel((user.getLevel()));

            }



            //TODO
            /*
            if(isLevelBeat(user))
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
            */

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
        if(isLevelBeat(user))
        {
            if(user.getLevel() instanceof  Level1)
            {
                user.setLevel(new Level2());
                inputLevel = new InputLevel2();
            }

            else if (user.getLevel() instanceof  Level2)
            {
                user.setLevel(new Level3());
                inputLevel = new InputLevel3();
            }

            else if (user.getLevel() instanceof  Level3)
            {
                user.setLevel(new Level4());
                inputLevel = new InputLevel4();
            }

        }


    }


    //Die genauere fragestellung die hier erfüllt werden soll ist doch eher, kann der user das level noch gewinnen
    public boolean isLevelBeat(User user)
    {
        if(user.getLevel().getLevelbeatcounter().getBeatList().size() < 5)
        {
            return false;
        }
        else
        {
            int rights = 0;

            for(int i = 0; i < user.getLevel().getLevelbeatcounter().getBeatList().size(); i++)
            {
                if(user.getLevel().getLevelbeatcounter().getBeatList().get(i))
                {
                    rights++;
                }
            }

            return (rights >= 5);

        }




    }

}
