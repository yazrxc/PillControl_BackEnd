package pe.edu.upc.demopillcontrol.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demopillcontrol.dtos.RecetaDTO;
import pe.edu.upc.demopillcontrol.entities.Receta;
import pe.edu.upc.demopillcontrol.servicesinterfaces.IRecetaService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/recetas")
public class RecetaController {

    @Autowired
    private IRecetaService rS;

    @PostMapping
    public void insertar(@RequestBody RecetaDTO rDTO) {
        ModelMapper m=new ModelMapper();
        Receta r=m.map(rDTO,Receta.class);
        rS.insert(r);
    }

    @PutMapping
    public void actualizar(@RequestBody RecetaDTO rDTO) {
        ModelMapper m=new ModelMapper();
        Receta r=m.map(rDTO,Receta.class);
        rS.update(r);
    }

    @DeleteMapping("/{idReceta}")
    public void eliminar(@PathVariable("idReceta") int idReceta) {
        rS.delete(idReceta);
    }

    @GetMapping()
    public List<RecetaDTO> listar() {
        return rS.list().stream().map( x ->{
            ModelMapper m=new ModelMapper();
            return m.map(x,RecetaDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/busquedas-por-id")
    public List<RecetaDTO> findRecetasByUsuarioId(@RequestParam("id_usuario") int id_usuario){
        return rS.findRecetasByUsuarioId(id_usuario).stream().map( x ->{
            ModelMapper m=new ModelMapper();
            return m.map(x,RecetaDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/busquedas-por-fecha-inicio")
    public List<RecetaDTO> findByFechaInicioReceta(@RequestParam("fecha_inicio_receta") LocalDate fecha_inicio_receta){
        return rS.findByFechaInicioReceta(fecha_inicio_receta).stream().map( x ->{
            ModelMapper m=new ModelMapper();
            return m.map(x,RecetaDTO.class);
        }).collect(Collectors.toList());
    }
}
