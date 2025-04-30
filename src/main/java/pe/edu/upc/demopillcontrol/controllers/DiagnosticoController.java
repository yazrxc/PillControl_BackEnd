package pe.edu.upc.demopillcontrol.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demopillcontrol.dtos.DiagnosticoDTO;
import pe.edu.upc.demopillcontrol.entities.Diagnostico;
import pe.edu.upc.demopillcontrol.servicesinterfaces.IDiagnosticoService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/diagnosticos")
public class DiagnosticoController {

    @Autowired
    private IDiagnosticoService dS;

    @PostMapping
    public void registrar(@RequestBody DiagnosticoDTO dDTO) {
        ModelMapper m=new ModelMapper();
        Diagnostico d=m.map(dDTO,Diagnostico.class);
        dS.registrar(d);
    }

    @PutMapping
    public void modificar(@RequestBody DiagnosticoDTO dDTO) {
        ModelMapper m=new ModelMapper();
        Diagnostico d=m.map(dDTO,Diagnostico.class);
        dS.modificar(d);
    }

    @DeleteMapping("/{idDiagnostico}")
    public void eliminar(@PathVariable("idDiagnostico") int idDiagnostico) {
        dS.eliminar(idDiagnostico);
    }

    @GetMapping()
    public List<DiagnosticoDTO> listar() {
        return dS.listar().stream().map( x ->{
            ModelMapper m=new ModelMapper();
            return m.map(x,DiagnosticoDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/{idDiagnostico}")
    public List<DiagnosticoDTO> findDiagnosticosByUsuarioId(@RequestParam int idUsuario) {
        return dS.findDiagnosticosByUsuarioId(idUsuario).stream().map( x ->{
            ModelMapper m=new ModelMapper();
            return m.map(x,DiagnosticoDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/fechas")
    public List<DiagnosticoDTO> findByFechaEmision(@RequestParam LocalDate f) {
        return dS.findByFechaEmision(f).stream().map( x ->{
            ModelMapper m=new ModelMapper();
            return m.map(x,DiagnosticoDTO.class);
        }).collect(Collectors.toList());
    }

}
