package pe.edu.upc.demopillcontrol.dtos;

import pe.edu.upc.demopillcontrol.entities.Medicamento;
import pe.edu.upc.demopillcontrol.entities.Receta;

import java.time.LocalDateTime;

public class DetalleRecetaDTO {

    private int idDetalleReceta;
    private int dosisDetalleReceta;
    private LocalDateTime horaDetalleReceta;
    private int intervaloDetalleReceta;
    private int frecuenciaDetalleReceta;
    private Receta receta;
    private Medicamento medicamento;

    public int getIdDetalleReceta() {
        return idDetalleReceta;
    }

    public void setIdDetalleReceta(int idDetalleReceta) {
        this.idDetalleReceta = idDetalleReceta;
    }

    public int getDosisDetalleReceta() {
        return dosisDetalleReceta;
    }

    public void setDosisDetalleReceta(int dosisDetalleReceta) {
        this.dosisDetalleReceta = dosisDetalleReceta;
    }

    public LocalDateTime getHoraDetalleReceta() {
        return horaDetalleReceta;
    }

    public void setHoraDetalleReceta(LocalDateTime horaDetalleReceta) {
        this.horaDetalleReceta = horaDetalleReceta;
    }

    public int getIntervaloDetalleReceta() {
        return intervaloDetalleReceta;
    }

    public void setIntervaloDetalleReceta(int intervaloDetalleReceta) {
        this.intervaloDetalleReceta = intervaloDetalleReceta;
    }

    public int getFrecuenciaDetalleReceta() {
        return frecuenciaDetalleReceta;
    }

    public void setFrecuenciaDetalleReceta(int frecuenciaDetalleReceta) {
        this.frecuenciaDetalleReceta = frecuenciaDetalleReceta;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }
}
