package pe.edu.upc.demopillcontrol.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demopillcontrol.dtos.UsuarioDTO;
import pe.edu.upc.demopillcontrol.dtos.UsuariologinDTO;
import pe.edu.upc.demopillcontrol.entities.Usuario;
import pe.edu.upc.demopillcontrol.servicesinterfaces.IUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private IUsuarioService uS;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")

    public List<UsuariologinDTO> listar() {
        return uS.listar().stream().map(x -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, UsuariologinDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/{idUsuario}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public UsuarioDTO listarId(@PathVariable("idUsuario") int idUsuario) {
        ModelMapper m = new ModelMapper();
        UsuarioDTO dto = m.map(uS.listarId(idUsuario), UsuarioDTO.class);
        return dto;
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('PACIENTE', 'ADMIN')")
    public void insertar(@RequestBody UsuariologinDTO uDto){
        ModelMapper modelMapper = new ModelMapper();
        Usuario u = modelMapper.map(uDto, Usuario.class);
        uS.insertar(u);
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('PACIENTE', 'ADMIN')")
    public void modificar(@RequestBody UsuariologinDTO uDto){
        ModelMapper m = new ModelMapper();
        Usuario u = m.map(uDto, Usuario.class);
        uS.modificar(u);
    }

    @DeleteMapping("/{idUsuario}")
    @PreAuthorize("hasAnyAuthority('PACIENTE', 'ADMIN')")
    public void eliminar(@PathVariable("idUsuario") int idUsuario) {
        uS.eliminar(idUsuario);
    }

    @GetMapping("/busquedascorreo")
    @PreAuthorize("hasAnyAuthority('PACIENTE', 'ADMIN')")
    public List<UsuarioDTO> buscarCorreo(@RequestParam String correo) {
        return uS.buscarPorCorreo(correo).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UsuarioDTO.class);
        }).collect(Collectors.toList());
    }

    //Query
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/edadpromedioUsuarioEspecialista")
    public ResponseEntity<Double> edadPromedioPorEspecialista(@RequestParam int idEspecialista) {
        return new ResponseEntity<>(uS.obtenerEdadPromedioPorEspecialista(idEspecialista), HttpStatus.OK);
    }
}
