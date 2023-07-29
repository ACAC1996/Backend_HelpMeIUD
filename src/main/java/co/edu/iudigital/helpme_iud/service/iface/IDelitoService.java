package co.edu.iudigital.helpme_iud.service.iface;

import co.edu.iudigital.helpme_iud.dto.request.DelitoDTORequest;
import co.edu.iudigital.helpme_iud.dto.response.DelitoDTO;
import co.edu.iudigital.helpme_iud.exceptions.BadRequestException;
import co.edu.iudigital.helpme_iud.exceptions.RestException;

import java.util.List;

public interface IDelitoService {

    List<DelitoDTO> consultarTodos();
    DelitoDTO consultarPorId(Long id);

    DelitoDTO guardarDelito(DelitoDTORequest delitoDTORequest) throws RestException;

    void borrarDelitoPorId(Long id);
}
