package com.remington.estudiantes;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "estudiante")
public class Estudiante {

    @Id
    private final Long cedula;
    public String nombre;
    public Double promedio;

    public Estudiante(Long cedula, String nombre, Double promedio) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.promedio = promedio;
    }

    public Estudiante(){
        this.nombre = "";
        this.cedula = 0l;
        this.promedio = 0.0;
    }

    public Long getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
