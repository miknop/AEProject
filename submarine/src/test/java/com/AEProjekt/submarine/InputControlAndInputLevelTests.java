package com.AEProjekt.submarine;

import com.AEProjekt.submarine.iLInput;
import com.AEProjekt.submarine.InputControl;


public class TestStructureForInputLevel1
{
    public boolean right_or_wrong;
    public double p1Y;
    public double p1X;
    public double p2Y;
    public double p2X;
}

public class InputControlAndInputLevelTests {

    private iLInput test_input;



    public void testController()
    {
        for(int i = 0; i < 4; i++)
        {
            for(int j = 0; i < 1000; i++)
            {
                switch (i) {
                    case 0:
                        TestStructureForInputLevel1 test_gen;
                        test_gen = TestForInputLevel1();

                        test_input = new InputLevel1(test_gen.p1Y, test_gen.p1X, test_gen.p2Y, test_gen.p2X);

                        if(test_gen.right_or_wrong == test_input.isInputValid())
                        {
                            System.out.print("Erfolgreich");
                        }
                        else
                        {
                            System.out.print("Nicht erfolgreich");
                        }

                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                }
            }
        }
    }

    public  TestStructureForInputLevel1 TestForInputLevel1()
    {
        TestStructureForInputLevel1 temp_obj = new TestStructureForInputLevel1();

        //Zuweisung von Werten in die Struktur
        temp_obj.p1Y = (int)(Math.random() * -100) + 100;
        temp_obj.p1X = (int)(Math.random() * -100) + 100;
        temp_obj.p2Y = (int)(Math.random() * -100) + 100;
        temp_obj.p2X = (int)(Math.random() * -100) + 100;
        temp_obj.right_or_wrong = true;

        if(temp_obj.p1Y <= -12 || temp_obj.p1Y >= 12)
            temp_obj.right_or_wrong = false;
        else if (temp_obj.p1X <= -12 || temp_obj.p1X >= 12)
            temp_obj.right_or_wrong = false;
        else if (temp_obj.p2Y <= -12 || temp_obj.p2Y >= 12)
            temp_obj.right_or_wrong = false;
        else if (temp_obj.p2X <= -12 || temp_obj.p2X >= 12)
            temp_obj.right_or_wrong = false;
        else if (temp_obj.p1X == temp_obj.p2X)
            temp_obj.right_or_wrong = false;


        return temp_obj;
    }
}
