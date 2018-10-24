import java.sql.*;
/*
Example usage:

bash> javac TestDB.java
bash> export CLASSPATH=".;$(cygpath -m ~/.m2/repository/org/postgresql/postgresql/42.2.5/postgresql-42.2.5.jar)"
bash> java TestDB

	Testing PostgreSQL DB with user=postgres and url=jdbc:postgresql://localhost/postgres
	SQL=SELECT VERSION()
	PostgreSQL 10.4, compiled by Visual C++ build 1800, 64-bit
*/
public class TestDB {
	public static void main(String[] args) throws Exception {
		String url = System.getProperty("url", "jdbc:postgresql://localhost/postgres");
		String user = System.getProperty("user", "postgres");
		String password = System.getProperty("password", "");
		String sql = System.getProperty("sql", "SELECT VERSION()");
		
		System.out.println("Testing PostgreSQL DB with user=" + user + " and url=" + url);
		System.out.println("SQL=" + sql);
		try (Connection conn = DriverManager.getConnection(url, user, password)) {
			try (Statement stmt = conn.createStatement()) {
				try (ResultSet rs = stmt.executeQuery(sql)) {
					while (rs.next()) {
						System.out.println(rs.getObject(1));
					}
				}
			}
		}
	}
}