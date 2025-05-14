package pe.edu.upc.demopillcontrol.dtos;

public class NotificacionesPorUsuarioDTO {
    private String nombre;
    private int idNotificacion;
    private Boolean estadoNotificacion;
    private String mensajeNotificacion;

    public NotificacionesPorUsuarioDTO(String nombre, int idNotificacion, Boolean estadoNotificacion, String mensajeNotificacion) {
        this.nombre = nombre;
        this.idNotificacion = idNotificacion;
        this.estadoNotificacion = estadoNotificacion;
        this.mensajeNotificacion = mensajeNotificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(int idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public Boolean getEstadoNotificacion() {
        return estadoNotificacion;
    }

    public void setEstadoNotificacion(Boolean estadoNotificacion) {
        this.estadoNotificacion = estadoNotificacion;
    }

    public String getMensajeNotificacion() {
        return mensajeNotificacion;
    }

    public void setMensajeNotificacion(String mensajeNotificacion) {
        this.mensajeNotificacion = mensajeNotificacion;
    }
}
