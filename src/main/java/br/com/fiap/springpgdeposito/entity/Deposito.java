package br.com.fiap.springpgdeposito.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name= "TB_DEPOSITO")
public class Deposito {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_DEPOSITO")
    @SequenceGenerator(
            name= "SQ_DEPOSITO",
            sequenceName = "SQ_DEPOSITO",
            initialValue = 1,
            allocationSize = 1
    )
    @Column(name = "ID_DEPOSITO")
    private Long id;
    @Column(name = "NM_DEPOSITO")
    private String nome;
    @Column (name = "CEP_DEPOSITO")
    private String number;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "ENDERECO",
            referencedColumnName = "ID_ENDERECO"
            , foreignKey = @ForeignKey(name = "FK_DEPOSITO_ENDERECO")
    )
    private Endereco endereco;


}
