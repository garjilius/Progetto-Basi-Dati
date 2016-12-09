
package GestioneEntita;

import Entity.Task;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
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
            
            //System.out.println(temp.getID());
            //System.out.println(temp.getDataInizio());
            //System.out.println(dataInizioCalendar.get(GregorianCalendar.DAY_OF_MONTH) + " " + (dataInizioCalendar.get(GregorianCalendar.MONTH)+1) + " " + dataInizioCalendar.get(GregorianCalendar.YEAR));
            //System.out.println(dataInizio.substring(8,10));
            //System.out.println("DATA, da GestioneTask: Giorno: " + dayInizio + " mese: " + monthInizio + " anno: " + yearInizio);
            
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
    
    public static Vector storicoTask() throws SQLException {
                
        String query = "SELECT * FROM Task WHERE DataFine IS NOT NULL";
        ResultSet result = new GestioneDB().readDB(query);
        
        Vector dati = new Vector();
        while(result.next()) {
            
            int id = result.getInt("ID");
            String operazione = result.getString("Operazione");
            int numeroStanza = result.getInt("NumeroStanza");
            String PIVA = result.getString("PIVA");
            String CF = result.getString("CodiceFiscale");
            String dataInizio = result.getString("DataInizio");
            String dataFine = result.getString("DataFine");


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
        
        public static boolean terminaTask(int index) throws SQLException {
        Task input = (Task) taskList.get(index);
        
        //String query = "INSERT IGNORE INTO Task VALUES (%d,'%s',%d,'%s',null,'%.2f','%s',null)";
        String query = "UPDATE Task SET DataFine = '%s' WHERE ID = %d";
        GregorianCalendar gregoryFine = new GregorianCalendar();
        
        int monthFine = gregoryFine.get(GregorianCalendar.MONTH) + 1;
        int dayFine = gregoryFine.get(GregorianCalendar.DAY_OF_MONTH);
        int yearFine = gregoryFine.get(GregorianCalendar.YEAR);
        String dataFine = yearFine + "-" + monthFine + "-" + dayFine;
        query = String.format(query, 
                dataFine,
                input.getID());
        System.out.println(query);
        
        if(new GestioneDB().updateDB(query)) {
           return true;
        }
        
        else 
            return false;
     
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
