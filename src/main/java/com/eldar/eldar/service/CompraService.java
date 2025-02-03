package com.eldar.eldar.service;

public interface CompraService {
    void realizarCompra(Double monto, String detalle, String pan, String cvv);
}
