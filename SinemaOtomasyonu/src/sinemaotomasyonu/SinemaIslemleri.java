
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SinemaIslemleri{
      private Connection con = null;
       
      private Statement statement = null; //Temel SQL ifadelerini çalıştırır.
      private PreparedStatement preparedStatement = null;//PreparedStatement ile SQL ifadelerimizi veritabanımızda önceden derlenmek üzere gönderebileceğimiz ve her defasında derlenmiş hale değer göndererek tekrar tekrar kullanabileceğimiz bir yapıdır.
      
      public boolean adminGirisYap(String kullaniciadi, String parola) 
      {
          String sorgu = "Select * from adminler where kullaniciadi = ? and parola = ?";
          try {
              preparedStatement = con.prepareStatement(sorgu); //veri tabanı klonları kullaniciadi, parola ile dolduruldu.
              preparedStatement.setString(1, kullaniciadi);
              preparedStatement.setString(2, parola);
              ResultSet rs = preparedStatement.executeQuery();
              
              return rs.next(); // rs içinde veri varsa true döner ve giriş yapılır.
          } catch (SQLException ex) {
              Logger.getLogger(SinemaIslemleri.class.getName()).log(Level.SEVERE, null, ex);
              return false;
          }
      }
      
      public boolean musteriGirisYap(String kullaniciadi, String parola) 
      {
          String sorgu = "Select * from kullanicilar where kullaniciadi = ? and parola = ?";
          try {
              preparedStatement = con.prepareStatement(sorgu);
              preparedStatement.setString(1, kullaniciadi);
              preparedStatement.setString(2, parola);
              ResultSet rs = preparedStatement.executeQuery(); //Doğrudan veri çekme(SELECT) veya veri listeme işlemi için executeQuery metodu kullanılabilir.
              
              return rs.next(); // rs içinde veri varsa true döner ve giriş yapılır.
          } catch (SQLException ex) {
              Logger.getLogger(SinemaIslemleri.class.getName()).log(Level.SEVERE, null, ex);
              return false;
          }
      }
       public ArrayList<Filmler> filmleriGetir()
    {
        ArrayList<Filmler> cikti = new ArrayList<Filmler>();
        String sorgu = "Select * from filmler";
           try {
               statement = con.prepareStatement(sorgu);
               ResultSet rs = statement.executeQuery(sorgu); //kayıt sayısı bilgisi.
               
               while(rs.next()) //veri olduğu sürece true döner. veri bitince false
               {
                   int id = rs.getInt("id");
                   String isim = rs.getString("isim");
                   String tur = rs.getString("tür");
                   float imdb = rs.getFloat("imdb");
                   String seans = rs.getString("seans");
                   String dil = rs.getString("Dil");
                   String vizyonagiris = rs.getString("VizyonaGiriş");
                   
                   
                   cikti.add(new Filmler(id,isim,tur,imdb,dil,vizyonagiris,seans));
               }
               return cikti;
           } catch (SQLException ex) {
               Logger.getLogger(FilmGoruntulemeIslemleri.class.getName()).log(Level.SEVERE, null, ex);
               return null;
           }
    }
      public SinemaIslemleri()
      {
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
           
      }
      }



