package co.edu.iudigital.helpme_iud.service.iface;

import co.edu.iudigital.helpme_iud.dto.request.UsuarioDTORequest;
import co.edu.iudigital.helpme_iud.dto.response.UsuarioDTO;
import co.edu.iudigital.helpme_iud.exceptions.BadRequestException;
import co.edu.iudigital.helpme_iud.exceptions.RestException;
import co.edu.iudigital.helpme_iud.model.Usuario;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface IUsuarioService {
    List<UsuarioDTO> consultarTodos();

    UsuarioDTO consultarPorId(Long Id);

    UsuarioDTO consultarPorUsername(String username);

    UsuarioDTO guardar(UsuarioDTORequest usuarioDTORequest) throws RestException;

    Usuario findByUsername(String username);

    UsuarioDTO userInfo(Authentication authentication) throws RestException;

    Usuario actualizar(Usuario usuario) throws RestException;
}
