package local.adler.FastAndFurious.domain.repository;

import local.adler.FastAndFurious.domain.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author adler
 */
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
