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

    @GetMapping("/{idmedicamentoFarmacia}")
    public MedicamentoFarmaciaDTO listarPorId(@PathVariable("idmedicamentoFarmacia") int idmedicamentoFarmacia) {
        ModelMapper m = new ModelMapper();
        MedicamentoFarmacia medicamentoFarmacia = mfS.listId(idmedicamentoFarmacia);
        return m.map(medicamentoFarmacia, MedicamentoFarmaciaDTO.class);
    }

    //Querys
    @GetMapping("/cantidad-tipo-venta")
    public List<QueryMedicamentoPorTipoVentaDTO> obtenerCantidadPorTipoVenta (){
        return  mfS.obtenerCantidadPorTipoVenta();
    }

    @GetMapping("/medicamento-farmacia")
    public List<QueryFarmaciaMedicamentoDTO> obtenerMedicamentosPorFarmacia (){
        return  mfS.obtenerMedicamentosPorFarmacia();
    }

    @GetMapping("/economico")
    public List<QueryFarmaciaStockEconomicoDTO> obtenerFarmaciasConStockEconomico (@RequestParam Long minCantidad, @RequestParam Double maxPrecio){
        return  mfS.obtenerFarmaciasConStockEconomico(minCantidad,maxPrecio);
    }
}
