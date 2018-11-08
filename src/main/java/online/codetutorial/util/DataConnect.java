package online.codetutorial.util;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnect {

	//public static Connection getConnection() {
	//	try {
			//Class.forName("com.mysql.jdbc.Driver");
			//Connection con = DriverManager.getConnection(
			//		"jdbc:mysql://localhost:3306/cardb", "pankaj", "pankaj123");
          //              Class.forName("org.mariadb.jdbc.Driver");
	//		Connection con = DriverManager.getConnection(
	//				"jdbc:mariadb://localhost:3306/cardb", "root", "admin");
	//		return con;
	//	} catch (Exception ex) {
	//		System.out.println("Database.getConnection() Error -->"
	//				+ ex.getMessage());
	//		return null;
	//	}
	//}
        //conexion haroku
        public static Connection getConnection() throws URISyntaxException, SQLException {
            URI jdbUri = new URI(System.getenv("JAWSDB_MARIA_URL"));
            String username = jdbUri.getUserInfo().split(":")[0];
            String password = jdbUri.getUserInfo().split(":")[1];
            String port = String.valueOf(jdbUri.getPort());
            String jdbUrl = "jdbc:mysql://" + jdbUri.getHost() + ":" + port + jdbUri.getPath();
            return DriverManager.getConnection(jdbUrl, username, password);
        }
	public static void close(Connection con) {
		try {
			con.close();
		} catch (Exception ex) {
		}
	}
}