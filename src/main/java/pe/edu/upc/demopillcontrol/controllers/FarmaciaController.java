package pe.edu.upc.demopillcontrol.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demopillcontrol.dtos.FarmaciaDTO;
import pe.edu.upc.demopillcontrol.dtos.QueryFarmaciaHorarioDTO;
import pe.edu.upc.demopillcontrol.dtos.QueryFarmaciaUbicacionDTO;
import pe.edu.upc.demopillcontrol.dtos.VerificarHorarioFarmaciaDTO;
import pe.edu.upc.demopillcontrol.entities.Farmacia;
import pe.edu.upc.demopillcontrol.servicesinterfaces.IFarmaciaService;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/farmacias")
public class FarmaciaController {

    @Autowired
    private IFarmaciaService fS;

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void insertar(@RequestBody FarmaciaDTO fDTO) {
        ModelMapper m=new ModelMapper();
        Farmacia f=m.map(fDTO,Farmacia.class);
        fS.insert(f);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void actualizar(@RequestBody FarmaciaDTO fDTO) {
        ModelMapper m=new ModelMapper();
        Farmacia f=m.map(fDTO,Farmacia.class);
        fS.update(f);
    }

    @DeleteMapping("/{idFarmacia}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("idFarmacia") int idFarmacia) {
        fS.delete(idFarmacia);
    }

    @GetMapping()
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<FarmaciaDTO> listar() {
        return fS.list().stream().map( x ->{
            ModelMapper m=new ModelMapper();
            return m.map(x,FarmaciaDTO.class);
        }).collect(Collectors.toList());
    }

    //verificar
    @GetMapping("/verificar-horario/{idFarmacia}")
    public List<VerificarHorarioFarmaciaDTO> obtenerFarmaciaPorId(@PathVariable Long idFarmacia) {
        return fS.obtenerFarmaciaPorId(idFarmacia);
    }
    //buscar por Nombre
    @GetMapping("/buscar/{nombre}")
    public Farmacia obtenerFarmaciaPorNombre(@PathVariable String nombre) {
        return fS.obtenerFarmaciaPorNombre(nombre);
    }

    //Querys
    @GetMapping("/farmacias-abren-temprano")
    public List<QueryFarmaciaHorarioDTO> obtenerFarmaciasQueAbrenTemprano(@RequestParam String horaApertura) {
        LocalTime hora = LocalTime.parse(horaApertura);
        return fS.obtenerFarmaciasQueAbrenTemprano(hora);
    }
    @GetMapping("/ubicaciones")
    public List<QueryFarmaciaUbicacionDTO> obtenerUbicacionesDeFarmacias (){
        return  fS.obtenerUbicacionesDeFarmacias();
    }
}
