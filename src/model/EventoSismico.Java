package src.model;

public class EventoSismico {
    private int id;
    private String fecha;
    private String estado;

    public EventoSismico(int id, String fecha, String estado) {
        this.id = id;
        this.fecha = fecha;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public String getFecha() {
        return fecha;
    }

    public String getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "EventoSismico{" +
                "id=" + id +
                ", fecha='" + fecha + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
