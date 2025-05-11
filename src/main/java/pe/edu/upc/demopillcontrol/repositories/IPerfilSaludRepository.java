package pe.edu.upc.demopillcontrol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.demopillcontrol.entities.Diagnostico;
import pe.edu.upc.demopillcontrol.entities.PerfilSalud;

import java.util.List;

@Repository
public interface IPerfilSaludRepository extends JpaRepository<PerfilSalud, Integer> {

    @Query(value = "SELECT u.nombre AS paciente_nombre, \n" +
            "       ps.gruposanguineo AS grupo_sanguineo\n" +
            "FROM Usuario u\n" +
            "JOIN PerfilSalud ps ON u.idUsuario = ps.idUsuario\n" +
            "WHERE u.idUsuario = id_usuario", nativeQuery = true)
    List<PerfilSalud> buscargruposanguineo(@Param("id_usuario") int id_usuario);

    @Query(value="SELECT u.nombre AS paciente_nombre, \n" +
            "       ps.condiciones AS condiciones_medicas\n" +
            "FROM PerfilSalud ps\n" +
            "JOIN Usuario u ON ps.id_Usuario = u.id_Usuario\n" +
            "WHERE ps.id_Usuario = id_usuario; ",nativeQuery = true)
    List<PerfilSalud> buscarcondiciones(@Param("id_usuario") int id_usuario);

    @Query(value ="SELECT \n" +
            "    u.nombre, ps.peso, ps.altura, ps.gruposanguineo,u.telefono_usuario,ROUND((ps.peso / POWER(ps.altura / 100.0, 2))::numeric, 2) AS IMC,\n" +
            "    CASE \n" +
            "        WHEN (ps.peso / POWER(ps.altura / 100.0, 2)) < 18.5 THEN 'Bajo peso'\n" +
            "        WHEN (ps.peso / POWER(ps.altura / 100.0, 2)) >= 18.5 AND (ps.peso / POWER(ps.altura / 100.0, 2)) <= 24.99 THEN 'Peso normal'\n" +
            "        WHEN (ps.peso / POWER(ps.altura / 100.0, 2)) >= 25.0 AND (ps.peso / POWER(ps.altura / 100.0, 2)) <= 29.99 THEN 'Pre-obesidad o Sobrepeso'\n" +
            "        WHEN (ps.peso / POWER(ps.altura / 100.0, 2)) >= 30.0 AND (ps.peso / POWER(ps.altura / 100.0, 2)) <= 34.99 THEN 'Obesidad clase I'\n" +
            "        WHEN (ps.peso / POWER(ps.altura / 100.0, 2)) >= 35.0 AND (ps.peso / POWER(ps.altura / 100.0, 2)) <= 39.99 THEN 'Obesidad clase II'\n" +
            "        WHEN (ps.peso / POWER(ps.altura / 100.0, 2)) >= 40.0 THEN 'Obesidad clase III'\n" +
            "        ELSE 'Desconocido'\n" +
            "    END AS Categoria_IMC,\n" +
            "    u.fecha_Registro_Usuario\n" +
            "FROM Perfil_Salud ps\n" +
            "JOIN Usuario u ON u.id_Usuario = ps.id_Usuario\n" +
            "WHERE \n" +
            "    EXTRACT(MONTH FROM u.fecha_Registro_Usuario) =:mes\n" +
            "    AND EXTRACT(YEAR FROM u.fecha_Registro_Usuario) =:anio;",nativeQuery = true)
    List<String[]> listperfilPorMesYAnio(@Param("mes") int mes, @Param("anio") int anio);
}
