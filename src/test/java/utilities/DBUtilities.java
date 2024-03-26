package utilities;

import org.junit.Assert;
import pojo.PromoCode.PPromoCode;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBUtilities {
    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement preparedStatement;
    public static ResultSet resultSet;

    //@SneakyThrows annotation kullanamadık, manifold ve Lombok kütüphaneleri çalıkışıyor
    //DB bağlanmak için kullanıyoruz
    public static void createConnection() {
        try {
            connection = DriverManager.getConnection(
                    ConfigurationReader.getProperty("url1"),
                    ConfigurationReader.getProperty("username"),
                    ConfigurationReader.getProperty("password1")
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //DB'i kapatmak için kullanıyoruz
    public static void closeConnection() {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    //Statement'i execute etmek için kullanıyoruz; query'i parametre olarak girmelisiniz
    //C U D işlemleri için kullanılır (create,update, delete)
    public static void updateQueryStatement(String query) { // insert update delete
        try {
            statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readQueryStatement(String query) {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    //Hub Product'da product_listing_state'i approved yapacak query
    public static void approvedLastProduct() {
        updateQueryStatement("UPDATE `hub_product` SET `product_listing_state` = 'APPROVED' WHERE `product_listing_state` LIKE 'IN_REVIEW' order BY id DESC;");
    }

    //prommo Code create etmek için kullanabilirsiniz
    public static void createPromoCode(String promoCodeName, String startDate, String endDate) {

        String query = "INSERT INTO promo_code (code,discount,discount_type,ends_at,starts_at)"
                + " VALUES('" + promoCodeName + "',30,'percentage','" + startDate + ".000000','" + endDate + "');";

        updateQueryStatement(query);
    }

    //prommo Code create etmek için kullanabilirsiniz /prestatement kullanımı için örnek/
    public static void createPromoCodeWithPreStatement(String promoCodeName, String startDate, String endDate) {

        try {
            preparedStatement = connection.prepareStatement("INSERT INTO 'promo_code' ('id','code','starts_at','end_at','number_of_users','discount','discount_type')"
                    + " VALUES (NULL, ?, ?, ?, ?, ?)");

            preparedStatement.setString(1, promoCodeName);
            preparedStatement.setString(2, startDate);
            preparedStatement.setString(3, endDate);
            preparedStatement.setInt(4, 5);
            preparedStatement.setInt(5, 20);
            preparedStatement.setString(6, "money");
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //prommo Code Update etmek için kullanabilirsiniz
    public static void updatePromoCode(String columnName, String columnValue, int id) {
        String query = "update promo_code set " + columnName + " = '" + columnValue + "' where promo_code.id = " + id + ";";
        updateQueryStatement(query);
    }

    //prommo Code Delete etmek için kullanabilirsiniz
    public static void deletePromoCode(int id) {
        String query = "DELETE FROM promo_code WHERE promo_code.id = " + id + ";";
        updateQueryStatement(query);
    }

    //istenen listesiyi okumak için kullanabilirsiniz, List<Map<String, Object>> bir liste dönecek
    public static List<Map<String, Object>> getList(String listName) throws SQLException {

        statement = connection.createStatement();

        resultSet = statement.executeQuery("SELECT * FROM '" + listName + "' ");

        List<Map<String, Object>> list = new ArrayList<>();

        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        while (resultSet.next()) {


            Map<String, Object> map = new HashMap<>();

            for (int i = 1; i <= columnCount; i++) {
                map.put(metaData.getColumnName(i), resultSet.getObject(i));
            }
            list.add(map);

//                map.put("id",resultSet.getInt(1));
//                map.put("code",resultSet.getString("code"));
//            System.out.println("resultSet.getInt(1) = " + resultSet.getInt(1));

        }
        return list;
    }

    //promo Code listesini okumak için kullanabilirsiniz, List<PPromoCode> bir liste dönecek
    public static List<PPromoCode> getPromoCodeList_pojo() throws SQLException {

        statement = connection.createStatement();
        resultSet = statement.executeQuery("select * from promo_code;");

        List<PPromoCode> list = new ArrayList<>();

        while (resultSet.next()) {

            PPromoCode promoCode = new PPromoCode(
                    resultSet.getInt("id"),
                    resultSet.getString("code"),
                    resultSet.getString("starts_at"),
                    resultSet.getString("ends_at"),
                    resultSet.getInt("number_of_users"),
                    resultSet.getInt("discount"),
                    resultSet.getString("discount_type")
            );
            list.add(promoCode);
        }
        return list;
    }

    //Event create etmek için kullanabilirsiniz
    public static void createEvent(String title, int attendee_limit) {

        String query = "insert into event (address_id,attendee_limit,date,duration,fee,is_active,is_refundable,owner_id,status,tac,title)" +
                " values (45," + attendee_limit + ",'2024-01-01 00:00:00.000000',45,0,0,0,1486,'NEW','only one person can be invited','" + title + "');";

        updateQueryStatement(query);
    }

    //istenen listesiyi okumak için kullanabilirsiniz, List<Map<String, Object>> bir liste dönecek
    public static void verifyEvent() throws SQLException {

        readQueryStatement("select * from event where address_id=45;");
        while (resultSet.next()) {
            ResultSetMetaData rsmd = resultSet.getMetaData();
            Assert.assertTrue(resultSet.getString("title").contains("Turgut"));
        }
    }

    //Event update etmek için kullanabilirsiniz
    public static void updateEvent(String title) throws SQLException {

        List<Map<String, Object>> eventsList = getEventsList();
        Object eventID = eventsList.getLast().get("id");
        String query = "update event set title='" + title + "' where id=" + eventID + ";";

        updateQueryStatement(query);
    }

    public static List<Map<String, Object>> getEventsList() throws SQLException {

        readQueryStatement("select * from event where address_id=45;");
        List<Map<String, Object>> list = new ArrayList<>();

        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        while (resultSet.next()) {


            Map<String, Object> map = new HashMap<>();

            for (int i = 1; i <= columnCount; i++) {
                map.put(metaData.getColumnName(i), resultSet.getObject(i));
            }
            list.add(map);

        }
        return list;
    }

    public static void verifyUpdateEvent() throws SQLException {
        readQueryStatement("select * from event where address_id=45;");
        while (resultSet.next()) {
            ResultSetMetaData rsmd = resultSet.getMetaData();
            Assert.assertTrue(resultSet.getString("title").contains("Turgut updated"));
        }
    }

    //Event delete etmek için kullanabilirsiniz
    public static void deleteEvent() throws SQLException {

        List<Map<String, Object>> eventsList = getEventsList();
        Object eventID = eventsList.getLast().get("id");
        String query = "delete from event where id=" + eventID + ";";

        updateQueryStatement(query);
    }

    public static void verifyDeleteEvent() throws SQLException {

        readQueryStatement("select * from event where address_id=45;");
        while (resultSet.next()) {
            ResultSetMetaData rsmd = resultSet.getMetaData();
            Assert.assertFalse(resultSet.getString("title").contains("Turgut updated"));
        }
    }
}
