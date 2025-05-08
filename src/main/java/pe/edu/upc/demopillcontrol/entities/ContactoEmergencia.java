package pe.edu.upc.demopillcontrol.entities;

import jakarta.persistence.*;

@Entity
@Table(name="ContactoEmergencia")
public class ContactoEmergencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idContactoEmergencia;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "parentesco", nullable = false, length = 50)
    private String parentesco;

    @Column(name="telefono", nullable = false,length = 9 )
    private String telefono;

    @Column(name="correo", nullable = false, length = 50)
    private String correo;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;


    public ContactoEmergencia() {
    }

    public ContactoEmergencia(int idContactoEmergencia, String nombre, String parentesco, String telefono, String correo, Usuario usuario) {
        this.idContactoEmergencia = idContactoEmergencia;
        this.nombre = nombre;
        this.parentesco = parentesco;
        this.telefono = telefono;
        this.correo = correo;
        this.usuario = usuario;
    }

    public int getIdContactoEmergencia() {
        return idContactoEmergencia;
    }

    public void setIdContactoEmergencia(int idContactoEmergencia) {
        this.idContactoEmergencia = idContactoEmergencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
