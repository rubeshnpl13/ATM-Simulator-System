//import com.mysql.cj.jdbc.Driver;

import java.sql.SQLException;
import java.sql.*;

public class DBCon {
    Connection con;
    Statement s;
    public DBCon(){
        try{
            //Class.forName(com.mysql.cj.jdbc.Driver);
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem", "root", "");
            s = con.createStatement();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
