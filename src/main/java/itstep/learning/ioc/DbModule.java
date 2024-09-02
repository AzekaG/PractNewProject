package itstep.learning.ioc;

import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Provides;
import itstep.learning.fs.FileDemo;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;


public class DbModule extends AbstractModule {

    private Connection connection = null;
    private Driver mysqlDriver = null;
    private Map<String, String> configureConnection;
    private FileDemo fileDemo;


   @Inject
    public DbModule(FileDemo fileDemo)
   {
       this.fileDemo = fileDemo;
       configureConnection = fileDemo.connectionMap();
       System.out.println("Db module with FILE DEMO INJECT");
   }

    @Provides
    private Connection getConnection()
    {

        if(connection == null)
        {
            try{
                mysqlDriver = new com.mysql.cj.jdbc.Driver();
                DriverManager.registerDriver(mysqlDriver);

                if(configureConnection != null)
                {
                    System.out.println("configureConnection in DbModule != null , using File for create connection");
                    connection = DriverManager.getConnection(String.format("jdbc:%s://%s:%s/%s?useUnicode=true&characterEncoding=utf8" ,
                                    configureConnection.get("dbms"),
                                    configureConnection.get("host"),
                                    configureConnection.get("port"),
                                    configureConnection.get("schema")),
                            "user222",
                            "pass222");
  }
                else
                {
                    connection = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/java_pv222" +
                                    "?useUnicode=true&characterEncoding=utf8",
                            "user222",
                            "pass222");
                }

            }
            catch(SQLException e)
            {
                System.out.println("DBModule::getConnection " + e.getMessage());
            }

        }
        return connection;
    }


    public void setConfigureConnection(Map<String, String> configureConnection)
    {
        this.configureConnection = configureConnection;
    }







}
