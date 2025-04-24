package pe.edu.upc.phill_control.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.phill_control.dtos.Rol_UsuarioDTO;
import pe.edu.upc.phill_control.entities.Rol_Usuario;
import pe.edu.upc.phill_control.serviceinterfaces.IRol_UsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/roles")
public class Rol_UsuarioController {
    @Autowired
    private IRol_UsuarioService rS;

    @GetMapping
    public List<Rol_UsuarioDTO> listar(){
        return rS.list().stream().map(x->{
                ModelMapper m = new ModelMapper();
        return m.map(x, Rol_UsuarioDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void registrar(@RequestBody Rol_UsuarioDTO rDTO) {
        ModelMapper m = new ModelMapper();
        Rol_Usuario r = m.map(rDTO, Rol_Usuario.class);
        rS.insert(r);
    }
    @PutMapping
    public void modificar(@RequestBody Rol_UsuarioDTO rDTO) {
        ModelMapper m = new ModelMapper();
        Rol_Usuario r = m.map(rDTO, Rol_Usuario.class);
        rS.update(r);
    }
    @DeleteMapping("/{idRol}")
    public void eliminar(@PathVariable("idRol") int idRol) {
        rS.delete(idRol);
    }

}
