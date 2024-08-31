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
        DbLoggingTime();
        DbReadingTime();
    }


    public  void DbLoggingTime()
    {
        String query = "INSERT INTO loggindateandtime (idloggindateandtime) VALUES(?)";

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

            ResultSet res = stmt.executeQuery("SELECT * FROM java_pv222.loggindateandtime");

            while(res.next())
            {
                System.out.println("DATABASE");
                System.out.println(res.getString(1));
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
