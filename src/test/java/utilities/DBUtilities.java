package utilities;

import java.sql.*;

public class DBUtilities {
    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement preparedStatement;
    public static ResultSet resultSet;
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
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
    public static void updateQueryStatement(String sql) { // insert update delete
        try {
            statement = connection.createStatement();
            int i = statement.executeUpdate(sql);
            System.out.println(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void approvedLastProduct(){
        updateQueryStatement("UPDATE `hub_product` SET `product_listing_state` = 'APPROVED' WHERE `product_listing_state` LIKE 'IN_REVIEW' order BY id DESC;");
    }
}
