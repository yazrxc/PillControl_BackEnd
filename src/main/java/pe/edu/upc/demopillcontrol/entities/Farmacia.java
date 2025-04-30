package pe.edu.upc.demopillcontrol.entities;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name = "Farmacia")
public class Farmacia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFarmacia;
    @Column(name ="nombreFarmacia" ,nullable = false,length = 50)
    private String nombreFarmacia;
    @Column(name ="direccionFarmacia" ,nullable = false,length = 50)
    private String direccionFarmacia;
    @Column(name ="telefonoFarmacia" ,nullable = false,length = 20)
    private String telefonoFarmacia;
    @Column(name = "horarioAperturaFarmacia",nullable = false)
    private LocalTime horarioAperturaFarmacia;
    @Column(name = "horarioCierreFarmacia",nullable = false)
    private LocalTime horarioCierreFarmacia;
    @Column(name ="longitudFarmacia" ,nullable = false,length = 20)
    private String longitudFarmacia;
    @Column(name ="latitudFarmacia" ,nullable = false,length = 20)
    private String latitudFarmacia;

    public Farmacia() {
    }

    public Farmacia(int idFarmacia, String nombreFarmacia, String direccionFarmacia, String telefonoFarmacia, LocalTime horarioAperturaFarmacia, LocalTime horarioCierreFarmacia, String longitudFarmacia, String latitudFarmacia) {
        this.idFarmacia = idFarmacia;
        this.nombreFarmacia = nombreFarmacia;
        this.direccionFarmacia = direccionFarmacia;
        this.telefonoFarmacia = telefonoFarmacia;
        this.horarioAperturaFarmacia = horarioAperturaFarmacia;
        this.horarioCierreFarmacia = horarioCierreFarmacia;
        this.longitudFarmacia = longitudFarmacia;
        this.latitudFarmacia = latitudFarmacia;
    }

    public int getIdFarmacia() {
        return idFarmacia;
    }

    public void setIdFarmacia(int idFarmacia) {
        this.idFarmacia = idFarmacia;
    }

    public String getNombreFarmacia() {
        return nombreFarmacia;
    }

    public void setNombreFarmacia(String nombreFarmacia) {
        this.nombreFarmacia = nombreFarmacia;
    }

    public String getDireccionFarmacia() {
        return direccionFarmacia;
    }

    public void setDireccionFarmacia(String direccionFarmacia) {
        this.direccionFarmacia = direccionFarmacia;
    }

    public String getTelefonoFarmacia() {
        return telefonoFarmacia;
    }

    public void setTelefonoFarmacia(String telefonoFarmacia) {
        this.telefonoFarmacia = telefonoFarmacia;
    }

    public LocalTime getHorarioAperturaFarmacia() {
        return horarioAperturaFarmacia;
    }

    public void setHorarioAperturaFarmacia(LocalTime horarioAperturaFarmacia) {
        this.horarioAperturaFarmacia = horarioAperturaFarmacia;
    }

    public LocalTime getHorarioCierreFarmacia() {
        return horarioCierreFarmacia;
    }

    public void setHorarioCierreFarmacia(LocalTime horarioCierreFarmacia) {
        this.horarioCierreFarmacia = horarioCierreFarmacia;
    }

    public String getLongitudFarmacia() {
        return longitudFarmacia;
    }

    public void setLongitudFarmacia(String longitudFarmacia) {
        this.longitudFarmacia = longitudFarmacia;
    }

    public String getLatitudFarmacia() {
        return latitudFarmacia;
    }

    public void setLatitudFarmacia(String latitudFarmacia) {
        this.latitudFarmacia = latitudFarmacia;
    }
}
