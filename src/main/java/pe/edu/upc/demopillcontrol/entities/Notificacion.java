package pe.edu.upc.demopillcontrol.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Notificacion")
public class Notificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNotificacion;
    @Column(name = "estadoNotificacion", nullable = false)
    private Boolean estadoNotificacion;
    @Column(name = "mensajeNotificacion", nullable = false, length = 250)
    private String mensajeNotificacion;

    @ManyToOne
    @JoinColumn(name = "idDetalleReceta")
    private DetalleReceta detallereceta;

    public Notificacion() {
    }

    public Notificacion(int idNotificacion, boolean estadoNotificacion, String mensajeNotificacion, DetalleReceta detallereceta) {
        this.idNotificacion = idNotificacion;
        this.estadoNotificacion = estadoNotificacion;
        this.mensajeNotificacion = mensajeNotificacion;
        this.detallereceta = detallereceta;
    }

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

    public DetalleReceta getDetallereceta() {
        return detallereceta;
    }

    public void setDetallereceta(DetalleReceta detallereceta) {
        this.detallereceta = detallereceta;
    }
}
