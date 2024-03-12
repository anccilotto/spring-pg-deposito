package br.com.fiap.springpgdeposito.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name="TB_DEPOSITO")
public class Deposito {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_DEPOSITO")
    @SequenceGenerator(
            sequenceName = "SQ_DEPOSITO",
            name = "SQ_DEPOSITO",
            allocationSize = 1,
            initialValue = 1
    )
    @Column(name="ID_DEPOSITO")
    private Long id;

    @Column(name="NM_DEPOSITO")
    private String nome;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "ENDERECO",
            referencedColumnName = "ID_ENDERECO",
            foreignKey = @ForeignKey(name="FK_DEPOSITO_ENDERECO")
    )
    private Endereco endereco;
}
