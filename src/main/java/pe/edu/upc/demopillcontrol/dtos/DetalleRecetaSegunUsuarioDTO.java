package pe.edu.upc.demopillcontrol.dtos;

import java.time.LocalTime;

public class DetalleRecetaSegunUsuarioDTO {
    //Se van a listar los detalles de sus recetas que se ingresaron según el usuario
    private int idDetalleReceta;
    private int idReceta;
    private int id_medicamento;
    private int dosisDetalleReceta;
    private LocalTime horaDetalleReceta;
    private int intervaloDetalleReceta;
    private int frecuenciaDetalleReceta;

    public int getIdDetalleReceta() {
        return idDetalleReceta;
    }

    public void setIdDetalleReceta(int idDetalleReceta) {
        this.idDetalleReceta = idDetalleReceta;
    }

    public int getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(int idReceta) {
        this.idReceta = idReceta;
    }

    public int getId_Medicamento() {
        return id_medicamento;
    }

    public void setId_Medicamento(int id_medicamento) {
        this.id_medicamento = id_medicamento;
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
