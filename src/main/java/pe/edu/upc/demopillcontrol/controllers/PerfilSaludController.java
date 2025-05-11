package pe.edu.upc.demopillcontrol.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demopillcontrol.dtos.PerfilSaludDTO;
import pe.edu.upc.demopillcontrol.dtos.PerfilTimeDTO;
import pe.edu.upc.demopillcontrol.dtos.TratamientoDTO;
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
    public List<PerfilSaludDTO> listar(){
        return pS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, PerfilSaludDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void registrar(@RequestBody PerfilSaludDTO pDTO) {
        ModelMapper m = new ModelMapper();
        PerfilSalud p = m.map(pDTO, PerfilSalud.class);
        pS.insert(p);
    }
    @PutMapping
    public void modificar(@RequestBody PerfilSaludDTO pDTO) {
        ModelMapper m = new ModelMapper();
        PerfilSalud p = m.map(pDTO, PerfilSalud.class);
        pS.update(p);
    }

    @DeleteMapping("/{idPerfilSalud}")
    public void eliminar(@PathVariable("idPerfilSalud") int idPerfilSalud) {
        pS.delete(idPerfilSalud);
    }

    @GetMapping("/{idPerfilSaludgruposanguineo}")
    public List<PerfilSaludDTO> buscargruposanguineo(@RequestParam int id_usuario) {
        return pS.buscargruposanguineo(id_usuario).stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,PerfilSaludDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/{idPerfilSaludcondiciones}")
    public List<PerfilSaludDTO> buscarcondiciones(@RequestParam int id_usuario) {
        return pS.buscarcondiciones(id_usuario).stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,PerfilSaludDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/timesperfiles")
    public List<PerfilTimeDTO> listperfilPorMesYAnio(@RequestParam int mes, @RequestParam int anio) {
        List<PerfilTimeDTO> dtoLista = new ArrayList<>();
        // Llamada al repositorio para obtener los resultados de la consulta SQL
        List<String[]> filaLista = pS.listperfilPorMesYAnio(mes, anio);
        // Recorremos cada fila de resultados y la mapeamos a PerfilTimeDTO
        for (String[] columna : filaLista) {
            PerfilTimeDTO dto = new PerfilTimeDTO();
            // Asignamos los valores de la fila a las propiedades del DTO
            dto.setNombre(columna[0]); // columna[0] -> nombre
            dto.setPeso(Double.parseDouble(columna[1])); // columna[1] -> peso
            dto.setAltura(Double.parseDouble(columna[2])); // columna[2] -> altura
            dto.setGrupoSanguineo(columna[3]); // columna[3] -> grupo sanguíneo
            dto.setTelefonoUsuario(columna[4]); // columna[4] -> teléfono (ajustado al orden correcto)
            dto.setImc(Double.parseDouble(columna[5])); // columna[5] -> imc
            dto.setCategoriaImc(columna[6]); // columna[6] -> categoría IMC
            dto.setFechaRegistro(java.sql.Date.valueOf(columna[7]).toLocalDate());
            // Agregamos el DTO a la lista
            dtoLista.add(dto);
        }
        // Devolvemos la lista de DTOs
        return dtoLista;
    }
}

