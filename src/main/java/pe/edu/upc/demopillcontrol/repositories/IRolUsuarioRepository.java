package pe.edu.upc.demopillcontrol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.demopillcontrol.entities.RolUsuario;
import pe.edu.upc.demopillcontrol.entities.Usuario;

import java.util.List;
@Repository
public interface IRolUsuarioRepository extends JpaRepository<RolUsuario, Integer> {
    // listar por tipo
    @Query(value = "SELECT r FROM RolUsuario r WHERE r.tiporol LIKE %:rol%" )
    public List<RolUsuario> listarPortipo(@Param("rol") String rol);

    // conteo de usuarios según el tipo de rol
    @Query(value = "SELECT COUNT(*) FROM rol_usuario WHERE tiporol ILIKE CONCAT('%', :tiporol, '%')", nativeQuery = true)
    int contarUsuariosPorRol(@Param("tiporol") String tiporol);

}
