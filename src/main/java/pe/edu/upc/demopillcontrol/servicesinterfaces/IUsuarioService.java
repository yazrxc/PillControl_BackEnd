package pe.edu.upc.demopillcontrol.servicesinterfaces;

import pe.edu.upc.demopillcontrol.entities.Usuario;

import java.util.List;

public interface IUsuarioService {
    public List<Usuario> listar();
    public void insertar(Usuario u);
    public void modificar(Usuario u);
    public void eliminar(int idUsuario);
    public List<Usuario> buscarPorCorreo(String correoUsuario);
    public List<Usuario> listarRoles(int idUsuario);
}
