
package paz1c.knihy;

public class UvodnaObrazovka extends javax.swing.JFrame {

    public UvodnaObrazovka() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jAdministrator = new javax.swing.JButton();
        jZakaznik = new javax.swing.JButton();
        jUvodnaObrazovka = new javax.swing.JLabel();
        lblPozadie = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(124, 145, 220));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jAdministrator.setText("Administrator");
        jAdministrator.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jAdministrator.setFocusPainted(false);
        jAdministrator.setOpaque(false);
        jAdministrator.setRequestFocusEnabled(false);
        jAdministrator.setRolloverEnabled(false);
        jAdministrator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAdministratorActionPerformed(evt);
            }
        });
        getContentPane().add(jAdministrator, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 36, 133, 28));

        jZakaznik.setForeground(new java.awt.Color(51, 51, 51));
        jZakaznik.setText("Zakaznik");
        jZakaznik.setOpaque(false);
        jZakaznik.setRequestFocusEnabled(false);
        jZakaznik.setRolloverEnabled(false);
        jZakaznik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jZakaznikActionPerformed(evt);
            }
        });
        getContentPane().add(jZakaznik, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 133, 28));

        jUvodnaObrazovka.setBackground(new java.awt.Color(204, 204, 255));
        jUvodnaObrazovka.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jUvodnaObrazovka.setForeground(new java.awt.Color(0, 51, 51));
        jUvodnaObrazovka.setText("Prihlasit sa ako:");
        jUvodnaObrazovka.setFocusable(false);
        jUvodnaObrazovka.setInheritsPopupMenu(false);
        jUvodnaObrazovka.setRequestFocusEnabled(false);
        getContentPane().add(jUvodnaObrazovka, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 36, 193, 57));

        lblPozadie.setIcon(new javax.swing.ImageIcon("D:\\Skola\\PAZ_PROJEKT\\projekt\\Book_Background_Texture___SS1_by_HornedGodSlaine_mensie.jpg")); // NOI18N
        lblPozadie.setText("jLabel1");
        getContentPane().add(lblPozadie, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 130));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jAdministratorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAdministratorActionPerformed
        PrihlasovaciaObrazovka prihlasovaciaObrazovka=new PrihlasovaciaObrazovka();
        prihlasovaciaObrazovka.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_jAdministratorActionPerformed

    private void jZakaznikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jZakaznikActionPerformed
        PrihlasovaciaObrazovkaZakaznik prihlasovaciaObrazovkaZakaznik=new PrihlasovaciaObrazovkaZakaznik();
        prihlasovaciaObrazovkaZakaznik.setVisible(true);
        dispose();
    }//GEN-LAST:event_jZakaznikActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UvodnaObrazovka.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UvodnaObrazovka.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UvodnaObrazovka.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UvodnaObrazovka.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UvodnaObrazovka().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jAdministrator;
    private javax.swing.JLabel jUvodnaObrazovka;
    private javax.swing.JButton jZakaznik;
    private javax.swing.JLabel lblPozadie;
    // End of variables declaration//GEN-END:variables
}
