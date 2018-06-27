package com.AEProjekt.submarine;

import com.AEProjekt.submarine.equations.Point;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.constraints.Digits;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInputTest {
    private Point punkt1;
    private Point punkt2;

    //integer = anzahl der ziffern, fraction = anzahl d. nachkomma stellen in dem fall keine)
    @Digits(integer = 10, fraction = 0, message = "Es muss eine gültige Zahl eingegeben werden")
    private int divident;

    @Digits(integer = 10, fraction = 0, message = "Es muss eine gültige Zahl eingegeben werden")
    private int divisor;

    @Digits(integer = 10, fraction = 0, message = "Es muss eine gültige Zahl eingegeben werden")
    private int b;


}
