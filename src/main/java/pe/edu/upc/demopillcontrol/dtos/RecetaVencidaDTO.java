package pe.edu.upc.demopillcontrol.dtos;

import java.time.LocalDate;

public class RecetaVencidaDTO {
    private int idReceta;
    private LocalDate fechaEmision;

    public int getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(int idReceta) {
        this.idReceta = idReceta;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }
}
