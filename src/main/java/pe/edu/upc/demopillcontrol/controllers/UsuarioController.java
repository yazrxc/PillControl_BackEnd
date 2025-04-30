package pe.edu.upc.demopillcontrol.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demopillcontrol.dtos.UsuarioDTO;
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
    public List<UsuarioDTO> listar() {
        return uS.listar().stream().map(x->{
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, UsuarioDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void insertar(@RequestBody UsuarioDTO uDto){
        ModelMapper modelMapper = new ModelMapper();
        Usuario u = modelMapper.map(uDto,Usuario.class);
        uS.insertar(u);
    }

    @PutMapping
    public void modificar(@RequestBody UsuarioDTO uDto){
        ModelMapper m = new ModelMapper();
        Usuario u = m.map(uDto,Usuario.class);
        uS.modificar(u);
    }

    @DeleteMapping("/{idUsuario}")
    public void eliminar(@PathVariable ("idUsuario") int idUsuario){
        uS.eliminar(idUsuario);
    }

    @GetMapping("/busquedascorreo")
    public List<UsuarioDTO> buscarCorreo(@RequestParam String correo){
        return uS.buscarPorCorreo(correo).stream().map(x ->{
            ModelMapper m = new ModelMapper();
            return m.map(x,UsuarioDTO.class);
        }).collect(Collectors.toList());
    }
}
