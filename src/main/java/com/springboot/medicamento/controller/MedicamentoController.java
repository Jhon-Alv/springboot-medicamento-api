package com.springboot.medicamento.controller;

import com.springboot.medicamento.model.Medicamento;
import com.springboot.medicamento.service.MedicamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(originPatterns = "*")
@RequestMapping(path = "/api/medicamentos")
public class MedicamentoController {

    @Autowired
    private MedicamentoService medicamentoService;

    @GetMapping
    public List<Medicamento> obtenerListaMedicamentos(){
        return medicamentoService.obtenerListaMedicamentos();
    }

    @GetMapping("/{id}")
    public Medicamento obtenerMedicamento(@PathVariable Integer id){
        Optional<Medicamento> optional = medicamentoService.obtenerMedicamentoPorId(id);
        return optional.orElse(null);
    }

    @PostMapping
    public Medicamento crearMedicamento(@RequestBody Medicamento medicamento){
        return medicamentoService.crearMedicamento(medicamento);
    }

    @PutMapping("/{id}")
    public Medicamento actualizarMedicamento(@PathVariable Integer codigo, @RequestBody Medicamento medicamento){
        return medicamentoService.actualizarMedicamento(codigo, medicamento);
    }

    @DeleteMapping("/{id}")
    public void eliminarMedicamento(@PathVariable Integer codigo){
        medicamentoService.eliminarModicamento(codigo);
    }

}
