package pe.edu.upc.demopillcontrol.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demopillcontrol.dtos.AlertaSinContactoGravedadAltaDTO;
import pe.edu.upc.demopillcontrol.dtos.ContactoEmergenciaDTO;
import pe.edu.upc.demopillcontrol.entities.ContactoEmergencia;
import pe.edu.upc.demopillcontrol.servicesinterfaces.IContactoEmergenciaService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/contactos")
public class ContactoEmergenciaController {
    @Autowired
    private IContactoEmergenciaService cS;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<ContactoEmergenciaDTO> listar(){
        return cS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, ContactoEmergenciaDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    @PreAuthorize("hasAnyAuthority('PACIENTE', 'ADMIN')")
    public void registrar(@RequestBody ContactoEmergenciaDTO cDTO) {
        ModelMapper m = new ModelMapper();
        ContactoEmergencia c = m.map(cDTO, ContactoEmergencia.class);
        cS.insert(c);
    }

    @GetMapping("/{idContactoEmergencia}")
    @PreAuthorize("hasAnyAuthority('PACIENTE', 'ADMIN')")
    public ContactoEmergenciaDTO listarId(@PathVariable("idContactoEmergencia") int idContactoEmergencia) {
        ModelMapper m = new ModelMapper();
        ContactoEmergenciaDTO dto = m.map(cS.listId(idContactoEmergencia), ContactoEmergenciaDTO.class);
        return dto;
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('PACIENTE', 'ADMIN')")
    public void modificar(@RequestBody ContactoEmergenciaDTO cDTO) {
        ModelMapper m = new ModelMapper();
        ContactoEmergencia c = m.map(cDTO, ContactoEmergencia.class);
        cS.update(c);
    }

    @DeleteMapping("/{idContactoEmergencia}")
    @PreAuthorize("hasAnyAuthority('PACIENTE', 'ADMIN')")
    public void eliminar(@PathVariable("idContactoEmergencia") int idContactoEmergencia) {
        cS.delete(idContactoEmergencia);
    }

    @GetMapping("/busquedascontactos")
    @PreAuthorize("hasAnyAuthority('PACIENTE', 'ADMIN')")
    public List<ContactoEmergenciaDTO> buscarPorNombre(@RequestParam String nombre) {
        return cS.buscarPorNombrecontacto(nombre).stream().map(x -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, ContactoEmergenciaDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/riesgoaltasincontactos")
    public List<AlertaSinContactoGravedadAltaDTO> listarUsuariosConDiagnosticoGraveSinContacto() {
        List<AlertaSinContactoGravedadAltaDTO> dtoLista = new ArrayList<>();
        List<String[]> filaLista = cS.listarUsuariosConDiagnosticoGraveSinContacto();
        for (String[] columna : filaLista) {
            AlertaSinContactoGravedadAltaDTO dto = new AlertaSinContactoGravedadAltaDTO();
            dto.setId_Usuario(Integer.parseInt(columna[0]));      // u.id_Usuario
            dto.setNombre_Usuario(columna[1]);                    // u.nombre
            dto.setEdad_Usuario(Integer.parseInt(columna[2]));    // u.edad_Usuario
            dto.setDiagnostico(columna[3]);                       // d.nombre
            dto.setGravedad(columna[4]);                          // d.gravedad
            dto.setAlergias(columna[5]);                          // ps.alergias
            dto.setCondiciones(columna[6]);                       // ps.condiciones
            dto.setNombre_Contacto(columna[7]);                   // ce.nombre
            dto.setTelefono_Contacto(columna[8]);                 // ce.telefono
            dtoLista.add(dto);
        }
        return dtoLista;
    }

}
