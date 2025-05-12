package pe.edu.upc.demopillcontrol.servicesinplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demopillcontrol.entities.Usuario;
import pe.edu.upc.demopillcontrol.repositories.IUsuarioRepository;
import pe.edu.upc.demopillcontrol.servicesinterfaces.IUsuarioService;

import java.util.List;
@Service
public class UsuarioServiceImplement implements IUsuarioService {
    @Autowired
    private IUsuarioRepository uR;

    @Override
    public List<Usuario> listar() {
        return uR.findAll();
    }

    @Override
    public Usuario listarId(int idUsuario) {
        return uR.findById(idUsuario).orElse(new Usuario());
    }

    @Override
    public void insertar(Usuario u) {
        uR.save(u);
    }

    @Override
    public void modificar(Usuario u) {
        uR.save(u);
    }

    @Override
    public void eliminar(int idUsuario) {
        uR.deleteById(idUsuario);
    }

    @Override
    public List<Usuario> buscarPorCorreo(String correoUsuario) {
        return uR.buscarPorCorreo(correoUsuario);
    }

    @Override
    public List<Usuario> listarRoles(int idUsuario) {
        return uR.listarRoles(idUsuario);
    }

    @Override
    public Double obtenerEdadPromedioPorEspecialista(int idEspecialista) {
        return uR.obtenerEdadPromedioPorEspecialista(idEspecialista);
    }
}
