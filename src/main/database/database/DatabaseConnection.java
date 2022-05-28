package database;

import lombok.extern.log4j.Log4j2;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Log4j2
public class DatabaseConnection extends DatabaseInformation {
    private String url=this.getUrl();
    private String userName=this.getUserName();
    private String userPassword=this.getUserPassword();
    private  String ForNameData=this.getForNameData();

    private Connection connection;

    private static DatabaseConnection instance;

    private DatabaseConnection() {
        try{
            //Class.forName(this.getForNameData());
            Class.forName("com.mysql.cj.jdbc.Driver");
            log.info("Driver success");


            connection= DriverManager.getConnection(url,userName,userPassword);
            log.info("connection success");

        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e);

        }
    }

    public static DatabaseConnection getInstance(){
        try{
            if (instance == null || instance.connection.isClosed()){
                instance = new DatabaseConnection();
            }
        } catch (SQLException sql) {
            log.error("is not working ql");
            sql.printStackTrace();

        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public DatabaseConnection setConnection(Connection connection){
        this.connection = connection;
        return  this;
    }

    public static void main(String[] args) {

        DatabaseConnection connection1 = new DatabaseConnection();
        System.out.println("ok");
    }
}
