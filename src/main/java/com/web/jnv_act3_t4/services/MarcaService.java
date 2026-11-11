package com.web.jnv_act3_t4.services;

import com.web.jnv_act3_t4.models.Marca;
import com.web.jnv_act3_t4.repository.MarcaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaService {

    private final MarcaRepository marcaRepository;

    public MarcaService(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    public List<Marca> listarMarcas() {
        return marcaRepository.findAll();
    }

    public Marca guardar(Marca marca) {
        return marcaRepository.save(marca);
    }
}
