package local.adler.FastAndFurious.api.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import local.adler.FastAndFurious.domain.model.Cliente;
import local.adler.FastAndFurious.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author adler
 */
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/listar")
    public List<Cliente> list() {
        return clienteRepository.findAll();
    }

    @GetMapping("/{id_cliente}")
    public ResponseEntity<Cliente> listId(@PathVariable Long id_cliente) {
        Optional<Cliente> cliente = clienteRepository.findById(id_cliente);

        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente criar(@Valid @RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }
}
