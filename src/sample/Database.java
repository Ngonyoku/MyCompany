package sample;

import java.sql.Connection;
import java.sql.DriverManager;

/*
 * This Class will connect to the MySQL database
 * */
public class Database {
    public Connection dbLink;

    public Connection getConnection() {

        String dbName = "my_company";
        String url = "jdbc:mysql://localhost/" + dbName;
        String dbUser = "root";
        String dbPwd = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            dbLink = DriverManager.getConnection(url, dbUser, dbPwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dbLink;
    }
}
