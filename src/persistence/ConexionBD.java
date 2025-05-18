package src.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL = "jdbc:sqlite:database/red_sismica.db";
    private static Connection conexion;

    public static Connection getConexion() {
        if (conexion == null) {
            try {
                conexion = DriverManager.getConnection(URL);
                System.out.println("✅ Conexión a base de datos establecida.");
            } catch (SQLException e) {
                System.out.println("❌ Error al conectar a la base de datos: " + e.getMessage());
            }
        }
        return conexion;
    }
}
