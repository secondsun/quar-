package net.saga.quarkey.testutil;

import java.sql.*;

import org.h2.tools.Server;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;

public class H2DatabaseTestResourceEnhanced implements QuarkusTestResourceLifecycleManager {
    private static final String H2_BACKUP_LOCATION = "/tmp/h2backup.sql";

    public static Server tcpServer;

    static {
        try {
            Class.forName("org.h2.Driver");
            DriverManager.registerDriver(new org.h2.Driver());
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public static void load() {
        try (Connection con = connectToSql()){
            try (PreparedStatement st = con.prepareStatement("DROP ALL OBJECTS");) {
                st.execute();
            }
            try (PreparedStatement st = con.prepareStatement("RUNSCRIPT FROM ?");) {
                st.setString(1, H2_BACKUP_LOCATION);
                st.execute();
            }
        } catch (SQLException e) {
            throw  new RuntimeException(e);
        }
    }

    public static void save() {
        try (Connection con = connectToSql(); PreparedStatement st = con.prepareStatement("SCRIPT TO ?");) {
            st.setString(1, H2_BACKUP_LOCATION);
            st.execute();
        } catch (SQLException e) {
            throw  new RuntimeException(e);
        }
    }

    @Override
    public void start() {

        try {
            tcpServer = Server.createTcpServer();
            tcpServer.start();
            System.out.println("[INFO] H2 database started in TCP server mode");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public synchronized void stop() {
        if (tcpServer != null) {
            tcpServer.stop();
            System.out.println("[INFO] H2 database was shut down");
            tcpServer = null;
        }
    }

    private static Connection connectToSql() {
        try {
            return DriverManager.getConnection("jdbc:h2:tcp://localhost/mem:test","sa",null);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
