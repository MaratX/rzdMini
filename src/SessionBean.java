

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.sql.*;
import java.util.List;

/**
 * Created by HMF on 04.06.2015.
 */
@ManagedBean(name="SessionBean")
@SessionScoped
public class SessionBean  {
    private static String has = "Mhj8j_jhg3sd%okl";
    private String userstat = "user";
    private String URL = "jdbc:mysql://localhost:3306/rzdmini";
    private String UserD = "root";
    private String Pass = "root";
    private String layoutStat = null;
    private String meS = null;
    private String logins = null;
    private String passs = null;
    private String emaill = null;
    private String stat = null;
    private String error = null;
    private String conect = null;
    private Connection con = null;
    private String log = null;
    private String pas = null;








    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public String getPas() {
        return pas;
    }

    public void setPas(String pas) {
        this.pas = pas;
    }

    public String getConect() {
        return conect;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getLayoutStat() {
        return layoutStat;
    }

    public void setLayoutStat(String layoutStat) {
        this.layoutStat = layoutStat;
    }



    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getLogins() {
        return logins;
    }

    public void setLogins(String logins) {
        this.logins = logins;
    }

    public String getMeS() {
        return meS;
    }

    public void setMeS(String name) {
        this.meS = name;
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

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }





    public String pay(){
        return "layout";
    }

    public String procesLogin(){
        try {
            PreparedStatement statement = con.prepareStatement(
                    "SELECT * FROM user WHERE (login = ?) AND (pass = MD5(?));"

            );

            statement.setString(1, logins.trim());
            statement.setString(2, passs + has);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                this.setMeS(rs.getString("nmsuser"));
                this.setLogins(rs.getString("login"));
                this.setPasss(rs.getString("pass"));
                this.setEmaill(rs.getString("email"));
                this.setStat(rs.getString("status"));
            }

        }catch (Exception e){
            error = e + " ";
            System.out.println(error);
            return "index";
        }
        if(this.getStat() != null){
            return this.getStat();
        }
        this.setError("ѕользователь с таким логином и паролем не найден");
        return "error";
    }



    public String layoutO(){
        this.setLayoutStat("open");
        return "layout";
    }

    public String layoutR(){
        this.setLayoutStat("reg");
        return "layout";
    }

    public Boolean openR(){
        if(this.getLayoutStat().equals("open")){
            return true;
        }
        return false;
    }

    public Boolean reg(){
        if(this.getLayoutStat().equals("reg")){
            return true;
        }
        return false;
    }

    public String procesRegistr(){
        try {
            PreparedStatement stat = con.prepareStatement(
                    "INSERT INTO user (nmsuser, login, pass, status, email) VALUES (?, ?, ?, ?, ?);"
            );
            stat.setString(1, meS);
            stat.setString(2, logins);
            stat.setString(3, passs + has);
            stat.setString(4, userstat);
            stat.setString(5, emaill);

            stat.executeUpdate();
            stat.close();
            layoutStat = "open";
            return "layout";
        }catch (Exception e){
            error = "not add insert =  " + e;
        }
        return "error";
    }
    public SessionBean(){
        try {
            con = DriverManager.getConnection(URL, UserD, Pass);
        }catch (Exception e){
            error = "not connect BD";
        }
    }


}


