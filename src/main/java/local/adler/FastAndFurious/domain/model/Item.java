package local.adler.FastAndFurious.domain.model;

import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author adler
 */
@Entity
public class Item {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Produto id_produto;
    
    @NotBlank
    private int quantidade;
    
    private String observacao;
    
    @NotBlank
    private BigDecimal valorUnit;

    public Item() {
    }

    public Item(Long id, Produto id_produto, int quantidade, String observacao, BigDecimal valorUnit) {
        this.id = id;
        this.id_produto = id_produto;
        this.quantidade = quantidade;
        this.observacao = observacao;
        this.valorUnit = valorUnit;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getId_produto() {
        return id_produto;
    }

    public void setId_produto(Produto id_produto) {
        this.id_produto = id_produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public BigDecimal getValorUnit() {
        return valorUnit;
    }

    public void setValorUnit(BigDecimal valorUnit) {
        this.valorUnit = valorUnit;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final Item other = (Item) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
