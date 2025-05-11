package pe.edu.upc.demopillcontrol.dtos;

public class AlertaSinContactoGravedadAltaDTO {
    private int id_Usuario;
    private String nombre_Usuario;
    private int edad_Usuario;
    private String diagnostico;
    private String gravedad;
    private String alergias;
    private String condiciones;
    private String nombre_Contacto;
    private String telefono_Contacto;

    public int getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(int id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    public String getNombre_Usuario() {
        return nombre_Usuario;
    }

    public void setNombre_Usuario(String nombre_Usuario) {
        this.nombre_Usuario = nombre_Usuario;
    }

    public Integer getEdad_Usuario() {
        return edad_Usuario;
    }

    public void setEdad_Usuario(Integer edad_Usuario) {
        this.edad_Usuario = edad_Usuario;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getGravedad() {
        return gravedad;
    }

    public void setGravedad(String gravedad) {
        this.gravedad = gravedad;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getCondiciones() {
        return condiciones;
    }

    public void setCondiciones(String condiciones) {
        this.condiciones = condiciones;
    }

    public String getNombre_Contacto() {
        return nombre_Contacto;
    }

    public void setNombre_Contacto(String nombre_Contacto) {
        this.nombre_Contacto = nombre_Contacto;
    }

    public String getTelefono_Contacto() {
        return telefono_Contacto;
    }

    public void setTelefono_Contacto(String telefono_Contacto) {
        this.telefono_Contacto = telefono_Contacto;
    }
}
