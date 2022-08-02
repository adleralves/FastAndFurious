/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package local.adler.FastAndFurious.api.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import local.adler.FastAndFurious.domain.model.Cliente;
import local.adler.FastAndFurious.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    
    @GetMapping
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }
    
    public ResponseEntity<Cliente> listarID(@PathVariable Long cliente_id) {
        Optional<Cliente> cliente = clienteRepository.findById(cliente_id);
        
        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    public Cliente criar(@Valid @RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }
}
    
