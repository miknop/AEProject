package com.AEProjekt.submarine.controllerz;


import com.AEProjekt.submarine.InputLevel.*;
import com.AEProjekt.submarine.equations.EquationGenerator;
import com.AEProjekt.submarine.equations.LinearEquation;
import com.AEProjekt.submarine.equations.Point;
import com.AEProjekt.submarine.equations.iEquationType;
import com.AEProjekt.submarine.figures.Submarine;
import com.AEProjekt.submarine.levelz.*;
import com.AEProjekt.submarine.persistence.services.UserService;
import com.AEProjekt.submarine.users.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    private UserService userService;


    public MainController(UserService aUserService) {
        inputLevel = new InputLevel1();
        user = new User();
        userService = aUserService;
    }


    //Level1
    @GetMapping("/exampleMainController")
    public String bootstrapTest(Model model) {
        model.addAttribute("user", user);
        model.addAttribute("userInput", this.inputLevel);

        iLevel level = user.getLevel();
        if (level instanceof Level1) {
            return "exampleMainController";
        } else if (level instanceof Level2) {
            return "redirect:/exampleMainController2";
        } else if (level instanceof Level3) {
            return "redirect:/exampleMainController3";
        } else if (level instanceof Level4) {
            return "redirect:/exampleMainController4";
        } else {
            return "redirect:/exampleMainControllerWin";
        }
    }

    @GetMapping("/exampleMainController2")
    public String bootstrapTest2(Model model) {
        model.addAttribute("user", user);
        model.addAttribute("userInput", this.inputLevel);

        iLevel level = user.getLevel();
        if (level instanceof Level1) {
            return "redirect:/exampleMainController";
        } else if (level instanceof Level2) {
            return "exampleMainController2";
        } else if (level instanceof Level3) {
            return "redirect:/exampleMainController3";
        } else if (level instanceof Level4) {
            return "redirect:/exampleMainController4";
        } else {
            return "redirect:/exampleMainControllerWin";
        }

    }

    @PostMapping("/exampleMainController2")
    public String userInputTest2(@ModelAttribute("userInput") InputLevel2 userInput, Model model) {
        this.inputLevel = userInput;
        model.addAttribute("user", user);
        model.addAttribute("userInput", this.inputLevel);
        model.addAttribute("userInputValid", this.inputLevel.isInputValid());

        storyExecution(this.user);


        if (user.getLevel() instanceof Level3) {
            return "exampleMainController3";
        } else {
            return "exampleMainController2";
        }
    }

    //Level3
    @GetMapping("/exampleMainController3")
    public String bootstrapTest3(Model model) {
        model.addAttribute("user", user);
        model.addAttribute("userInput", this.inputLevel);

        iLevel level = user.getLevel();
        if (level instanceof Level1) {
            return "redirect:/exampleMainController";
        } else if (level instanceof Level2) {
            return "redirect:/exampleMainController2";
        } else if (level instanceof Level3) {
            return "exampleMainController3";
        } else if (level instanceof Level4) {
            return "redirect:/exampleMainController4";
        } else {
            return "redirect:/exampleMainControllerWin";
        }
    }

    @PostMapping("/exampleMainController3")
    public String userInputTest3(@ModelAttribute("userInput") InputLevel3 userInput, Model model) {
        this.inputLevel = userInput;
        model.addAttribute("user", user);
        model.addAttribute("userInput", this.inputLevel);
        model.addAttribute("userInputValid", this.inputLevel.isInputValid());

        storyExecution(this.user);

        if (user.getLevel() instanceof Level4) {
            return "exampleMainController4";
        } else {
            return "exampleMainController3";
        }
    }

    //Level4
    @GetMapping("/exampleMainController4")
    public String bootstrapTest4(Model model) {
        model.addAttribute("user", user);
        model.addAttribute("userInput", this.inputLevel);

        iLevel level = user.getLevel();
        if (level instanceof Level1) {
            return "redirect:/exampleMainController";
        } else if (level instanceof Level2) {
            return "redirect:/exampleMainController2";
        } else if (level instanceof Level3) {
            return "redirect:/exampleMainController3";
        } else if (level instanceof Level4) {
            return "exampleMainController4";
        } else {
            return "redirect:/exampleMainControllerWin";
        }
    }


    @PostMapping("/exampleMainController4")
    public String userInputTest4(@ModelAttribute("userInput") InputLevel4 userInput, Model model) {
        this.inputLevel = userInput;
        model.addAttribute("user", user);
        model.addAttribute("userInput", this.inputLevel);
        model.addAttribute("userInputValid", this.inputLevel.isInputValid());

        storyExecution(this.user);

        //if(user.getLevel() instanceof Level5) -- Fuer die erweiterbarkeit mit einem Weiteren Level braucht man das
        if (isLevelBeat(user)) {
            return "exampleMainControllerWin";
        } else {
            return "exampleMainController4";
        }
    }


    @GetMapping("/example") // Die URL, für keine Subseite einfach @GetMapping()
    public String example(@RequestParam(name = "gleichung", required = false, defaultValue = "gleichung") String gleichung, Model model) {
        LinearEquation equation = EquationGenerator.generateLinearEquation();
        model.addAttribute("gleichung", equation);
        model.addAttribute("submarine", new Submarine(EquationGenerator.generatePointBelowSea(equation)));
        model.addAttribute("plane", new Submarine(EquationGenerator.generatePointAboveSea(equation)));

        model.addAttribute("user", user);
        model.addAttribute("userInput", this.inputLevel);
        iLevel level = user.getLevel();
        return "example";
    }

    @PostMapping("/example")
    public String userInputTest(@ModelAttribute("userInput") InputLevel1 userInput, Model model) {
        this.inputLevel = userInput;
        model.addAttribute("user", user);
        model.addAttribute("userInput", this.inputLevel);
        model.addAttribute("userInputValid", this.inputLevel.isInputValid());
        LinearEquation equation = EquationGenerator.generateLinearEquation();
        model.addAttribute("gleichung", equation);
        model.addAttribute("submarine", new Submarine(EquationGenerator.generatePointBelowSea(equation)));
        model.addAttribute("plane", new Submarine(EquationGenerator.generatePointAboveSea(equation)));
        storyExecution(this.user);

        if (user.getLevel() instanceof Level2) {
            return "exampleMainController2";
        } else {
            return "example";
        }
    }

    /**
     * Hier wird das Level sozusagen gespielt. Hier finden ableiche statt, wie z.B. ist die Aufgespannte Gerade aus den zwei
     * Punkten, die der Benutzer eingezeichnet hat gleich zu der generierten Geraden ist. Hat der Benutzer eine richtige Eingabe
     * gemacht, wird das Ergebnis der akutellen spielrunde in form von einer boolischen Liste eingetragen.
     * @author Simon Freygang
     */
    public void playLevel(iLevel level) {
        if (level instanceof Level1) {
            int m1 = ((InputLevel1) inputLevel).getP2Y() - ((InputLevel1) inputLevel).getP1Y();
            int m2 = ((InputLevel1) inputLevel).getP2X() - ((InputLevel1) inputLevel).getP1X();

            int m = 0;
            double m_doub = 0;

            //Es darf nicht durch null geteilt werden
            if (m2 != 0) {
                m = m1 / m2;
                m_doub = (double) m1 / (double) m2;
            }


            LinearEquation temp_linearequation = new LinearEquation(m1, m2, (int) ((double) ((InputLevel1) inputLevel).getP1Y()
                    + m_doub * (double) ((InputLevel1) inputLevel).getP1X() * (-1)));


            if (temp_linearequation.compareTo(level.getLinEq()) == 0) {
                level.getLevelbeatcounter().fillResultOfRound(true);
                userService.updateUserEntity(user);
                ((Level1) level).equipLevelNoRS();
            } else {
                level.getLevelbeatcounter().fillResultOfRound(false);
                userService.updateUserEntity(user);
                ((Level1) level).equipLevelNoRS();
            }

        }

        if (level instanceof Level2) {
            Point temp_point = new Point(((Level2) level).getSubmarine().getPoint().getX(), ((InputLevel2) inputLevel).getPFX());

            if (temp_point.compareTo(((Level2) level).getSubmarine().getPoint()) == 0) {
                level.getLevelbeatcounter().fillResultOfRound(true);
                userService.updateUserEntity(user);
                ((Level2) level).equipLevelNoRS();
            } else {
                level.getLevelbeatcounter().fillResultOfRound(false);
                userService.updateUserEntity(user);
                ((Level2) level).equipLevelNoRS();
            }
        }

        if (level instanceof Level3) {
            Point temp_point = new Point(((InputLevel3) inputLevel).getPX(), ((Level3) level).getSubmarine().getPoint().getY());

            if (temp_point.compareTo(((Level3) level).getSubmarine().getPoint()) == 0) {
                level.getLevelbeatcounter().fillResultOfRound(true);
                userService.updateUserEntity(user);
                ((Level3) level).equipLevelNoRS();
            } else {
                level.getLevelbeatcounter().fillResultOfRound(false);
                userService.updateUserEntity(user);
                ((Level3) level).equipLevelNoRS();
            }
        }

        if (level instanceof Level4) {
            LinearEquation temp_linearequation = new LinearEquation(((InputLevel4) inputLevel).getUserNumeratorInput(),
                    ((InputLevel4) inputLevel).getUserDenominatorInput(), ((InputLevel4) inputLevel).getUserYInput());

            if (temp_linearequation.compareTo(level.getLinEq()) == 0) {
                level.getLevelbeatcounter().fillResultOfRound(true);
                userService.updateUserEntity(user);
                ((Level4) level).equipLevelNoRS();
            } else {
                level.getLevelbeatcounter().fillResultOfRound(false);
                userService.updateUserEntity(user);
                ((Level4) level).equipLevelNoRS();
            }
        }
    }

    /**
     * Diese Methode wird bei jeder entgegenname von Post-Parametern aufgerufen. Sie ruft unteranderem die playLevel(iLevel level)
     * Methode auf. Hier wird abgefangen, ob der Nutzer das letzt Level geschlagen und damit gewonnen hat. Zusätzlich ruft sie nach
     * jedem playLevel(iLevel level) die Methode setToNextLevel(User user) auf.
     * @author Simon Freygang
     */
    //TODO Login Funktion entwickeln (wo kommt user her?)
    public void storyExecution(User user) {
        if ((user.getLevel() instanceof Level4) && isLevelBeat(user)) {
            System.out.println("Du hast gewonnen!");
        } else {
            //Jedes level hat sein eigenen Beatcounter und es muss nicht gecastet werden
            if (inputLevel.isInputValid()) {
                playLevel((user.getLevel()));
            }
            //Nachdem die runde gespielt wurde, kann nun eine entscheidung getroffen werden, ob er in das naechste kommt
            setToNextLevel(user);
        }
    }

    private void moveFigure(User user) {

    }

    private void prepareLevel(iEquationType et, iLevel lv) {

    }

    public ArrayList<Boolean> generateRoundsList(int tt) {
        return null;
    }

    /**
    * Mit Hilfe der Methode isLevelBeat(User user) wird der Benutzer in das nächste Level befördert.
    * Die Methode isLevelBeat(User user) gibt einen boolischen Wert zurück der, wenn er true ist, den
    * Benutzer in das nächste Level bringt. Zusätzlich muss danach noch geprüft werden, in welchem Level
    * er sich gerade befindet, damit das Programm weiß, in welches Level der Benutzer als nächstes gebracht werden muss.
    * @author Simon Freygang
    */
    public void setToNextLevel(User user) {
        //Die Fragstellung hier ist doch, koennte er es nach wie vor gewinnen und hat er seinen soll erfuellt
        if (isLevelBeat(user)) {
            if (user.getLevel() instanceof Level1) {
                user.setLevel(new Level2());
                inputLevel = new InputLevel2();
            } else if (user.getLevel() instanceof Level2) {
                user.setLevel(new Level3());
                inputLevel = new InputLevel3();
            } else if (user.getLevel() instanceof Level3) {
                user.setLevel(new Level4());
                inputLevel = new InputLevel4();
            }

        }


    }


    /**
     * Gibt einen boolischen Wert zurück. Hier wird geprüft, ob er aus den Letzten spielen fünf stück Gewonnen hat.
     * Hat er noch keine fünf Spiele im aktuellen Level gespielt, wird in jedem fall False zurück gegeben.
     * @author Simon Freygang
     */
    public boolean isLevelBeat(User user) {
        if (user.getLevel().getLevelbeatcounter().getBeatList().size() < 5) {
            return false;
        } else {
            int rights = 0;

            for (int i = 0; i < user.getLevel().getLevelbeatcounter().getBeatList().size(); i++) {
                if (user.getLevel().getLevelbeatcounter().getBeatList().get(i)) {
                    rights++;
                }
            }

            return (rights >= 5);

        }


    }

}
