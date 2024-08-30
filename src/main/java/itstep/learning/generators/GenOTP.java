package itstep.learning.generators;

import java.util.Random;

public class GenOTP implements Generators{



    @Override
    public String generate()
    {
        Random rand = new Random();
        int pass = 0;
        for(int i = 0 ; i < 6 ; i++)
        {
            pass = pass * 10 +  rand.nextInt(9);

        }
        return Integer.toString(pass);
    }
}
