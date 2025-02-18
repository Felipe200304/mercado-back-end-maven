package com.MercadoMaven.Final.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MercadoMaven.Final.Entity.Venda;
import com.MercadoMaven.Final.Repository.VendaRepository;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    // Salvar nova venda
    public Venda salvarVenda(Venda venda) {
        return vendaRepository.save(venda);
    }

    // Listar todas as vendas
    public List<Venda> listarVendas() {
        return vendaRepository.findAll();
    }

    // Buscar uma venda por ID
    public Optional<Venda> buscarVenda(Long id) {
        return vendaRepository.findById(id);
    }

    // Deletar uma venda
    public boolean deletarVenda(Long id) {
        if (vendaRepository.existsById(id)) {
            vendaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Atualizar uma venda
    public Venda atualizarVenda(Long id, Venda vendaAtualizada) {
        Optional<Venda> vendaExistente = vendaRepository.findById(id);

        if (vendaExistente.isPresent()) {
            Venda venda = vendaExistente.get();
            venda.setValorCompra(vendaAtualizada.getValorCompra());
            venda.setValorPago(vendaAtualizada.getValorPago());
            venda.setTroco(vendaAtualizada.getTroco());
            return vendaRepository.save(venda);
        }
        return null; // Indica que a venda com o ID fornecido não foi encontrada
    }
}