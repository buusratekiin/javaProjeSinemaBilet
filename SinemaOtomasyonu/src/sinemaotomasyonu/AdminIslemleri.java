import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class AdminIslemleri extends javax.swing.JFrame implements AdminFilmFonksiyonlari{
      FilmGoruntulemeIslemleri filmIslemleri = new FilmGoruntulemeIslemleri();
      DefaultTableModel model;
      private Connection con = null;
      private Statement statement = null;
      private PreparedStatement preparedStatement = null;
      SinemaIslemleri sinemaIslemleri = new SinemaIslemleri();
      
      @Override
      public void filmGoruntule()  //Override interface örneği
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
      
    public AdminIslemleri() {
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        filmAlani = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        seansAlani = new javax.swing.JTextField();
        turAlani = new javax.swing.JTextField();
        imdbAlani = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        dilAlani = new javax.swing.JTextField();
        vizyonAlani = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        ekleButonu = new javax.swing.JButton();
        guncelleButonu = new javax.swing.JButton();
        silButonu = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        filmTablosu = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        aramaCubugu = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(300, 100, 0, 0));
        setMinimumSize(new java.awt.Dimension(1350, 850));
        setPreferredSize(new java.awt.Dimension(1200, 770));
        setSize(new java.awt.Dimension(908, 617));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(62, 25, 99));
        jPanel1.setForeground(new java.awt.Color(0, 51, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 730, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 40, 730);

        jPanel2.setBackground(new java.awt.Color(27, 141, 194));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SİNEMA OTOMASYONU V1.0");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Güncellemek istediğiniz filmi tablodan seçin");

        jPanel3.setBackground(new java.awt.Color(15, 166, 90));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Seçilen Film : ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("IMDB : ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Türü : ");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Seans: ");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Dil:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Vizyona giriş:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(dilAlani, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                    .addComponent(seansAlani, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imdbAlani, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filmAlani, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(turAlani, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(vizyonAlani))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filmAlani, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(turAlani, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imdbAlani, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seansAlani, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(dilAlani, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(vizyonAlani, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39))
        );

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("İpucu: film güncellemek veya silmek için tablodan bir filmi seçin");

        ekleButonu.setText("Film Ekle");
        ekleButonu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ekleButonuActionPerformed(evt);
            }
        });

        guncelleButonu.setText("Güncelle");
        guncelleButonu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guncelleButonuActionPerformed(evt);
            }
        });

        silButonu.setText("Sil");
        silButonu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                silButonuActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("İpucu: Film eklemek için formu doldurup ekleye tıklayın");

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
        if (filmTablosu.getColumnModel().getColumnCount() > 0) {
            filmTablosu.getColumnModel().getColumn(0).setMaxWidth(35);
            filmTablosu.getColumnModel().getColumn(3).setMaxWidth(45);
        }

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/geri.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        aramaCubugu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                aramaCubuguKeyReleased(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("ARAMA YAPMAK İÇİN YANDAK PANELİ KULLANABİLİRSİNİZ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(371, 371, 371)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 864, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(aramaCubugu, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel13)))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(ekleButonu, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(guncelleButonu, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(21, 21, 21)
                                    .addComponent(silButonu, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(aramaCubugu, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ekleButonu, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(guncelleButonu, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(silButonu, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(40, 0, 1300, 730);

        jPanel4.setBackground(new java.awt.Color(84, 81, 3));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1340, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel4);
        jPanel4.setBounds(0, 730, 1340, 70);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void filmTablosuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_filmTablosuMouseClicked
        // TODO add your handling code here:
        int secilensira = filmTablosu.getSelectedRow();
        filmAlani.setText(model.getValueAt(secilensira, 1).toString());
        turAlani.setText(model.getValueAt(secilensira, 2).toString());
        imdbAlani.setText(model.getValueAt(secilensira, 3).toString());
        seansAlani.setText(model.getValueAt(secilensira, 5).toString());
        dilAlani.setText(model.getValueAt(secilensira, 6).toString());
        vizyonAlani.setText(model.getValueAt(secilensira, 4).toString());
    }//GEN-LAST:event_filmTablosuMouseClicked
   
    private void ekleButonuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ekleButonuActionPerformed
        
        String film = filmAlani.getText();
        String tur = turAlani.getText();
        String imdb = imdbAlani.getText();
        String seans = seansAlani.getText();
        String dil = dilAlani.getText();
        String vizyon = vizyonAlani.getText();
        filmIslemleri.filmEkle(film,tur,imdb,seans,dil,vizyon);
        filmGoruntule();
        
    }//GEN-LAST:event_ekleButonuActionPerformed
      @Override
      public void filmGuncelle(String sira, String isim, String tur, String imdb, String seans, String dil, String vizyon)
      {
          String sorgu = "Update filmler set isim = ?, tür = ?, imdb = ?, seans = ?, Dil = ?, VizyonaGiriş = ? where id = ?";
          
          try {
              preparedStatement = con.prepareStatement(sorgu);
              preparedStatement.setString(1, isim);
              preparedStatement.setString(2, tur);
              preparedStatement.setString(3, imdb);
              preparedStatement.setString(4, seans);
              preparedStatement.setString(5, dil);
              preparedStatement.setString(6, vizyon);
              preparedStatement.setString(7, sira);
              preparedStatement.executeUpdate();
          } catch (SQLException ex) {
              ex.printStackTrace();
          }
      }
    private void guncelleButonuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guncelleButonuActionPerformed

        String film = filmAlani.getText();
        String tur = turAlani.getText();
        String imdb = imdbAlani.getText();
        String seans = seansAlani.getText();
        String dil = dilAlani.getText();
        String vizyon = vizyonAlani.getText();
        int secilensira = filmTablosu.getSelectedRow();
          if(secilensira == -1)
          {
              JOptionPane.showMessageDialog(this, "Henüz bir film seçmediniz");
          }
          else
          {
              String sira = String.valueOf(filmTablosu.getValueAt(secilensira, 0));
               filmGuncelle(sira,film,tur,imdb,seans,dil,vizyon);
          }
       
        filmGoruntule();
    }//GEN-LAST:event_guncelleButonuActionPerformed
      @Override
    public void filmSil(String id)
    {
        String sorgu = "Delete from filmler where id = ?";
          try {
              preparedStatement = con.prepareStatement(sorgu);
              preparedStatement.setString(1, id);
              preparedStatement.executeUpdate();
          } catch (SQLException ex) {
              Logger.getLogger(AdminIslemleri.class.getName()).log(Level.SEVERE, null, ex);
          }
        
    }
    private void silButonuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_silButonuActionPerformed
        // TODO add your handling code here:
        int secilensira = filmTablosu.getSelectedRow();
        if(secilensira == -1)
          {
              JOptionPane.showMessageDialog(this, "Henüz bir film seçmediniz");
          }
          else
          {
               String sira = String.valueOf(filmTablosu.getValueAt(secilensira, 0)) ;
               filmSil(sira);
               filmGoruntule();
          }
    }//GEN-LAST:event_silButonuActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        setVisible(false);
        LoginPanel loginPanel = new LoginPanel();
        loginPanel.setVisible(true);
    }//GEN-LAST:event_jLabel5MouseClicked
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
            java.util.logging.Logger.getLogger(AdminIslemleri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminIslemleri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminIslemleri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminIslemleri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminIslemleri().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aramaCubugu;
    private javax.swing.JTextField dilAlani;
    private javax.swing.JButton ekleButonu;
    private javax.swing.JTextField filmAlani;
    private javax.swing.JTable filmTablosu;
    private javax.swing.JButton guncelleButonu;
    private javax.swing.JTextField imdbAlani;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField seansAlani;
    private javax.swing.JButton silButonu;
    private javax.swing.JTextField turAlani;
    private javax.swing.JTextField vizyonAlani;
    // End of variables declaration//GEN-END:variables
}
