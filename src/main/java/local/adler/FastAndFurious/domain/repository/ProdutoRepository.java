package local.adler.FastAndFurious.domain.repository;

import local.adler.FastAndFurious.domain.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Adler
 */
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
