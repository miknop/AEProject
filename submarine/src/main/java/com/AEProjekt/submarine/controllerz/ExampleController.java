package com.AEProjekt.submarine.controllerz;


/*
import com.AEProjekt.submarine.UserInputTest;
import com.AEProjekt.submarine.equations.EquationGenerator;
import com.AEProjekt.submarine.equations.LinearEquationEntity;
import com.AEProjekt.submarine.figures.Submarine;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;



@Controller
public class ExampleController
{

    private com.AEProjekt.submarine.controllerz.Controller abc = new com.AEProjekt.submarine.controllerz.Controller();





    @GetMapping("/example") // Die URL, für keine Subseite einfach @GetMapping()
    public String example(@RequestParam(name="gleichung", required=false, defaultValue="gleichung") String gleichung, Model model)
    {
        LinearEquationEntity equation = EquationGenerator.generateLinearEquation();
        model.addAttribute("gleichung", equation);
        model.addAttribute("submarine", new Submarine(EquationGenerator.generatePointBelowSea(equation)));
        model.addAttribute("plane", new Submarine(EquationGenerator.generatePointAboveSea(equation)));
        return "example";
    }

    @GetMapping("/bootstrapTest")
    public String bootstrapTest(Model model)
    {
        model.addAttribute("message", "Bootstrap Test");
        return "bootstrapTest";
    }

    @GetMapping("/userInputTest")
    public String userInputTest(Model model)
    {
        model.addAttribute("userInput", new UserInputTest());
        model.addAttribute("fkt", abc.getUser().getLevel().getLinEq().toString());
        return "userInputTest";
    }


    @PostMapping("/userInputTest")
    public String userInputTest(@Valid @ModelAttribute("userInput") UserInputTest userInput, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {

            return "userInputTest";
        }


        abc.storyBeforeExecution(userInput);

        return "userInputTestResult";
    }
}
*/