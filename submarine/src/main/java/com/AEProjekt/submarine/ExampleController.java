package com.AEProjekt.submarine;



import com.AEProjekt.submarine.equations.EquationGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExampleController
{
    EquationGenerator generator = new EquationGenerator();

    @GetMapping("/example") // Die URL, für keine Subseite einfach @GetMapping()
    public String example(@RequestParam(name="gleichung", required=false, defaultValue="gleichung") String gleichung, Model model)
    {
        generator.generateEquation(1);
        model.addAttribute("gleichung", generator.getEquation().toString());
        return "example";
    }

}