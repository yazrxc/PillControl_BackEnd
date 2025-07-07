package pe.edu.upc.demopillcontrol.servicesinterfaces;

import pe.edu.upc.demopillcontrol.dtos.QueryFarmaciaMedicamentoDTO;
import pe.edu.upc.demopillcontrol.dtos.QueryFarmaciaStockEconomicoDTO;
import pe.edu.upc.demopillcontrol.dtos.QueryMedicamentoPorTipoVentaDTO;
import pe.edu.upc.demopillcontrol.entities.MedicamentoFarmacia;

import java.util.List;

public interface IMedicamentoFarmaciaService {
    public List<MedicamentoFarmacia> list();
    public void insert(MedicamentoFarmacia mf);
    public MedicamentoFarmacia listId(int idmedicamentoFarmacia);
    public void update(MedicamentoFarmacia mf);
    public void delete(int idmedicamentoFarmacia);
    //public List<MedicamentoFarmacia> buscarPorCantidad(int cantidadMedicamentoFarmacia);


    //Querys
    public List<QueryMedicamentoPorTipoVentaDTO>  obtenerCantidadPorTipoVenta();
    public List<QueryFarmaciaMedicamentoDTO> obtenerMedicamentosPorFarmacia();
    public List<QueryFarmaciaStockEconomicoDTO> obtenerFarmaciasConStockEconomico(Long minCantidad, Double maxPrecio);

}
