package pe.edu.upc.demopillcontrol.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demopillcontrol.dtos.*;
import pe.edu.upc.demopillcontrol.entities.DetalleReceta;
import pe.edu.upc.demopillcontrol.entities.Medicamento;
import pe.edu.upc.demopillcontrol.entities.Receta;
import pe.edu.upc.demopillcontrol.servicesinterfaces.IDetalleRecetaService;
import pe.edu.upc.demopillcontrol.servicesinterfaces.INotificacionService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/detallesrecetas")
public class DetalleRecetaController {

    @Autowired
    private IDetalleRecetaService drS;
    @Autowired
    private INotificacionService nS; // <--- este es el que falta

    @PostMapping
    @PreAuthorize("hasAnyAuthority('PACIENTE', 'ADMIN')")
    public ResponseEntity<Void> insertar(@RequestBody DetalleRecetaDTO drDTO) {
        DetalleReceta dr = new DetalleReceta();

        dr.setDosisDetalleReceta(drDTO.getDosisDetalleReceta());
        dr.setHoraDetalleReceta(drDTO.getHoraDetalleReceta());
        dr.setIntervaloDetalleReceta(drDTO.getIntervaloDetalleReceta());
        dr.setFrecuenciaDetalleReceta(drDTO.getFrecuenciaDetalleReceta());

        // Asignar receta solo con el id (asumiendo que existe)
        Receta receta = new Receta();
        receta.setIdReceta(drDTO.getReceta().getIdReceta());
        dr.setReceta(receta);

        // Asignar medicamento solo con el id (asumiendo que existe)
        Medicamento medicamento = new Medicamento();
        medicamento.setId_medicamento(drDTO.getMedicamento().getId_medicamento());
        dr.setMedicamento(medicamento);

        drS.insert(dr);
        return new ResponseEntity<>(HttpStatus.CREATED);
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

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('PACIENTE', 'ADMIN')")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) {
        try {
            nS.deleteByDetalleRecetaId(id); // 1. Elimina notificaciones
            drS.delete(id);                 // 2. Luego elimina el detalle receta
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping()
    @PreAuthorize("hasAnyAuthority('PACIENTE', 'ADMIN')")
    public List<DetalleRecetaDTO> listar() {
        return drS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, DetalleRecetaDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/horas-medicamentos")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<HoraIngerirMedicamentoDTO> obtenerHorasYMedicamentos() {
        return drS.getNombreYHoraMedicamento();
    }

    @GetMapping("/dosis-intervalos")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<DosisIntervaloSegunMedicamentoDTO> obtenerDosisEIntervalos() {
        return drS.getDosisEIntervalobyMedicamento();
    }

    @GetMapping("/busquedas-medicamentos-graves/{id_usuario}")
    @PreAuthorize("hasAnyAuthority('PACIENTE', 'ADMIN')")
    public List<MedicamentosByGravedadDTO> medicamentosByGravedad(@PathVariable("id_usuario") int id_usuario) {
        List<MedicamentosByGravedadDTO> dtoLista = new ArrayList<>();
        List<String[]> filaLista = drS.getMedicamentosByGravedadDiagnostico(id_usuario);
        for (String[] columna : filaLista) {
            MedicamentosByGravedadDTO dto = new MedicamentosByGravedadDTO();
            dto.setNombreMedicamento(columna[0]);
            dto.setTipoMedicamento(columna[1]);
            dto.setNombreDiagnostico(columna[2]);
            dtoLista.add(dto);
        }
        return dtoLista;
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
