package pe.edu.upc.demopillcontrol.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    @Column(name = "nombreUsuario", nullable = false, length = 100)
    private String nombreUsuario;

    @Column(name = "edadUsuario", nullable = false)
    private int edadUsuario;

    @Column(name = "correoUsuario", nullable = false, length = 100)
    private String correoUsuario;

    @Column(name = "generoUsuario", nullable = false, length = 50)
    private String generoUsuario;

    @Column(name = "telefonoUsuario", nullable = false, length = 20)
    private String telefonoUsuario;

    @Column(name = "direccionUsuario", nullable = false, length = 100)
    private String direccionUsuario;

    @Column(name = "fechaRegistroUsuario", nullable = false, length = 100)
    private LocalDate fechaRegistroUsuario;

    @ManyToOne
    @JoinColumn(name = "idrol")
    private RolUsuario rolusuario;

    @ManyToOne
    @JoinColumn(name = "idEspecialista")
    private Especialista especialista;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nombreUsuario, int edadUsuario, String correoUsuario, String generoUsuario, String telefonoUsuario, String direccionUsuario, LocalDate fechaRegistroUsuario, RolUsuario rolusuario, Especialista especialista) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.edadUsuario = edadUsuario;
        this.correoUsuario = correoUsuario;
        this.generoUsuario = generoUsuario;
        this.telefonoUsuario = telefonoUsuario;
        this.direccionUsuario = direccionUsuario;
        this.fechaRegistroUsuario = fechaRegistroUsuario;
        this.rolusuario = rolusuario;
        this.especialista = especialista;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public int getEdadUsuario() {
        return edadUsuario;
    }

    public void setEdadUsuario(int edadUsuario) {
        this.edadUsuario = edadUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getGeneroUsuario() {
        return generoUsuario;
    }

    public void setGeneroUsuario(String generoUsuario) {
        this.generoUsuario = generoUsuario;
    }

    public String getTelefonoUsuario() {
        return telefonoUsuario;
    }

    public void setTelefonoUsuario(String telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
    }

    public String getDireccionUsuario() {
        return direccionUsuario;
    }

    public void setDireccionUsuario(String direccionUsuario) {
        this.direccionUsuario = direccionUsuario;
    }

    public LocalDate getFechaRegistroUsuario() {
        return fechaRegistroUsuario;
    }

    public void setFechaRegistroUsuario(LocalDate fechaRegistroUsuario) {
        this.fechaRegistroUsuario = fechaRegistroUsuario;
    }

    public RolUsuario getRolusuario() {
        return rolusuario;
    }

    public void setRolusuario(RolUsuario rolusuario) {
        this.rolusuario = rolusuario;
    }

    public Especialista getEspecialista() {
        return especialista;
    }

    public void setEspecialista(Especialista especialista) {
        this.especialista = especialista;
    }
}
