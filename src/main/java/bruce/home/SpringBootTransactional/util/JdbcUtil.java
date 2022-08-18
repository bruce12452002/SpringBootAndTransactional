package bruce.home.SpringBootTransactional.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcUtil {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(
                    "jdbc:mysql://mysql-lottery-dev.caynne.com:3306/db_name?serverTimezone=UTC",
                    "root", "password");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
