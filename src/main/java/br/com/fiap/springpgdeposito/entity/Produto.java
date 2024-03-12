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
@Table(name= "TP_ACAO")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ-PRODUTO")
    @SequenceGenerator(
            name= "SQ_PRODUTO",
            sequenceName = "SQ_PRODUTO",
            initialValue = 1,
            allocationSize = 1
    )
    @Column(name = "ID_PRODUTO")
    private Long id;
    @Column(name = "NM_PRODUTO")
    private String nome;
    @Column(name = "DESC_PRODUTO")
    private  String sigla;

}
