package pe.edu.upc.demopillcontrol.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demopillcontrol.dtos.MedicamentoFarmaciaDTO;
import pe.edu.upc.demopillcontrol.dtos.QueryFarmaciaMedicamentoDTO;
import pe.edu.upc.demopillcontrol.dtos.QueryFarmaciaStockEconomicoDTO;
import pe.edu.upc.demopillcontrol.dtos.QueryMedicamentoPorTipoVentaDTO;
import pe.edu.upc.demopillcontrol.entities.MedicamentoFarmacia;
import pe.edu.upc.demopillcontrol.servicesinterfaces.IMedicamentoFarmaciaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/medicamentosfarmacias")
public class MedicamentoFarmaciaController {

    @Autowired
    private IMedicamentoFarmaciaService mfS;

    @PostMapping
    public void insertar(@RequestBody MedicamentoFarmaciaDTO mfDTO) {
        ModelMapper m=new ModelMapper();
        MedicamentoFarmacia mf=m.map(mfDTO,MedicamentoFarmacia.class);
        mfS.insert(mf);
    }

    @PutMapping
    public void actualizar(@RequestBody MedicamentoFarmaciaDTO mfDTO) {
        ModelMapper m=new ModelMapper();
        MedicamentoFarmacia mf=m.map(mfDTO,MedicamentoFarmacia.class);
        mfS.update(mf);
    }

    @DeleteMapping("/{idmedicamentoFarmacia}")
    public void eliminar(@PathVariable("idmedicamentoFarmacia") int idmedicamentoFarmacia) {
        mfS.delete(idmedicamentoFarmacia);
    }

    @GetMapping("/Listar")
    public List<MedicamentoFarmaciaDTO> listar() {
        return mfS.list().stream().map( x ->{
            ModelMapper m=new ModelMapper();
            return m.map(x,MedicamentoFarmaciaDTO.class);
        }).collect(Collectors.toList());
    }

    //Querys
    @GetMapping("/cantidad-tipo-venta")
    public List<QueryMedicamentoPorTipoVentaDTO> obtenerCantidadPorTipoVenta (){
        return  mfS.obtenerCantidadPorTipoVenta();
    }

    @GetMapping("/medicamento-farmacia")
    public List<QueryFarmaciaMedicamentoDTO> obtenerMedicamentoFarmacia (){
        return  mfS.obtenerMedicamentoFarmacia();
    }

    @GetMapping("/economico")
    public List<QueryFarmaciaStockEconomicoDTO> obtenerFarmaciasConStockEconomico (Long minCantidad, Double maxPrecio){
        return  mfS.obtenerFarmaciasConStockEconomico(minCantidad,maxPrecio);
    }
}
