package pe.edu.upc.luiserik.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.luiserik.dto.FarmaciaDTO;
import pe.edu.upc.luiserik.entities.Farmacia;
import pe.edu.upc.luiserik.servicesinterfaces.FarmaciaServiceInterfaces;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class FarmaciaController {

    @Autowired
    private FarmaciaServiceInterfaces farmaciaService;


    @GetMapping
    public List<FarmaciaDTO> listar() {
        return farmaciaService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, FarmaciaDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void registrar(@RequestBody FarmaciaDTO farmaciaDTO) {
        ModelMapper m = new ModelMapper();
        Farmacia farmacia = m.map(farmaciaDTO, Farmacia.class);
        farmaciaService.insert(farmacia);
    }
    @PutMapping
    public void modificar(@RequestBody FarmaciaDTO farmaciaDTO) {
        ModelMapper m = new ModelMapper();
        Farmacia farmacia = m.map(farmaciaDTO, Farmacia.class);
        farmaciaService.update(farmacia);
    }
    @DeleteMapping("/{idFarmacia}")
    public void eliminar(@PathVariable("idFarmacia") Long idFarmacia) {
        farmaciaService.delete(idFarmacia);
    }
}
