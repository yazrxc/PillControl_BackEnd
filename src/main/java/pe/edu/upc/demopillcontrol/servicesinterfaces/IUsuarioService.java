package pe.edu.upc.demopillcontrol.servicesinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.demopillcontrol.entities.Usuario;

import java.util.List;

public interface IUsuarioService {
    public List<Usuario> listar();

    public Usuario listarId(int idUsuario);

    public void insertar(Usuario u);

    public void modificar(Usuario u);

    public void eliminar(int idUsuario);

    public List<Usuario> buscarPorCorreo(String correoUsuario);

    // Querys
    Double obtenerEdadPromedioPorEspecialista(int idEspecialista);
}
