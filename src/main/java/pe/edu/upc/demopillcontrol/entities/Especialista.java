package pe.edu.upc.demopillcontrol.entities;

import jakarta.persistence.*;

@Entity
@Table(name="Especialista")
public class Especialista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEspecialista;

    @Column(name="nombreEspecialista", nullable = false, length = 100)
    private String nombreEspecialista;

    @Column(name="especialidadEspecialista", nullable = false, length = 50)
    private String especialidadEspecialista;

    @Column(name="telefonoEspecialista", nullable = false,length = 9 )
    private String telefonoEspecialista;

    @Column(name="correoEspecialista", nullable = false, length = 50)
    private String correoEspecialista;

    @Column(name="institucionEspecialista", nullable = false, length = 250)
    private String institucionEspecialista;

    public Especialista() {
    }

    public Especialista(int idEspecialista, String nombreEspecialista, String especialidadEspecialista, String telefonoEspecialista, String correoEspecialista, String institucionEspecialista) {
        this.idEspecialista = idEspecialista;
        this.nombreEspecialista = nombreEspecialista;
        this.especialidadEspecialista = especialidadEspecialista;
        this.telefonoEspecialista = telefonoEspecialista;
        this.correoEspecialista = correoEspecialista;
        this.institucionEspecialista = institucionEspecialista;
    }

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
