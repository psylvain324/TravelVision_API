package com.travel.vision.api.daos.restaurants;

import com.travel.vision.api.database.DatabaseManager;
import com.travel.vision.api.models.restaurants.RoomCharge;
import org.springframework.beans.factory.annotation.Autowired;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

//TODO: Add Missing Fields & Refactor Redundant Code
public class RoomChargeDaoImpl implements RoomChargeDao {
    public static final String INSERT_INTO_ROOM_CHARGE_VALUES = "INSERT INTO RoomCharge values (?,?,?)";
    private final String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    private final String protocol = "jdbc:derby:";
    private final String userId = "dbo";
    private final String dbName = "TravelVisionDb";
    @Autowired
    private DatabaseManager databaseManager;

    public RoomChargeDaoImpl(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
        this.databaseManager.loadDriver();
    }

    protected Connection getConnection() throws SQLException {
        Connection conn;
        Properties props = new Properties();
        props.put("user", userId);
        conn = DriverManager.getConnection(protocol + dbName + ";create=true", props);
        conn.setAutoCommit(false);
        return conn;
    }

    @Override
    public boolean create(RoomCharge roomCharge) {
        PreparedStatement statement = null;
        Connection conn = null;
        try {
            conn = getConnection();
            statement = conn.prepareStatement(INSERT_INTO_ROOM_CHARGE_VALUES);
            statement.setLong(1, Long.parseLong(String.valueOf(roomCharge.getId())));
            statement.setInt(2, Integer.parseInt(String.valueOf(roomCharge.getRoomNumber())));
            statement.setString(3, String.valueOf(roomCharge.getLastName()));
            statement.executeUpdate();
            conn.commit();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            if(conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    @Override
    public boolean update(RoomCharge roomCharge) {
        PreparedStatement statement = null;
        Connection conn = null;
        try {
            conn = getConnection();
            statement = conn.prepareStatement("UPDATE RoomCharge SET id=?, room_number=? where last_name=?");
            statement.setLong(1, Long.parseLong(String.valueOf(roomCharge.getId())));
            statement.setInt(2, Integer.parseInt(String.valueOf(roomCharge.getRoomNumber())));
            statement.setString(3, String.valueOf(roomCharge.getLastName()));
            statement.executeUpdate();
            conn.commit();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            if(conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    @Override
    public List<RoomCharge> searchById(long id) {
        PreparedStatement statement = null;
        Connection conn = null;
        ResultSet resultSet = null;
        List<RoomCharge> roomCharges = new ArrayList<>();
        try {
            conn = getConnection();
            statement = conn.prepareStatement("SELECT * FROM RoomCharge where id=?");
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                RoomCharge roomCharge = new RoomCharge();
                roomCharge.setId(Long.parseLong((resultSet.getString("id"))));
                roomCharge.setRoomNumber(Integer.parseInt(resultSet.getString("room_number")));
                roomCharge.setLastName(resultSet.getString("last_name"));
                roomCharges.add(roomCharge);
            }
            conn.commit();
            return roomCharges;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public List<RoomCharge> searchByRoomNumber(String roomNumber) {
        PreparedStatement statement = null;
        Connection conn = null;
        ResultSet resultSet = null;
        List<RoomCharge> roomCharges = new ArrayList<>();
        try {
            conn = getConnection();
            statement = conn.prepareStatement("SELECT * FROM RoomCharge where room_number=?");
            statement.setString(1, roomNumber);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                RoomCharge roomCharge = new RoomCharge();
                roomCharge.setId(Long.parseLong((resultSet.getString("id"))));
                roomCharge.setRoomNumber(Integer.parseInt(resultSet.getString("room_number")));
                roomCharge.setLastName(resultSet.getString("last_name"));
                roomCharges.add(roomCharge);
            }
            conn.commit();
            return roomCharges;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public List<RoomCharge> searchByLastName(String lastName) {
        PreparedStatement statement = null;
        Connection conn = null;
        ResultSet resultSet = null;
        List<RoomCharge> roomCharges = new ArrayList<>();
        try {
            conn = getConnection();
            statement = conn.prepareStatement("SELECT * FROM RoomCharge where last_name=?");
            statement.setString(1, lastName);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                RoomCharge roomCharge = new RoomCharge();
                roomCharge.setId(Long.parseLong((resultSet.getString("id"))));
                roomCharge.setRoomNumber(Integer.parseInt(resultSet.getString("room_number")));
                roomCharge.setLastName(resultSet.getString("last_name"));
                roomCharges.add(roomCharge);
            }
            conn.commit();
            return roomCharges;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public boolean delete(long id) {
        PreparedStatement statement = null;
        Connection conn = null;
        try {
            conn = getConnection();
            statement = conn.prepareStatement("DELETE FROM RoomCharge WHERE id=?");
            statement.setLong(1, id);
            statement.executeUpdate();
            conn.commit();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            if(conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

}
