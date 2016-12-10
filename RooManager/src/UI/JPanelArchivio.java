/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import GestioneEntita.GestioneAnagDip;
import GestioneEntita.GestioneDitte;
import GestioneEntita.GestionePermanenza;
import GestioneEntita.GestioneTask;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author giandomenico
 */
public class JPanelArchivio extends javax.swing.JPanel {

    private boolean dipendente;
    /**
     * Creates new form JPanelArchivio
     */
    public JPanelArchivio() throws SQLException {
        initComponents();
        registroPermanenze();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jButtonAggiungi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonStipendio = new javax.swing.JButton();

        setName("Archivio"); // NOI18N

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Permanenze", "Ospiti", "Dipendenti", "Ditte esterne", "Task completati" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Selezionare il registro");
        jLabel1.setName("Archivio"); // NOI18N

        jButtonAggiungi.setText("Aggiungi");
        jButtonAggiungi.setEnabled(false);
        jButtonAggiungi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAggiungiActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setPreferredSize(new java.awt.Dimension(300, 1000));
        jScrollPane1.setViewportView(jTable1);

        jButtonStipendio.setText("Aggiorna stipendio");
        jButtonStipendio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStipendioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonStipendio, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonAggiungi, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(227, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAggiungi)
                    .addComponent(jButtonStipendio))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(370, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

        try {
            int index = jComboBox1.getSelectedIndex();
            switch(index) {
                case 0:
                registroPermanenze();
                break;
                case 1:
                registroOspiti();
                break;
                case 2:
                registroDipendenti();
                break;
                case 3:
                registroDitteEsterne();
                break;
                case 4:
                registroTask();
                break;

            }
        } catch (SQLException ex) {
            Logger.getLogger(getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButtonAggiungiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAggiungiActionPerformed

        if(dipendente) {
            new JDialogOspDip(null, true, false).setVisible(true);
        } else {
            new JDialogDittaEsterna(null, true).setVisible(true);
        }
    }//GEN-LAST:event_jButtonAggiungiActionPerformed

    private void jButtonStipendioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStipendioActionPerformed
        
        int index = jTable1.getSelectedRow();
        System.out.println("Riga: " + index);
        int nuovoS = Integer.parseInt(JOptionPane.showInputDialog("Inserire nuovo stipendio"));
        while(!new GestioneAnagDip().aggiornaStipendio(index, nuovoS))
        {}
        try {
            registroDipendenti();
        } catch (SQLException ex) {
            Logger.getLogger(JPanelArchivio.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButtonStipendioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAggiungi;
    private javax.swing.JButton jButtonStipendio;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private void registroPermanenze() throws SQLException{
        
        Vector colonne = new Vector();
        colonne.add("Nome");
        colonne.add("Cognome");
        colonne.add("Codice fiscale");
        colonne.add("Stanza");
        colonne.add("Data arrivo");
        colonne.add("Data partenza");
        

        //Vector dati = new GestionePermanenza().tutteLePermanenze();
        Vector dati = GestionePermanenza.permanenzeConcluse();
        
        jTable1.setModel(new DefaultTableModel(dati, colonne));
        jButtonAggiungi.setEnabled(false);
        jButtonStipendio.setEnabled(false);
    }
    
    private void registroOspiti() throws SQLException{
        
        Vector colonne = new Vector();
        colonne.add("Nome");
        colonne.add("Cognome");
        colonne.add("Codice fiscale");
        colonne.add("Data di nascita");
        colonne.add("Numero documento");
        
        Vector dati = GestioneAnagDip.leggiOspiti();
        
        jTable1.setModel(new DefaultTableModel(dati, colonne));
        jButtonAggiungi.setEnabled(false);
        jButtonStipendio.setEnabled(false);
    }
    
    private void registroDipendenti() throws SQLException{
        
        Vector colonne = new Vector();
        colonne.add("Nome");
        colonne.add("Cognome");
        colonne.add("Codice fiscale");
        colonne.add("Stipendio");
        colonne.add("Data assunzione");
        colonne.add("Mansione");
        
        Vector dati = GestioneAnagDip.letturaCompletaDipendenti();
        
        jTable1.setModel(new DefaultTableModel(dati, colonne));
        jButtonAggiungi.setEnabled(true);
        jButtonStipendio.setEnabled(true);
        dipendente = true;
    }
    
    private void registroDitteEsterne() throws SQLException{
        
        Vector colonne = new Vector();
        colonne.add("Partita IVA");
        colonne.add("Nome");
        colonne.add("Sede");
        colonne.add("Recapito");
        
        Vector dati = GestioneDitte.leggiDitteComplete();
        
        jTable1.setModel(new DefaultTableModel(dati, colonne));
        jButtonAggiungi.setEnabled(true);
        jButtonStipendio.setEnabled(false);
        dipendente = false;
    }
    
    private void registroTask() throws SQLException{
        
        Vector colonne = new Vector();
        colonne.add("ID");
        colonne.add("Operazione");
        colonne.add("Stanza");
        colonne.add("Partita IVA");
        colonne.add("Codice fiscale");
        colonne.add("Costo");
        colonne.add("Data inizio");
        colonne.add("Data fine");
        
        Vector dati = GestioneTask.storicoTask();
        
        jTable1.setModel(new DefaultTableModel(dati, colonne));
        jButtonAggiungi.setEnabled(false);
        jButtonStipendio.setEnabled(false);
    }

}
