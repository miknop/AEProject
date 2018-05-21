package com.AEProjekt.submarine.equation;

import com.AEProjekt.submarine.equations.EquationGenerator;
import com.AEProjekt.submarine.equations.LinearEquation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EquationGeneratorTests {

    @Test
    public void testLinearEquations()
    {
        for (int i = 0; i < 1000; i++)
        {
            LinearEquation linear = EquationGenerator.generateLinearEquation();
            System.out.print(linear.toString());
            System.out.println(" Submarine" + EquationGenerator.generatePointBelowSea(linear).toString() + ", " + " Ufo" + EquationGenerator.generatePointAboveSea(linear).toString() + "");
            assertTrue("Zähler nicht im Bereich von -12 bis 12", linear.getDividend() >= -12 && linear.getDividend() <= 12);
            assertTrue("Nenner nicht im Bereich von 1 bis 12",linear.getDivisor() >= 1 && linear.getDivisor() <= 12);
            assertTrue("Y-Achsenabschnitt nicht im Bereich von -12 bis 12", linear.getB() >= -12 && linear.getB() <= 12);
        }
    }


}
