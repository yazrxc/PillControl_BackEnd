package pe.edu.upc.demopillcontrol.servicesinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.demopillcontrol.entities.Medicamento;

import java.util.List;


public interface IMedicamentoService {
    public List<Medicamento> listarMedicamentos();
    public void insertar(Medicamento m);
    public void eliminar(int id);
    public Medicamento listarporID(int id);
    public void modificar(Medicamento m);

    public List<Medicamento> listarPorNombre(String nombre);
    public List<Medicamento> listarPorPresentacion(String presentacion);
}
