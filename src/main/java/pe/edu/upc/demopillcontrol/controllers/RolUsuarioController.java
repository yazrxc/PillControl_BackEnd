package pe.edu.upc.demopillcontrol.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demopillcontrol.dtos.RolUsuarioDTO;
import pe.edu.upc.demopillcontrol.entities.RolUsuario;
import pe.edu.upc.demopillcontrol.servicesinterfaces.IRolUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/roles")
public class RolUsuarioController {
    @Autowired
    private IRolUsuarioService rS;

    @GetMapping
    public List<RolUsuarioDTO> listar(){
        return rS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,RolUsuarioDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void registrar(@RequestBody RolUsuarioDTO rDTO) {
        ModelMapper m = new ModelMapper();
        RolUsuario r = m.map(rDTO, RolUsuario.class);
        rS.insert(r);
    }

    @GetMapping("/{idrol}")
    public RolUsuarioDTO listarId(@PathVariable("idrol") int idrol) {
        ModelMapper m = new ModelMapper();
        RolUsuarioDTO dto = m.map(rS.listId(idrol), RolUsuarioDTO.class);
        return dto;
    }

    @PutMapping
    public void modificar(@RequestBody RolUsuarioDTO rDTO) {
        ModelMapper m = new ModelMapper();
        RolUsuario r = m.map(rDTO, RolUsuario.class);
        rS.update(r);
    }

    @DeleteMapping("/{idrol}")
    public void eliminar(@PathVariable("idrol") int idrol) {
        rS.delete(idrol);
    }

    @GetMapping("/busqueda-tiporol")
    public List<RolUsuarioDTO> listarPortipo(@RequestParam String n) {
        return rS.listarPortipo(n).stream().map(x -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, RolUsuarioDTO.class);
        }).collect(Collectors.toList());
    }
}
