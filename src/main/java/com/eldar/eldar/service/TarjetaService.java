package com.eldar.eldar.service;

import com.eldar.eldar.model.Tarjeta;

import java.util.List;

public interface TarjetaService {
    Tarjeta registrarTarjeta(Tarjeta tarjeta);
    List<Tarjeta> obtenerTarjetasPorDni(String dni);
}
