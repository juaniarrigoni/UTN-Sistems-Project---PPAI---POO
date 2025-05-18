package src;

import src.boundary.PantallaRevisionManual;
import src.persistence.DatabaseConnection;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("=== Red Sísmica - Sistema de Revisión Manual ===");
            System.out.println("Iniciando sistema...");
            
            // Inicializar conexión a la base de datos
            DatabaseConnection.getInstance().initialize();
            
            // Inicializar y mostrar pantalla principal
            PantallaRevisionManual pantalla = new PantallaRevisionManual();
            pantalla.iniciar();
            
        } catch (Exception e) {
            System.err.println("Error al iniciar la aplicación: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                DatabaseConnection.getInstance().closeConnection();
            } catch (Exception e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}