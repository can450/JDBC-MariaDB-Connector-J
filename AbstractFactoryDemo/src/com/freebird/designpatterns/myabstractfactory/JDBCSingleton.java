package com.freebird.designpatterns.myabstractfactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class JDBCSingleton {

    //Created the class, we have a static member to hold our one instance of JDBC connector
    private static JDBCSingleton myDBConntector;

    //we need to make the constructor private in order to prevent this being created from outside
    private JDBCSingleton(){}

    //We need to provide a global point of access with the connector

    public JDBCSingleton getJDBCConnector(){
        if(myDBConntector==null){
            myDBConntector= new JDBCSingleton();
        }
        return myDBConntector;
    }

    //this is a private method to get connections for operations like view insert etc.
    private static Connection getConnection(String URL, String user, String pass) throws ClassNotFoundException, SQLException{

        Connection connection =null;
        //Class.forName("com.mysql.jdbc.Driver");
        connection= DriverManager.getConnection(URL, user, pass);
        return connection;
    }






}
