package pe.edu.upc.demopillcontrol.dtos;

import pe.edu.upc.demopillcontrol.entities.Diagnostico;
import pe.edu.upc.demopillcontrol.entities.Usuario;

import java.time.LocalDate;

public class RecetaDTO {

    private int idReceta;
    private LocalDate fechaInicioReceta;
    private LocalDate fechaFinReceta;
    private String observacionesReceta;
    private Usuario usuario;
    private Diagnostico diagnostico;

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
