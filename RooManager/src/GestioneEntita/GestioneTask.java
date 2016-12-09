
package GestioneEntita;

import Entity.Task;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.Vector;


public class GestioneTask {
            
        private Vector<Task> taskInCorso;

    public Vector taskInCorso() throws SQLException {
        
        taskInCorso = new Vector<Task>();
        
        String query = "SELECT * FROM Task WHERE DataFine IS NULL";
        ResultSet result = new GestioneDB().readDB(query);
        
        Vector dati = new Vector();
        while(result.next()) {
            Task temp = new Task();
            temp.setID(result.getInt("ID"));
            temp.setOperazione(result.getString("Operazione"));
            taskInCorso.add(temp);
            
            Vector riga = new Vector();
            riga.add(result.getString("CodiceFiscale"));
            riga.add(result.getInt("NumeroStanza"));
            riga.add(result.getString("DataInizio"));
            dati.add(riga);
        }
        
        return dati;
    }
    
    public static void aggiungiTaskOrdinario(Task input) {
        
        String query = "INSERT INTO Task VALUES (%d,'%s',%d,null,'%s',null,'%s',null)";
        
        int monthInizio = input.getDataInizio().get(GregorianCalendar.MONTH) + 1;
        int dayInizio = input.getDataInizio().get(GregorianCalendar.DAY_OF_MONTH);
        int yearInizio = input.getDataInizio().get(GregorianCalendar.YEAR);
        String dataInizio = yearInizio + "-" + monthInizio + "-" + dayInizio;
        query = String.format(query, 
                input.getID(), 
                input.getOperazione(), 
                input.getStanza(), 
                input.getCF(), 
                dataInizio);
        
        new GestioneDB().updateDB(query);
    }
    
        public static void aggiungiTaskStraordinario(Task input) {
        
        String query = "INSERT IGNORE INTO Task VALUES (%d,'%s',%d,'%s',null,'%.2f','%s',null)";
        
        int monthInizio = input.getDataInizio().get(GregorianCalendar.MONTH) + 1;
        int dayInizio = input.getDataInizio().get(GregorianCalendar.DAY_OF_MONTH);
        int yearInizio = input.getDataInizio().get(GregorianCalendar.YEAR);
        String dataInizio = yearInizio + "-" + monthInizio + "-" + dayInizio;
        query = String.format(query, 
                input.getID(), 
                input.getOperazione(), 
                input.getStanza(), 
                input.getPIVA(),  
                input.getCosto(),
                dataInizio);
        System.out.println(query);
        
        new GestioneDB().updateDB(query);
    }
        
       public static int ultimoID() throws SQLException {
        
        String query = "SELECT max(ID) FROM Task";
        ResultSet result = new GestioneDB().readDB(query);
        while(result.next())
            return result.getInt(1) + 1;
        return 0;
    }
           
    public static GregorianCalendar calculateDays(int nGiorni) {
        GregorianCalendar data = new GregorianCalendar();
        data.add(GregorianCalendar.DAY_OF_MONTH, nGiorni);
        return data;
    }
}
