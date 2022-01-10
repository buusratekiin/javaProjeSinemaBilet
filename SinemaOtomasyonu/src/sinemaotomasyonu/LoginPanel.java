
import javax.swing.JOptionPane;

public class LoginPanel extends javax.swing.JFrame {

    public LoginPanel() {
        initComponents();
    }
      SinemaIslemleri sinemaIslemleri = new SinemaIslemleri();
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        usernamerea = new javax.swing.JTextField();
        passwordarea = new javax.swing.JPasswordField();
        adminLoginButton = new javax.swing.JButton();
        clientLogin = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        registerButonu = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(520, 300, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(860, 520));
        getContentPane().setLayout(null);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Kullanıcı Adı : ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(250, 150, 170, 70);

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Parola : ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(250, 220, 140, 40);
        getContentPane().add(usernamerea);
        usernamerea.setBounds(440, 170, 140, 30);
        getContentPane().add(passwordarea);
        passwordarea.setBounds(440, 230, 140, 30);

        adminLoginButton.setBackground(new java.awt.Color(51, 255, 204));
        adminLoginButton.setText("Yönetici girişi");
        adminLoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminLoginButtonActionPerformed(evt);
            }
        });
        getContentPane().add(adminLoginButton);
        adminLoginButton.setBounds(280, 370, 110, 50);

        clientLogin.setBackground(new java.awt.Color(51, 255, 204));
        clientLogin.setText("Müşteri girişi");
        clientLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientLoginActionPerformed(evt);
            }
        });
        getContentPane().add(clientLogin);
        clientLogin.setBounds(430, 370, 110, 50);

        jSeparator1.setBackground(new java.awt.Color(255, 255, 102));
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(10, 350, 830, 10);

        registerButonu.setBackground(new java.awt.Color(51, 255, 204));
        registerButonu.setText("Kaydınız yok mu? Hemen oluşturun");
        registerButonu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButonuActionPerformed(evt);
            }
        });
        getContentPane().add(registerButonu);
        registerButonu.setBounds(290, 290, 250, 40);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cinema.jpg"))); // NOI18N
        jLabel3.setOpaque(true);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 840, 470);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void adminLoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminLoginButtonActionPerformed
        
        String kullaniciadi = usernamerea.getText();
        String parola = new String(passwordarea.getPassword());
        
        boolean girisIslemi = sinemaIslemleri.adminGirisYap(kullaniciadi, parola);
        
        if(girisIslemi)
        {
            AdminIslemleri adminIslemleri = new AdminIslemleri();
            setVisible(false);
            adminIslemleri.setVisible(true);
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Giriş başarısız");
        }
    }//GEN-LAST:event_adminLoginButtonActionPerformed
    public static String girilenkullanciadi;
    private void clientLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientLoginActionPerformed
        
        String kullaniciadi = usernamerea.getText();
        String parola = new String(passwordarea.getPassword());
        
        boolean girisIslemi = sinemaIslemleri.musteriGirisYap(kullaniciadi, parola);
        if(girisIslemi)
        {
            JOptionPane.showMessageDialog(this, "giriş başarılı");
            setVisible(false);
            FilmGoruntulemeIslemleri filmIslemleri = new FilmGoruntulemeIslemleri();
            filmIslemleri.setVisible(true);
            girilenkullanciadi = kullaniciadi;
        }
        else{
            JOptionPane.showMessageDialog(this, "giriş başarısız");
            usernamerea.setText("");
            passwordarea.setText("");
       }
        
    }//GEN-LAST:event_clientLoginActionPerformed

    private void registerButonuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButonuActionPerformed
        // TODO add your handling code here:
        Register register = new Register();
        register.setVisible(true);
    }//GEN-LAST:event_registerButonuActionPerformed

    
    
    public static void main(String args[]) {
     
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adminLoginButton;
    private javax.swing.JButton clientLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPasswordField passwordarea;
    private javax.swing.JButton registerButonu;
    private javax.swing.JTextField usernamerea;
    // End of variables declaration//GEN-END:variables
}
