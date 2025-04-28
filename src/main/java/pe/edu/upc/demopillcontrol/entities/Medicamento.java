package pe.edu.upc.demopillcontrol.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Medicamento")
public class Medicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_medicamento;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "descripcion", nullable = false, length = 250)
    private String descripcion;

    @Column(name = "dosis", nullable = false)
    private double dosis;

    @Column(name = "unidad_medida", nullable = false, length = 20)
    private String unidad_medida;

    @Column(name = "tipo_medicamento", nullable = false, length = 20)
    private String tipo_medicamento;

    @Column(name = "presentacion", nullable = false, length = 20)
    private String presentacion;

    @Column(name = "contenido", nullable = false)
    private int contenido;

    public Medicamento() {
    }

    public Medicamento(int id_medicamento, String nombre, String descripcion, double dosis, String unidad_medida, String tipo_medicamento, String presentacion, int contenido) {
        this.id_medicamento = id_medicamento;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.dosis = dosis;
        this.unidad_medida = unidad_medida;
        this.tipo_medicamento = tipo_medicamento;
        this.presentacion = presentacion;
        this.contenido = contenido;
    }

    public int getId_medicamento() {
        return id_medicamento;
    }

    public void setId_medicamento(int id_medicamento) {
        this.id_medicamento = id_medicamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getDosis() {
        return dosis;
    }

    public void setDosis(double dosis) {
        this.dosis = dosis;
    }

    public String getUnidad_medida() {
        return unidad_medida;
    }

    public void setUnidad_medida(String unidad_medida) {
        this.unidad_medida = unidad_medida;
    }

    public String getTipo_medicamento() {
        return tipo_medicamento;
    }

    public void setTipo_medicamento(String tipo_medicamento) {
        this.tipo_medicamento = tipo_medicamento;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public int getContenido() {
        return contenido;
    }

    public void setContenido(int contenido) {
        this.contenido = contenido;
    }
}
