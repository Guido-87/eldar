package com.eldar.eldar.service;

import static org.mockito.Mockito.*;

import com.eldar.eldar.model.Tarjeta;
import com.eldar.eldar.service.impl.CompraServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootTest
public class CompraServiceImplTest {

    @Mock
    private TarjetaService tarjetaService;

    @Mock
    private JavaMailSender emailSender;

    @InjectMocks
    private CompraServiceImpl compraService;

    @Test
    public void testRealizarCompra() {
        Tarjeta tarjeta = new Tarjeta();
        tarjeta.setCodigoSeguridad(123);
        tarjeta.setPan("1234567812345678");
        when(tarjetaService.obtenerTarjetaPorPan("1234567812345678")).thenReturn(tarjeta);
        compraService.realizarCompra(100.0, "Compra de prueba", "1234567812345678", "123");
        verify(emailSender, times(1)).send(any(SimpleMailMessage.class));
    }
}
