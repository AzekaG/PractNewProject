package itstep.learning.fs;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class FileDemo{

    public void run()
    {
        Map<String, String> init = connectionMap();
        System.out.println(
                    String.format("jdbc:%s://%s:%s/%s",
                            init.get("dbms"),
                            init.get("host"),
                            init.get("port"),
                            init.get("schema"))
            );
    }


    public Map<String, String> connectionMap()
    {
        Map<String , String > init = new HashMap<>();

        try(InputStream rs =
                    this.getClass()
                            .getClassLoader()
                            .getResourceAsStream("db.ini"))
        {
            String content = readStream(rs);

            String[] lines = content.split("\n");

            for(String line : lines)
            {
                String[] parts = line.split("=");
                init.put(parts[0].trim(), parts[1].trim());

            }
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
        return init;
    }




private String readStream(InputStream in , Charset charset) throws IOException
{
    byte[] buffer = new byte[4096];

    try(BufferedInputStream bis = new BufferedInputStream(in);
        ByteArrayOutputStream byteBuilder = new ByteArrayOutputStream();)
    {
        int len;

        while ((len = bis.read(buffer)) != -1)
        {
            byteBuilder.write(buffer, 0, len);
        }

        return byteBuilder.toString(charset.toString());
    }
}




public String readStream(InputStream in) throws IOException
{
    return readStream(in, StandardCharsets.UTF_8);
}


public void rewriteDataTiDBIni(String dbms , String host , String port , String schema , String user ,String password)
{
    Map<String, String > mp = new HashMap<>();
    mp.put("dbms", dbms);
    mp.put("host", host);
    mp.put("port", port);
    mp.put("schema", schema);
    mp.put("user", user);
    mp.put("password", password);
    mp.put("coding" , "StandardCharsets.UTF_8");

    File file = new File("db.ini");

    ByteArrayOutputStream out = new ByteArrayOutputStream();

    try(BufferedOutputStream bs = new BufferedOutputStream(new FileOutputStream(file)))
    {
        for(Map.Entry<String , String> entry : mp.entrySet())
        {
            String line = entry.getKey() + "=" + entry.getValue() + "\n";
            out.write(line.getBytes());
        }
        bs.write(out.toByteArray());
    }
    catch(IOException ex)
    {
        System.out.println(ex.getMessage());
    }
}


public void runFile()
{
    System.out.println("FileSystem   : method runFile started");

    File file = new File("logging.txt");


    ByteArrayOutputStream builder = new ByteArrayOutputStream();
    byte[] buffer = new byte[4096];

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






















}