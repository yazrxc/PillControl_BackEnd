package pe.edu.upc.demopillcontrol.servicesinplement;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demopillcontrol.dtos.DetalleRecetaSegunUsuarioDTO;
import pe.edu.upc.demopillcontrol.dtos.DosisIntervaloSegunMedicamentoDTO;
import pe.edu.upc.demopillcontrol.dtos.HoraIngerirMedicamentoDTO;
import pe.edu.upc.demopillcontrol.entities.DetalleReceta;
import pe.edu.upc.demopillcontrol.entities.Medicamento;
import pe.edu.upc.demopillcontrol.repositories.IDetalleRecetaRepository;
import pe.edu.upc.demopillcontrol.servicesinterfaces.IDetalleRecetaService;
import pe.edu.upc.demopillcontrol.servicesinterfaces.INotificacionService;

import java.sql.Time;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DetalleRecetaServiceImplement implements IDetalleRecetaService {

    @Autowired
    private IDetalleRecetaRepository drR;
    @Autowired
    private INotificacionService nS;

    @Override
    public void insert(DetalleReceta dr) {
        drR.save(dr);
    }

    @Override
    public DetalleReceta listId(int idDetalleReceta) {
        return drR.findById(idDetalleReceta).orElse(new DetalleReceta());
    }

    @Override
    public void update(DetalleReceta dr) {
        drR.save(dr);
    }
    @Override
    @Transactional
    public void delete(int id) {
        nS.deleteByDetalleRecetaId(id); // Línea crítica
        drR.deleteById(id);
    }

    @Override
    public List<HoraIngerirMedicamentoDTO> getNombreYHoraMedicamento() {
        List<Object[]> resultados = drR.getNombreYHoraMedicamento();

        return resultados.stream()
                .map(r -> new HoraIngerirMedicamentoDTO(
                        (String) r[0],
                        ((Time) r[1]).toLocalTime()  // Si es Time, convertirlo a LocalTime
                ))
                .collect(Collectors.toList());
    }

    @Override
    public List<DosisIntervaloSegunMedicamentoDTO> getDosisEIntervalobyMedicamento() {
        List<Object[]> resultados = drR.getDosisEIntervalobyMedicamento();

        return resultados.stream()
                .map(r -> new DosisIntervaloSegunMedicamentoDTO(
                        (String) r[0],
                        (Integer) r[1],
                        (Integer) r[2]
                ))
                .collect(Collectors.toList());
    }

    @Override
    public List<String[]> getMedicamentosByGravedadDiagnostico(int id_usuario) {
        return drR.getMedicamentosByGravedadDiagnostico(id_usuario);
    }


    @Override
    public List<DetalleRecetaSegunUsuarioDTO> getDetalleRecetaByUsuario(int idUsuario, String nombre) {
        return drR.getDetalleRecetaByUsuario(idUsuario, nombre);
    }

    @Override
    public List<DetalleReceta> list() {
        return drR.findAll();
    }
}
