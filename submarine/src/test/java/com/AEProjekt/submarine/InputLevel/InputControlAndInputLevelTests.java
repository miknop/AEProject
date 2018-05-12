package com.AEProjekt.submarine;

import com.AEProjekt.submarine.iLInput;
import com.AEProjekt.submarine.InputControl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InputControlAndInputLevelTests {

    private iLInput test_input;


    @Test
    public void testController()
    {
        for(int i = 0; i < 4; i++)
        {
            for(int j = 0; j < 1000; j++)
            {
                switch (i) {
                    case 0:
                        TestStructureForInputLevel1 test_gen;
                        test_gen = TestForInputLevel1();

                        test_input = new InputLevel1(test_gen.p1Y, test_gen.p1X, test_gen.p2Y, test_gen.p2X);

                        assertTrue("Ungueltige Gerade.", test_input.isInputValid() != test_gen.right_or_wrong);
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

    public int TestForInputLevel2()
    {
        double temp_obj = 0;
        temp_obj = (double)(Math.random() * -100);


        return temp_obj;
    }

    public  TestStructureForInputLevel1 TestForInputLevel1()
    {
        TestStructureForInputLevel1 temp_obj = new TestStructureForInputLevel1();

        //Zuweisung von Werten in die Struktur
        temp_obj.p1Y = (int)(Math.random() * -100) + (int)(Math.random() * +100);
        temp_obj.p1X = (int)(Math.random() * -100) + (int)(Math.random() * +100);
        temp_obj.p2Y = (int)(Math.random() * -100) + (int)(Math.random() * +100);
        temp_obj.p2X = (int)(Math.random() * -100) + (int)(Math.random() * +100);
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
