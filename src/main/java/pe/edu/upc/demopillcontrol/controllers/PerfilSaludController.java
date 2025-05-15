package pe.edu.upc.demopillcontrol.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demopillcontrol.dtos.*;
import pe.edu.upc.demopillcontrol.entities.PerfilSalud;
import pe.edu.upc.demopillcontrol.servicesinterfaces.IPerfilSaludService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/perfiles")
public class PerfilSaludController {
    @Autowired
    private IPerfilSaludService pS;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<PerfilSaludDTO> listar(){
        return pS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, PerfilSaludDTO.class);
        }).collect(Collectors.toList());
    }


    @PostMapping
    @PreAuthorize("hasAnyAuthority('PACIENTE', 'ADMIN')")
    public void registrar(@RequestBody PerfilSaludDTO pDTO) {
        ModelMapper m = new ModelMapper();
        PerfilSalud p = m.map(pDTO, PerfilSalud.class);
        pS.insert(p);
    }


    @PutMapping
    @PreAuthorize("hasAnyAuthority('PACIENTE', 'ADMIN')")
    public void modificar(@RequestBody PerfilSaludDTO pDTO) {
        ModelMapper m = new ModelMapper();
        PerfilSalud p = m.map(pDTO, PerfilSalud.class);
        pS.update(p);
    }
    @GetMapping("/{idPerfilSalud}")
    @PreAuthorize("hasAnyAuthority('PACIENTE', 'ADMIN')")
    public PerfilSaludDTO listarId(@PathVariable("idPerfilSalud") int idPerfilSalud) {
        ModelMapper m = new ModelMapper();
        PerfilSaludDTO dto = m.map(pS.listId(idPerfilSalud), PerfilSaludDTO.class);
        return dto;
    }

    @DeleteMapping("/{idPerfilSalud}")
    @PreAuthorize("hasAnyAuthority('PACIENTE', 'ADMIN')")
    public void eliminar(@PathVariable("idPerfilSalud") int idPerfilSalud) {
        pS.delete(idPerfilSalud);
    }


    @GetMapping("/idgruposanguineo")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<GruposanguineoDTO> buscargruposanguineo(@RequestParam int idUsuario) {
        List<GruposanguineoDTO> dtoLista = new ArrayList<>();
        List<String[]> filaLista = pS.buscargruposanguineo(idUsuario);
        for (String[] columna : filaLista) {
            GruposanguineoDTO dto = new GruposanguineoDTO();
            dto.setNombre(columna[0]);
            dto.setGruposanguineo(columna[1]);
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @GetMapping("/condicionesid")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<BuscarCondicionesDTO> buscarcondiciones(@RequestParam int idUsuario) {
        List<BuscarCondicionesDTO> dtoLista = new ArrayList<>();
        List<String[]> filaLista = pS.buscarcondiciones(idUsuario);
        for (String[] columna : filaLista) {
            BuscarCondicionesDTO dto = new BuscarCondicionesDTO();
            dto.setNombre(columna[0]);
            dto.setCondiciones(columna[1]);
            dtoLista.add(dto);
        }
        return dtoLista;
    }


    @GetMapping("/timesperfiles")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<PerfilTimeDTO> listperfilPorMesYAnio(@RequestParam int mes, @RequestParam int anio) {
        List<PerfilTimeDTO> dtoLista = new ArrayList<>();
        // Llamada al repositorio para obtener los resultados de la consulta SQL
        List<String[]> filaLista = pS.listperfilPorMesYAnio(mes, anio);
        // Recorremos cada fila de resultados y la mapeamos a PerfilTimeDTO
        for (String[] columna : filaLista) {
            PerfilTimeDTO dto = new PerfilTimeDTO();
            dto.setNombre(columna[0]); // columna[0] -> nombre
            dto.setPeso(Double.parseDouble(columna[1])); // columna[1] -> peso
            dto.setAltura(Double.parseDouble(columna[2])); // columna[2] -> altura
            dto.setGrupoSanguineo(columna[3]); // columna[3] -> grupo sanguíneo
            dto.setTelefonoUsuario(columna[4]); // columna[4] -> teléfono
            dto.setImc(Double.parseDouble(columna[5])); // columna[5] -> imc
            dto.setCategoriaImc(columna[6]); // columna[6] -> categoría IMC
            dto.setFechaRegistro(java.sql.Date.valueOf(columna[7]).toLocalDate());
            dtoLista.add(dto);
        }
        return dtoLista;
    }
}

