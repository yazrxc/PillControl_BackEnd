package pe.edu.upc.demopillcontrol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.demopillcontrol.dtos.QueryFarmaciaMedicamentoDTO;
import pe.edu.upc.demopillcontrol.dtos.QueryFarmaciaStockEconomicoDTO;
import pe.edu.upc.demopillcontrol.dtos.QueryMedicamentoPorTipoVentaDTO;
import pe.edu.upc.demopillcontrol.entities.MedicamentoFarmacia;

import java.util.List;

@Repository
public interface IMedicamentoFarmaciaRepository extends JpaRepository<MedicamentoFarmacia,Integer> {

    //Ver cantidad total de medicamentos por tipo de venta en todas las farmacias
    @Query("SELECT new pe.edu.upc.demopillcontrol.dtos.QueryMedicamentoPorTipoVentaDTO(mf.tipoVentaMedicamentoFarmacia, SUM(mf.cantidadMedicamentoFarmacia)) " +
            "FROM MedicamentoFarmacia mf " +
            "GROUP BY mf.tipoVentaMedicamentoFarmacia")
    List<QueryMedicamentoPorTipoVentaDTO> obtenerCantidadPorTipoVenta();


    //Ver lista de farmacias con su nombre, dirección y la cantidad total de medicamentos que tienen
    @Query("SELECT new pe.edu.upc.demopillcontrol.dtos.QueryFarmaciaMedicamentoDTO(f.nombreFarmacia, f.direccionFarmacia, SUM(mf.cantidadMedicamentoFarmacia)) " +
            "FROM MedicamentoFarmacia mf JOIN mf.farmacia f " +
            "GROUP BY f.nombreFarmacia, f.direccionFarmacia")
    List<QueryFarmaciaMedicamentoDTO> obtenerMedicamentosPorFarmacia();

    //Obtener farmacias que tengan medicamentos con una cantidad mínima y un precio máximo
    @Query("SELECT new pe.edu.upc.demopillcontrol.dtos.QueryFarmaciaStockEconomicoDTO(f.nombreFarmacia, f.direccionFarmacia, mf.cantidadMedicamentoFarmacia, mf.precioMedicamentoFarmacia) " +
            "FROM MedicamentoFarmacia mf " +
            "JOIN mf.farmacia f " +
            "WHERE mf.cantidadMedicamentoFarmacia >= :minCantidad AND mf.precioMedicamentoFarmacia <= :maxPrecio")
    List<QueryFarmaciaStockEconomicoDTO> obtenerFarmaciasConStockEconomico(
            @Param("minCantidad") Long minCantidad,
            @Param("maxPrecio") Double maxPrecio);
}
