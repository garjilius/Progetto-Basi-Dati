
package UI;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.UnsupportedLookAndFeelException;


public class Home extends javax.swing.JFrame {
    
    public static JPanelTaskCorso task;
    public static JPanelPermanenza permanenze;
    public static JPanelFatture fatture;
    public static ArrayList<String> storicoQuery;
    public static DefaultListModel<String> model;

    public Home() throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);        
        permanenze = new JPanelPermanenza();
        task = new JPanelTaskCorso();
        fatture = new JPanelFatture();
        
        jTabbedPane1.add(permanenze);
        jTabbedPane1.add(task);
        jTabbedPane1.add(new JPanelNewTask());
        jTabbedPane1.add(fatture);
        jTabbedPane1.add(new JPanelArchivio());
        storicoQuery = new ArrayList();
    }

    public static void refreshQList() {
        model = new DefaultListModel<>();
        jListQuerys.removeAll();
        for(String s : storicoQuery  ) {
         model.addElement(s);   
        }
        jListQuerys.setModel(model);
        jListQuerys.ensureIndexIsVisible(storicoQuery.size()-1);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListQuerys = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ROOMANAGER");
        setResizable(false);

        jTabbedPane1.setMinimumSize(new java.awt.Dimension(640, 480));

        jLabel1.setText("Ultime Query:");

        jListQuerys.setBackground(new java.awt.Color(0, 0, 0));
        jListQuerys.setForeground(new java.awt.Color(0, 255, 0));
        jScrollPane1.setViewportView(jListQuerys);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 669, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
                
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Home().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    public static javax.swing.JList<String> jListQuerys;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables

}
