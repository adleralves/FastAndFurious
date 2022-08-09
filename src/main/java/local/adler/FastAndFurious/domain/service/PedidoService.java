package local.adler.FastAndFurious.domain.service;

import java.time.LocalDateTime;
import local.adler.FastAndFurious.domain.model.Pedido;
import local.adler.FastAndFurious.domain.model.StatusPedido;
import local.adler.FastAndFurious.domain.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author devsys-a
 */
@Service
public class PedidoService {
    
    @Autowired
    private PedidoRepository pedidoRepository;
    
    public Pedido criar(Pedido pedido) {
        pedido.setDataHoraPedido(LocalDateTime.now());
        pedido.setStatus(StatusPedido.FINALIZADO);
         
        return pedidoRepository.save(pedido);
    }
}
