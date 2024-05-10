package model;


import java.util.Date;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class Login{
     private int accountID;
     private String username;
     private String fullname;
     private String password;
     private Date boB;
     private String address;
     private String profile;
     private int role;
     public Login(){
          super();
     }
     public Login(int accountID, String username, String password, Date boB, Srring address, int role){
          this.accountID= accountID;
          this.username = username;
          this.fullname  = fullname;
          this.password = password;
          this.boB =boB;
          this.profile = profile;
          this.role = role;
     }
     @Override
     public static Login check(String username, String password)
     {
          String sql = "SELECT * FROM hiasats WHERE ";
          try{
               PreparedStatement ps = DBContext.connection().preparedStatement(sql);
               ps.setString(1, username);
               ps.setString(2, password);

               ResultSet rs = ps.executeQuery();
               if(rs.next()){
                    Login lg = new Login(
                         rs.getInt("accountID"),
                         rs.getString("username"),
                         rs.getString("fullname"),
                         rs.getString("password"),
                         rs.getDate("boB"),
                         rs.getInt("role")
                    );
                    return lg;
               } catch{
                    e.printStackTrace();
               }
               return null;
          }
     }
}

private void drawCircle(Graphic2D g, int x, int y, int width, int height)
{
     x=x-(width/2);
     y=y-(height/2);
     g.setColor(color);
}