package pe.edu.upc.demopillcontrol.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demopillcontrol.dtos.TratamientoDTO;
import pe.edu.upc.demopillcontrol.entities.Tratamiento;
import pe.edu.upc.demopillcontrol.servicesinterfaces.ITratamientoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tratamientos")
public class TratamientoController {

    @Autowired
    private ITratamientoService tS;


    @GetMapping
    public List<TratamientoDTO> listar() {
        return tS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, TratamientoDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/{idTratamiento}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public TratamientoDTO listarId(@PathVariable("idTratamiento") int idTratamiento) {
        ModelMapper m = new ModelMapper();
        TratamientoDTO dto = m.map(tS.listarId(idTratamiento), TratamientoDTO.class);
        return dto;
    }

    @PostMapping
    public void insertar(@RequestBody TratamientoDTO tDTO) {
        ModelMapper m = new ModelMapper();
        Tratamiento t = m.map(tDTO, Tratamiento.class);
        tS.insert(t);
    }

    @PutMapping
    public void actualizar(@RequestBody TratamientoDTO tDTO) {
        ModelMapper m = new ModelMapper();
        Tratamiento t = m.map(tDTO, Tratamiento.class);
        tS.update(t);
    }

    @DeleteMapping("/{idTratamiento}")
    public void eliminar(@PathVariable("idTratamiento") int idTratamiento) {
        tS.delete(idTratamiento);
    }


    @GetMapping("/tratamientoporestado")
    public List<TratamientoDTO> listarPorEstado(@RequestParam String estado) {
        return tS.listarPorEstado(estado).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, TratamientoDTO.class);
        }).collect(Collectors.toList());
    }
    //Query
    @GetMapping("/tratamientosusuario")
    public List<TratamientoDTO> listarPorUsuario(@RequestParam int idUsuario) {
        return tS.listarPorUsuario(idUsuario).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, TratamientoDTO.class);
        }).collect(Collectors.toList());
    }
}
