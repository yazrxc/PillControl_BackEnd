package pe.edu.upc.demopillcontrol.dtos;

import pe.edu.upc.demopillcontrol.entities.DetalleReceta;

public class NotificacionDTO {

    private int idNotificacion;
    private boolean estadoNotificacion;
    private String mensajeNotificacion;
    private DetalleRecetaDTO detallereceta;
    private String nombreUsuario;
    private int idDetalleReceta;
    private String nombreMedicamento;
    private DetalleRecetaDTO detalleReceta;

    public int getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(int idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public boolean getEstadoNotificacion() {
        return estadoNotificacion;
    }

    public void setEstadoNotificacion(boolean estadoNotificacion) {
        this.estadoNotificacion = estadoNotificacion;
    }

    public String getMensajeNotificacion() {
        return mensajeNotificacion;
    }

    public void setMensajeNotificacion(String mensajeNotificacion) {
        this.mensajeNotificacion = mensajeNotificacion;
    }

    public DetalleRecetaDTO getDetallereceta() {
        return detallereceta;
    }

    public void setDetallereceta(DetalleRecetaDTO detallereceta) {
        this.detallereceta = detallereceta;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public int getIdDetalleReceta() {
        return idDetalleReceta;
    }

    public void setIdDetalleReceta(int idDetalleReceta) {
        this.idDetalleReceta = idDetalleReceta;
    }

    public String getNombreMedicamento() {
        return nombreMedicamento;
    }

    public void setNombreMedicamento(String nombreMedicamento) {
        this.nombreMedicamento = nombreMedicamento;
    }

    public DetalleRecetaDTO getDetalleReceta() {
        return detalleReceta;
    }

    public void setDetalleReceta(DetalleRecetaDTO detalleReceta) {
        this.detalleReceta = detalleReceta;
    }
}
