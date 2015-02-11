/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paz1c.knihy;

import javax.swing.JOptionPane;

public class PrihlasovaciaObrazovka extends javax.swing.JFrame {

    public PrihlasovaciaObrazovka() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLoginText = new javax.swing.JLabel();
        jHesloText = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        jOK = new javax.swing.JButton();
        txtHeslo = new javax.swing.JPasswordField();
        lblPozadie = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 50, 50));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLoginText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLoginText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLoginText.setText("Login :");
        jLoginText.setFocusable(false);
        jLoginText.setInheritsPopupMenu(false);
        jLoginText.setRequestFocusEnabled(false);
        getContentPane().add(jLoginText, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 12, 91, 33));

        jHesloText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jHesloText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jHesloText.setText("Heslo :");
        jHesloText.setFocusable(false);
        jHesloText.setInheritsPopupMenu(false);
        jHesloText.setRequestFocusEnabled(false);
        getContentPane().add(jHesloText, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 65, 91, 35));
        getContentPane().add(txtLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 14, 171, 33));

        jOK.setText("OK");
        jOK.setFocusPainted(false);
        jOK.setFocusable(false);
        jOK.setOpaque(false);
        jOK.setRequestFocusEnabled(false);
        jOK.setRolloverEnabled(false);
        jOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jOKActionPerformed(evt);
            }
        });
        getContentPane().add(jOK, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 132, 64, -1));

        txtHeslo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHesloActionPerformed(evt);
            }
        });
        getContentPane().add(txtHeslo, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 67, 171, 35));

        lblPozadie.setIcon(new javax.swing.ImageIcon("D:\\Skola\\PAZ_PROJEKT\\projekt\\Book_Background_Texture___SS1_by_HornedGodSlaine_mensie.jpg")); // NOI18N
        lblPozadie.setText("jLabel1");
        getContentPane().add(lblPozadie, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 180));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jOKActionPerformed
        
        String login = txtLogin.getText();
        String heslo = txtHeslo.getText();

        LoginService loginService = new LoginService();
        boolean isLoggedIn = loginService.login(login, heslo);
        if(isLoggedIn) {
            HlavnyFormular hlavnyformular = new HlavnyFormular();
            hlavnyformular.setVisible(true);
            dispose();
            
        } else {
            JOptionPane.showMessageDialog(this, "Neplatne prihlasenie !");
        }
        
        
        
    }//GEN-LAST:event_jOKActionPerformed

    private void txtHesloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHesloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHesloActionPerformed

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
            java.util.logging.Logger.getLogger(PrihlasovaciaObrazovka.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrihlasovaciaObrazovka.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrihlasovaciaObrazovka.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrihlasovaciaObrazovka.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrihlasovaciaObrazovka().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jHesloText;
    private javax.swing.JLabel jLoginText;
    private javax.swing.JButton jOK;
    private javax.swing.JLabel lblPozadie;
    private javax.swing.JPasswordField txtHeslo;
    private javax.swing.JTextField txtLogin;
    // End of variables declaration//GEN-END:variables
}
