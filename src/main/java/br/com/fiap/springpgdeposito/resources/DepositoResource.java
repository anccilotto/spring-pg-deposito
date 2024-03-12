package br.com.fiap.springpgdeposito.resource;

import br.com.fiap.springpgdeposito.entity.Deposito;
import br.com.fiap.springpgdeposito.entity.Endereco;
import br.com.fiap.springpgdeposito.repository.DepositoRepository;
import br.com.fiap.springpgdeposito.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/deposito")
public class DepositoResource {

    @Autowired
    private DepositoRepository repo;

    @Autowired
    private EnderecoRepository enderecoRepo;

    @GetMapping
    public List<Deposito> findAll() {
        return repo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Deposito findById(@PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }

    @PostMapping
    @Transactional
    public Deposito save(@RequestBody Deposito deposito) {

        if (Objects.isNull(deposito)) return null;

        if (Objects.nonNull(deposito.getEndereco().getId())) {
            Endereco endereco = enderecoRepo.findById(deposito.getEndereco().getId()).orElseThrow();
            deposito.setEndereco(endereco);
        }

        return repo.save(deposito);
    }
}
