package itstep.learning.hash;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

import com.google.inject.Singleton;

@Singleton
public class Md5HashService implements HashService {

    @Override
    public String digest(String message)
    {
        StringBuilder sb = new StringBuilder();
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(message.getBytes(StandardCharsets.UTF_8));
            for(byte b : md.digest())
            {
                sb.append(String.format("%02x", b));
            }
        }
        catch(Exception e)
        {
            throw new RuntimeException(e);
        }



        return sb.toString();
    }



}
