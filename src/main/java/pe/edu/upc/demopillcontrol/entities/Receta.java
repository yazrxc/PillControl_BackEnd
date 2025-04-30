package pe.edu.upc.demopillcontrol.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Receta")
public class Receta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReceta;
    @Column(name = "fechaInicioReceta",nullable = false)
    private LocalDate fechaInicioReceta;
    @Column(name = "fechaFinReceta",nullable = false)
    private LocalDate fechaFinReceta;
    @Column(name ="observacionesReceta" ,nullable = false,length = 250)
    private String observacionesReceta;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "idDiagnostico")
    private Diagnostico diagnostico;

    public Receta() {
    }

    public Receta(int idReceta, LocalDate fechaInicioReceta, LocalDate fechaFinReceta, String observacionesReceta, Usuario usuario, Diagnostico diagnostico) {
        this.idReceta = idReceta;
        this.fechaInicioReceta = fechaInicioReceta;
        this.fechaFinReceta = fechaFinReceta;
        this.observacionesReceta = observacionesReceta;
        this.usuario = usuario;
        this.diagnostico = diagnostico;
    }

    public int getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(int idReceta) {
        this.idReceta = idReceta;
    }

    public LocalDate getFechaInicioReceta() {
        return fechaInicioReceta;
    }

    public void setFechaInicioReceta(LocalDate fechaInicioReceta) {
        this.fechaInicioReceta = fechaInicioReceta;
    }

    public LocalDate getFechaFinReceta() {
        return fechaFinReceta;
    }

    public void setFechaFinReceta(LocalDate fechaFinReceta) {
        this.fechaFinReceta = fechaFinReceta;
    }

    public String getObservacionesReceta() {
        return observacionesReceta;
    }

    public void setObservacionesReceta(String observacionesReceta) {
        this.observacionesReceta = observacionesReceta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }
}
