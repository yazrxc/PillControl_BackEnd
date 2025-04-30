package pe.edu.upc.demopillcontrol.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demopillcontrol.dtos.PerfilSaludDTO;
import pe.edu.upc.demopillcontrol.entities.ContactoEmergencia;
import pe.edu.upc.demopillcontrol.entities.PerfilSalud;
import pe.edu.upc.demopillcontrol.servicesinterfaces.IPerfilSaludService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/perfiles")
public class PerfilSaludController {
    @Autowired
    private IPerfilSaludService pS;

    @GetMapping
    public List<PerfilSaludDTO> listar(){
        return pS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, PerfilSaludDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void registrar(@RequestBody PerfilSaludDTO pDTO) {
        ModelMapper m = new ModelMapper();
        PerfilSalud p = m.map(pDTO, PerfilSalud.class);
        pS.insert(p);
    }
    @PutMapping
    public void modificar(@RequestBody PerfilSaludDTO pDTO) {
        ModelMapper m = new ModelMapper();
        PerfilSalud p = m.map(pDTO, PerfilSalud.class);
        pS.update(p);
    }

    @DeleteMapping("/{idPerfilSalud}")
    public void eliminar(@PathVariable("idPerfilSalud") int idPerfilSalud) {
        pS.delete(idPerfilSalud);
    }
}
