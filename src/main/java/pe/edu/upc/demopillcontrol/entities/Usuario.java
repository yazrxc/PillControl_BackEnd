package pe.edu.upc.demopillcontrol.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    @JsonIgnore
    @Column(length = 30, unique = true)
    private String username;
    @JsonIgnore
    @Column(length = 200)
    private String password;
    @JsonIgnore
    private Boolean enabled;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

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
    @JoinColumn(name = "idEspecialista")
    private Especialista especialista;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "idUsuario")
    private List<RolUsuario> roles;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public Especialista getEspecialista() {
        return especialista;
    }

    public void setEspecialista(Especialista especialista) {
        this.especialista = especialista;
    }

    public List<RolUsuario> getRoles() {
        return roles;
    }

    public void setRoles(List<RolUsuario> roles) {
        this.roles = roles;
    }
}
