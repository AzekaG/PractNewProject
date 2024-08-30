package itstep.learning.generators;


import java.util.Random;

public class GenNameFile implements Generators {

    private static final String Characters = "abcdefghijklmnopqrstuvwxyz";
    private static final int MIN_LENGTH = 8;
    private static final int MAX_LENGTH = 12;


    private final Random rand = new Random();
    @Override
    public String generate()
    {
       int length = MIN_LENGTH + rand.nextInt(MAX_LENGTH - MIN_LENGTH);
       StringBuilder fileName = new StringBuilder(length);
        for (int i = 0; i < length; i++)
        {
            fileName.append(Characters.charAt(rand.nextInt(Characters.length())));
        }

        return fileName.toString();
    }
}
