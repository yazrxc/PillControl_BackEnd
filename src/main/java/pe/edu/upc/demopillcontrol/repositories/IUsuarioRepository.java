package pe.edu.upc.demopillcontrol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.demopillcontrol.entities.Usuario;

import java.util.List;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    @Query(value = "select * from usuario where correo_usuario like %:correo", nativeQuery = true)
    List<Usuario> buscarPorCorreo(@Param("correo") String correo);

    public Usuario findOneByUsername(String username);

    //BUSCAR POR NOMBRE
    @Query("select count(u.username) from Usuario u where u.username =:username")
    public int buscarUsername(@Param("username") String nombre);


    //INSERTAR ROLES
    @Transactional
    @Modifying
    @Query(value = "insert into RolUsuario (tiporol, idUsuario) VALUES (:tiporol, :idUsuario)", nativeQuery = true)
    public void insRol(@Param("tiporol") String authority, @Param("idUsuario") int idUsuario);

    @Query(value = "SELECT AVG(edad_usuario) FROM usuario WHERE id_especialista= :idEspecialista", nativeQuery = true)
    Double obtenerEdadPromedioPorEspecialista(@Param("idEspecialista") int idEspecialista);

}

