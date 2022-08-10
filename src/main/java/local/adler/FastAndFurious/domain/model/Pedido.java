package local.adler.FastAndFurious.domain.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 *
 * @author adler
 */
@Entity
public class Pedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Cliente cliente;
    
    @OneToMany(targetEntity=Item.class, mappedBy="id_pedido", fetch=FetchType.EAGER)
    
    private List<Item> item = new ArrayList<>();
    
    @NotBlank
    @Enumerated(EnumType.STRING)
    private StatusPedido status;
    
    @Size(max = 100)
    private String observacao;
    
    @NotBlank
    private LocalDateTime data_horario_pedido;
    
    private LocalDateTime data_horario_entrega;

    public Pedido() {
    }

    public Pedido(Long id, Cliente cliente, List<Item> item,StatusPedido status, String obs, LocalDateTime data_horario_pedido, LocalDateTime data_horario_entrega) {
        this.id = id;
        this.cliente = cliente;
        this.item = item;
        this.status = status;
        this.observacao = obs;
        this.data_horario_pedido = data_horario_pedido;
        this.data_horario_entrega = data_horario_entrega;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getId_cliente() {
        return cliente;
    }

    public void setId_cliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }
    

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String obs) {
        this.observacao = obs;
    }

    public LocalDateTime getDataHorarioPedido() {
        return data_horario_pedido;
    }

    public void setDataHorarioPedido(LocalDateTime data_horario_pedido) {
        this.data_horario_pedido = data_horario_pedido;
    }

    public LocalDateTime getDataHorarioEntrega() {
        return data_horario_entrega;
    }

    public void setDataHorarioEntrega(LocalDateTime data_horario_entrega) {
        this.data_horario_entrega = data_horario_entrega;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pedido other = (Pedido) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
