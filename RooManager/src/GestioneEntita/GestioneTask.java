
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
            temp.setTipo(result.getInt("Tipo"));
            taskInCorso.add(temp);
            
            Vector riga = new Vector();
            riga.add(result.getString("CodiceFiscale"));
            riga.add(result.getInt("NumeroStanza"));
            riga.add(result.getString("DataInizio"));
            dati.add(riga);
        }
        
        return dati;
    }
    
    public static void aggiungiTask(Task input) {
        
        String query = "INSERT INTO Task VALUES (%d,'%s',%d,%d)";
        query = String.format(query, input.getID(), input.getOperazione(),
                input.getTipo(), input.getStanza());
        
        new GestioneDB().updateDB(query);
    }
        
    public static void aggiungiEsecuzioneTask(TaskEseguitoDa input) {
        
        String query = "INSERT IGNORE INTO TaskEseguitoDa VALUES ('%s',%d,null,'%s',null)";
            int monthInizio = input.getDataInizio().get(GregorianCalendar.MONTH) + 1;
            int dayInizio = input.getDataInizio().get(GregorianCalendar.DAY_OF_MONTH);
            int yearInizio = input.getDataInizio().get(GregorianCalendar.YEAR);
            String dataInizio = yearInizio + "-" + monthInizio + "-" + dayInizio;
          /*  int monthFine = input.getDataFine().get(GregorianCalendar.MONTH) + 1;
            int dayFine = input.getDataFine().get(GregorianCalendar.DAY_OF_MONTH);
            int yearFine = input.getDataFine().get(GregorianCalendar.YEAR);
            String dataFine = yearFine + "-" + monthFine + "-" + dayFine; */
            
        query = String.format(query, input.getPIVA(), input.getIDTask(),
                 dataInizio);
        
        new GestioneDB().updateDB(query);
    }
    
       public static int ultimoID() throws SQLException {
        
        String query = "SELECT max(ID) FROM Task";
        ResultSet result = new GestioneDB().readDB(query);
        while(result.next())
            return result.getInt(1) + 1;
        return 0;
    }
    
    public static void aggiungiSvolgimentoTask(SvolgeTask input) {
        
        String query = "INSERT INTO SvolgeTask VALUES ('%s',%d,'%s')";
         
            int monthFine = input.getDataFine().get(GregorianCalendar.MONTH) + 1;
            int dayFine = input.getDataFine().get(GregorianCalendar.DAY_OF_MONTH);
            int yearFine = input.getDataFine().get(GregorianCalendar.YEAR);
            String dataFine = yearFine + "-" + monthFine + "-" + dayFine;
            
        query = String.format(query, input.getCF(), input.getIDTask(), dataFine);
        
        new GestioneDB().updateDB(query);
    }
        
    public static GregorianCalendar calculateDays(int nGiorni) {
        GregorianCalendar data = new GregorianCalendar();
        data.add(GregorianCalendar.DAY_OF_MONTH, nGiorni);
        return data;
    }
}
