package pe.edu.upc.demopillcontrol.dtos;

import java.sql.Date;
import java.time.LocalDate;

public class NotificacionPorFechaDTO {
    private int idNotificacion;
    private Boolean estadoNotificacion;
    private String mensajeNotificacion;
    private LocalDate fechaInicioReceta;

    public NotificacionPorFechaDTO(int idNotificacion, Boolean estadoNotificacion, String mensajeNotificacion, LocalDate fechaInicioReceta) {
        this.idNotificacion = idNotificacion;
        this.estadoNotificacion = estadoNotificacion;
        this.mensajeNotificacion = mensajeNotificacion;
        this.fechaInicioReceta = fechaInicioReceta;
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

    public LocalDate getFechaInicioReceta() {
        return fechaInicioReceta;
    }

    public void setFechaInicioReceta(LocalDate fechaInicioReceta) {
        this.fechaInicioReceta = fechaInicioReceta;
    }
}
