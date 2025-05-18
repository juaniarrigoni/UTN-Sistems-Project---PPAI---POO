package src.persistence;

import src.model.EventoSismico;
import src.persistence.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventoSismicoDAO {
    private final Connection connection;

    public EventoSismicoDAO() throws SQLException {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    public List<EventoSismico> listarTodos() throws SQLException {
        List<EventoSismico> eventos = new ArrayList<>();
        String sql = "SELECT * FROM eventos_sismicos ORDER BY fecha_hora DESC";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                eventos.add(mapearEvento(rs));
            }
        }
        return eventos;
    }

    public EventoSismico buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM eventos_sismicos WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapearEvento(rs);
            }
        }
        return null;
    }

    private EventoSismico mapearEvento(ResultSet rs) throws SQLException {
        EventoSismico evento = new EventoSismico();
        evento.setId(rs.getInt("id"));
        evento.setFechaHora(rs.getTimestamp("fecha_hora").toLocalDateTime());
        evento.setMagnitud(rs.getDouble("magnitud"));
        evento.setProfundidad(rs.getDouble("profundidad"));
        evento.setLatitud(rs.getDouble("latitud"));
        evento.setLongitud(rs.getDouble("longitud"));
        evento.setEstado(rs.getString("estado"));
        evento.setObservaciones(rs.getString("observaciones"));
        return evento;
    }
}