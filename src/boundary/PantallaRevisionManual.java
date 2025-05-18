package src.boundary;

import src.model.EventoSismico;
import src.persistence.EventoSismicoDAO;

import java.util.List;
import java.util.Scanner;

public class PantallaRevisionManual {

    private Scanner scanner = new Scanner(System.in);
    private EventoSismicoDAO dao = new EventoSismicoDAO();

    public void iniciar() {
        System.out.println("Bienvenido al Sistema Red Sísmica - Revisión Manual");
        System.out.println("1. Ver eventos sísmicos");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");

        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                List<EventoSismico> eventos = dao.listarTodos();
                eventos.forEach(System.out::println);
                break;
            case 0:
                System.out.println("Saliendo del sistema...");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }
}
