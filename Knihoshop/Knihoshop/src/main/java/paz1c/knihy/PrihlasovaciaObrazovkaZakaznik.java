/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paz1c.knihy;

import java.util.List;
import javax.swing.JOptionPane;

public class PrihlasovaciaObrazovkaZakaznik extends javax.swing.JFrame {

    public PrihlasovaciaObrazovkaZakaznik() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLoginText = new javax.swing.JLabel();
        jHesloText = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        txtHeslo = new javax.swing.JTextField();
        jOK = new javax.swing.JButton();
        lblPozadie = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLoginText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLoginText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLoginText.setText("Login :");
        jLoginText.setFocusable(false);
        jLoginText.setInheritsPopupMenu(false);
        jLoginText.setRequestFocusEnabled(false);
        getContentPane().add(jLoginText, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 33, -1, -1));

        jHesloText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jHesloText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jHesloText.setText("Heslo :");
        jHesloText.setInheritsPopupMenu(false);
        jHesloText.setRequestFocusEnabled(false);
        getContentPane().add(jHesloText, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 80, -1, -1));
        getContentPane().add(txtLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 28, 158, 30));
        getContentPane().add(txtHeslo, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 77, 158, 29));

        jOK.setText("OK");
        jOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jOKActionPerformed(evt);
            }
        });
        getContentPane().add(jOK, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 133, -1, -1));

        lblPozadie.setIcon(new javax.swing.ImageIcon("D:\\Skola\\PAZ_PROJEKT\\projekt\\Book_Background_Texture___SS1_by_HornedGodSlaine_mensie.jpg")); // NOI18N
        lblPozadie.setText("jLabel1");
        getContentPane().add(lblPozadie, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 170));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jOKActionPerformed
        
        String login = txtLogin.getText();
        String heslo = txtHeslo.getText();
        List<User> zoznamZakaznikov;

        LoginServiceZakaznik loginService = new LoginServiceZakaznik();
        zoznamZakaznikov =loginService.dajZakaznikov();
        
        boolean isLoggedIn = loginService.login(login, heslo,zoznamZakaznikov);
        if(isLoggedIn) {
            HlavnyFormularZakaznik hlavnyFormularZakaznik = new HlavnyFormularZakaznik();
            hlavnyFormularZakaznik.setVisible(true);
            dispose();
            
        } else {
            JOptionPane.showMessageDialog(this, "Neplatne prihlasenie !");
        }
        
        
        
    }//GEN-LAST:event_jOKActionPerformed

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
            java.util.logging.Logger.getLogger(PrihlasovaciaObrazovkaZakaznik.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrihlasovaciaObrazovkaZakaznik.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrihlasovaciaObrazovkaZakaznik.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrihlasovaciaObrazovkaZakaznik.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrihlasovaciaObrazovkaZakaznik().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jHesloText;
    private javax.swing.JLabel jLoginText;
    private javax.swing.JButton jOK;
    private javax.swing.JLabel lblPozadie;
    private javax.swing.JTextField txtHeslo;
    private javax.swing.JTextField txtLogin;
    // End of variables declaration//GEN-END:variables
}
