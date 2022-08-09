package local.adler.FastAndFurious.domain.model;

import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
    
    @NotBlank
    @Enumerated(EnumType.STRING)
    private StatusPedido status;
    
    @Size(max = 100)
    private String observacao;
    
    @NotBlank
    private LocalDateTime dataHoraPedido;
    
    private LocalDateTime dataHoraEntrega;

    public Pedido() {
    }

    public Pedido(Long id, Cliente id_cliente,StatusPedido status, String obs, LocalDateTime dataHoraPedido, LocalDateTime dataHoraEntrega) {
        this.id = id;
        this.id_cliente = id_cliente;
        this.status = status;
        this.observacao = obs;
        this.dataHoraPedido = dataHoraPedido;
        this.dataHoraEntrega = dataHoraEntrega;
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

    public void setId_cliente(Cliente id_cliente) {
        this.id_cliente = id_cliente;
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

    public LocalDateTime getDataHoraPedido() {
        return dataHoraPedido;
    }

    public void setDataHoraPedido(LocalDateTime dataHoraPedido) {
        this.dataHoraPedido = dataHoraPedido;
    }

    public LocalDateTime getDataHoraEntrega() {
        return dataHoraEntrega;
    }

    public void setDataHoraEntrega(LocalDateTime dataHoraEntrega) {
        this.dataHoraEntrega = dataHoraEntrega;
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
