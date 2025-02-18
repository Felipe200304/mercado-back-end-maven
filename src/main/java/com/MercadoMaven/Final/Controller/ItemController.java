package com.MercadoMaven.Final.Controller;




import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.MercadoMaven.Final.Entity.Item;
import com.MercadoMaven.Final.Repository.ItemRepository;

import java.util.List;

@RestController
@RequestMapping("/api/itens")
@CrossOrigin(origins = "*") // Permite requisições de qualquer origem
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Transactional
    @PostMapping
    public ResponseEntity<?> createItem(@RequestBody Item item) {
        // Verifica se já existe um item com o mesmo código
        boolean codigoExistente = itemRepository.findByCodigo(item.getCodigo()).isPresent();

        if (codigoExistente) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Já existe um produto com o código informado!");
        }

        Item itemSalvo = itemRepository.save(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(itemSalvo);
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Long id, @RequestBody Item item) {
        var entity = itemRepository.findById(id);

        if (entity.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        entity.get().setCategoria(item.getCategoria());
        entity.get().setCodigo(item.getCodigo());
        entity.get().setCusto(item.getCusto());
        entity.get().setDescricao(item.getDescricao());
        entity.get().setNomeProduto(item.getNomeProduto());
        entity.get().setPercentualLucro(item.getPercentualLucro());
        entity.get().setPrecoSugerido(item.getPrecoSugerido());
        entity.get().setQuantidade(item.getQuantidade());
        entity.get().setValorVenda(item.getValorVenda());

        Item itemAtualizado = itemRepository.save(entity.get());

        return ResponseEntity.ok(itemAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        if (!itemRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        itemRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id) {
        Item item = itemRepository.findById(id).orElse(null);
        if (item == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(item);
    }

    @GetMapping("/buscar")
    public ResponseEntity<Item> getItemByCodigo(@RequestParam String codigo) {
        return itemRepository.findByCodigo(codigo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping("/vendas")
    @Transactional
    public ResponseEntity<String> finalizarVenda(@RequestBody List<Item> itensVendidos) {
        for (Item itemVendido : itensVendidos) {
            Item produto = itemRepository.findByCodigo(itemVendido.getCodigo()).orElse(null);

            if (produto == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Produto não encontrado: " + itemVendido.getCodigo());
            }

            // Atualiza a quantidade no estoque
            int quantidadeAtual = Integer.parseInt(produto.getQuantidade());
            int quantidadeVendida = Integer.parseInt(itemVendido.getQuantidade());

            if (quantidadeVendida > quantidadeAtual) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Estoque insuficiente para o produto: " + produto.getNomeProduto());
            }

            produto.setQuantidade(String.valueOf(quantidadeAtual - quantidadeVendida));
            itemRepository.save(produto);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body("Venda finalizada com sucesso!");
    }
}