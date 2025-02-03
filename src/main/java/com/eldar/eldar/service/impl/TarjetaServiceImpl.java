package com.eldar.eldar.service.impl;

import com.eldar.eldar.exception.AppException;
import com.eldar.eldar.model.Tarjeta;
import com.eldar.eldar.repository.TarjetaRepository;
import com.eldar.eldar.service.TarjetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarjetaServiceImpl implements TarjetaService {
    @Autowired
    private TarjetaRepository tarjetaRepository;

    @Override
    public Tarjeta registrarTarjeta(Tarjeta tarjeta) {
        return tarjetaRepository.save(tarjeta);
    }

    @Override
    public List<Tarjeta> obtenerTarjetasPorDni(String dni) {
        List<Tarjeta> tarjetas = tarjetaRepository.findByPersonaDni(dni);
        if (tarjetas.isEmpty()) {
            throw new AppException("No se encontraron tarjetas asociadas a este DNI.");
        }
        return tarjetas;
    }
}
