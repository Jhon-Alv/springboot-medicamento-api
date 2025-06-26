package com.springboot.medicamento.service;

import com.springboot.medicamento.model.Medicamento;
import com.springboot.medicamento.repository.MedicamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicamentoService {

    @Autowired
    private MedicamentoRepository medicamentoRepository;

    public Optional<Medicamento> obtenerMedicamentoPorId(Integer codigo){
        return medicamentoRepository.findById(codigo);
    }

    public List<Medicamento> obtenerListaMedicamentos(){
        return medicamentoRepository.findAll();
    }

    public Medicamento crearMedicamento(Medicamento medicamento){
        return medicamentoRepository.save(medicamento);
    }

    public Medicamento actualizarMedicamento(Integer codigo, Medicamento medicamento){
        Optional<Medicamento> optional = medicamentoRepository.findById(codigo);

        if (optional.isPresent()){
            Medicamento medicamentoExistente = optional.get();

            medicamentoExistente.setCodigo(medicamento.getCodigo());
            medicamentoExistente.setNombre(medicamento.getNombre());
            medicamentoExistente.setPrecio(medicamento.getPrecio());
            medicamentoExistente.setStock(medicamento.getStock());

            return medicamentoExistente;
        }else {
            return null;
        }

    }

    public void  eliminarModicamento(Integer codigo){
        medicamentoRepository.deleteById(codigo);
    }


}
