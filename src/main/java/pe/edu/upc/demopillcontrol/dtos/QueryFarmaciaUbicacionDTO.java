package pe.edu.upc.demopillcontrol.dtos;

public class QueryFarmaciaUbicacionDTO {
    private String nombre;
    private String latitud;
    private String longitud;

    public QueryFarmaciaUbicacionDTO() {}
    public QueryFarmaciaUbicacionDTO(String nombre, String latitud, String longitud) {
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }
}
