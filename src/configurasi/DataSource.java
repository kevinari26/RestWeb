package configurasi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DataSource {
    private Connection connect = null;
    private Statement statement = null;
    private String usernameDatabase = "root";
    private String passwordDatabase = "root1234";
    private String schemaName = "absensi";


    public Connection connection() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/"+schemaName+"?"
                            + "user="+usernameDatabase+"&password="+passwordDatabase+"");
        } catch (Exception e){
            System.out.println("Error Connect To Database");
            System.out.println(e);
        }
        return connect;
    }
}
