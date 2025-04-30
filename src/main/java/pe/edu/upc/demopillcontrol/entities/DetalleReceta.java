package pe.edu.upc.demopillcontrol.entities;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name = "DetalleReceta")
public class DetalleReceta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetalleReceta;
    @Column(name = "dosisDetalleReceta",nullable = false)
    private int dosisDetalleReceta;
    @Column(name = "horaDetalleReceta",nullable = false)
    private LocalTime horaDetalleReceta;
    @Column(name = "intervaloDetalleReceta",nullable = false)
    private int intervaloDetalleReceta;
    @Column(name = "frecuenciaDetalleReceta",nullable = false)
    private int frecuenciaDetalleReceta;

    @ManyToOne
    @JoinColumn(name = "idReceta")
    private Receta receta;
    @ManyToOne
    @JoinColumn(name = "id_medicamento")
    private Medicamento medicamento;

    public DetalleReceta() {
    }

    public DetalleReceta(int idDetalleReceta, int dosisDetalleReceta, LocalTime horaDetalleReceta, int intervaloDetalleReceta, int frecuenciaDetalleReceta, Receta receta, Medicamento medicamento) {
        this.idDetalleReceta = idDetalleReceta;
        this.dosisDetalleReceta = dosisDetalleReceta;
        this.horaDetalleReceta = horaDetalleReceta;
        this.intervaloDetalleReceta = intervaloDetalleReceta;
        this.frecuenciaDetalleReceta = frecuenciaDetalleReceta;
        this.receta = receta;
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
