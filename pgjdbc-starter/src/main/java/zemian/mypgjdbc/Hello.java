package zemian.mypgjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Hello {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:postgresql://localhost:5432/test";
        String username = "test";
        String password = "";
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            System.out.println("Hello: " + conn.getMetaData().getDatabaseProductName());

            try (Statement st = conn.createStatement()) {
                String sql = "SELECT * FROM pg_extension;";
                try (ResultSet rs = st.executeQuery(sql)) {
                    while (rs.next()) {
                        System.out.println("Extension: " + rs.getObject(1));
                    }
                }
            }
        }
    }
}
