package ua.lviv.navpil.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcDemo {

    public static void main(String[] args) throws SQLException {
        Properties properties = new Properties();
        properties.setProperty("user", "postgres");
        properties.setProperty("password", "qwerty123456");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/cofeeshop", properties);

        selectShops(connection);

        connection.close();

    }

    private static void selectShops(Connection c) throws SQLException {
        try (Statement s = c.createStatement()) {
            ResultSet r = s.executeQuery("select id, name from cities");
            while (r.next()) {
                int id = r.getInt("id");
                String name = r.getString("name");
                System.out.printf("Id: %1$d Name: %2$s%n", id, name);
            }
        }

    }
}
