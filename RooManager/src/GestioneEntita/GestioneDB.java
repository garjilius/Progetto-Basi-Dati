package GestioneEntita;

import java.sql.*;

public class GestioneDB {

    private Connection con = null;

    private void connect() {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://localhost:3306/roomanager";
            con = DriverManager.getConnection(url, "root", "16Luglio2011!");
            //con = DriverManager.getConnection(url, "root", "");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateDB(String query) {
        
        if(con == null)
            connect();
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(query);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e);
            if (e.toString().contains("Duplicate")) {
                System.out.println("Gia' presente zio");
            }
            if (e.toString().contains("cannot be null")) {
                System.out.println("zio non puoi mettere null");
            }
        }
    }

    public ResultSet readDB(String query) {
        
        if(con == null)
            connect();
        
        try {
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(query);
            return result;

        } catch (Exception e) {
            System.out.println(e);
            if (e.toString().contains("Duplicate")) {
                System.out.println("Gia' presente zio");
            }
            if (e.toString().contains("cannot be null")) {
                System.out.println("zio non puoi mettere null");
            }
        }
        return null;
    }

}
