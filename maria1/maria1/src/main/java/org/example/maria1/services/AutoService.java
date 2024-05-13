package org.example.maria1.services;

import org.example.maria1.model.Auto;

import java.util.Optional;

public interface AutoService {


    Iterable<Auto> listarAuto();
    Optional<Auto> obtenerPorId(Long id);
    Auto crear(Auto auto);
    Auto actualizar(Long id, Auto auto);
    void eliminar(Long id);
}
