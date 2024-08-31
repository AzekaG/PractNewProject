package itstep.learning.fs;

import com.google.protobuf.BytesValueOrBuilder;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class FileDemo
{


    public void run(){
        try(InputStream rs =
                    this.getClass()
                            .getClassLoader()
                            .getResourceAsStream("db.ini");
        )
        {
            String content = readStream(rs);
            Map<String, String> init = new HashMap<>();
            String[] lines = content.split("/n");

            for(String line : lines)
            {
                String[] parts = line.split("=");
                init.put(parts[0].trim(), parts[1].trim());
                System.out.println(line);
            }

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

    }

    public void runFile()
    {
        System.out.println("FileSystem");

        File file = new File("logging.txt");

        ByteArrayOutputStream byteBuilder = new ByteArrayOutputStream();
        byte[] buffer = new byte[24];

        int len;

        try(InputStream is = new FileInputStream(file))
        {
            System.out.println(readStream(is));
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

    }








    private String readStream (InputStream in , Charset charset) throws IOException {
        byte[] buffer = new byte[4096];


        try(BufferedInputStream bis = new BufferedInputStream(in);
            ByteArrayOutputStream byteBuilder =  new ByteArrayOutputStream();)
        {
            int len;

            while( (len = bis.read(buffer)) != -1)
            {
                byteBuilder.write(buffer, 0, len);
            }
            return byteBuilder.toString(charset.toString());
        }

    }

    private String readStream (InputStream in ) throws IOException {
        return readStream(in, StandardCharsets.UTF_8);
    }



}
