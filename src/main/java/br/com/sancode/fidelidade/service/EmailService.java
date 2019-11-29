package br.com.sancode.fidelidade.service;

import br.com.sancode.fidelidade.model.Cliente;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public interface EmailService {

    void sendOrderConfimationEmail(Cliente cliente);

    void sendEmail(SimpleMailMessage msg);

    void sendNewPasswordEmail(Cliente cliente, String newPass);
}
