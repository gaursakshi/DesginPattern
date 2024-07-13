package ObjectPoolDesignPattern;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

 class DBConnection {

    Connection connection;

    DBConnection(){
        try {
            connection = DriverManager.getConnection("localhost", "sakshi", "");
        }
        catch (SQLException e){
            System.out.println("Connection Failed! Check output console" + e.getMessage());
        }
    }

}
