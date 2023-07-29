package co.edu.iudigital.helpme_iud.repository;

import co.edu.iudigital.helpme_iud.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByUsername(String username);
}
