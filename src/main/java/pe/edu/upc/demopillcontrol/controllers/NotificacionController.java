package pe.edu.upc.demopillcontrol.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pe.edu.upc.demopillcontrol.dtos.MedicamentosByGravedadDTO;
import pe.edu.upc.demopillcontrol.dtos.NotificacionDTO;
import pe.edu.upc.demopillcontrol.dtos.NotificacionPorFechaDTO;
import pe.edu.upc.demopillcontrol.dtos.NotificacionesPorUsuarioDTO;
import pe.edu.upc.demopillcontrol.entities.DetalleReceta;
import pe.edu.upc.demopillcontrol.entities.Notificacion;
import pe.edu.upc.demopillcontrol.servicesinplement.NotificacionServiceImplement;
import pe.edu.upc.demopillcontrol.servicesinterfaces.INotificacionService;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notificaciones")
public class NotificacionController {

    @Autowired
    private INotificacionService nS;

    //actualizado
    @GetMapping
    public ResponseEntity<List<NotificacionDTO>> listar() {
        return new ResponseEntity<>(nS.list(), HttpStatus.OK);
    }

    //actualizado
    @PostMapping
    public ResponseEntity<Void> insertar(@RequestBody NotificacionDTO dto) {
        Notificacion n = new Notificacion();

        // Mapeo manual
        n.setIdNotificacion(dto.getIdNotificacion());
        n.setEstadoNotificacion(dto.getEstadoNotificacion());
        n.setMensajeNotificacion(dto.getMensajeNotificacion());

        if (dto.getIdDetalleReceta() != 0) {
            DetalleReceta dr = new DetalleReceta();
            dr.setIdDetalleReceta(dto.getIdDetalleReceta());
            n.setDetallereceta(dr);
        }

        System.out.println("Notificación a guardar: " + n);
        System.out.println("Detalle recibido: " + n.getDetallereceta().getIdDetalleReceta());

        nS.insert(n);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //actualizado
    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizar(@PathVariable("id") int id, @RequestBody NotificacionDTO dto) {
        System.out.println("🔧 Actualizando notificación ID: " + id);
        System.out.println("Estado: " + dto.getEstadoNotificacion());
        System.out.println("Mensaje: " + dto.getMensajeNotificacion());
        System.out.println("ID DetalleReceta: " + dto.getIdDetalleReceta());

        if (dto.getIdDetalleReceta() == 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El detalle de receta es obligatorio");
        }
        Notificacion n = new Notificacion();
        n.setIdNotificacion(id);  // ← el ID se toma de la URL
        n.setEstadoNotificacion(dto.getEstadoNotificacion());
        n.setMensajeNotificacion(dto.getMensajeNotificacion());

        // Relación con DetalleReceta
        DetalleReceta dr = new DetalleReceta();
        dr.setIdDetalleReceta(dto.getIdDetalleReceta());
        n.setDetallereceta(dr);

        nS.update(n);  // ← solo se actualiza lo necesario
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{idNotificacion}")
    public void eliminar(@PathVariable("idNotificacion") int idNotificacion) {
        nS.delete(idNotificacion);
    }

    //actualizado
    @GetMapping("/{id}")
    public ResponseEntity<NotificacionDTO> listarPorId(@PathVariable("id") int id) {
        Notificacion notificacion = nS.listarPorId(id); // ✔ método correctamente nombrado
        if (notificacion == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        NotificacionDTO dto = new NotificacionDTO();
        dto.setIdNotificacion(notificacion.getIdNotificacion());
        dto.setEstadoNotificacion(notificacion.getEstadoNotificacion());
        dto.setMensajeNotificacion(notificacion.getMensajeNotificacion());

        // Agregamos manualmente el idDetalleReceta si está presente
        if (notificacion.getDetallereceta() != null) {
            dto.setIdDetalleReceta(notificacion.getDetallereceta().getIdDetalleReceta());
        }
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/notificaciones/estado")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<Notificacion> obtenerPorEstado(@RequestParam boolean estado) {
        return nS.getbyEstado(estado);
    }

    @GetMapping("/notificaciones-usuario/{nombre}")
    @PreAuthorize("hasAnyAuthority('PACIENTE', 'ADMIN')")
    public List<NotificacionesPorUsuarioDTO> obtenerNotificacionesPorNombre(@PathVariable("nombre") String nombre) {
        return nS.getNotificacionByNombre(nombre).stream().map(x -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, NotificacionesPorUsuarioDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/notificaciones-fecha/{fechaInicioReceta}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<NotificacionPorFechaDTO> obtenerNotificacionesPorFecha(
            @PathVariable("fechaInicioReceta") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicioReceta) {
        return nS.getNotificacionByFecha(Date.valueOf(fechaInicioReceta));
    }
}
