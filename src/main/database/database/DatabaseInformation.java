package database;

import lombok.Data;

@Data
public class DatabaseInformation {
    private String url;
    private String userName;
    private String userPassword;

    private  String ForNameData;

    public DatabaseInformation() {
        this.url = "jdbc:mysql://localhost:3306/Products";
        this.userName = "root";
        this.userPassword = "root";
        this.ForNameData = "com.mysql.jdbc.Driver";
    }
}
