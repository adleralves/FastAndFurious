package local.adler.FastAndFurious.api.controller;

import java.util.List;
import local.adler.FastAndFurious.domain.model.Pedido;
import local.adler.FastAndFurious.domain.repository.PedidoRepository;
import local.adler.FastAndFurious.domain.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
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

    @GetMapping("/pedido")
    public List<Pedido> list() {
        return pedidoRepository.findAll();
    }

    @PostMapping("/criar")
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido criar(@RequestBody Pedido pedido) {
        return pedidoService.criar(pedido);
    }

    @DeleteMapping("/pedido/{id_pedido}")
    public ResponseEntity<Void> excluir(@PathVariable Long id_pedido) {
        if (!pedidoRepository.existsById(id_pedido)) {
            return ResponseEntity.notFound().build();
        }
        pedidoRepository.deleteById(id_pedido);
        return ResponseEntity.noContent().build();
    }
}
