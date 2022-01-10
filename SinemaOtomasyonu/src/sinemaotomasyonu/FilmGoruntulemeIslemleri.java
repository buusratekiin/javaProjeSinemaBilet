
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class FilmGoruntulemeIslemleri extends javax.swing.JFrame implements IFilmGoruntuleme {

    DefaultTableModel model ;
    SinemaIslemleri sinemaIslemleri = new SinemaIslemleri();
    public static int sirano;
    private Connection con = null;
       public ImageIcon icon;
      private Statement statement = null;
      private PreparedStatement preparedStatement = null;
      
    public void filmGoruntule()
{
    model.setRowCount(0);
    ArrayList<Filmler> filmler = new ArrayList<Filmler>();
    filmler = sinemaIslemleri.filmleriGetir();
    
    if(filmler != null)
    {
        for(Filmler f:filmler)
        {
            int id = f.getId();
            String isim = f.getIsim();
            String tur = f.getTur();
            float imdb = f.getImdb();
            String seans = f.getSeans();
            String dil = f.getDil();
            String vizyonagiris = f.getVizyonagiris();
        Object[] eklenecek = {id,isim,tur,imdb,dil,vizyonagiris,seans};
        model.addRow(eklenecek);
        }
    }
}
    
    public void filmEkle(String film,String tur,String imdb,String seans,String dil,String vizyon)
    {
        String sorgu = "Insert into filmler (isim,tür,imdb,seans,Dil,VizyonaGiriş) VALUES(?,?,?,?,?,?)";
        try {
            preparedStatement = con.prepareStatement(sorgu);
             preparedStatement.setString(1, film);
              preparedStatement.setString(2, tur);
               preparedStatement.setString(3, imdb);
                preparedStatement.setString(4, seans);
                 preparedStatement.setString(5, dil);
                  preparedStatement.setString(6, vizyon);
                  preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FilmGoruntulemeIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    public FilmGoruntulemeIslemleri() {
        initComponents();
        model = (DefaultTableModel) filmTablosu.getModel();
        String url = "jdbc:mysql://localhost:3306/sinema?useUnicode=characterEncoding=utf8";
           try {
               Class.forName("com.mysql.cj.jdbc.Driver");
           } catch (ClassNotFoundException ex) {
               ex.printStackTrace();
               System.out.println("hata");
           }
         try {
             con = DriverManager.getConnection(url,Database.kullaniciadi,Database.parola);
         } catch (SQLException ex) {
            ex.printStackTrace();
         }
        filmGoruntule();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        aramaCubugu = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        filmTablosu = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        imdbAlani = new javax.swing.JLabel();
        isimAlani = new javax.swing.JLabel();
        turAlani = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        filmResmi = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(350, 175, 0, 0));

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));

        aramaCubugu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                aramaCubuguKeyReleased(evt);
            }
        });

        filmTablosu.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        filmTablosu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sıra", "Film adı", "Türü", "IMDB", "Vizyona giriş", "Seans", "Dil"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        filmTablosu.setRowHeight(20);
        filmTablosu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                filmTablosuMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(filmTablosu);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("ARAMA YAPMAK İÇİN YANDAKİ PANELİ KULLANABİLİRSİNİZ");

        jPanel2.setBackground(new java.awt.Color(0, 153, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SEÇİLEN FİLM");

        imdbAlani.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        imdbAlani.setForeground(new java.awt.Color(255, 255, 255));
        imdbAlani.setText("IMDB: ");

        isimAlani.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        isimAlani.setForeground(new java.awt.Color(255, 255, 255));
        isimAlani.setText("Film adı: ");

        turAlani.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        turAlani.setForeground(new java.awt.Color(255, 255, 255));
        turAlani.setText("Tür: ");

        jButton1.setText("Seçilen film için bilet al");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(isimAlani, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                            .addComponent(turAlani, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(imdbAlani, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(isimAlani, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(turAlani, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(imdbAlani, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 153, 102));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(filmResmi, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(filmResmi, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/geri.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(aramaCubugu, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(67, 67, 67))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(aramaCubugu, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void filmTablosuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_filmTablosuMouseClicked
        // TODO add your handling code here:
        int secilensira = filmTablosu.getSelectedRow();
        sirano = secilensira + 1;
        isimAlani.setText("Film adı: " + model.getValueAt(secilensira, 1).toString());
        turAlani.setText("Film türü: " + model.getValueAt(secilensira, 2).toString());
        imdbAlani.setText("IMDB: " + model.getValueAt(secilensira, 3).toString());
        
        if(sirano == 1){
            try {
                icon = new ImageIcon(ImageIO.read(new File("C:\\images\\esaretinbedeli.jpg")));
            } catch (IOException ex) {
               ex.printStackTrace();
            }
            filmResmi.setIcon(icon);
            filmResmi.repaint();
        }
        if(sirano == 2)
        {
            try {
                icon = new ImageIcon(ImageIO.read(new File("C:\\images\\cepherkulu.jpg")));
            } catch (IOException ex) {
               ex.printStackTrace();
            }
            filmResmi.setIcon(icon);
            filmResmi.repaint();
        }
        if(sirano == 3)
        {
            try {
                icon = new ImageIcon(ImageIO.read(new File("C:\\images\\yuzuklerinefendisi.jpg")));
            } catch (IOException ex) {
               ex.printStackTrace();
               
            }
            filmResmi.setIcon(icon);
            filmResmi.repaint();
        }
        if(sirano == 4)
        {
            try {
                icon = new ImageIcon(ImageIO.read(new File("C:\\images\\forrestgump.jpg")));
            } catch (IOException ex) {
               ex.printStackTrace();
            }
            filmResmi.setIcon(icon);
            filmResmi.repaint();
        }
        if(sirano == 5)
        {
            try {
                icon = new ImageIcon(ImageIO.read(new File("C:\\images\\yesilyol.jpg")));
            } catch (IOException ex) {
               ex.printStackTrace();
            }
            filmResmi.setIcon(icon);
        }
        if(sirano == 6)
        {
            try {
                icon = new ImageIcon(ImageIO.read(new File("C:\\images\\kıyametyakındır.jpg")));
            } catch (IOException ex) {
               ex.printStackTrace();
            }
            filmResmi.setIcon(icon);
        }
        if(sirano == 7)
        {
            try {
                icon = new ImageIcon(ImageIO.read(new File("C:\\images\\tenet.jpg")));
            } catch (IOException ex) {
               ex.printStackTrace();
            }
            filmResmi.setIcon(icon);
            filmResmi.repaint(); 
        }
        if(sirano == 8)
        {
            try {
                icon = new ImageIcon(ImageIO.read(new File("C:\\images\\nefesinitut.jpg")));
            } catch (IOException ex) {
               ex.printStackTrace();
            }
            filmResmi.setIcon(icon);
            filmResmi.repaint();
        }
        if(sirano == 9)
        {
            try {
                icon = new ImageIcon(ImageIO.read(new File("C:\\images\\hayaladası.jpg")));
            } catch (IOException ex) {
               ex.printStackTrace();
            }
            filmResmi.setIcon(icon);
            filmResmi.repaint(); 
        }
        if(sirano == 10)
        {
            try {
                icon = new ImageIcon(ImageIO.read(new File("C:\\images\\snowman.jpg")));
            } catch (IOException ex) {
               ex.printStackTrace();
            }
            filmResmi.setIcon(icon);
            filmResmi.repaint(); 
        }
        if(sirano == 11)
        {
            try {
                icon = new ImageIcon(ImageIO.read(new File("C:\\images\\gorunmezadam.jpg")));
            } catch (IOException ex) {
               ex.printStackTrace();
            }
            filmResmi.setIcon(icon);
            filmResmi.repaint();
        }
        if(sirano == 12)
        {
            try {
                icon = new ImageIcon(ImageIO.read(new File("C:\\images\\boru.jpg")));
            } catch (IOException ex) {
               ex.printStackTrace();
            }
            filmResmi.setIcon(icon);
            filmResmi.repaint(); 
        }
        if(FilmGoruntulemeIslemleri.sirano == 13)
        {
            try {
                icon = new ImageIcon(ImageIO.read(new File("C:\\images\\yedincikogus.jpg")));
            } catch (IOException ex) {
               ex.printStackTrace();
            }
            filmResmi.setIcon(icon);
            filmResmi.repaint(); 
        }
        if(sirano == 14)
        {
            try {
                icon = new ImageIcon(ImageIO.read(new File("C:\\images\\deadpool.jpg")));
            } catch (IOException ex) {
               ex.printStackTrace();
            }
            filmResmi.setIcon(icon);
            filmResmi.repaint(); 
        }
        if(sirano == 15)
        {
            try {
                icon = new ImageIcon(ImageIO.read(new File("C:\\images\\platform.jpg")));
            } catch (IOException ex) {
               ex.printStackTrace();
            }
            filmResmi.setIcon(icon);
            filmResmi.repaint(); 
        }
        if(sirano == 16)
        {
            try {
                icon = new ImageIcon(ImageIO.read(new File("C:\\images\\birdbox.jpg")));
            } catch (IOException ex) {
               ex.printStackTrace();
            }
            filmResmi.setIcon(icon);
            filmResmi.repaint(); 
        }
    }//GEN-LAST:event_filmTablosuMouseClicked
public void dinamikArama(String text)
    {
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        
        filmTablosu.setRowSorter(tr);
        
        tr.setRowFilter(RowFilter.regexFilter(text));
    }
    private void aramaCubuguKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_aramaCubuguKeyReleased

        String ara = aramaCubugu.getText();
        dinamikArama(ara);
    }//GEN-LAST:event_aramaCubuguKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        BiletAl biletAl = new BiletAl();
        biletAl.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        setVisible(false);
        LoginPanel loginPanel = new LoginPanel();
        loginPanel.setVisible(true);
        
    }//GEN-LAST:event_jLabel2MouseClicked

    
    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FilmGoruntulemeIslemleri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FilmGoruntulemeIslemleri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FilmGoruntulemeIslemleri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FilmGoruntulemeIslemleri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FilmGoruntulemeIslemleri().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aramaCubugu;
    private javax.swing.JLabel filmResmi;
    private javax.swing.JTable filmTablosu;
    private javax.swing.JLabel imdbAlani;
    private javax.swing.JLabel isimAlani;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel turAlani;
    // End of variables declaration//GEN-END:variables
}
