package pe.edu.upc.phill_control.serviceinterfaces;

import pe.edu.upc.phill_control.entities.Rol_Usuario;

import java.util.List;

public interface IRol_UsuarioService {
    public List<Rol_Usuario> list();
    public void insert(Rol_Usuario r);
    public void update(Rol_Usuario r);
    public void delete(int idRol);
}
