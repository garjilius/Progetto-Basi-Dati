package UI;

import Entity.AnagDipe;
import Entity.Permanenza;
import GestioneEntita.GestioneAnagDip;
import GestioneEntita.GestionePermanenza;
import GestioneEntita.GestioneStanza;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class JDialogOspDip extends javax.swing.JDialog {

    private boolean nuovoCF;

    public JDialogOspDip(java.awt.Frame parent, boolean modal, boolean perm) {
        super(parent, modal);
        initComponents();

        // MODALITA PERMANENZA
        if (perm) {
            Vector stanze = null;
            try {
                stanze = new GestioneStanza().leggiStanze();
            } catch (SQLException ex) {}

            jComboBoxStanza.setModel(new DefaultComboBoxModel<>(stanze));
            String oggi = new SimpleDateFormat("yyyy-MM-dd").format(new GregorianCalendar().getTime());
            dataInizio.setText(oggi);
            jPanelDipendente.setVisible(false);
        } else {
            String oggi = new SimpleDateFormat("yyyy-MM-dd").format(new GregorianCalendar().getTime());
            dataAss.setText(oggi);
            jPanelCheckIn.setVisible(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cf = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        nome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cognome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        dd = new javax.swing.JTextField();
        mese = new javax.swing.JComboBox<>();
        yyyy = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        ndoc = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jButtonVerifica = new javax.swing.JButton();
        jPanelCheckIn = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxStanza = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        dataInizio = new javax.swing.JTextField();
        jButtonPermanenza = new javax.swing.JButton();
        jPanelDipendente = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        stipendio = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        dataAss = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jComboBoxMansione = new javax.swing.JComboBox<>();
        jButtonDipendente = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Codice Fiscale");

        jLabel2.setText("Nome");

        nome.setEnabled(false);

        jLabel3.setText("Cognome");

        cognome.setEnabled(false);

        jLabel4.setText("Data di nascita");

        dd.setEnabled(false);

        mese.setEditable(true);
        mese.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        mese.setEnabled(false);

        yyyy.setEnabled(false);

        jLabel5.setText("Numero documento");

        ndoc.setEnabled(false);

        jButtonVerifica.setText("Verifica");
        jButtonVerifica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerificaActionPerformed(evt);
            }
        });

        jLabel6.setText("Stanza");

        jLabel8.setText("Check-in");

        dataInizio.setEditable(false);

        jButtonPermanenza.setText("Conferma");
        jButtonPermanenza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPermanenzaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelCheckInLayout = new javax.swing.GroupLayout(jPanelCheckIn);
        jPanelCheckIn.setLayout(jPanelCheckInLayout);
        jPanelCheckInLayout.setHorizontalGroup(
            jPanelCheckInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCheckInLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelCheckInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCheckInLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxStanza, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(204, 204, 204))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCheckInLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataInizio, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(154, 154, 154))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCheckInLayout.createSequentialGroup()
                        .addComponent(jButtonPermanenza, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanelCheckInLayout.setVerticalGroup(
            jPanelCheckInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCheckInLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCheckInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxStanza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCheckInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dataInizio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonPermanenza)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel9.setText("Stipendio");

        jLabel10.setText("Data assunzione");

        dataAss.setEditable(false);

        jLabel11.setText("Mansione");

        jComboBoxMansione.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pulizia", "Servizio in camera" }));

        jButtonDipendente.setText("Conferma");
        jButtonDipendente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDipendenteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDipendenteLayout = new javax.swing.GroupLayout(jPanelDipendente);
        jPanelDipendente.setLayout(jPanelDipendenteLayout);
        jPanelDipendenteLayout.setHorizontalGroup(
            jPanelDipendenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDipendenteLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanelDipendenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDipendenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBoxMansione, 0, 190, Short.MAX_VALUE)
                    .addComponent(dataAss)
                    .addComponent(stipendio))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDipendenteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonDipendente, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelDipendenteLayout.setVerticalGroup(
            jPanelDipendenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDipendenteLayout.createSequentialGroup()
                .addGroup(jPanelDipendenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stipendio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(8, 8, 8)
                .addGroup(jPanelDipendenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(dataAss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDipendenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxMansione, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addComponent(jButtonDipendente)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jPanelCheckIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelDipendente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cf, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(153, 153, 153)
                                .addComponent(ndoc, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(cognome, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(nome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(dd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(mese, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(yyyy, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jButtonVerifica, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addComponent(jSeparator2)
            .addComponent(jSeparator3)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonVerifica)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cognome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mese, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yyyy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ndoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(8, 8, 8)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jPanelDipendente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVerificaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerificaActionPerformed

        AnagDipe info = new AnagDipe();
        if (!(cf.getText().trim().equals(""))) {
            try {
                info = new GestioneAnagDip().verificaCf(cf.getText());
            } catch (SQLException ex) {
                Logger.getLogger(JDialogOspDip.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (info == null) {
                nome.setEnabled(true);
                cognome.setEnabled(true);
                ndoc.setEnabled(true);
                dd.setEnabled(true);
                yyyy.setEnabled(true);
                mese.setEnabled(true);
                nuovoCF = true;
            } else {
                nome.setText(info.getNome());
                cognome.setText(info.getCognome());
                ndoc.setText(info.getNumeroDocumento());
                String[] data = info.getDataDiNascita().split("[.-]");
                yyyy.setText(data[0]);
                mese.setSelectedItem(data[1]);
                dd.setText(data[2]);
                nuovoCF = false;
            }
        }
    }//GEN-LAST:event_jButtonVerificaActionPerformed

    private void jButtonPermanenzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPermanenzaActionPerformed

        // CONTROLLIAMO PRIMA LA STANZA SELEZIONATA
        int stanzaSelezionata = (Integer) jComboBoxStanza.getSelectedItem();
        try {
            if (!(new GestioneStanza().controllaStanza(stanzaSelezionata))) {
                JOptionPane.showMessageDialog(this, "Stanza selezionata piena");
                return;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDialogOspDip.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // SE LA STANZA E' LIBERA CREO L'ANAGRAFICA SE SERVE E CREO LA PERMANENZA
        if (nuovoCF) {
            creaAnagrafica(true);
        }

        Permanenza nuovaPer = new Permanenza();
        nuovaPer.setCodiceFiscale(cf.getText());
        nuovaPer.setNumeroStanza(jComboBoxStanza.getSelectedIndex() + 1);
        nuovaPer.setDataInizio(dataInizio.getText());
        new GestionePermanenza().aggiungiPermanenza(nuovaPer);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonPermanenzaActionPerformed

    private void jButtonDipendenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDipendenteActionPerformed

        AnagDipe nuovoDip = new AnagDipe();
        if (nuovoCF) {
            nuovoDip = creaAnagrafica(false);
        } else {
            nuovoDip.setCodiceFiscale(cf.getText());
        }

        nuovoDip.setStipendio(Integer.parseInt(stipendio.getText()));
        nuovoDip.setDataAssunzione(dataAss.getText());
        nuovoDip.setMansione(jComboBoxMansione.getSelectedIndex());
        new GestioneAnagDip().aggiungiDipendente(nuovoDip);
        this.setVisible(false);

    }//GEN-LAST:event_jButtonDipendenteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cf;
    private javax.swing.JTextField cognome;
    private javax.swing.JTextField dataAss;
    private javax.swing.JTextField dataInizio;
    private javax.swing.JTextField dd;
    private javax.swing.JButton jButtonDipendente;
    private javax.swing.JButton jButtonPermanenza;
    private javax.swing.JButton jButtonVerifica;
    private javax.swing.JComboBox<String> jComboBoxMansione;
    private javax.swing.JComboBox<String> jComboBoxStanza;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanelCheckIn;
    private javax.swing.JPanel jPanelDipendente;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JComboBox<String> mese;
    private javax.swing.JTextField ndoc;
    private javax.swing.JTextField nome;
    private javax.swing.JTextField stipendio;
    private javax.swing.JTextField yyyy;
    // End of variables declaration//GEN-END:variables

    private AnagDipe creaAnagrafica(boolean ospite) {

        AnagDipe nuovo = new AnagDipe();
        nuovo.setCodiceFiscale(cf.getText());
        nuovo.setNome(nome.getText());
        nuovo.setCognome(cognome.getText());
        String dataNascita = yyyy.getText() + "-" + mese.getSelectedItem() + "-"
                + dd.getText();
        nuovo.setDataDiNascita(dataNascita);
        nuovo.setNumeroDocumento(ndoc.getText());

        if (ospite) {
            nuovo.setTipo(1);

            //Essendo ospite dobbiamo solo aggiungere la riga al database e 
            //poi dopo la permanenza
            new GestioneAnagDip().aggiungiAnagrafica(nuovo);
            return null;
        } else {
            nuovo.setTipo(2);

            //Essendo dipendente ritorniamo l'anagrafica appena creata così che
            //si possono aggiungere le informazioni che mancano
            new GestioneAnagDip().aggiungiAnagrafica(nuovo);
            return nuovo;
        }

    }

}
