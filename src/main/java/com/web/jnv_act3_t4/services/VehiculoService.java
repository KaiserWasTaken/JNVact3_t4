package com.web.jnv_act3_t4.services;

import com.web.jnv_act3_t4.models.Marca;
import com.web.jnv_act3_t4.models.vehiculo;
import com.web.jnv_act3_t4.repository.MarcaRepository;
import com.web.jnv_act3_t4.repository.vehiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoService {

    private final vehiculoRepository vehiculoRepository;
    private final MarcaRepository marcaRepository;

    public VehiculoService(vehiculoRepository vehiculoRepository, MarcaRepository marcaRepository) {
        this.vehiculoRepository = vehiculoRepository;
        this.marcaRepository = marcaRepository;
    }

    public List<vehiculo> listarVehiculos() {
        return vehiculoRepository.findAll();
    }

    public vehiculo buscarPorId(Integer id) {
        return vehiculoRepository.findById(id).orElseThrow();
    }

    public vehiculo guardar(vehiculo vehiculo, Integer marcaId) {
        Marca marca = marcaRepository.findById(marcaId).orElseThrow();
        vehiculo.setMarca(marca);
        return vehiculoRepository.save(vehiculo);
    }

    public void eliminar(Integer id) {
        vehiculoRepository.deleteById(id);
    }

    public List<Marca> listarMarcas() {
        return marcaRepository.findAll();
    }
}
