package pe.edu.upc.demopillcontrol.servicesinplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demopillcontrol.entities.RolUsuario;
import pe.edu.upc.demopillcontrol.repositories.IRolUsuarioRepository;
import pe.edu.upc.demopillcontrol.servicesinterfaces.IRolUsuarioService;

import java.util.List;

@Service
public class RolUsuarioServiceImplement implements IRolUsuarioService {
    @Autowired
    private IRolUsuarioRepository rR;

    @Override
    public List<RolUsuario> list() {
        return rR.findAll();
    }
    @Override
    public void insert(RolUsuario r) {
        rR.save(r);
    }

    @Override
    public RolUsuario listId(int idrol) {
        return rR.findById(idrol).orElse(new RolUsuario());
    }

    @Override
    public void update(RolUsuario r) {
        rR.save(r);
    }

    @Override
    public void delete(int idrol) {
        rR.deleteById(idrol);
    }

    @Override
    public List<RolUsuario> listarPortipo(String rol) {
        return rR.listarPortipo(rol);
    }
}
