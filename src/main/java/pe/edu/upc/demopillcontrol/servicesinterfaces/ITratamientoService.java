package pe.edu.upc.demopillcontrol.servicesinterfaces;

import pe.edu.upc.demopillcontrol.entities.Tratamiento;

import java.util.List;

public interface ITratamientoService {
    public List<Tratamiento> list();

    public Tratamiento listarId(int idTratamiento);

    public void insert(Tratamiento t);

    public void update(Tratamiento t);

    public void delete(int idTratamiento);

    public List<Tratamiento> listarPorEstado(String estadoTratamiento);

    public List<Tratamiento> listarPorUsuario(int idUsuario);

    // QUERY N1
    public List<Tratamiento> listarActivosPorEspecialista(int idEspecialista);
}
