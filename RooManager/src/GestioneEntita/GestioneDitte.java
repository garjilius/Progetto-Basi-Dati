
package GestioneEntita;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.Vector;


public class GestioneDitte {
    
    public ArrayList PIVAs = new ArrayList();
    
    public ArrayList getPIVAs() {
        return this.PIVAs;
    }
    
    public Vector leggiDitte() throws SQLException {
        Vector ditteEsterne = new Vector();
        String query = "SELECT NOME, PIVA FROM DittaEsterna";
        ResultSet result = new GestioneDB().readDB(query);
        while(result.next()) {
            ditteEsterne.add(result.getString("Nome"));
            PIVAs.add(result.getString("PIVA"));
        }
        return ditteEsterne;
    }
    
   /*
    Metodo mai usato?
    public static String leggiPIVADitta(String nome) throws SQLException {
        String query = "Select PIVA FROM DittaEsterna WHERE Nome = '%s'";
         query = String.format(query, nome);       
        String PIVALetta = "";
         ResultSet result = new GestioneDB().readDB(query);
        while(result.next()) {
            PIVALetta = result.getString("PIVA");
        }
         return PIVALetta;
    }
    */
    
    public static Vector leggiDitteComplete() throws SQLException {
        
        Vector ditteEsterne = new Vector();
        String query = "SELECT * FROM DittaEsterna";
        ResultSet result = new GestioneDB().readDB(query);
        while(result.next()) {
            Vector riga = new Vector();
            riga.add(result.getString("PIVA"));
            riga.add(result.getString("Nome"));
            riga.add(result.getString("Sede"));
            riga.add(result.getString("Recapito"));
           ditteEsterne.add(riga);
        }
        return ditteEsterne;
    }
    
        public static Vector leggiDitteUsateComplete() throws SQLException {
        
        Vector ditteEsterne = new Vector();
        String query = "SELECT * FROM DittaEsterna where DittaEsterna.PIVA IN"
                + "(Select PIVA from Task)";
        
       
        ResultSet result = new GestioneDB().readDB(query);
        while(result.next()) {
            Vector riga = new Vector();
            riga.add(result.getString("PIVA"));
            riga.add(result.getString("Nome"));
            riga.add(result.getString("Sede"));
            riga.add(result.getString("Recapito"));
            ditteEsterne.add(riga);
        }
        return ditteEsterne;
    }
    
    public void aggiungiDitta(String piva, String nome, String sede, String recapito) {
        
        String query = "INSERT INTO DittaEsterna VALUES('%s','%s','%s','%s')";
        query = String.format(query, piva, nome, sede, recapito);
        
        new GestioneDB().updateDB(query);
    }
    
}
 