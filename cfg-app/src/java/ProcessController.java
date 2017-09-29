
import java.util.*;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.stream.Stream;

public class ProcessController {

    public static ArrayList<Beneficiary> provideRanking() {
        PreparedStatement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        ArrayList<Beneficiary> beneficiary_list = null;
        try {
            conn = ConnectionManager.getConnection();
            stmt = conn.prepareStatement("select * from beneficiaries_table");
            rs = stmt.executeQuery();
            beneficiary_list = new ArrayList<>();
            while (rs.next()) {
                beneficiary_list.add(new Beneficiary(
                        rs.getString("name"),
                        rs.getString("category"),
                        rs.getDate("last_receipt"),
                        rs.getInt("headcount"),
                        rs.getInt("request_counter"),
                        rs.getInt("receipt_counter")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, stmt, rs);
        }

        return beneficiary_list;

    }

    public static HashMap<String, HashMap<String, Integer>> allocate(
            HashMap<String, Integer> inventory, 
            HashMap<String, HashMap<String, Integer>> requestList, 
            List<Beneficiary> ranking) {

        HashMap<String, HashMap<String, Integer>> recommendedList = new HashMap<>();

        for (Beneficiary ben : ranking) {
            HashMap<String, Integer> foodList = requestList.get(ben.getId());
            if (foodList != null) {
                Iterator it = foodList.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry pair = (Map.Entry) it.next();
                    String foodName = (String) pair.getKey();
                    Integer requestedQty = (Integer) pair.getValue();
                    Integer inventoryAmount = inventory.get(foodName);
                    Integer allocatedAmount = null;
                    if (requestedQty != null && inventoryAmount != null) {
                        if (requestedQty > inventoryAmount) {
                            allocatedAmount = inventoryAmount;
                            inventoryAmount = 0;
                        } else {
                            allocatedAmount = inventoryAmount - requestedQty;
                            inventoryAmount = inventoryAmount - allocatedAmount;
                        }
                        inventory.put(foodName, inventoryAmount);

                        if (recommendedList.get(ben.getId()) == null) {
                            HashMap<String, Integer> allocatedList = new HashMap<>();
                            allocatedList.put(foodName, allocatedAmount);
                            recommendedList.put(ben.getId(), allocatedList);
                        } else {
                            HashMap<String, Integer> allocatedList = recommendedList.get(ben.getId());
                            allocatedList.put(foodName, allocatedAmount);
                            recommendedList.put(ben.getId(), allocatedList);
                        }
                    }

                }

            }
        }

        return recommendedList;

    }

}
