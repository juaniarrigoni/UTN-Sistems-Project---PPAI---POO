package src.model;

import java.time.LocalDateTime;

public class EventoSismico {
    private int id;
    private LocalDateTime fechaHora;
    private double magnitud;
    private double profundidad;
    private double latitud;
    private double longitud;
    private String estado;
    private String observaciones;

    public EventoSismico() {}

    public EventoSismico(int id, LocalDateTime fechaHora, double magnitud, double profundidad,
                        double latitud, double longitud, String estado, String observaciones) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.magnitud = magnitud;
        this.profundidad = profundidad;
        this.latitud = latitud;
        this.longitud = longitud;
        this.estado = estado;
        this.observaciones = observaciones;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public LocalDateTime getFechaHora() { return fechaHora; }
    public void setFechaHora(LocalDateTime fechaHora) { this.fechaHora = fechaHora; }

    public double getMagnitud() { return magnitud; }
    public void setMagnitud(double magnitud) { this.magnitud = magnitud; }

    public double getProfundidad() { return profundidad; }
    public void setProfundidad(double profundidad) { this.profundidad = profundidad; }

    public double getLatitud() { return latitud; }
    public void setLatitud(double latitud) { this.latitud = latitud; }

    public double getLongitud() { return longitud; }
    public void setLongitud(double longitud) { this.longitud = longitud; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }

    @Override
    public String toString() {
        return String.format("Evento Sísmico #%d\n" +
                           "Fecha y Hora: %s\n" +
                           "Magnitud: %.1f\n" +
                           "Profundidad: %.1f km\n" +
                           "Ubicación: %.4f, %.4f\n" +
                           "Estado: %s\n" +
                           "Observaciones: %s",
                           id, fechaHora, magnitud, profundidad, latitud, longitud, estado, observaciones);
    }
}