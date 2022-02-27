import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Service {
    ConnectDB connectDB = new ConnectDB();
    Connection conn = connectDB.connect();
    public void getAllUsers(){
        String query = "SELECT * FROM users";
        try {
            Statement stm = conn.createStatement();
            ResultSet result = stm.executeQuery(query);
            while(result.next()){
                System.out.println(result.getString("id") + " - " + result.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void getUserBy(int id){
        String query = "SELECT * FROM users id = " + id;

    }
}
