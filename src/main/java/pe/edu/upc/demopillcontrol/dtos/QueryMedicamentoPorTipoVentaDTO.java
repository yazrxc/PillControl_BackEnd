package pe.edu.upc.demopillcontrol.dtos;

public class QueryMedicamentoPorTipoVentaDTO {

    private String tipoVenta;
    private Long cantidadTotal;

    public QueryMedicamentoPorTipoVentaDTO() {}
    public QueryMedicamentoPorTipoVentaDTO(String tipoVenta, Long cantidadTotal) {
        this.tipoVenta = tipoVenta;
        this.cantidadTotal = cantidadTotal;
    }

    public String getTipoVenta() {
        return tipoVenta;
    }

    public void setTipoVenta(String tipoVenta) {
        this.tipoVenta = tipoVenta;
    }

    public Long getCantidadTotal() {
        return cantidadTotal;
    }

    public void setCantidadTotal(Long cantidadTotal) {
        this.cantidadTotal = cantidadTotal;
    }
}
