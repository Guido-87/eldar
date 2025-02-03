package com.eldar.eldar.service.impl;

import com.eldar.eldar.model.Persona;
import com.eldar.eldar.model.Tarjeta;
import com.eldar.eldar.service.CompraService;
import com.eldar.eldar.service.TarjetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class CompraServiceImpl implements CompraService {
    @Autowired
    private TarjetaService tarjetaService;

    @Autowired
    private JavaMailSender emailSender;

    @Override
    public void realizarCompra(Double monto, String detalle, String pan, String cvv) {
        Tarjeta tarjeta = tarjetaService.obtenerTarjetaPorPan(pan);
        if (tarjeta != null && tarjeta.getCodigoSeguridad() == (Integer.parseInt(cvv)) && monto < 10000) {
            System.out.println("Compra realizada por " + monto + " con tarjeta " + pan);
            Persona persona = new Persona();
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(persona.getEmail());
            message.setSubject("Compra realizada");
            message.setText("Se ha realizado una compra de " + monto + " en detalle: " + detalle);
            emailSender.send(message);
        }
    }
}
