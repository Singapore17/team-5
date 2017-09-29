import Connection.*;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.stream.Stream;

public class Main {
	public static void main (String[] args) {
		getData();
	}
	
	public static void getData () {
		PreparedStatement stmt = null;
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = ConnectionManager.getConnection();
			stmt = conn.prepareStatement("select * from newtable");
			rs = stmt.executeQuery();
			while (rs.next()) {
				System.out.println("test " + rs.getDouble("col1"));
				System.out.println("test " + rs.getDouble("col2"));
				System.out.println("test " + rs.getDouble("col3"));
				System.out.println("test " + rs.getDouble("col4"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(conn, stmt, rs);
		}

	}
	
	public static void processInputCSV () {
		try {
			Stream<String> is = Files.lines(Paths.get("C:\\testapp\\src\\datafiles\\test.csv"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
