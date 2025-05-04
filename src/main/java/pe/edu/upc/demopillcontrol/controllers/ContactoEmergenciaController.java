package pe.edu.upc.demopillcontrol.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demopillcontrol.dtos.ContactoEmergenciaDTO;
import pe.edu.upc.demopillcontrol.entities.ContactoEmergencia;
import pe.edu.upc.demopillcontrol.servicesinterfaces.IContactoEmergenciaService;

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
}
