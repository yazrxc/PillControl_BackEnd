package pe.edu.upc.demopillcontrol.servicesinterfaces;

import pe.edu.upc.demopillcontrol.entities.RolUsuario;

import java.util.List;

public interface IRolUsuarioService {

    List<RolUsuario> list();

    void insert(RolUsuario r);

    RolUsuario listId(int idApp);

    void update(RolUsuario r);

    void delete(int idrol);

    List<RolUsuario> listarPortipo(String rol);
}
