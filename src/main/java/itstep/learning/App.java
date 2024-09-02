package itstep.learning;

import com.google.inject.Guice;
import itstep.learning.Async.AsyncDemo;
import itstep.learning.Db.DbDemo;
import itstep.learning.Db.DbDemoLogerTime;
import itstep.learning.fs.FileDemo;
import itstep.learning.generators.GenCryptoSalt;
import itstep.learning.generators.GeneratorDemo;
import itstep.learning.ioc.DbLoggerTimeModule;
import itstep.learning.ioc.DbModule;
import itstep.learning.generators.GeneratorsModule;
import itstep.learning.ioc.IocDemo;
import itstep.learning.ioc.ServicesModule;

import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );


        boolean showJournal = false;
        for(String arg : args)
        {
            if("--journal".equals(arg))
            {
                showJournal = true;
            }
        }

        if(showJournal)
        {
            System.out.println("Журнал запуска:");
            System.out.println("_____________________________________________________________________________________________________");
            Guice.createInjector(new DbLoggerTimeModule()).getInstance(DbDemoLogerTime.class).DbReadingTime();
            return;
        }


//        new Basics().run();
//
//        new Shop().run();
//
//        new IocDemo(new Md5HashService(), new ShaHashService() , "MyApp").run();


        //Guice.createInjector(new ServicesModule()).getInstance(IocDemo.class).run();

       // Guice.createInjector(new DbModule()).getInstance(DbDemo.class).run();

//        System.out.println("_____________________________________________________________________________________________________");
//        System.out.println("OTP = " + Guice.createInjector(new GeneratorsModule()).getInstance(GeneratorDemo.class).generateOTP());
//        System.out.println("_____________________________________________________________________________________________________");
//        System.out.println("Password = " + Guice.createInjector(new GeneratorsModule()).getInstance(GeneratorDemo.class).generatePassword());
//        System.out.println("_____________________________________________________________________________________________________");
//        System.out.println("CryptoSalt = " + Guice.createInjector(new GeneratorsModule()).getInstance(GeneratorDemo.class).generateCryptoSalt());
//        System.out.println("_____________________________________________________________________________________________________");
//        System.out.println("FileName = " + Guice.createInjector(new GeneratorsModule()).getInstance(GeneratorDemo.class).generateFileName());

//
//        System.out.println("_____________________________________________________________________________________________________");
//        Guice.createInjector(new GeneratorsModule()).getInstance(FileDemo.class).run();
//        System.out.println("_____________________________________________________________________________________________________");
//        System.out.println("_____________________________________________________________________________________________________");
//        Guice.createInjector(new GeneratorsModule()).getInstance(FileDemo.class).runFile();
//


//        System.out.println("_____________________________________________________________________________________________________");
//        Guice.createInjector(new DbLoggerTimeModule()).getInstance(DbDemoLogerTime.class).run();
//
//
//
//
//        System.out.println(Guice.createInjector(new ServicesModule()).getInstance(GenCryptoSalt.class));
//        System.out.println("_____________________________________________________________________________________________________");
//
//
//
//        Map<String, String> mp = Guice.createInjector(new ServicesModule()).getInstance(FileDemo.class).connectionMap();
//
//        for(Map.Entry<String, String> entry : mp.entrySet())
//        {
//            System.out.println(entry.getKey() + ": " + entry.getValue());
//        }
//
//
//        System.out.println("_____________________________________________________________________________________________________");
//
//        System.out.println("_____________________________________________________________________________________________________");
//        FileDemo fd = Guice.createInjector(new DbModule(new FileDemo())).getInstance(FileDemo.class);
//        Guice.createInjector(new DbModule(fd)).getInstance(DbDemo.class).run();
//        Guice.createInjector(new DbModule(fd)).getInstance(FileDemo.class);
//
//
//        System.out.println("_____________________________________________________________________________________________________");
//        Guice.createInjector(new GeneratorsModule()).getInstance(FileDemo.class).rewriteDataTiDBIni("dbms" , "localhost" , "3306" , "java_pv222" , "user222", "pass222");


        AsyncDemo asyncDemo = new AsyncDemo();
        asyncDemo.run();
    }
}
