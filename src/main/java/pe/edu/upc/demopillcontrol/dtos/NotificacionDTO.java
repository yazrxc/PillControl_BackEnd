package pe.edu.upc.demopillcontrol.dtos;

import pe.edu.upc.demopillcontrol.entities.DetalleReceta;

public class NotificacionDTO {

    private int idNotificacion;
    private boolean estadoNotificacion;
    private String mensajeNotificaion;
    private DetalleReceta detallereceta;

    public int getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(int idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public boolean isEstadoNotificacion() {
        return estadoNotificacion;
    }

    public void setEstadoNotificacion(boolean estadoNotificacion) {
        this.estadoNotificacion = estadoNotificacion;
    }

    public String getMensajeNotificaion() {
        return mensajeNotificaion;
    }

    public void setMensajeNotificaion(String mensajeNotificaion) {
        this.mensajeNotificaion = mensajeNotificaion;
    }

    public DetalleReceta getDetallereceta() {
        return detallereceta;
    }

    public void setDetallereceta(DetalleReceta detallereceta) {
        this.detallereceta = detallereceta;
    }
}
