package itstep.learning.Db;

import com.google.inject.Inject;
import itstep.learning.fs.FileDemo;

import java.sql.*;


public class DbDemo {

    @Inject
    private Connection connection;

    @Inject
    private FileDemo fileDemo;

    public void run(){
        System.out.println("Db demo");

        try{
            Statement statement = connection.createStatement();

            ResultSet res = statement.executeQuery("SHOW DATABASES");

            while(res.next())
            {
                System.out.println(res.getString(1));
            }
            res.close();
            statement.close();

        }
        catch(SQLException e){
            System.out.println( "DbDemo  :  Method run : "  +  e.getMessage());
        }
    }


}
