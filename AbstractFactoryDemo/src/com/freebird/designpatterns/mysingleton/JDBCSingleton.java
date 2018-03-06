package com.freebird.designpatterns.mysingleton;

import java.sql.*;

class JDBCSingleton {

    //Created the class, we have a static member to hold our one instance of JDBC connector
    private static JDBCSingleton myDBConntector;

    //I define connection string parameters as static
    private static String URL, loginuser, loginpass;


    //we need to make the constructor private in order to prevent this being created from outside
    private JDBCSingleton(){}

    //We need to provide a global point of access with the connector

    public static JDBCSingleton getJDBCConnector(){
        if(myDBConntector==null){
            myDBConntector= new JDBCSingleton();
        }
        return myDBConntector;
    }

    //this is a private method to get connections for operations like view insert etc.
    private static Connection getConnection() throws ClassNotFoundException, SQLException{

        Connection connection =null;
        //load a class during runtime
        //Class.forName("com.mysql.jdbc.Driver");
        connection= DriverManager.getConnection(URL, loginuser, loginpass);
        return connection;
    }

    //insert data to the table
    public int insert(String username, String pass) throws SQLException {
        Connection c=null;
        PreparedStatement ps=null;

        int recordCounter=0;

        try {
            c=this.getConnection();
            ps=c.prepareStatement("INSERT INTO USERDATA (USERNAME, PASSWORD) VALUES (?,?)");
            ps.setString(1, username);
            ps.setString(2, pass);
            recordCounter=ps.executeUpdate();
        }catch(Exception e){e.printStackTrace();}finally {
            if(ps!=null){
                ps.close();
            }if(c!=null){
                c.close();
            }
        }
        return recordCounter;


    }

    public void view(String username) throws SQLException {

        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;

        try{
            con=this.getConnection();
            ps=con.prepareStatement("SELECT * FROM USERDATA WHERE USERNAME=?");
            ps.setString(1, username);
            rs=ps.executeQuery();
            while(rs.next()){
                System.out.println("Name="+rs.getString(2)+"\t"+"Password= "+rs.getString(3));
            }
        }catch(Exception ex){
            ex.printStackTrace();

        }finally {
            if(rs!=null){
                rs.close();
            }
            if(ps!=null){
                ps.close();
            }
        }
    }

    //to update a password of an existing user
    public int update(String username, String newPassword) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;
        int recordCounter=0;
        try{
            c=this.getConnection();
            ps=c.prepareStatement("UPDATE USERDATA SET PASSWORD=? WHERE USERNAME=?");
            ps.setString(1,newPassword);
            ps.setString(2,username);
            recordCounter=ps.executeUpdate();

        }
        catch (Exception ex){ex.printStackTrace();}finally{
            if(ps!=null) ps.close();
            if(c!=null) c.close();
            //don't return inside finally! finally is for resource handling, closing everything tidily.
            //return recordCounter;
        }

        return recordCounter;
    }

    //to delete a row from the user table
    public int delete (int userid) throws SQLException{
        Connection c=null;
        PreparedStatement ps =null;
        int recordCounter=0;

        try {
            c=this.getConnection();
            ps = c.prepareStatement("DELETE FROM USERDATA WHERE UID=?");
            ps.setInt(1,userid);
            recordCounter=ps.executeUpdate();


        }catch (Exception ex){ex.printStackTrace();}finally{
            if(ps!=null) ps.close();
            if(c!=null) c.close();
        }
        return recordCounter;

    }//End of JDBCSingleton class










}
