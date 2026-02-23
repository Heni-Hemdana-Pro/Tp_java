package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    public static Connection makeConnection() {
        try {
            Class.forName(DataBaseConfig.NOM_DRIVER);
            System.out.println("Driver okk");
        } catch (ClassNotFoundException e) {
            System.out.println("erreur Driver"+e.getMessage());
        }
        Connection con=null;

        try {
            con = DriverManager.getConnection(DataBaseConfig.URL_DB,DataBaseConfig.USERNAME,DataBaseConfig.PASSWORD);
            System.out.println("Connected");
        } catch (SQLException e) {
            System.out.println("Erreur de cnx"+e.getMessage());
        }

        return con;
    }
}
