package src.utils;

public enum Estado {
    PENDIENTE("Pendiente de revisión"),
    EN_REVISION("En revisión"),
    VALIDADO("Validado"),
    RECHAZADO("Rechazado"),
    FINALIZADO("Finalizado");

    private final String descripcion;

    Estado(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }
}