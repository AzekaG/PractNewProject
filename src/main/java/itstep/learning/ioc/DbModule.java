package itstep.learning.ioc;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbModule extends AbstractModule {

    private Connection connection = null;
    private Driver mysqlDriver = null;


    @Provides
    private Connection getConnection()
    {
        if(connection == null)
        {
            try{
                mysqlDriver = new com.mysql.cj.jdbc.Driver();
                DriverManager.registerDriver(mysqlDriver);
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/java_pv222" +
                                "?useUnicode=true&characterEncoding=utf8",
                        "user222",
                        "pass222"
                );
            }
            catch(SQLException e)
            {
                System.out.println("DBModule::getConnection " + e.getMessage());
            }

        }
        return connection;
    }






}
