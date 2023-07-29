package co.edu.iudigital.helpme_iud.service.impl;

import co.edu.iudigital.helpme_iud.dto.CasoDTO;
import co.edu.iudigital.helpme_iud.exceptions.BadRequestException;
import co.edu.iudigital.helpme_iud.exceptions.ErrorDto;
import co.edu.iudigital.helpme_iud.exceptions.RestException;
import co.edu.iudigital.helpme_iud.model.Caso;
import co.edu.iudigital.helpme_iud.model.Delito;
import co.edu.iudigital.helpme_iud.model.Usuario;
import co.edu.iudigital.helpme_iud.repository.ICasoRepository;
import co.edu.iudigital.helpme_iud.repository.IDelitoRepository;
import co.edu.iudigital.helpme_iud.repository.IUsuarioRepository;
import co.edu.iudigital.helpme_iud.service.iface.ICasoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CasoServiceImpl implements ICasoService {

    @Autowired
    private ICasoRepository casoRepository;

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private IDelitoRepository delitoRepository;
    @Override
    @Transactional(readOnly = true)
    public List<CasoDTO> consultarTodos() {
        log.info("consultando todos los casos{}");
        List<Caso> casos= casoRepository.findAll();
        /*List<CasoDTO> casosDTO=new ArrayList<>();
        for(Caso caso: casos){
            CasoDTO casoDTO= CasoDTO.builder()
                    .id(caso.getId())
                    .descripcion(caso.getDescripcion())
                    .altitud(caso.getAltitud())
                    .latitud(caso.getLatitud())
                    .longitud(caso.getLongitud())
                    .esVisible(caso.getEsVisible())
                    .fechaHora(caso.getFechaHora())
                    .rmiUrl(caso.getRmiUrl())
                    .urlMap(caso.getUrlMap())
                    .usuarioId(caso.getUsuario().getId())
                    .delitoId(caso.getDelito().getId())
                    .build();
            casosDTO.add(casoDTO);
        }*/
        return casos.stream().map(caso->
            CasoDTO.builder()
                    .id(caso.getId())
                    .descripcion(caso.getDescripcion())
                    .altitud(caso.getAltitud())
                    .latitud(caso.getLatitud())
                    .longitud(caso.getLongitud())
                    .esVisible(caso.getEsVisible())
                    .fechaHora(caso.getFechaHora())
                    .rmiUrl(caso.getRmiUrl())
                    .urlMap(caso.getUrlMap())
                    .usuarioId(caso.getUsuario().getId())
                    .delitoId(caso.getDelito().getId())
                    .build()
        ).collect(Collectors.toList());

    }

    @Override
    @Transactional
    public Caso crear(CasoDTO casoDTO) throws RestException {
        Optional<Usuario> usuario=usuarioRepository.findById(casoDTO.getUsuarioId());
        Optional<Delito> delito=delitoRepository.findById(casoDTO.getDelitoId());
        if(!usuario.isPresent() || !delito.isPresent()){
            log.error("No existe usuario {}",casoDTO.getUsuarioId());
            log.error("No existe delito {}",casoDTO.getDelitoId());
            throw new BadRequestException(
                    ErrorDto.builder()
                            .status(HttpStatus.BAD_REQUEST.value())
                            .message("No existe usuario o delito")
                            .error(HttpStatus.BAD_REQUEST.getReasonPhrase())
                            .date(LocalDateTime.now())
                            .build()
            );
        }
        Caso caso=new Caso();
        caso.setFechaHora(casoDTO.getFechaHora());
        caso.setLatitud(casoDTO.getLatitud());
        caso.setAltitud(casoDTO.getAltitud());
        caso.setLongitud(casoDTO.getLongitud());
        caso.setDescripcion(casoDTO.getDescripcion());
        caso.setEsVisible(true);
        caso.setRmiUrl(casoDTO.getRmiUrl());
        caso.setUrlMap(casoDTO.getUrlMap());
        caso.setUsuario(usuario.get());
        caso.setDelito(delito.get());
        return casoRepository.save(caso);
    }

    @Override
    @Transactional
    public Boolean visible(Boolean visible, Long id) {
        return casoRepository.setVisible(visible, id);
    }

    @Override
    @Transactional(readOnly = true)
    public CasoDTO consultarPorId(Long id) {
        Optional<Caso> casoOptional=casoRepository.findById(id);
        if(casoOptional.isPresent()){
            Caso caso=casoOptional.get();
            return CasoDTO.builder()
                    .id(caso.getId())
                    .descripcion(caso.getDescripcion())
                    .altitud(caso.getAltitud())
                    .latitud(caso.getLatitud())
                    .longitud(caso.getLongitud())
                    .esVisible(caso.getEsVisible())
                    .fechaHora(caso.getFechaHora())
                    .rmiUrl(caso.getRmiUrl())
                    .urlMap(caso.getUrlMap())
                    .usuarioId(caso.getUsuario().getId())
                    .delitoId(caso.getDelito().getId())
                    .build();
        }
        log.warn("No existe caso {}",id);
        return null;
    }
}
