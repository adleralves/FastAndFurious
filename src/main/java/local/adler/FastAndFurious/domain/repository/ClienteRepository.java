package local.adler.FastAndFurious.domain.repository;

import local.adler.FastAndFurious.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author adler
 */
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}
