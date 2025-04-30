package pe.edu.upc.demopillcontrol.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demopillcontrol.dtos.FarmaciaDTO;
import pe.edu.upc.demopillcontrol.entities.Farmacia;
import pe.edu.upc.demopillcontrol.servicesinterfaces.IFarmaciaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/farmacias")
public class FarmaciaController {

    @Autowired
    private IFarmaciaService fS;

    @PostMapping
    public void insertar(@RequestBody FarmaciaDTO fDTO) {
        ModelMapper m=new ModelMapper();
        Farmacia f=m.map(fDTO,Farmacia.class);
        fS.insert(f);
    }

    @PutMapping
    public void actualizar(@RequestBody FarmaciaDTO fDTO) {
        ModelMapper m=new ModelMapper();
        Farmacia f=m.map(fDTO,Farmacia.class);
        fS.update(f);
    }

    @DeleteMapping("/{idFarmacia}")
    public void eliminar(@PathVariable("idFarmacia") int idFarmacia) {
        fS.delete(idFarmacia);
    }

    @GetMapping()
    public List<FarmaciaDTO> listar() {
        return fS.list().stream().map( x ->{
            ModelMapper m=new ModelMapper();
            return m.map(x,FarmaciaDTO.class);
        }).collect(Collectors.toList());
    }
}
