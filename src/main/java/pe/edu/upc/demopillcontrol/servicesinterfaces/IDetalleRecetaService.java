package pe.edu.upc.demopillcontrol.servicesinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.demopillcontrol.dtos.DetalleRecetaSegunUsuarioDTO;
import pe.edu.upc.demopillcontrol.dtos.DosisIntervaloSegunMedicamentoDTO;
import pe.edu.upc.demopillcontrol.dtos.HoraIngerirMedicamentoDTO;
import pe.edu.upc.demopillcontrol.entities.DetalleReceta;
import pe.edu.upc.demopillcontrol.entities.Medicamento;

import java.util.List;

public interface IDetalleRecetaService {
    public List<DetalleReceta> list();
    public void insert(DetalleReceta dr);
    public DetalleReceta listId(int idDetalleReceta);
    public void update(DetalleReceta dr);
    public void delete(int idDetalleReceta);
    //public List<DetalleReceta> buscarPorReceta(int idReceta);

    public List<HoraIngerirMedicamentoDTO> getNombreYHoraMedicamento();
    public List<DosisIntervaloSegunMedicamentoDTO> getDosisEIntervalobyMedicamento();
    public List<Medicamento> getMedicamentosByGravedadDiagnostico(int id_usuario);
    public List<DetalleRecetaSegunUsuarioDTO> getDetalleRecetaByUsuario(int idUsuario, String nombre);
}
