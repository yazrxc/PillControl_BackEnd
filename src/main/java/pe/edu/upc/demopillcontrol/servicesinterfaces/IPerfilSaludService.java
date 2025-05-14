package pe.edu.upc.demopillcontrol.servicesinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.demopillcontrol.entities.PerfilSalud;

import java.util.List;

public interface IPerfilSaludService {
    List<PerfilSalud> list();

    void insert(PerfilSalud p);

    void update(PerfilSalud p);

    void delete(int idPerfilSalud);

    PerfilSalud listId(int idPerfilSalud);

    List<String[]> buscargruposanguineo(int id_usuario);

    List<String[]> buscarcondiciones(int id_usuario);

    List<String[]> listperfilPorMesYAnio(@Param("mes") int mes, @Param("anio") int anio);
}
