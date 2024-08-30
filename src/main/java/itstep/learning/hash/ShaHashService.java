package itstep.learning.hash;


import com.google.inject.Singleton;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

@Singleton
public class ShaHashService implements HashService {


    @Override
    public String digest(String message)
    {
        StringBuilder sb = new StringBuilder();

        try {
            System.out.println("ShaHasService method digest");

            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(message.getBytes(StandardCharsets.UTF_8));

            for (byte b : md.digest())
            {
                sb.append(String.format("%02x", b));
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }


        return sb.toString();
    }
}
