package pe.edu.upc.demopillcontrol.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<RolUsuarioDTO> listar() {
        return rS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, RolUsuarioDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void registrar(@RequestBody RolUsuarioDTO rDTO) {
        ModelMapper m = new ModelMapper();
        RolUsuario r = m.map(rDTO, RolUsuario.class);
        rS.insert(r);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody RolUsuarioDTO rDTO) {
        ModelMapper m = new ModelMapper();
        RolUsuario r = m.map(rDTO, RolUsuario.class);
        rS.update(r);
    }

    @DeleteMapping("/{idrol}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("idrol") int idrol) {
        rS.delete(idrol);
    }

    @GetMapping("/{idrol}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public RolUsuarioDTO listarId(@PathVariable("idrol") int idrol) {
        ModelMapper m = new ModelMapper();
        RolUsuarioDTO dto = m.map(rS.listId(idrol), RolUsuarioDTO.class);
        return dto;
    }

    @GetMapping("/busqueda-tiporol")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<RolUsuarioDTO> listarPortipo(@RequestParam String n) {
        return rS.listarPortipo(n).stream().map(x -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, RolUsuarioDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/conteo-tiporol")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Integer> contarPorRol(@RequestParam String n) {
        int cantidad = rS.contarPorRol(n);
        return ResponseEntity.ok(cantidad);
    }
}
