package pe.edu.upc.phill_control.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.phill_control.entities.Rol_Usuario;
import pe.edu.upc.phill_control.repositories.IRol_UsuarioRepository;
import pe.edu.upc.phill_control.serviceinterfaces.IRol_UsuarioService;

import java.util.List;

@Service
public class Rol_UsuarioServiceImplement implements IRol_UsuarioService {
    @Autowired
    private IRol_UsuarioRepository rR;
    @Override
    public List<Rol_Usuario> list() {
        return rR.findAll();
    }

    @Override
    public void insert(Rol_Usuario r) {rR.save(r);}

    @Override
    public void update(Rol_Usuario r) {rR.save(r);}

    @Override
    public void delete(int idRol) {rR.deleteById(idRol);}
}
