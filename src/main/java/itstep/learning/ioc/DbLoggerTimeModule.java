package itstep.learning.ioc;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbLoggerTimeModule extends AbstractModule {

    private Connection connection = null;
    private Driver mysqlDriver = null;


    @Provides
    private Connection getConnection()
    {

        if(connection == null)
        {
            try
            {
                mysqlDriver = new Driver();
                DriverManager.registerDriver(mysqlDriver);


                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/java_pv222"+
                                "?useUnicode=true&characterEncoding=utf8",
                                "user222",
                                "pass222"
                );

            }
            catch (SQLException e)
            {
                System.out.println("DBModule::getConnection " + e.getMessage());
            }
        }

        return connection;

    }


}
