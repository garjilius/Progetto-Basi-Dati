
package GestioneEntita;

import Entity.SvolgeTask;
import Entity.Task;
import Entity.TaskEseguitoDa;
import java.util.GregorianCalendar;


public class GestioneTask {
            
    public static void aggiungiTask(Task input) {
        
        String query = "INSERT INTO Task VALUES (%d,'%s',%d,%d)";
        query = String.format(query, input.getID(), input.getOperazione(),
                input.getTipo(), input.getStanza());
        
        new GestioneDB().updateDB(query);
    }
        
    public static void aggiungiEsecuzioneTask(TaskEseguitoDa input) {
        
        String query = "INSERT IGNORE INTO TaskEseguitoDa VALUES ('%s',%d,'%.2f','%s','%s')";
            int monthInizio = input.getDataInizio().get(GregorianCalendar.MONTH) + 1;
            int dayInizio = input.getDataInizio().get(GregorianCalendar.DAY_OF_MONTH);
            int yearInizio = input.getDataInizio().get(GregorianCalendar.YEAR);
            String dataInizio = yearInizio + "-" + monthInizio + "-" + dayInizio;
            int monthFine = input.getDataFine().get(GregorianCalendar.MONTH) + 1;
            int dayFine = input.getDataFine().get(GregorianCalendar.DAY_OF_MONTH);
            int yearFine = input.getDataFine().get(GregorianCalendar.YEAR);
            String dataFine = yearFine + "-" + monthFine + "-" + dayFine;
            
        query = String.format(query, input.getPIVA(), input.getIDTask(),
                input.getCosto(), dataInizio, dataFine);
        System.out.println(query);
        
        new GestioneDB().updateDB(query);
    }
    
    public static void aggiungiSvolgimentoTask(SvolgeTask input) {
        
        String query = "INSERT INTO SvolgeTask VALUES ('%s',%d,'%s')";
         
            int monthFine = input.getDataFine().get(GregorianCalendar.MONTH) + 1;
            int dayFine = input.getDataFine().get(GregorianCalendar.DAY_OF_MONTH);
            int yearFine = input.getDataFine().get(GregorianCalendar.YEAR);
            String dataFine = yearFine + "-" + monthFine + "-" + dayFine;
            
        query = String.format(query, input.getCF(), input.getIDTask(), dataFine);
        System.out.println(query);
        
        new GestioneDB().updateDB(query);
    }
        
    public static GregorianCalendar calculateDays(int nGiorni) {
        GregorianCalendar data = new GregorianCalendar();
        data.add(GregorianCalendar.DAY_OF_MONTH, nGiorni);
        return data;
    }
}
