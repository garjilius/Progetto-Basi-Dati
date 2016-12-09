/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.GregorianCalendar;
import java.util.Random;

/**
 *
 * @author emanuelegargiulo
 */
public class Task {
    private int ID;
    private int tipo;
    private String Operazione;
    private int stanza;
    private String CF = "";
    private int IDTask;
    private GregorianCalendar dataFine = new GregorianCalendar();
    private String PIVA; 
    private float costo;
    private Random randomGenerator = new Random();
    private GregorianCalendar dataInizio = new GregorianCalendar();

    /**
     * @return the PIVA
     */
    public String getPIVA() {
        return PIVA;
    }

    /**
     * @param PIVA the PIVA to set
     */
    public void setPIVA(String PIVA) {
        this.PIVA = PIVA;
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
     * @return the costo
     */
    public float getCosto() {
        return costo;
    }

    /**
     * @param costo the costo to set
     */
    public void setCosto(float costo) {
        this.costo = costo;
    }

    /**
     * @return the randomGenerator
     */
    public Random getRandomGenerator() {
        return randomGenerator;
    }

    /**
     * @param randomGenerator the randomGenerator to set
     */
    public void setRandomGenerator(Random randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    /**
     * @return the dataInizio
     */
    public GregorianCalendar getDataInizio() {
        return dataInizio;
    }

    /**
     * @param dataInizio the dataInizio to set
     */
    public void setDataInizio(GregorianCalendar dataInizio) {
        this.dataInizio = dataInizio;
    }

    /**
     * @return the dataFine
     */
    public GregorianCalendar getDataFine() {
        return dataFine;
    }

    /**
     * @param dataFine the dataFine to set
     */
    public void setDataFine(GregorianCalendar dataFine) {
        this.dataFine = dataFine;
    }

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
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }
    
    public int getStanza() {
        return stanza;
    }
    
    public void setStanza(int stanza) {
        this.stanza = stanza;
    }

    /**
     * @return the tipo
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the Operazione
     */
    public String getOperazione() {
        return Operazione;
    }

    /**
     * @param Operazione the Operazione to set
     */
    public void setOperazione(String Operazione) {
        this.Operazione = Operazione;
    }
    
}
