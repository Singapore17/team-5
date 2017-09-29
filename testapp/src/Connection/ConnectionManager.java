package Connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionManager {
	
	private static final String PROPERTY_FILENAME = "./connection.properties";
	private static String dbUser;
	private static String dbPassword;
	private static String dbUrl;
	
	static {
		readDatabaseProperties();
		initDBDriver();
	}
	
	private static void readDatabaseProperties () {
		InputStream is = null;
		try {
			
			// Load properties file
			is = ConnectionManager.class.getResourceAsStream(PROPERTY_FILENAME);
			Properties props = new Properties();
			props.load(is);
			
			// Load database connection details
			String host = props.getProperty("db.host");
			String port = props.getProperty("db.port");
			String dbName = props.getProperty("db.name");
            dbUser = props.getProperty("db.user");
            dbPassword = props.getProperty("db.password");
            dbUrl = "jdbc:mysql://" + host + ":" + port + "/" + dbName;
			
		} catch (Exception e) {
			
			// Unable to load properties file
			String message = "Unable to load '" + PROPERTY_FILENAME + "'.";
			Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, message, e);
			
		} finally {
			
			// Close InputStream
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					Logger.getLogger(ConnectionManager.class.getName()).log(Level.WARNING, "Unable to close connection.properties", e);
				}
			}
			
		}
	}
	
	private static void initDBDriver () {
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception e) {
			String message = "Unable to find JDBC driver for MySQL";
			Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, message, e);
            throw new RuntimeException(message, e);
		}
		
	}
	
	public static Connection getConnection () throws SQLException {
		
		String message = "dbURL: " 			+ dbUrl
                	+ ", dbUser: " 			+ dbUser
                	+ " , dbPassword: " 	+ dbPassword;
		
		Logger.getLogger(ConnectionManager.class.getName()).log(Level.INFO, message);
		
		return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
		
	}
	
	public static void close (Connection conn, Statement stmt, ResultSet rs) {
		try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.WARNING,
                    "Unable to close ResultSet", ex);
        }
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.WARNING,
                    "Unable to close Statement", ex);
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.WARNING,
                    "Unable to close Connection", ex);
        }
	}
	
	public static void close(Connection conn, Statement stmt) {
        close(conn, stmt, null);
    }
	
	public static void close(Connection conn) {
        close(conn, null, null);
    }
	
}
