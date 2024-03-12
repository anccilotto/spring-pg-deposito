package br.com.fiap.springpgdeposito.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
@Table(name="TB_ITEM_ESTOCADO")
public class ItemEstocado {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SQ_ITEM_ESTOCADO")
    @SequenceGenerator(name = "SQ_ITEM_ESTOCADO", sequenceName = "SQ_ITEM_ESTOCADO", initialValue = 1, allocationSize = 1)
    @Column(name="ID_ITEM_ESTOCADO")
    private Long id;

    private String numeroDeSerie;

    private LocalDateTime entrada;

    private LocalDate saida;


    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name="DEPOSITO",
            referencedColumnName = "ID_DEPOSITO",
            foreignKey = @ForeignKey(name = "FK_ITEM_ESTOCADO_DEPOSITO")
    )
    private Deposito deposito;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name="PRODUTO",
            referencedColumnName = "ID_PRODUTO",
            foreignKey = @ForeignKey(name = "FK_ITEM_ESTOCADO_PRODUTO")
    )
    private Produto produto;
}

