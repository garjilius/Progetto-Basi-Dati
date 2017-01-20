
package GestioneEntita;

import Entity.Task;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        
        String query = "INSERT INTO Task VALUES (null,'%s',%d,null,'%s',null,'%s',null)";
        
        int monthInizio = input.getDataInizio().get(GregorianCalendar.MONTH) + 1;
        int dayInizio = input.getDataInizio().get(GregorianCalendar.DAY_OF_MONTH);
        int yearInizio = input.getDataInizio().get(GregorianCalendar.YEAR);
        String dataInizio = yearInizio + "-" + monthInizio + "-" + dayInizio;
        query = String.format(query, 
                input.getOperazione(), 
                input.getStanza(), 
                input.getCF(), 
                dataInizio);
               
        System.out.println(query);
        new GestioneDB().updateDB(query);
    }
    
        public static void aggiungiTaskStraordinario(Task input) {
        
        String query = "INSERT INTO Task VALUES (null,'%s',%d,'%s',null,null,'%s',null)";
        
        int monthInizio = input.getDataInizio().get(GregorianCalendar.MONTH) + 1;
        int dayInizio = input.getDataInizio().get(GregorianCalendar.DAY_OF_MONTH);
        int yearInizio = input.getDataInizio().get(GregorianCalendar.YEAR);
        String dataInizio = yearInizio + "-" + monthInizio + "-" + dayInizio;
        query = String.format(query,                 
                input.getOperazione(), 
                input.getStanza(), 
                input.getPIVA(),  
                dataInizio);
        System.out.println(query);
        
        new GestioneDB().updateDB(query);
    }
        
        public static boolean terminaTask(int index) throws SQLException, ParseException {
        Task input = (Task) taskList.get(index);
        System.out.println(input.getID() + "Id task gestionetask-terminatask");
        
        GregorianCalendar gregoryFine = new GregorianCalendar();
        Random randomGenerator = new Random();
        String query;
        int monthFine = gregoryFine.get(GregorianCalendar.MONTH) + 1;
        int dayFine = gregoryFine.get(GregorianCalendar.DAY_OF_MONTH);
        int yearFine = gregoryFine.get(GregorianCalendar.YEAR);
        String dataFine = yearFine + "-" + monthFine + "-" + dayFine;
        int costo = randomGenerator.nextInt(10000);

// QUI IL CONTROLLO LO FACCIAMO SU TIPO TASK E NON SU ASSENZA CF POI EH?
        if(input.getTipo() == 2) {
            query = "UPDATE Task SET DataFine = '%s', Costo = %d WHERE ID = %d";
            query = String.format(query, 
                dataFine,
                costo,
                input.getID());
        }
        else {
         query = "UPDATE Task SET DataFine = '%s' WHERE ID = %d";
         query = String.format(query, 
                dataFine,
                input.getID());
        }
        
        System.out.println(query);
        
        if(new GestioneDB().updateDB(query)) {
            
            if(input.getCF() == null ) { 
        }     
             return true;            
        }
        else 
            return false;
        }
                  
    public static GregorianCalendar calculateDays(int nGiorni) {
        GregorianCalendar data = new GregorianCalendar();
        data.add(GregorianCalendar.DAY_OF_MONTH, nGiorni);
        return data;
    }
}
