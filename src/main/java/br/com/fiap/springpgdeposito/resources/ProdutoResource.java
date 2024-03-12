package br.com.fiap.springpgdeposito.resources;
import br.com.fiap.springpgdeposito.entity.Deposito;
import br.com.fiap.springpgdeposito.entity.Endereco;
import br.com.fiap.springpgdeposito.entity.Produto;
import br.com.fiap.springpgdeposito.repository.EnderecoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Objects;
@RestController
@RequestMapping(value = "/produto")
public class ProdutoResource {
    @Autowired
    private ProdutoResource produtoResource;
    @GetMapping
    public List<Produto> findAll(){return produtoResource.findAll();}
    @GetMapping(value = "/{id}")
    public ResponseEntity<Produto> findById(@PathVariable(name = "id") Long id){
        Object o = null;
        Produto produto = (null);
        if (Objects.isNull(produto)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(produto);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Produto> persist(@RequestBody Produto produto){
        Produto saved = produtoResource.save(produto);
        return ResponseEntity.ok(saved);
    }

    private Produto save(Produto produto) {

        return produto;
    }

}
