package GestioneEntita;

import UI.Home;
import java.sql.*;

public class GestioneDB {

    private Connection con = null;

    private void connect() {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://localhost:3306/roomanager";
            //con = DriverManager.getConnection(url, "root", "16Luglio2011!");
            con = DriverManager.getConnection(url, "gestore", "password");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean updateDB(String query) {
        
        if(con == null)
            connect();
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(query);
            if(Home.jListQuerys != null && Home.storicoQuery != null) {
            Home.storicoQuery.add(query);
            Home.refreshQList();
            }
            return true;
        } catch (Exception e) {
            System.out.println(e);
            if (e.toString().contains("Duplicate")) {
                System.out.println("Gia' presente");
            }
            if (e.toString().contains("cannot be null")) {
                System.out.println("Non puo' essere null");
            }
        }
        return false;
    }

    public ResultSet readDB(String query) {
        
        if(con == null)
            connect();
        
        try {
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(query);
            if(Home.jListQuerys != null && Home.storicoQuery != null) {
            Home.storicoQuery.add(query);
            Home.refreshQList();
            }
            return result;

        } catch (Exception e) {
            System.out.println(e);
            if (e.toString().contains("Duplicate")) {
                System.out.println("Gia' presente");
            }
            if (e.toString().contains("cannot be null")) {
                System.out.println("Non puo' essere null");
            }
        }
        return null;
    }

}
