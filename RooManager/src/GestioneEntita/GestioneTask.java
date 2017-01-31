
package GestioneEntita;

import Entity.Task;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.Vector;


public class GestioneTask {
            
        public static ArrayList taskList;

    public static Vector taskInCorso() throws SQLException {
                
        String query = "SELECT * FROM Task WHERE DataFine IS NULL";
        ResultSet result = new GestioneDB().readDB(query);
        taskList = new ArrayList();
        
        Vector dati = new Vector();
        while(result.next()) {
            
            int id = result.getInt("ID");
            String operazione = result.getString("Operazione");
            int numeroStanza = result.getInt("NumeroStanza");
            int tipo = result.getInt("Tipo");
            String PIVA = result.getString("PIVA");
            String CF = result.getString("CodiceFiscale");
            String dataInizio = result.getString("DataInizio");
            int yearInizio = Integer.parseInt(dataInizio.substring(0,4));
            int monthInizio = Integer.parseInt(dataInizio.substring(5,7));
            int dayInizio = Integer.parseInt(dataInizio.substring(8,10));
            GregorianCalendar dataInizioCalendar = new GregorianCalendar();
            dataInizioCalendar.set(yearInizio, monthInizio-1, dayInizio);           
   
            Task temp = new Task();
            temp.setID(id);
            temp.setTipo(tipo);
            temp.setOperazione(operazione);
            temp.setStanza(numeroStanza);
            temp.setPIVA(PIVA);
            temp.setCF(CF); 
            temp.setDataInizio(dataInizioCalendar);
           
            taskList.add(temp);
            
            Vector riga = new Vector();
            riga.add(id);
            riga.add(operazione);
            riga.add(numeroStanza);
            riga.add(PIVA);
            riga.add(CF);
            riga.add(dataInizio);
            dati.add(riga);
        }
      
        return dati;
    }
    

    public static Vector storicoTask(int mode) throws SQLException {
        
        String query = "SELECT * FROM Task WHERE DataFine IS NOT NULL";
        if(mode == 0) {
           query = "SELECT * FROM Task WHERE DataFine IS NOT NULL ORDER BY ID";
        }
        if(mode == 1) {
           query = "SELECT * FROM Task WHERE DataFine IS NOT NULL ORDER BY DataInizio";
        }
        if(mode == 2) {
            query = "SELECT * FROM Task WHERE DataFine IS NOT NULL ORDER BY DataFine";
        }
        ResultSet result = new GestioneDB().readDB(query);   
        Vector dati = new Vector();
        while(result.next()) {
            
            int id = result.getInt("ID");
            String operazione = result.getString("Operazione");
            int numeroStanza = result.getInt("NumeroStanza");
            String PIVA = result.getString("PIVA");
            String CF = result.getString("CodiceFiscale");
            int costo = result.getInt("Costo");
            String dataInizio = result.getString("DataInizio");
            String dataFine = result.getString("DataFine");

            Vector riga = new Vector();
            riga.add(id);
            riga.add(operazione);
            riga.add(numeroStanza);
            riga.add(PIVA);
            riga.add(CF);
            riga.add(costo);
            riga.add(dataInizio);
            riga.add(dataFine);
            dati.add(riga);
        }
        
        return dati;
    }
    
    public static void aggiungiTaskOrdinario(Task input) {
        
        String query = "INSERT INTO Task VALUES (null,%d,'%s',%d,null,'%s',null,CURRENT_DATE(),null)";
        
        query = String.format(query, 
                input.getTipo(),
                input.getOperazione(), 
                input.getStanza(), 
                input.getCF()); 
               
        new GestioneDB().updateDB(query);
    }
    
        public static void aggiungiTaskStraordinario(Task input) {
        
        String query = "INSERT INTO Task VALUES (null,%d,'%s',%d,'%s',null,null,CURRENT_DATE(),null)";
        
        query = String.format(query,
                input.getTipo(),
                input.getOperazione(), 
                input.getStanza(), 
                input.getPIVA());  
        
        new GestioneDB().updateDB(query);
    }
        
        public static boolean terminaTask(int index) throws SQLException, ParseException {
        Task input = (Task) taskList.get(index);
        
        Random randomGenerator = new Random();
        String query;
        int costo = randomGenerator.nextInt(10000);

        if(input.getTipo() == 2) {
            query = "UPDATE Task SET DataFine = CURRENT_DATE(), Costo = %d WHERE ID = %d";
            query = String.format(query, 
                costo,
                input.getID());
        }
        else {
         query = "UPDATE Task SET DataFine = CURRENT_DATE() WHERE ID = %d";
         query = String.format(query, 
                input.getID());
        }
        
        if(new GestioneDB().updateDB(query)) {          
            if(input.getCF() == null ) {
        }     
             return true;            
        }
        else 
            return false;
        }  
}
