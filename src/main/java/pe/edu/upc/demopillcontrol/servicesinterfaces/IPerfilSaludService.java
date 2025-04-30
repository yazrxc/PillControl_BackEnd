package pe.edu.upc.demopillcontrol.servicesinterfaces;

import pe.edu.upc.demopillcontrol.entities.PerfilSalud;

import java.util.List;

public interface IPerfilSaludService {
    List<PerfilSalud> list();

    void insert(PerfilSalud p);

    void update(PerfilSalud p);

    void delete(int idPerfilSalud);
}
