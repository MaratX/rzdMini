/**
 * Created by marat on 09.06.2015.
 */
public class user {
    private int id = 0;
    private String meS = null;
    private String logins = null;
    private String passs = null;
    private String emaill = null;
    private String status = null;

    public user (){}

    public user(String meS, String logins, String passs, String emaill, String status) {
        this.meS = meS;
        this.logins = logins;
        this.passs = passs;
        this.emaill = emaill;
        this.status = status;
    }

    public int getId() {

        return id;
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
}
