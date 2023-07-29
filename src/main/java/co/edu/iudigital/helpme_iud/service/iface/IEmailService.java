package co.edu.iudigital.helpme_iud.service.iface;

public interface IEmailService {

    boolean sendEmail(String mensaje, String email, String asunto);
}
