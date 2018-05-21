package com.AEProjekt.submarine.controllerz;



import com.AEProjekt.submarine.equations.EquationGenerator;
import com.AEProjekt.submarine.equations.LinearEquation;
import com.AEProjekt.submarine.figures.Submarine;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExampleController
{
    @GetMapping("/example") // Die URL, für keine Subseite einfach @GetMapping()
    public String example(@RequestParam(name="gleichung", required=false, defaultValue="gleichung") String gleichung, Model model)
    {
        LinearEquation equation = EquationGenerator.generateLinearEquation();
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

}