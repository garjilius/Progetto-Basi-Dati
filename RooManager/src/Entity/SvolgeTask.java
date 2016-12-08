/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.GregorianCalendar;

/**
 *
 * @author emanuelegargiulo
 */
public class SvolgeTask {
    private String CF = "";
    private int IDTask;
    private GregorianCalendar dataFine = new GregorianCalendar();

    /**
     * @return the CF
     */
    public String getCF() {
        return CF;
    }

    /**
     * @param CF the CF to set
     */
    public void setCF(String CF) {
        this.CF = CF;
    }

    /**
     * @return the IDTask
     */
    public int getIDTask() {
        return IDTask;
    }

    /**
     * @param IDTask the IDTask to set
     */
    public void setIDTask(int IDTask) {
        this.IDTask = IDTask;
    }

    /**
     * @return the dataCompletamento
     */
    public GregorianCalendar getDataFine() {
        return dataFine;
    }

    /**
     * @param dataCompletamento the dataCompletamento to set
     */
    public void setDataFine(GregorianCalendar dataCompletamento) {
        this.dataFine = dataCompletamento;
    }
         
    
}
