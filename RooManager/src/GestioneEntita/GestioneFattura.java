
package GestioneEntita;

import java.sql.ResultSet;
import java.sql.SQLException;


public class GestioneFattura {
 
    public int ultimoID() throws SQLException {
        
        String query = "SELECT max(ID) FROM Fattura";
        ResultSet result = new GestioneDB().readDB(query);
        while(result.next())
            return result.getInt(0);
        return 0;
    }
    
}
