package pe.edu.upc.demopillcontrol.servicesinplement;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demopillcontrol.dtos.NotificacionDTO;
import pe.edu.upc.demopillcontrol.dtos.NotificacionPorFechaDTO;
import pe.edu.upc.demopillcontrol.dtos.NotificacionesPorUsuarioDTO;
import pe.edu.upc.demopillcontrol.entities.DetalleReceta;
import pe.edu.upc.demopillcontrol.entities.Notificacion;
import pe.edu.upc.demopillcontrol.repositories.INotificacionRepository;
import pe.edu.upc.demopillcontrol.servicesinterfaces.INotificacionService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NotificacionServiceImplement implements INotificacionService {

    @Autowired
    private INotificacionRepository nR;

    @Override
    public void insert(Notificacion n) {
        nR.save(n);
    }
    @Override
    public Notificacion listarPorId(int idNotificacion) {
        return nR.findById(idNotificacion).orElse(null);
    }
    @Override
    public void update(Notificacion n) {
        Optional<Notificacion> opt = nR.findById(n.getIdNotificacion());
        if (opt.isPresent()) {
            Notificacion existente = opt.get();
            existente.setEstadoNotificacion(n.getEstadoNotificacion());
            existente.setMensajeNotificacion(n.getMensajeNotificacion());
            existente.setDetallereceta(n.getDetallereceta());
            nR.save(existente);
        }
    }
    @Override
    public void delete(int idNotificacion) {
        nR.deleteById(idNotificacion);
    }

    @Override
    @Transactional
    public void deleteByDetalleRecetaId(Integer idDetalleReceta) {
        nR.deleteByDetalleRecetaId(idDetalleReceta);
    }

    @Override
    public List<Notificacion> getbyEstado(boolean estado) {
        return nR.findByEstadoNotificacion(estado);
    }

    @Override
    public List<NotificacionDTO> list() {
        List<Notificacion> lista = nR.findAll();
        List<NotificacionDTO> listaDTO = new ArrayList<>();

        for (Notificacion n : lista) {
            NotificacionDTO dto = new NotificacionDTO();
            dto.setIdNotificacion(n.getIdNotificacion());
            dto.setMensajeNotificacion(n.getMensajeNotificacion());
            dto.setEstadoNotificacion(n.getEstadoNotificacion());

            if (n.getDetallereceta() != null) {
                DetalleReceta detalle = n.getDetallereceta();

                // Medicamento
                if (detalle.getMedicamento() != null) {
                    dto.setNombreMedicamento(detalle.getMedicamento().getNombre());
                }

                // Usuario desde receta
                if (detalle.getReceta() != null && detalle.getReceta().getUsuario() != null) {
                    dto.setNombreUsuario(detalle.getReceta().getUsuario().getNombre());
                }
            }
            listaDTO.add(dto);
        }
        return listaDTO;
    }

    @Override
    public List<NotificacionesPorUsuarioDTO> getNotificacionByNombre(String nombre) {
        return nR.getNotificacionByNombre(nombre);
    }

    @Override
    public List<NotificacionPorFechaDTO> getNotificacionByFecha(Date fechaInicioReceta) {
        List<Object[]> resultados = nR.getNotificacionByFecha(fechaInicioReceta);
        return resultados.stream().map(r -> new NotificacionPorFechaDTO(
                (Integer) r[0],
                (Boolean) r[1],
                (String) r[2],
                ((Date) r[3]).toLocalDate()
        )).collect(Collectors.toList());
    }

}
