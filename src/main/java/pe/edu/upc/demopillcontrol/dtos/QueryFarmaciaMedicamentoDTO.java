package pe.edu.upc.demopillcontrol.dtos;

public class QueryFarmaciaMedicamentoDTO {
    //Ver lista de farmacias con su nombre, dirección y la cantidad total de medicamentos que tienen
    private String nombreFarmacia;
    private String direccion;
    private Long totalMedicamentos;

    public QueryFarmaciaMedicamentoDTO() {}
    public QueryFarmaciaMedicamentoDTO(String nombreFarmacia, String direccion, Long totalMedicamentos) {
        this.nombreFarmacia = nombreFarmacia;
        this.direccion = direccion;
        this.totalMedicamentos = totalMedicamentos;
    }

    public String getNombreFarmacia() {
        return nombreFarmacia;
    }

    public void setNombreFarmacia(String nombreFarmacia) {
        this.nombreFarmacia = nombreFarmacia;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Long getTotalMedicamentos() {
        return totalMedicamentos;
    }

    public void setTotalMedicamentos(Long totalMedicamentos) {
        this.totalMedicamentos = totalMedicamentos;
    }
}
