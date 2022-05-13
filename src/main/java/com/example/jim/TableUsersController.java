package com.example.jim;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

public class TableUsersController implements DatabaseController{

    //    private static Connection con;
    private static Connection connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test","root","12345678");

    }

    public static void select(String item){

        try{
            Connection con = connect();

            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select "+item+" from usersdata");

            while(rs.next())
                System.out.println(rs.getString(1)+"  "+rs.getString(2));//+"  "+rs.getString(3));

            con.close();
        }catch(Exception e){ System.out.println(e);}

    }



    public static boolean insert(String username, String firstname, String lastname, String email, String company){

        try{
            Connection con=connect();

            Statement stmt=con.createStatement();

            int rs=stmt.executeUpdate("INSERT INTO `test`.`usersdata` (`username`, `firstname`, `lastname`, `email`, `company`)" +
                    " VALUES ('"+username+"','"+firstname +"','"+ lastname +"','"+ email+"','"+ company+"')");

            con.close();
        }catch(SQLException | ClassNotFoundException e){ System.out.println(e); return false;}
        return true;
    }

    public static boolean checkUniqueUsername(String username) throws SQLException {

        try{
            //To delete
            String a="df";
            String b="dfd";
            if (a ==    b)
            {

            }


            Connection con = connect();

            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from usersdata where username = "+ "'"+ username +"'");

            if(rs.next())
                return false;

            con.close();
            return true;
        }catch(Exception ignored){ }

        return true;

    }




}

class PasswordController implements DatabaseController {

    private static Connection connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test","root","12345678");

    }

    public static void insert(String username, String content){

        try{
            Connection con=connect();

            Statement stmt=con.createStatement();

            int rs=stmt.executeUpdate("INSERT INTO `test`.`passwords` (`username`, `content`)" +
                    " VALUES ('"+username+"','"+content +"')");

            con.close();
        }catch(Exception e){ System.out.println(e);}
    }


    public static boolean loginAttempt (String username, String content)
    {
        try{
            int result =-1;
            Connection con = connect();

            Statement stmt=con.createStatement();
//            ResultSet rs=stmt.executeQuery("select * from usersdata where username = "+ "'"+ username +"'");

            ResultSet rs=stmt.executeQuery("SELECT EXISTS (" +
                    "SELECT * FROM passwords WHERE username = '"+username+"' AND content = '"+content+"')");

            if(rs.next())
                result = rs.getInt(1);

            con.close();

            System.out.println(result);

            return result == 1;

        }catch(Exception e){ System.out.println(e);}


        Collection<Object> objects;
        TreeSet<Integer> binaryTree;
//        List;
        return false;


    }



}