
package UI;

import GestioneEntita.GestionePermanenza;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class JPanelPermanenza extends javax.swing.JPanel {

    private GestionePermanenza gestore = null;
    private int rigaSelezionata = -1;
    
    public JPanelPermanenza() {
        initComponents();
        gestore = new GestionePermanenza();
        try {
            popolaTabella();
        } catch (SQLException ex) {
            Logger.getLogger(this.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabellaPermanenze = new javax.swing.JTable();
        checkIn = new javax.swing.JButton();
        checkOut = new javax.swing.JButton();

        setName("Permanenze"); // NOI18N

        tabellaPermanenze.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Codice Fiscale", "Stanza", "Data Check-In"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabellaPermanenze.setMaximumSize(new java.awt.Dimension(2147483647, 6400));
        tabellaPermanenze.setPreferredSize(new java.awt.Dimension(225, 800));
        tabellaPermanenze.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabellaPermanenzeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabellaPermanenze);

        checkIn.setText("Check-in");
        checkIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkInActionPerformed(evt);
            }
        });

        checkOut.setText("Check-out / Fattura");
        checkOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(checkIn, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 231, Short.MAX_VALUE)
                        .addComponent(checkOut, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkIn)
                    .addComponent(checkOut))
                .addGap(16, 16, 16))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tabellaPermanenzeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabellaPermanenzeMouseClicked
      rigaSelezionata = tabellaPermanenze.getSelectedRow();
    }//GEN-LAST:event_tabellaPermanenzeMouseClicked

    private void checkInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkInActionPerformed

        JDialog dialog = new JDialogOspDip(null, true, true);
        dialog.setVisible(true);
        while(dialog.isShowing()) {}
        try {
            popolaTabella();
        } catch (SQLException ex) {
            Logger.getLogger(this.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_checkInActionPerformed

    private void checkOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkOutActionPerformed
        if(rigaSelezionata == -1) {
            JOptionPane.showMessageDialog(null, "Selezionare una permanenza");
            return;
        }
        try {
            gestore.terminaPermanenza(rigaSelezionata);
        } catch (ParseException | SQLException ex) {
            Logger.getLogger(this.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_checkOutActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton checkIn;
    private javax.swing.JButton checkOut;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabellaPermanenze;
    // End of variables declaration//GEN-END:variables

    public void popolaTabella() throws SQLException {
        
        Vector colonne = new Vector();
        colonne.add("Codice Fiscale");
        colonne.add("Stanza");
        colonne.add("Data Check-in");
        
        Vector dati = gestore.permanenzeInCorso();
        
        tabellaPermanenze.setModel(new DefaultTableModel(dati, colonne));
    }
}
