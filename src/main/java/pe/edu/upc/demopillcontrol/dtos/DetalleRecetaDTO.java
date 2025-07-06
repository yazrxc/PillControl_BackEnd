package pe.edu.upc.demopillcontrol.dtos;

import pe.edu.upc.demopillcontrol.entities.Medicamento;
import pe.edu.upc.demopillcontrol.entities.Receta;

import java.time.LocalTime;

public class DetalleRecetaDTO {

    private int idDetalleReceta;
    private int dosisDetalleReceta;
    private LocalTime horaDetalleReceta;
    private int intervaloDetalleReceta;
    private int frecuenciaDetalleReceta;
    private RecetaDTO receta;
    private MedicamentoDTO medicamento;

    public RecetaDTO getReceta() {
        return receta;
    }

    public void setReceta(RecetaDTO receta) {
        this.receta = receta;
    }

    public MedicamentoDTO getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(MedicamentoDTO medicamento) {
        this.medicamento = medicamento;
    }

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

    public LocalTime getHoraDetalleReceta() {
        return horaDetalleReceta;
    }

    public void setHoraDetalleReceta(LocalTime horaDetalleReceta) {
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

}
