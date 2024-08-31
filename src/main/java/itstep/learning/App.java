package itstep.learning;

import com.google.inject.Guice;
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

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
//        new Basics().run();
//
//        new Shop().run();
//
//        new IocDemo(new Md5HashService(), new ShaHashService() , "MyApp").run();


        //Guice.createInjector(new ServicesModule()).getInstance(IocDemo.class).run();

       // Guice.createInjector(new DbModule()).getInstance(DbDemo.class).run();

        System.out.println("_____________________________________________________________________________________________________");
        System.out.println("OTP = " + Guice.createInjector(new GeneratorsModule()).getInstance(GeneratorDemo.class).generateOTP());
        System.out.println("_____________________________________________________________________________________________________");
        System.out.println("Password = " + Guice.createInjector(new GeneratorsModule()).getInstance(GeneratorDemo.class).generatePassword());
        System.out.println("_____________________________________________________________________________________________________");
        System.out.println("CryptoSalt = " + Guice.createInjector(new GeneratorsModule()).getInstance(GeneratorDemo.class).generateCryptoSalt());
        System.out.println("_____________________________________________________________________________________________________");
        System.out.println("FileName = " + Guice.createInjector(new GeneratorsModule()).getInstance(GeneratorDemo.class).generateFileName());


        System.out.println("_____________________________________________________________________________________________________");
        Guice.createInjector(new GeneratorsModule()).getInstance(FileDemo.class).run();
        System.out.println("_____________________________________________________________________________________________________");
        System.out.println("_____________________________________________________________________________________________________");
        Guice.createInjector(new GeneratorsModule()).getInstance(FileDemo.class).runFile();

        System.out.println("_____________________________________________________________________________________________________");
        Guice.createInjector(new DbLoggerTimeModule()).getInstance(DbDemoLogerTime.class).run();


    }
}
