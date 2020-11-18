package com.remington.estudiantes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EstudianteService {

    private final EstudianteRepository estudianteRepository;

    @Autowired
    public EstudianteService(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    public HttpStatus crearEstudiante(Estudiante estudiante) {
        if (estudianteRepository.existsById(estudiante.getCedula())) {
            throw new EstudianteException(
                    HttpStatus.BAD_REQUEST, "El estudiante ya esxiste"
            );
        }
        estudianteRepository.save(estudiante);
        return HttpStatus.CREATED;
    }

    public Iterable<Estudiante> obtenerEstudiantes() {

        return estudianteRepository.findAll();
    }

    public Estudiante obtenerEstudiante(Long cedula) {

        Optional<Estudiante> estudianteObtenido = estudianteRepository.findById(cedula);

        if (estudianteObtenido.isPresent()) {
            return estudianteObtenido.get();
        } else {
            throw new EstudianteException(
                    HttpStatus.NOT_FOUND, "El estudiante no existe"
            );
        }
    }

    public HttpStatus eliminarEstudiante(Long cedula) {
        try {
            estudianteRepository.deleteById(cedula);
        } catch (EmptyResultDataAccessException ex) {
            throw new EstudianteException(
                    HttpStatus.NOT_FOUND, "El estudiante a eliminar no existe"
            );
        }

        return HttpStatus.OK;
    }

    public HttpStatus actualizarEstudiante(Estudiante estudiante) {

        if (estudianteRepository.existsById(estudiante.getCedula())) {
            estudianteRepository.save(estudiante);
            return HttpStatus.OK;
        }else {
            throw new EstudianteException(
                    HttpStatus.NOT_FOUND, "El estudiante no existe"
            );
        }

    }

    public Iterable<Estudiante> mejoresEstudiantes() {

        return estudianteRepository.ordernarPorMayorPromedio();
    }
}
