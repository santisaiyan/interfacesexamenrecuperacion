package org.example.santiexameninterfaces;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Alumno {
    private Integer id;
    private String nombre;
    private String apellido;
    private Double AD;
    private Double SGE;
    private Double DI;
    private Double PMDM;
    private Double PSP;
    private Double EIE;
    private Double HLC;
    private Double MEDIA;
}
