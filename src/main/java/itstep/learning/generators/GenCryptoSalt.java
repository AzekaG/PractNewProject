package itstep.learning.generators;

import itstep.learning.hash.HashService;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;

public class GenCryptoSalt implements Generators{

    @Override
    public String generate()
    {
            return  HashService(bytesToHex(generateSalt(20)));
    }


    public static byte[] generateSalt(int length)
        {
            int length_salt = 20;

            byte[] salt = new byte[length_salt];
            SecureRandom random = new SecureRandom();
            random.nextBytes(salt);
            return salt;
        }

        public static String bytesToHex(byte[] bytes)
        {
            StringBuilder builder = new StringBuilder();
            for(byte b : bytes) {

                String hex = Integer.toHexString(b & 0xFF);
                builder.append(hex);
            }
            return builder.toString();
        }

        public static String HashService(String msg)
        {
            StringBuffer sb = new StringBuffer();
            try{
                System.out.println("Md5HashService method digest");

                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(msg.getBytes(StandardCharsets.UTF_8));
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
