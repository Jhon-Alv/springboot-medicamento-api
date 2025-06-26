package com.springboot.medicamento.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Medicamento {

    @Id
    private Integer codigo;

    private String nombre;

    private Double precio;

    private Integer stock;

}
