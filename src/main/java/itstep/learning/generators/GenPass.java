package itstep.learning.generators;

import java.util.Random;

public class GenPass implements Generators{


    @Override
    public String generate()
    {
        int length = 8;
        StringBuilder bd = new StringBuilder();
        String pattern = "qwertyuiop[]asdfghjkl;'zxcvbnm,/1234567890-=QWERTYUIOPASDFGHJKLZXCVBNM,M";


        Random rand = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++)
        {
            sb.append(pattern.charAt(rand.nextInt(pattern.length())));
        }

        return sb.toString();
    }
}
