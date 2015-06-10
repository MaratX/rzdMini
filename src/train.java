import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Created by mario on 06.06.2015.
 */
@ManagedBean(name="train")
@RequestScoped
public class train {
    private int id = 0;
    private String nameLog = null;
    private Connection con = null;
    private String URL = "jdbc:mysql://localhost:3306/rzdmini";
    private String UserD = "root";
    private String Pass = "root";
    private String errro = "null";

    public String getErrro() {
        return errro;
    }

    public String procesAddTrain(){
        try{
            con = DriverManager.getConnection(URL, UserD, Pass);
            PreparedStatement stat = con.prepareStatement(
                    "INSERT INTO train (t_name) VALUES (?);"
            );
            stat.setString(1, getNameLog());
            stat.executeUpdate();
            stat.close();

        }catch (Exception e){
            errro = " " + e;

        }
        errro = "Поезд номер № " + getNameLog() + " добавлен";
        nameLog = null;
        return "admin";
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameLog() {
        return nameLog;
    }

    public void setNameLog(String nameLog) {
        this.nameLog = nameLog;
    }
    public train(){

    }
}

