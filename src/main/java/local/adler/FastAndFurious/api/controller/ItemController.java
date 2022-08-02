package local.adler.FastAndFurious.api.controller;

import java.util.List;
import local.adler.FastAndFurious.domain.model.Item;
import local.adler.FastAndFurious.domain.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author adler
 */

@RestController
@RequestMapping("/itens")
public class ItemController {
    
    @Autowired
    private ItemRepository itemRepository;
    
    public List<Item> listarItem() {
        return itemRepository.findAll();
    }
    
    public Item addItem(@RequestBody Item item) {
        return itemRepository.save(item);
    }
}
