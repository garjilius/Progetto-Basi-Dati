/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author emanuelegargiulo
 */
public class Task {
    private int ID;
    private int tipo;
    private String Operazione;
    private int stanza;


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
