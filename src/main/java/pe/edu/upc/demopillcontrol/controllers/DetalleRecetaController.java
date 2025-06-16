package pe.edu.upc.demopillcontrol.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demopillcontrol.dtos.DetalleRecetaDTO;
import pe.edu.upc.demopillcontrol.dtos.DetalleRecetaSegunUsuarioDTO;
import pe.edu.upc.demopillcontrol.dtos.MedicamentoDTO;
import pe.edu.upc.demopillcontrol.dtos.MedicamentosByGravedadDTO;
import pe.edu.upc.demopillcontrol.entities.DetalleReceta;
import pe.edu.upc.demopillcontrol.servicesinterfaces.IDetalleRecetaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/detallesrecetas")
public class DetalleRecetaController {

    @Autowired
    private IDetalleRecetaService drS;

    @PostMapping
    @PreAuthorize("hasAnyAuthority('PACIENTE', 'ADMIN')")
    public void insertar(@RequestBody DetalleRecetaDTO drDTO) {
        ModelMapper m = new ModelMapper();
        DetalleReceta dr = m.map(drDTO, DetalleReceta.class);
        drS.insert(dr);
    }

    @GetMapping("/{idApp}")
    @PreAuthorize("hasAnyAuthority('PACIENTE', 'ADMIN')")
    public DetalleRecetaDTO listarId(@PathVariable("idApp") int idApp) {
        ModelMapper m = new ModelMapper();
        DetalleRecetaDTO dto = m.map(drS.listId(idApp), DetalleRecetaDTO.class);
        return dto;
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('PACIENTE', 'ADMIN')")
    public void actualizar(@RequestBody DetalleRecetaDTO drDTO) {
        ModelMapper m = new ModelMapper();
        DetalleReceta dr = m.map(drDTO, DetalleReceta.class);
        drS.update(dr);
    }

    @DeleteMapping("/{idDetalleReceta}")
    @PreAuthorize("hasAnyAuthority('PACIENTE', 'ADMIN')")
    public void eliminar(@PathVariable("idDetalleReceta") int idDetalleReceta) {
        drS.delete(idDetalleReceta);
    }

    @GetMapping()
    @PreAuthorize("hasAnyAuthority('PACIENTE', 'ADMIN')")
    public List<DetalleRecetaDTO> listar() {
        return drS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, DetalleRecetaDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/busquedas-medicamentos-graves/{id_usuario}")
    @PreAuthorize("hasAnyAuthority('PACIENTE', 'ADMIN')")
    public List<MedicamentosByGravedadDTO> medicamentosGraves(@PathVariable("id_usuario") int id_usuario) {
        return drS.getMedicamentosByGravedadDiagnostico(id_usuario).stream().map(x -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, MedicamentosByGravedadDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/detalle-receta/usuario")
    @PreAuthorize("hasAnyAuthority('PACIENTE', 'ADMIN')")
    public List<DetalleRecetaSegunUsuarioDTO> obtenerDetallesPorUsuario(
            @RequestParam(required = true) int idUsuario,
            @RequestParam(required = true) String nombre
    ) {
        return drS.getDetalleRecetaByUsuario(idUsuario, nombre).stream().map(x -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, DetalleRecetaSegunUsuarioDTO.class);
        }).collect(Collectors.toList());
    }
}
