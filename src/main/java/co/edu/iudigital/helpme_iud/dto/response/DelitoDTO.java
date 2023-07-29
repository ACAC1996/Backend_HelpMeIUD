package co.edu.iudigital.helpme_iud.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level= AccessLevel.PRIVATE)
public class DelitoDTO {
    Long id;
    String nombre;
    String descripcion;
}
