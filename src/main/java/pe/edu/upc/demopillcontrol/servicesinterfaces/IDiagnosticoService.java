package pe.edu.upc.demopillcontrol.servicesinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.demopillcontrol.entities.Diagnostico;
import pe.edu.upc.demopillcontrol.entities.Medicamento;

import java.time.LocalDate;
import java.util.List;
import java.util.spi.LocaleNameProvider;

public interface IDiagnosticoService {
    // registrar
    public void registrar(Diagnostico d);

    // modificar
    public void modificar (Diagnostico d);

    // eliminar
    public void eliminar (int idDiagnostico);

    // listar
    public List<Diagnostico> listar();

    // Ver diagnóstico por usuario
    List<Diagnostico> findDiagnosticosByUsuarioId(int id_usuario);

    // Buscar diagnóstico por fecha
    public List<Diagnostico> findByFechaEmision(LocalDate fecha);
}
