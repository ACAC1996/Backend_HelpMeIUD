package co.edu.iudigital.helpme_iud.service.iface;

import co.edu.iudigital.helpme_iud.dto.CasoDTO;
import co.edu.iudigital.helpme_iud.exceptions.RestException;
import co.edu.iudigital.helpme_iud.model.Caso;

import java.util.List;

public interface ICasoService {
    List<CasoDTO> consultarTodos();

    Caso crear(CasoDTO casoDTO) throws RestException;

    Boolean visible(Boolean visible, Long id);

    CasoDTO consultarPorId(Long id);
}
