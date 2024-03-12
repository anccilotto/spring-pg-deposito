package br.com.fiap.springpgdeposito.entity;
import br.com.fiap.springpgdeposito.entity.Deposito;
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
@Table(name= "TB_ITEMESTOCADO")
public class ItemEstocado {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ITEMESTOCADO")
    @SequenceGenerator(
            name= "SQ_ITEMESTOCADO",
            sequenceName = "SQ_ITEMESTOCADO",
            initialValue = 1,
            allocationSize = 1
    )
    @Column(name = "ID_ITEMESTOCADO")
    private Long id;
    @Column(name = "NM_de_serie_ITEMESTOCADO")
    private String sigla;


    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "DEPOSITO",
            referencedColumnName = "ID_DEPOSITO"
            , foreignKey = @ForeignKey(name = "FK_PROCESSO_DEPOSITO")
    )
    private Deposito deposito;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "PRODUTO",
            referencedColumnName = "ID_PRODUTO"
            , foreignKey = @ForeignKey(name = "FK_ITEMESTOCADO_PRODUTO")
    )
    private Produto produto;
}
