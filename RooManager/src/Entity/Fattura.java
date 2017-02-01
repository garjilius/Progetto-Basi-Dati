
package Entity;

public class Fattura {
    
    private int ID;
    private String data;
    private String dataInizio;
    private int importo;
    private String causale;
    private String cf;
    private int stanza;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getData() {
        return data;
    }

    public String getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(String dataInizio) {
        this.dataInizio = dataInizio;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getImporto() {
        return importo;
    }

    public void setImporto(int importo) {
        this.importo = importo;
    }

    public String getCausale() {
        return causale;
    }

    public void setCausale(String causale) {
        this.causale = causale;
    }

    public String getCf() {
        return cf;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }

    public int getStanza() {
        return stanza;
    }

    public void setStanza(int stanza) {
        this.stanza = stanza;
    }
    
}
