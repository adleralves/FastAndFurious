package local.adler.FastAndFurious.domain.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
    private Cliente id_cliente;

    @OneToMany(targetEntity = Item.class, mappedBy = "id_pedido", fetch = FetchType.EAGER)

    private List<Item> item = new ArrayList<>();

    @NotBlank
    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    @Size(max = 100)
    private String observacao;

    @NotBlank
    private LocalDateTime dataHorarioPedido;

    private LocalDateTime dataHorarioEntrega;

    public Pedido() {
    }

    public Pedido(Long id, Cliente id_cliente, List<Item> item, StatusPedido status, String obs, LocalDateTime dataHorarioPedido, LocalDateTime dataHorarioEntrega) {
        this.id = id;
        this.id_cliente = id_cliente;
        this.item = item;
        this.status = status;
        this.observacao = obs;
        this.dataHorarioPedido = dataHorarioPedido;
        this.dataHorarioEntrega = dataHorarioEntrega;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Cliente cliente) {
        this.id_cliente = cliente;
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
        return dataHorarioPedido;
    }

    public void setDataHorarioPedido(LocalDateTime dataHorarioPedido) {
        this.dataHorarioPedido = dataHorarioPedido;
    }

    public LocalDateTime getDataHorarioEntrega() {
        return dataHorarioEntrega;
    }

    public void setDataHorarioEntrega(LocalDateTime dataHorarioEntrega) {
        this.dataHorarioEntrega = dataHorarioEntrega;
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
