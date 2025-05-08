package pe.edu.upc.demopillcontrol.dtos;

import java.time.LocalTime;

public class FarmaciaDTO {
    private int idFarmacia;
    private String nombreFarmacia;
    private String direccionFarmacia;
    private String telefonoFarmacia;
    private LocalTime horarioAperturaFarmacia;
    private LocalTime horarioCierreFarmacia;
    private String longitudFarmacia;
    private String latitudFarmacia;


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
