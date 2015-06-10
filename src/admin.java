import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 * Created by mario on 06.06.2015.
 */
@ManagedBean(name="admin")
@RequestScoped

public class admin {

    private String URL = "jdbc:mysql://localhost:3306/rzdmini";
    private String UserD = "root";
    private String Pass = "root";
    private String meS = null;
    private String logins = null;
    private String passs = null;
    private String emaill = null;
    private String status = null;
    private String error = "null";
    private Connection con = null;
    private String pozicia = "user";
    private List<user> list = null;
    private user user = null;
    private int mini = 0;
    private int maxi = 0;

    public List<user> getList() {
        return list;
    }

    public int listSize(){
        return list.size();
    }

    public String procesMenu(String name){
        this.setPozicia(name);
        return "admin";
    }
    public Boolean procesOpen(String name){
        if(this.getPozicia().equals(name)){
            return true;
        }
        return false;
    }

    public String procesList(){
        try{
            con = DriverManager.getConnection(URL, UserD, Pass);
            PreparedStatement stat = con.prepareStatement(
                    "SELECT * FROM user LIMIT " + mini +"," + maxi+";"
            );
            ResultSet rs = stat.executeQuery();
            if(rs.next()){
                user.setMeS(rs.getString("nmsuser"));
                user.setLogins(rs.getString("login"));
                user.setPasss(rs.getString("pass"));
                user.setStatus(rs.getString("status"));
                user.setEmaill(rs.getString("email"));
                list.add(user);
                user = null;
            }
        }catch (Exception e){

        }
        return "admin";
    }

    public String procesAddUser(){
        try {
            con = DriverManager.getConnection(URL, UserD, Pass);
            PreparedStatement stat = con.prepareStatement(
                    "INSERT INTO user (nmsuser, login, pass, status, email) VALUES (?, ?, ?, ?, ?);"
            );
            stat.setString(1, meS);
            stat.setString(2, logins);
            stat.setString(3, passs);
            stat.setString(4, status);
            stat.setString(5, emaill);

            stat.executeUpdate();
            stat.close();
            this.error = "Пользователь" + meS + "добавлен";
            meS =null;
            logins = null;
            passs = null;
            status = null;
            emaill = null;

        }catch (Exception e){
            this.error = "admin " + e;
        }
        return "admin";
    }

    public String getMeS() {
        return meS;
    }

    public void setMeS(String meS) {
        this.meS = meS;
    }

    public String getLogins() {
        return logins;
    }

    public void setLogins(String logins) {
        this.logins = logins;
    }

    public String getPasss() {
        return passs;
    }

    public void setPasss(String passs) {
        this.passs = passs;
    }

    public String getEmaill() {
        return emaill;
    }

    public void setEmaill(String emaill) {
        this.emaill = emaill;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public String getPozicia() {
        return pozicia;
    }

    public void setPozicia(String pozicia) {
        this.pozicia = pozicia;
    }
}
