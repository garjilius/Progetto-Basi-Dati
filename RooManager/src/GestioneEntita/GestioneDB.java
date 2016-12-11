package GestioneEntita;

import UI.Home;
import java.sql.*;
import javax.swing.JOptionPane;

public class GestioneDB {

    private Connection con = null;

    private void connect() {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://localhost:3306/roomanager";
            con = DriverManager.getConnection(url, "gestore", "password");
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Errore di cominucazione col database, controllare la connessione e riprovare");
            System.exit(-1);
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
                JOptionPane.showMessageDialog(null, "La riga è già presente");
            }
            if (e.toString().contains("cannot be null")) {
                JOptionPane.showMessageDialog(null, "Valore null non ammesso");
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
        }
        return null;
    }

}
