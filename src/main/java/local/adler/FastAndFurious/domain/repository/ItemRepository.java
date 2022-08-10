package local.adler.FastAndFurious.domain.repository;

import local.adler.FastAndFurious.domain.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author adler
 */
public interface ItemRepository extends JpaRepository<Item, Long>{
    
}
