package src.persistence;

import src.model.EventoSismico;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EventoSismicoDAO {

    public List<EventoSismico> listarTodos() {
        List<EventoSismico> eventos = new ArrayList<>();
        try {
            Connection conn = ConexionBD.getConexion();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id, fecha, estado FROM evento_sismico");

            while (rs.next()) {
                int id = rs.getInt("id");
                String fecha = rs.getString("fecha");
                String estado = rs.getString("estado");
                EventoSismico evento = new EventoSismico(id, fecha, estado);
                eventos.add(evento);
            }

            rs.close();
            stmt.close();
        } catch (Exception e) {
            System.out.println("❌ Error al listar eventos sísmicos: " + e.getMessage());
        }
        return eventos;
    }
}
