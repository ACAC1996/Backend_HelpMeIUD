package co.edu.iudigital.helpme_iud.repository;

import co.edu.iudigital.helpme_iud.model.Delito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDelitoRepository extends JpaRepository<Delito, Long> {
    List<Delito> findByNombre(String nombre);

}
