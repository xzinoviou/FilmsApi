package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by xzinoviou
 * 26/10/2018
 */
public class DBUtils {

    private final static String DRIVER = "com.mysql.jdbc.Driver";
    private final static String URI = "jdbc:mysql://localhost:3306/";
    private final static String DB_NAME = "FILMS_DB";
    private final static String USER = "root";
    private final static String PASS = "root";

    private static Connection connection;

    public DBUtils(){
        try {
            Class.forName(DRIVER);
            connection = DriverManager
                    .getConnection(URI+DB_NAME, USER, PASS);
        }

        catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        catch (SQLException e) {
            e.printStackTrace();
        }

        catch (Exception e){
            e.printStackTrace();
        }

    }

    public static Connection getConnection() {
        if(connection==null)
            new DBUtils();

            return connection;
    }


}
