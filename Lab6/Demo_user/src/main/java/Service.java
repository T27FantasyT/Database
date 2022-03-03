import java.util.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.function.Consumer;

public class Service {
    ConnectDB connectDB = new ConnectDB();
    Connection conn = connectDB.connect();
    public void getAllUsers(){
        String query = "SELECT * FROM users";
        List<User> list = new ArrayList<>();
        try {
            Statement stm = conn.createStatement();
            ResultSet result = stm.executeQuery(query);
            while(result.next()){
                System.out.println(result.getString("id") + " - " + result.getString("name"));
                int id = result.getInt("id");
                String name = result.getString("name");
                String gender = result.getString("gender");
                String address = result.getString("address");
                String moblie = result.getString("mobile");
                String create_at = result.getString("create_at");
                list.add(new User(id,name,gender,address,moblie,create_at));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        list.forEach(i -> System.out.println(i));

    }
    public void getUserBy(int id){
        User findUser = null;
        String query = "SELECT * FROM users id = " + id;


    }
}
