package com.travel.vision.api.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DatabaseManager
{
    private String framework = "embedded";
    private String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    private String protocol = "jdbc:derby:";

    public DatabaseManager() {}

    public static void main(String[] args)
    {
        new DatabaseManager().go(args);
        System.out.println("Database Manager finished");
    }

    void go(String[] args)
    {
        parseArguments(args);
        System.out.println("Database Manager starting in " + framework + " mode");
        loadDriver();
        Connection conn = null;
        Statement statement = null;
        try {
            Properties props = new Properties();
            props.put("user", "dbo");
            props.put("password", "");
            String dbName = "TravelVisionDb";
            String url = protocol + dbName + ";create=true";
            conn = DriverManager.getConnection(url, props);
            conn.setAutoCommit(false);
            conn.commit();

            if (framework.equals("embedded")) {
                try {
                    DriverManager.getConnection("jdbc:derby:;shutdown=true");
                }
                catch (SQLException se) {
                    if (( (se.getErrorCode() == 50000)
                            && ("XJ015".equals(se.getSQLState()) ))) {
                        System.out.println("Derby shut down normally");
                    } else {
                        System.err.println("Derby did not shut down normally");
                        printSQLException(se);
                    }
                }
            }
        }
        catch (SQLException sqlException) {
            printSQLException(sqlException);
            if(conn != null) {
                try {
                    conn.rollback();
                    System.out.println("\tConnection rolled back.");
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        } finally {
            if (statement != null) {
                try {
                    if (statement != null) {
                        statement.close();
                    }
                } catch (SQLException sqle) {
                    printSQLException(sqle);
                }
            }
            try {
                if (conn != null) {
                    conn.close();
                    System.out.println("\tConnection closed");
                }
            } catch (SQLException sqlException) {
                printSQLException(sqlException);
            }
        }
    }

    public void loadDriver() {
        try {
            DriverManager.registerDriver(DriverManager.getDriver(driver));
            System.out.println("Loaded the Driver successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void printSQLException(SQLException e)
    {
        while (e != null)
        {
            System.err.println("\n----- SQLException -----");
            System.err.println("  SQL State:  " + e.getSQLState());
            System.err.println("  Error Code: " + e.getErrorCode());
            System.err.println("  Message:    " + e.getMessage());
            e = e.getNextException();
        }
    }

    private void parseArguments(String[] args)
    {
        if (args.length > 0) {
            if (args[0].equalsIgnoreCase("derbyclient"))
            {
                framework = "derbyclient";
                driver = "org.apache.derby.jdbc.ClientDriver";
                protocol = "jdbc:derby://localhost:1527/";
            }
        }
    }
}
