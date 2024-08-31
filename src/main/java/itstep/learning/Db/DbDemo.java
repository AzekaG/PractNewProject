package itstep.learning.Db;

import com.google.inject.Inject;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DbDemo {
    @Inject
    private Connection connection;

    public void run(){
        System.out.println("Db demo");

        try{
            Statement statement = connection.createStatement();

            ResultSet res = statement.executeQuery("SELECT * FROM user_222 ");



            while(res.next())
            {
                System.out.println(res.getString(1));
            }
            res.close();
            statement.close();

        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }


}
