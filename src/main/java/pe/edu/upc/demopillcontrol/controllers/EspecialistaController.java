package pe.edu.upc.demopillcontrol.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demopillcontrol.dtos.EspecialistaDTO;
import pe.edu.upc.demopillcontrol.entities.Especialista;
import pe.edu.upc.demopillcontrol.servicesinterfaces.IEspecialistaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/especialista")
public class EspecialistaController {

    @Autowired
    private IEspecialistaService eS;

    @GetMapping
    public List<EspecialistaDTO> listar() {
        return eS.list().stream().map(x->{
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, EspecialistaDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void insertar(@RequestBody EspecialistaDTO eDto){
        ModelMapper modelMapper = new ModelMapper();
        Especialista e = modelMapper.map(eDto,Especialista.class);
        eS.insert(e);
    }
    @GetMapping("/{idEspecialista}")
    public EspecialistaDTO listarId(@PathVariable ("idEspecialista") int idEspecialista){
        ModelMapper m = new ModelMapper();
        EspecialistaDTO dto=m.map(eS.listId(idEspecialista),EspecialistaDTO.class);
        return dto;
    }
    @PutMapping
    public void modificar(@RequestBody EspecialistaDTO eDto){
        ModelMapper m = new ModelMapper();
        Especialista e = m.map(eDto,Especialista.class);
        eS.update(e);
    }

    @DeleteMapping("/{idEspecialista}")
    public void eliminar(@PathVariable ("idEspecialista") int idEspecialista){
        eS.delete(idEspecialista);
    }

}
