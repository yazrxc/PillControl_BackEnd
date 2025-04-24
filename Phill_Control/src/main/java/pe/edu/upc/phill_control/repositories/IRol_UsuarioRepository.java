package pe.edu.upc.phill_control.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.phill_control.entities.Rol_Usuario;
public interface IRol_UsuarioRepository extends JpaRepository  <Rol_Usuario, Integer> {
}
