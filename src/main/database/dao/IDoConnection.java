package dao;

import database.DatabaseConnection;

import java.sql.Connection;
import java.util.ArrayList;

public interface IDoConnection <T>{


    public void create(T t);
    public void update(T t);
    public void delete(T t);
    public ArrayList<T> list();

    default Connection getInterfaceConnection(){
        return DatabaseConnection.getInstance().getConnection();
    }
}
