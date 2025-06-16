package pe.edu.upc.demopillcontrol.servicesinplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demopillcontrol.dtos.NotificacionDTO;
import pe.edu.upc.demopillcontrol.dtos.NotificacionPorFechaDTO;
import pe.edu.upc.demopillcontrol.dtos.NotificacionesPorUsuarioDTO;
import pe.edu.upc.demopillcontrol.entities.Notificacion;
import pe.edu.upc.demopillcontrol.entities.RolUsuario;
import pe.edu.upc.demopillcontrol.repositories.INotificacionRepository;
import pe.edu.upc.demopillcontrol.servicesinterfaces.INotificacionService;

import java.sql.Date;
import java.util.List;
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
    public void update(Notificacion n) {
        nR.save(n);
    }
    @Override
    public void delete(int idNotificacion) {
        nR.deleteById(idNotificacion);
    }
    @Override
    public List<Notificacion> list() {
        return nR.findAll();
    }

    @Override
    public List<Notificacion> getbyEstado(Boolean estado) {
        return nR.getByEstado(estado);
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
