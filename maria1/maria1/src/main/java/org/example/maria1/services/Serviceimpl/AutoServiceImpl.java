package org.example.maria1.services.Serviceimpl;

import jakarta.transaction.Transactional;
import org.example.maria1.model.Auto;
import org.example.maria1.repositories.AutoRepository;
import org.example.maria1.services.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class  AutoServiceImpl  implements AutoService {

    private final AutoRepository autoRepository;

    @Autowired
    public AutoServiceImpl(AutoRepository autoRepository) {
        this.autoRepository = autoRepository;
    }

    @Override
    public Iterable<Auto> listarAuto() {
        return autoRepository.findAll();
    }

    @Override
    public Optional<Auto> obtenerPorId(Long id) {
        return autoRepository.findById(id);
    }

    @Override
    @Transactional
    public Auto crear(Auto auto) {
        return autoRepository.save(auto);
    }

    @Override
    @Transactional
    public Auto actualizar(Long id, Auto autoactua) {
        Optional<Auto> optionalEstudiante = autoRepository.findById(id);
        Auto autoactualiza = null;
        if (optionalEstudiante.isPresent()) {
            autoactualiza = optionalEstudiante.get();
            autoactualiza.setResponsable(autoactua.getResponsable());
            autoactualiza.setPlaca(autoactua.getPlaca());
            autoactualiza.setMarca(autoactua.getMarca());


        return autoRepository.save(autoactualiza);
    }
        return null;
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        autoRepository.deleteById(id);
    }
}