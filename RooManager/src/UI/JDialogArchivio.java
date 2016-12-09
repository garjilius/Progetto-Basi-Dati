
package UI;

import GestioneEntita.GestioneAnagDip;
import GestioneEntita.GestionePermanenza;
import GestioneEntita.GestioneTask;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class JDialogArchivio extends javax.swing.JDialog {

    private boolean dipendente;
    
    public JDialogArchivio(java.awt.Frame parent, boolean modal) throws SQLException {
        super(parent, modal);
        initComponents();
        registroPermanenze();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonAggiungi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Selezionare l'archivio");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Permanenze", "Ospiti", "Dipendenti", "Ditte esterne", "Task completati" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
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
        jScrollPane1.setViewportView(jTable1);

        jButtonAggiungi.setText("Aggiungi");
        jButtonAggiungi.setEnabled(false);
        jButtonAggiungi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAggiungiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonAggiungi, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(jButtonAggiungi)
                .addContainerGap())
        );

        pack();
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
            Logger.getLogger(JDialogArchivio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButtonAggiungiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAggiungiActionPerformed
        
        if(dipendente) {
            JOptionPane.showMessageDialog(null,"Nuovo dipendente");
        } else {
            JOptionPane.showMessageDialog(null,"Nuova ditta");
        }
    }//GEN-LAST:event_jButtonAggiungiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAggiungi;
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
    }
    
    private void registroOspiti() throws SQLException{
        
        Vector colonne = new Vector();
        colonne.add("Nome");
        colonne.add("Cognome");
        colonne.add("Codice fiscale");
        colonne.add("Data di nascita");
        colonne.add("Numero documento");
        
        //Vector dati = new GestioneAnagDip().leggiOspiti();
        Vector dati = new Vector();
        
        jTable1.setModel(new DefaultTableModel(dati, colonne));
        jButtonAggiungi.setEnabled(false);
    }
    
    private void registroDipendenti() throws SQLException{
        
        Vector colonne = new Vector();
        colonne.add("Nome");
        colonne.add("Cognome");
        colonne.add("Codice fiscale");
        colonne.add("Stipendio");
        colonne.add("Data assunzione");
        colonne.add("Data mansione");
        
        Vector dati = new Vector();
        
        jTable1.setModel(new DefaultTableModel(dati, colonne));
        jButtonAggiungi.setEnabled(true);
        dipendente = true;
    }
    
    private void registroDitteEsterne() throws SQLException{
        
        Vector colonne = new Vector();
        colonne.add("Partita IVA");
        colonne.add("Nome");
        colonne.add("Sede");
        colonne.add("Recapito");
        
        Vector dati = new Vector();
        
        jTable1.setModel(new DefaultTableModel(dati, colonne));
        jButtonAggiungi.setEnabled(true);
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
    }

}
