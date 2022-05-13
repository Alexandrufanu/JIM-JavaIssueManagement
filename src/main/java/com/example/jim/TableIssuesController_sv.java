package com.example.jim;

import java.sql.*;
import java.util.ArrayList;

public class TableIssuesController_sv {



    //    private static Connection con;
    private static Connection connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");


        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test","root","12345678");

    }



    public static ArrayList<Issue> select(String item) throws SQLException, ClassNotFoundException {


        Connection con = connect();

        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("select "+item+" from issues");

        ArrayList<Issue> issues = new ArrayList<>();
        while(rs.next())
            issues.add(new Issue(rs.getInt(1), rs.getString(2), rs.getString(3)
                    , rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));

        con.close();

        return issues;


    }



    public static void insert(int id, String summary , String proj, String type,String release,String description, String importance) throws SQLException, ClassNotFoundException {

        Connection con=connect();

        Statement stmt=con.createStatement();

        int rs=stmt.executeUpdate("INSERT INTO `test`.`issues` (`id`, `summary`, `project`, `type`, `inrelease`, `description`, `importance`) " +
                "VALUES ('"+id+"', '"+summary+"', '"+proj+"', '"+type+"', '"+release+"', '"+description+"', '"+importance+"');");

        con.close();
    }

    public static int getMAXId() throws SQLException, ClassNotFoundException {
        Connection con = connect();
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("select MAX(id) from issues");
        rs.next();
        int result =rs.getInt(1);
        con.close();

        return result;
    }

    public static Issue selectbysummary(String summary) throws SQLException, ClassNotFoundException {
        Connection con = connect();

        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("select * from issues where summary='"+summary+"'");

        Issue issue ;
        rs.next();
        issue = new Issue(rs.getInt(1), rs.getString(2), rs.getString(3)
                    , rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));

        con.close();

        return issue;

    }

    public static boolean checkUniqueUsername(String username) throws SQLException {

        try{
            Connection con = connect();

            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from usersdata where username = "+ "'"+ username +"'");

            con.close();

            if(rs.next())
                return false;

            return true;
        }catch(Exception ignored){ }

        return true;

    }


    public static void editIssue(Issue issue) throws SQLException, ClassNotFoundException {
        Connection con = connect();
        Statement stmt=con.createStatement();

        stmt.executeUpdate("UPDATE `test`.`issues` SET `summary` = '"+issue.summary+"', `project` = '"+issue.project+
                "', `type` = '"+issue.type+"', `inrelease` = '"+issue.inrelease+"', `description` = '"+issue.description+
                "', `importance` = '"+issue.importance+"' WHERE (`id` = '"+issue.id+"')");
        con.close();

//        UPDATE `test`.`issues` SET `summary` = 'asdd', `project` = 'asdd', `type` = 'issue reportd', `inrelease` = 'asdd', `description` = 'asdd', `importance` = 'high' WHERE (`id` = '2');
    }

    public static void deleteIssue(Issue issue) throws SQLException, ClassNotFoundException {
        //DELETE FROM `test`.`issues` WHERE (`id` = '2');
        Connection con = connect();
        Statement stmt=con.createStatement();

        stmt.executeUpdate("DELETE FROM `test`.`issues` WHERE (`id` = '"+issue.id+"')");
        con.close();

    }



    public static void main(String[] args){

    }

}












