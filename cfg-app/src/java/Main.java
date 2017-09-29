package java;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.stream.Stream;

import com.opencsv.CSVReader;

public class Main {

    public static void main(String[] args) {
        processInputCSV();
    }

    public static void getData() {
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

    public static void processInputCSV() {
        try {

            File initialFile = new File("C:\\Users\\tcw\\team-5\\test.csv");
            InputStream targetStream = new FileInputStream(initialFile);

            CSVReader csvr = null;

            csvr = new CSVReader(new InputStreamReader(targetStream));//read each record in the file

            Iterator<String[]> recordsIterator = csvr.iterator();

            int lineNumber = 1;

            if (recordsIterator.hasNext()) {//skip header
                recordsIterator.next();
                lineNumber++;
            }

            while (recordsIterator.hasNext()) {
                String row[] = recordsIterator.next();
                for(String col : row){
                    System.out.println(col);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
