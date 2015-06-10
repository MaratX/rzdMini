import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.sql.Date;
import java.sql.*;

/**
 * Created by mario on 06.06.2015.
 */
@ManagedBean(name = "maps")
@RequestScoped
public class maps {
    private String URL = "jdbc:mysql://localhost:3306/rzdmini";
    private String UserD = "root";
    private String Pass = "root";
    private String stationGo = null;
    private String stationDown = null;
    private String taimGo = null;
    private String taimRoad = null;
    private String error = "null";
    private Connection con = null;

    public String procesAddMaps(){
        try{
            con = DriverManager.getConnection(URL, UserD, Pass);
            PreparedStatement stat = con.prepareStatement(
                    "INSERT INTO maps (stationgo, stationdown, timego, taimroad)  VALUES (?, ?, ?, ?);"
            );
            stat.setString(1, stationGo);
            stat.setString(2, stationDown);
            stat.setString(3, taimGo);
            stat.setString(4, taimRoad);

            stat.executeUpdate();
            stat.close();
            error = "Записано";
        }catch (Exception e){
            error = " " + e;
        }
        stationDown = null;
        stationGo = null;
        taimGo = null;
        taimRoad = null;

        return "admin";
    }


    public String getStationGo() {
        return stationGo;
    }

    public void setStationGo(String stationGo) {
        this.stationGo = stationGo;
    }

    public String getStationDown() {
        return stationDown;
    }

    public void setStationDown(String stationDown) {
        this.stationDown = stationDown;
    }

    public String getTaimGo() {
        return taimGo;
    }

    public void setTaimGo(String taimGo) {
        this.taimGo = taimGo;
    }

    public String getTaimRoad() {
        return taimRoad;
    }

    public void setTaimRoad(String taimRoad) {
        this.taimRoad = taimRoad;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
    public maps(){

    }
}
