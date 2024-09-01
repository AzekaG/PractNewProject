package itstep.learning.Db;

import com.google.inject.Inject;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DbDemoLogerTime {

    @Inject
    private Connection connection;


    public void run()
    {

        System.out.println("Hello DB MODULE");
        DbLoggingTime();
        DbReadingTime();
    }


    public  void DbLoggingTime()
    {
        String query = "INSERT INTO LoggingDateTime (log_time) VALUES(?)";

        try
        {
         Statement stmt = connection.createStatement();
         PreparedStatement preparedStatement = connection.prepareStatement(query);
            {
                LocalDateTime now = LocalDateTime.now();
                String formattedNow = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
                preparedStatement.setString(1, formattedNow);

                int rowAffected = preparedStatement.executeUpdate();
                System.out.println("Количество добавленых строк : " + rowAffected);
            }


        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }



    }

    public void DbReadingTime()
    {
        try
        {
            Statement stmt = connection.createStatement();

            ResultSet res = stmt.executeQuery("SELECT * FROM java_pv222.LoggingDateTime");

            while(res.next())
            {
                int id = res.getInt("id");
                String logTime = res.getString("log_time");
                System.out.println("ID: " + id + ", Log Time: " + logTime);

            }
            res.close();
            stmt.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }



}
