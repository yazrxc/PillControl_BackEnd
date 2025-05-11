package pe.edu.upc.demopillcontrol.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demopillcontrol.dtos.MedicamentoDTO;
import pe.edu.upc.demopillcontrol.dtos.MedicamentosByGravedadDTO;
import pe.edu.upc.demopillcontrol.entities.Medicamento;
import pe.edu.upc.demopillcontrol.servicesinterfaces.IMedicamentoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/medicamentos")
public class MedicamentoController {

    @Autowired
    private IMedicamentoService mS;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('PACIENTE', 'ADMIN')")
    public List<MedicamentoDTO> listarMedicamentos() {
        return mS.listarMedicamentos().stream().map( x->{
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(x,MedicamentoDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('PACIENTE', 'ADMIN')")
    public void insertar(@RequestBody MedicamentoDTO mDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Medicamento m = modelMapper.map(mDTO, Medicamento.class);
        mS.insertar(m);
    }

    @DeleteMapping("/{id_medicamento}")
    @PreAuthorize("hasAnyAuthority('PACIENTE', 'ADMIN')")
    public void eliminar(@PathVariable("id_medicamento") int id_medicamento) {
        mS.eliminar(id_medicamento);
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('PACIENTE', 'ADMIN')")
    public void modificar(@RequestBody MedicamentoDTO mDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Medicamento m = modelMapper.map(mDTO, Medicamento.class);
        mS.modificar(m);
    }

    @GetMapping("/busqueda-nombres")
    @PreAuthorize("hasAnyAuthority('PACIENTE', 'ADMIN')")
    public List<MedicamentoDTO> listarPorNombre(@RequestParam String n) {
        return mS.listarPorNombre(n).stream().map( x->{
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x,MedicamentoDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/busquedas-presentaciones")
    @PreAuthorize("hasAnyAuthority('PACIENTE', 'ADMIN')")
    public List<MedicamentoDTO> listarPorPresentacion(@RequestParam String n) {
        return mS.listarPorPresentacion(n).stream().map( x->{
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x,MedicamentoDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/busquedas-medicamentos-graves/{id_usuario}")
    @PreAuthorize("hasAnyAuthority('PACIENTE', 'ADMIN')")
    public List<MedicamentosByGravedadDTO> listarPorPresentacion(@PathVariable("id_usuario") int id_usuario) {
        return mS.getMedicamentosByGravedadDiagnostico(id_usuario).stream().map( x->{
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x,MedicamentosByGravedadDTO.class);
        }).collect(Collectors.toList());
    }

}
