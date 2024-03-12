package br.com.fiap.springpgdeposito.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name="TB_PRODUTO")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PRODUTO")
    @SequenceGenerator(
            name = "SQ_PRODUTO",
            sequenceName = "SQ_PRODUTO",
            allocationSize = 1,
            initialValue = 1
    )
    @Column(name="ID_PRODUTO")
    private Long id;

    @Column(name="NM_PRODUTO")
    private String nome;

    private String descricao;

    private BigDecimal valor;

}
