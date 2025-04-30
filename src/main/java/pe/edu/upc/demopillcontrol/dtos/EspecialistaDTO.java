package pe.edu.upc.demopillcontrol.dtos;

import jakarta.persistence.Column;

public class EspecialistaDTO {
    private int idEspecialista;
    private String nombreEspecialista;
    private String especialidadEspecialista;
    private String telefonoEspecialista;
    private String correoEspecialista;
    private String institucionEspecialista;

    public int getIdEspecialista() {
        return idEspecialista;
    }

    public void setIdEspecialista(int idEspecialista) {
        this.idEspecialista = idEspecialista;
    }

    public String getNombreEspecialista() {
        return nombreEspecialista;
    }

    public void setNombreEspecialista(String nombreEspecialista) {
        this.nombreEspecialista = nombreEspecialista;
    }

    public String getEspecialidadEspecialista() {
        return especialidadEspecialista;
    }

    public void setEspecialidadEspecialista(String especialidadEspecialista) {
        this.especialidadEspecialista = especialidadEspecialista;
    }

    public String getTelefonoEspecialista() {
        return telefonoEspecialista;
    }

    public void setTelefonoEspecialista(String telefonoEspecialista) {
        this.telefonoEspecialista = telefonoEspecialista;
    }

    public String getCorreoEspecialista() {
        return correoEspecialista;
    }

    public void setCorreoEspecialista(String correoEspecialista) {
        this.correoEspecialista = correoEspecialista;
    }

    public String getInstitucionEspecialista() {
        return institucionEspecialista;
    }

    public void setInstitucionEspecialista(String institucionEspecialista) {
        this.institucionEspecialista = institucionEspecialista;
    }
}
