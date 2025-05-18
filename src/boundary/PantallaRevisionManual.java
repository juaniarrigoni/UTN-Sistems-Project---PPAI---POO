package src.boundary;

import src.model.EventoSismico;
import src.persistence.EventoSismicoDAO;

import java.util.List;
import java.util.Scanner;

public class PantallaRevisionManual {
    private final Scanner scanner;
    private final EventoSismicoDAO dao;

    public PantallaRevisionManual() {
        this.scanner = new Scanner(System.in);
        try {
            this.dao = new EventoSismicoDAO();
        } catch (Exception e) {
            throw new RuntimeException("Error al inicializar el DAO: " + e.getMessage());
        }
    }

    public void iniciar() {
        boolean continuar = true;
        while (continuar) {
            mostrarMenu();
            int opcion = leerOpcion();
            try {
                switch (opcion) {
                    case 1 -> mostrarEventos();
                    case 0 -> continuar = false;
                    default -> System.out.println("Opción no válida");
                }
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }

    private void mostrarMenu() {
        System.out.println("\n=== Menú de Revisión Manual ===");
        System.out.println("1. Ver eventos sísmicos");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private int leerOpcion() {
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, ingrese un número válido");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public void mostrarEventos() {
        try {
            List<EventoSismico> eventos = dao.listarTodos();
            if (eventos.isEmpty()) {
                System.out.println("No hay eventos sísmicos registrados.");
            } else {
                System.out.println("\n=== Eventos Sísmicos ===");
                for (EventoSismico evento : eventos) {
                    System.out.println("\n" + evento);
                }
            }
        } catch (Exception e) {
            System.err.println("Error al mostrar eventos: " + e.getMessage());
        }
    }
}