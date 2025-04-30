package pe.edu.upc.demopillcontrol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.demopillcontrol.entities.Medicamento;
import pe.edu.upc.demopillcontrol.entities.RolUsuario;

import java.util.List;

public interface IRolUsuarioRepository extends JpaRepository<RolUsuario, Integer> {
    // listar por tipo
    @Query(value = "SELECT r FROM RolUsuario r WHERE r.tiporol LIKE %:rol%" )
    public List<RolUsuario> listarPortipo(@Param("rol") String rol);
}
