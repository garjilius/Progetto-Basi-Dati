
package GestioneEntita;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;


public class GestioneStanza {
    
    public Vector leggiStanze() throws SQLException {
        
        String query = "SELECT * FROM Stanza";
        ResultSet result = new GestioneDB().readDB(query);
        Vector stanze = new Vector();
        while(result.next()) {
            stanze.add(result.getInt("Numero"));
        }
        return stanze;
    }
    
    public boolean controllaStanza(int stanza) throws SQLException {
        
        String query = "SELECT COUNT(*) FROM Permanenza "
                + "WHERE NumeroStanza = " + stanza + " AND DataFine IS NULL";
        ResultSet result = new GestioneDB().readDB(query);
        int n = 0;
        while(result.next())
            n = result.getInt(1);
        
        query = "SELECT Tipologia FROM Stanza WHERE Numero = " + stanza;
        result = new GestioneDB().readDB(query);   
        int tipologia = 0;
        while(result.next())
            tipologia = result.getInt(1);
        
        if(n >= tipologia)
            return false;
        else
            return true;
    }
}
