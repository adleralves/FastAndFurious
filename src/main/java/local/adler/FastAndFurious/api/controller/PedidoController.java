package local.adler.FastAndFurious.api.controller;

import java.util.List;
import local.adler.FastAndFurious.domain.model.Pedido;
import local.adler.FastAndFurious.domain.repository.PedidoRepository;
import local.adler.FastAndFurious.domain.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author adler
 */

@RestController
public class PedidoController {
    
    @Autowired
    private PedidoRepository pedidoRepository;
    
    @Autowired
    private PedidoService pedidoService;
    
    public List<Pedido> listar() {
        return pedidoRepository.findAll();
    }
}
