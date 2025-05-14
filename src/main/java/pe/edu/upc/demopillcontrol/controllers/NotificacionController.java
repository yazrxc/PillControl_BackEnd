package pe.edu.upc.demopillcontrol.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demopillcontrol.dtos.MedicamentosByGravedadDTO;
import pe.edu.upc.demopillcontrol.dtos.NotificacionDTO;
import pe.edu.upc.demopillcontrol.dtos.NotificacionesPorUsuarioDTO;
import pe.edu.upc.demopillcontrol.entities.Notificacion;
import pe.edu.upc.demopillcontrol.servicesinplement.NotificacionServiceImplement;
import pe.edu.upc.demopillcontrol.servicesinterfaces.INotificacionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notificaciones")
public class NotificacionController {

    @Autowired
    private INotificacionService nS;

    @PostMapping
    public void insertar(@RequestBody NotificacionDTO nDTO) {
        ModelMapper m=new ModelMapper();
        Notificacion n=m.map(nDTO,Notificacion.class);
        nS.insert(n);
    }

    @PutMapping
    public void actualizar(@RequestBody NotificacionDTO nDTO) {
        ModelMapper m=new ModelMapper();
        Notificacion n=m.map(nDTO,Notificacion.class);
        nS.update(n);
    }

    @DeleteMapping("/{idNotificacion}")
    public void eliminar(@PathVariable("idNotificacion") int idNotificacion) {
        nS.delete(idNotificacion);
    }

    @GetMapping()
    public List<NotificacionDTO> listar() {
        return nS.list().stream().map( x ->{
            ModelMapper m=new ModelMapper();
            return m.map(x,NotificacionDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/notificaciones-usuario/{nombre}")
    @PreAuthorize("hasAnyAuthority('PACIENTE', 'ADMIN')")
    public List<NotificacionesPorUsuarioDTO> obtenerNotificacionesPorNombre(@PathVariable("nombre") String nombre) {
        return nS.getNotificacionByNombre(nombre).stream().map(x -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, NotificacionesPorUsuarioDTO.class);
        }).collect(Collectors.toList());
    }
}
