package com.travel.vision.api.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DbMigrations {
    private String protocol = "jdbc:derby:";

    private Statement CreateRoomChargeTable() {
        Statement statement = null;
        Connection conn;
        try {
            Properties props = new Properties();
            props.put("user", "dbo");
            props.put("password", "");
            String dbName = "TravelVisionDb";
            String url = protocol + dbName + ";create=true";
            conn = DriverManager.getConnection(url, props);
            statement = conn.createStatement();
            statement.execute("CREATE TABLE RoomCharge(" +
                    "id int(10), " +
                    "room_number varchar(40), " +
                    "last_name varchar(40))");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return statement;
    }
}
