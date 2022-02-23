package com.gmail.voronovskyi.yaroslav.integerdivision;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class IntegerDevisionServiceTest {
    
    private IntegerDivisionService integerDivisionService = new IntegerDivisionService();
    
    @Test
    public void createdIntegerDevisionServiceTest() {
        String expected =   "_78945|4\n" +
                            " 4    |-----\n" + 
                            " -    |19736\n" + 
                            "_38\n" + 
                            " 36\n" + 
                            " --\n" + 
                            " _29\n" + 
                            "  28\n" + 
                            "  --\n" + 
                            "  _14\n" +
                            "   12\n" +
                            "   --\n" +
                            "   _25\n" + 
                            "    24\n" + 
                            "    --\n" + 
                            "     1\n" ;
        assertEquals(expected, integerDivisionService.createDivision(78945, 4));
    }
}
