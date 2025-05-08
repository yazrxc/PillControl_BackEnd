package pe.edu.upc.demopillcontrol.dtos;

public class QueryFarmaciaStockEconomicoDTO {
    private String nombre;
    private String direccion;
    private int cantidad;
    private Double precio;

    public QueryFarmaciaStockEconomicoDTO() {}
    public QueryFarmaciaStockEconomicoDTO(String nombre, String direccion, int cantidad, Double precio) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
