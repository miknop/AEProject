package com.AEProjekt.submarine.InputLevel;

//import com.AEProjekt.submarine.iLInput;
//import com.AEProjekt.submarine.InputControl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InputControlAndInputLevelTests {

    /*
    private iLInput test_input;


    @Test
    public void testController()
    {
        for(int i = 0; i < 4; i++)
        {
            for(int j = 0; j < 100000; j++)
            {
                switch (i) {
                    case 0:
                        TestStructureForInputLevel1 test_gen1;
                        test_gen1 = TestForInputLevel1();

                        test_input = new InputLevel1((int)test_gen1.p1Y, (int)test_gen1.p1X, (int)test_gen1.p2Y, (int)test_gen1.p2X);
                        assertTrue("Ungueltige Gerade.", test_input.isInputValid() == test_gen1.right_or_wrong);
                        break;
                    case 1:
                        TestStructureForInputLevel2 test_gen2;
                        test_gen2 = TestForInputLevel2();

                        test_input = new InputLevel2(test_gen2.pFX);
                        assertTrue("Ungueltiger Y-Wert.", test_input.isInputValid() == test_gen2.right_or_wrong);
                        break;
                    case 2:
                        TestStructureForInputLevel3 test_gen3;
                        test_gen3 = TestForInputLevel3();

                        test_input = new InputLevel3(test_gen3.pX);
                        assertTrue("Ungueltiger X-Wert.", test_input.isInputValid() == test_gen3.right_or_wrong);
                        break;
                    case 3:
                        TestStructureForInputLevel4 test_gen4;
                        test_gen4 = TestForInputLevel4();

                        test_input = new InputLevel4(test_gen4.userNumeratorInput, test_gen4.userDenominatorInput, test_gen4.userYInput);
                        assertTrue("Ungueltiger Zaehler oder Ungueltiger Y-Wert.", test_input.isInputValid() == test_gen4.right_or_wrong);
                        break;
                }
            }
        }
    }

    public TestStructureForInputLevel4 TestForInputLevel4()
    {
        TestStructureForInputLevel4 temp_obj = new TestStructureForInputLevel4();

        //Zuweisung von Werten in die Struktur
        temp_obj.userNumeratorInput = (int)(Math.random() * -5) + (int)(Math.random() * +5);
        temp_obj.userDenominatorInput = (int)(Math.random() * -5) + (int)(Math.random() * +5);
        temp_obj.userYInput = (int)(Math.random() * -100) + (int)(Math.random() * +100);
        temp_obj.right_or_wrong = true;

        if(temp_obj.userYInput < -12 || temp_obj.userYInput > 12)
        {
            temp_obj.right_or_wrong = false;
        }
        else if (temp_obj.userDenominatorInput == 0)
        {
            temp_obj.right_or_wrong = false;
        }
        return temp_obj;
    }

    public TestStructureForInputLevel3 TestForInputLevel3()
    {
        TestStructureForInputLevel3 temp_obj = new TestStructureForInputLevel3();

        //Zuweisung von Werten in die Struktur
        temp_obj.pX = (double)(Math.random() * -100) + (double)(Math.random() * +100);
        temp_obj.right_or_wrong = true;

        if(temp_obj.pX < -12 || temp_obj.pX > 12)
        {
            temp_obj.right_or_wrong = false;
        }

        return temp_obj;
    }

    public TestStructureForInputLevel2 TestForInputLevel2()
    {
        TestStructureForInputLevel2 temp_obj = new TestStructureForInputLevel2();

        //Zuweisung von Werten in die Struktur
        temp_obj.pFX = (double)(Math.random() * -100);
        temp_obj.right_or_wrong = true;

        if(temp_obj.pFX < -12 || temp_obj.pFX > 0)
        {
            temp_obj.right_or_wrong = false;
        }


        return temp_obj;
    }

    public  TestStructureForInputLevel1 TestForInputLevel1()
    {
        TestStructureForInputLevel1 temp_obj = new TestStructureForInputLevel1();

        //Zuweisung von Werten in die Struktur
        temp_obj.p1Y = (double)(Math.random() * -100) + (double)(Math.random() * +100);
        temp_obj.p1X = (double)(Math.random() * -100) + (double)(Math.random() * +100);
        temp_obj.p2Y = (double)(Math.random() * -100) + (double)(Math.random() * +100);
        temp_obj.p2X = (double)(Math.random() * -100) + (double)(Math.random() * +100);
        temp_obj.right_or_wrong = true;

        if(temp_obj.p1Y < -12 || temp_obj.p1Y > 12)
            temp_obj.right_or_wrong = false;
        else if (temp_obj.p1X < -12 || temp_obj.p1X > 12)
            temp_obj.right_or_wrong = false;
        else if (temp_obj.p2Y < -12 || temp_obj.p2Y > 12)
            temp_obj.right_or_wrong = false;
        else if (temp_obj.p2X < -12 || temp_obj.p2X > 12)
            temp_obj.right_or_wrong = false;
        else if (temp_obj.p1X == temp_obj.p2X)
            temp_obj.right_or_wrong = false;


        return temp_obj;
    }
    */
}
