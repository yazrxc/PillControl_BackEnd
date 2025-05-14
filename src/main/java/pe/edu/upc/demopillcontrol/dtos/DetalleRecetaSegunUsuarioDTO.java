package pe.edu.upc.demopillcontrol.dtos;

import java.sql.Time;

public class DetalleRecetaSegunUsuarioDTO {
    //Se van a listar los detalles de sus recetas que se ingresaron según el usuario
    private int idDetalleReceta;
    private int idReceta;
    private int id_medicamento;
    private int dosisDetalleReceta;
    private Time horaDetalleReceta;
    private int intervaloDetalleReceta;
    private int frecuenciaDetalleReceta;

    public int getIdDetalleReceta() {
        return idDetalleReceta;
    }

    public DetalleRecetaSegunUsuarioDTO(int idDetalleReceta, int idReceta, int id_medicamento, int dosisDetalleReceta, Time horaDetalleReceta, int intervaloDetalleReceta, int frecuenciaDetalleReceta) {
        this.idDetalleReceta = idDetalleReceta;
        this.idReceta = idReceta;
        this.id_medicamento = id_medicamento;
        this.dosisDetalleReceta = dosisDetalleReceta;
        this.horaDetalleReceta = horaDetalleReceta;
        this.intervaloDetalleReceta = intervaloDetalleReceta;
        this.frecuenciaDetalleReceta = frecuenciaDetalleReceta;
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

    public Time getHoraDetalleReceta() {
        return horaDetalleReceta;
    }

    public void setHoraDetalleReceta(Time horaDetalleReceta) {
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
